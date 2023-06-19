package com.bootcamp.robotikka.robotikkaapi.service;

import com.bootcamp.robotikka.robotikkaapi.dto.request.RequestProductDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.response.CommonResponseDTO;

public interface ProductService {
    public CommonResponseDTO createProduct(RequestProductDTO dto);
}
