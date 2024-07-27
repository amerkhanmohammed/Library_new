package com.library.system.dtos.user;

import com.library.system.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupResponseDto {
    private long userId;
    private String username;

    public UserSignupResponseDto() {}
    public UserSignupResponseDto(User user) {
        this.userId = user.getId();
        this.username = user.getUsername();
    }
}
