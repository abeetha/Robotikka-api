package com.bootcamp.robotikka.robotikkaapi.dto.request;
import com.bootcamp.robotikka.robotikkaapi.entity.share.UserNameResource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserDTO {

    private String contactNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
