package com.bootcamp.robotikka.robotikkaapi.service.impl;


import com.bootcamp.robotikka.robotikkaapi.dto.request.RequestProductDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.response.CommonResponseDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.response.ResponseProductDTO;
import com.bootcamp.robotikka.robotikkaapi.entity.Product;
import com.bootcamp.robotikka.robotikkaapi.repo.ProductRepo;
import com.bootcamp.robotikka.robotikkaapi.service.ProductService;
import com.bootcamp.robotikka.robotikkaapi.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final Generator generator;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, Generator generator) {
        this.productRepo = productRepo;
        this.generator = generator;
    }

    @Override
    public CommonResponseDTO createProduct(RequestProductDTO dto) {
       Product product = new Product(
               generator.generateKey("PI"),
             dto.getDisplayName(),
             dto.getDescription(),
             dto.getUnitPrice(),
             dto.getQty(),
             null,
             dto.getSellingPrice(),
             null,
             null
       );
       productRepo.save(product);
        return new CommonResponseDTO(201,"Saved!",null);
    }

    @Override
    public CommonResponseDTO updateProduct(RequestProductDTO dto, String id) {
        Optional<Product> selectedProduct = productRepo.findById(id);
        if(selectedProduct.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Product product = selectedProduct.get();
        product.setDescription(dto.getDescription());
        product.setDisplayName(dto.getDisplayName());
        product.setSellingPrice(dto.getSellingPrice());
        product.setUnitPrice(dto.getUnitPrice());
        product.setQty(dto.getQty());
        productRepo.save(product);
        return new CommonResponseDTO(201,"Updated",null);
    }

    @Override
    public ResponseProductDTO findProduct(String id) {
        Optional<Product> selectedProduct = productRepo.findById(id);
        if(selectedProduct.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new ResponseProductDTO(
                selectedProduct.get().getPropertyId(),
                selectedProduct.get().getDisplayName(),
                selectedProduct.get().getDescription(),
                selectedProduct.get().getUnitPrice(),
                selectedProduct.get().getQty(),
                selectedProduct.get().getSellingPrice()
        );
    }
}
