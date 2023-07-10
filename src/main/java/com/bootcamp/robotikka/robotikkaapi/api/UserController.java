package com.bootcamp.robotikka.robotikkaapi.api;

import com.bootcamp.robotikka.robotikkaapi.dto.request.RequestUserDTO;
import com.bootcamp.robotikka.robotikkaapi.dto.response.CommonResponseDTO;
import com.bootcamp.robotikka.robotikkaapi.service.UserService;
import com.bootcamp.robotikka.robotikkaapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/visitor/register")
    public ResponseEntity<StandardResponse>
    createUser(@RequestBody RequestUserDTO dto){
        CommonResponseDTO responseData = userService.createUser(dto);
        return new ResponseEntity<>(new StandardResponse(
                responseData.getCode(), responseData.getMessage(), responseData.getData()
        ), HttpStatus.CREATED);

    }

    @PostMapping(value = "/visitor/verify/{otp}",params = "email")
    public ResponseEntity<StandardResponse>
    verifyUser(@PathVariable String otp, @RequestBody String email){
        CommonResponseDTO responseData = userService.verifyAccount(email,otp);
        return new ResponseEntity<>(new StandardResponse(
                responseData.getCode(), responseData.getMessage(), responseData.getData()
        ), HttpStatus.CREATED);

    }
}
