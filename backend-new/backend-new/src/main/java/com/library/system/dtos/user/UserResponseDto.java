package com.library.system.dtos.user;


import com.library.system.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private long id;
    private String userName;
    private String fullName;
    private String institute;


    public UserResponseDto() {}
    public UserResponseDto(User user) {
        this.id = user.getId();
        this.userName = user.getUsername();
        this.fullName = user.getFullName();
        this.institute = user.getInstitute();

    }
}
