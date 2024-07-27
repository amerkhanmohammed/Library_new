package com.library.system.dtos.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupRequestDto {
    private String fullName;
    private String email;
    private String password;
    private String gender;
    private String institute;
    private int degree;
    private String address;
}
