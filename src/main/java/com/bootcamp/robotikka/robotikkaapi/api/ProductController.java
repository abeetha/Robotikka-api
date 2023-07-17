package com.bootcamp.robotikka.robotikkaapi.api;

import com.bootcamp.robotikka.robotikkaapi.dto.request.RequestProductDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.response.CommonResponseDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.response.ResponseProductDTO;
import com.bootcamp.robotikka.robotikkaapi.service.ProductService;
import com.bootcamp.robotikka.robotikkaapi.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @PostMapping("/member/create")
    public ResponseEntity<StandardResponse> createProduct(
            @RequestBody RequestProductDTO dto
    ){
        CommonResponseDTO savedData = productService.createProduct(dto);
        return new ResponseEntity<>(
                new StandardResponse(savedData.getCode(),
                        savedData.getMessage(),savedData.getData()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/member/find/{id}")
    public ResponseEntity<StandardResponse> createProduct(
            @PathVariable String id
    ){
        ResponseProductDTO product = productService.findProduct(id);
        return new ResponseEntity<>(
                new StandardResponse(200,
                        "Product Details",product),
                HttpStatus.OK
        );
    }

    @PutMapping("/member/modify/{}")
    public ResponseEntity<StandardResponse> createProduct(
            @RequestBody RequestProductDTO dto,
            @PathVariable String id
    ){
        CommonResponseDTO updateData = productService.updateProduct(dto,id);
        return new ResponseEntity<>(
                new StandardResponse(updateData.getCode(),
                        updateData.getMessage(),updateData.getData()),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/member/remove/{id}")
    public ResponseEntity<StandardResponse>deleteProduct(
            @PathVariable String id
    ) {
        CommonResponseDTO updatedData = productService.deleteProduct(id);
        return new ResponseEntity<>(
                new StandardResponse(updatedData.getCode(),
                        updatedData.getMessage(), updatedData.getData()),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping(value = "/member/list", params = {"searchText","page","size"})
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER','ROLE_USER')")
    public ResponseEntity<StandardResponse>deleteProduct(
            @RequestParam(required = false) String text,
            @RequestParam int page,
            @RequestParam int size
    ) {
        return new ResponseEntity<>(
                new StandardResponse(200,
                        "Product List", productService.findAll(text,page,size)),
                HttpStatus.OK
        );
    }
}
