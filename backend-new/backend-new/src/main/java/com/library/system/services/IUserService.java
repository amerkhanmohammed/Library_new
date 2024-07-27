package com.library.system.services;

import com.library.system.dtos.user.UserResponseDto;
import com.library.system.dtos.user.UserSignupRequestDto;
import com.library.system.dtos.user.UserSignupResponseDto;
import com.library.system.models.User;

import java.util.List;

public interface IUserService {
    UserSignupResponseDto userSignup(UserSignupRequestDto request);
    UserResponseDto getUserDetails(long id);
    UserResponseDto getUserDetails(String username);

    User getUserByUsername(String username);

    List<UserResponseDto> getAllUsers();
}
