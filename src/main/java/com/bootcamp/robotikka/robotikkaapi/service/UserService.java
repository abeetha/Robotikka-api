package com.bootcamp.robotikka.robotikkaapi.service;

import com.bootcamp.robotikka.robotikkaapi.dto.request.RequestUserDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.response.CommonResponseDTO;

public interface UserService {
    public CommonResponseDTO createUser(RequestUserDTO dto);

    public CommonResponseDTO verifyAccount(String email, String otp);
}
