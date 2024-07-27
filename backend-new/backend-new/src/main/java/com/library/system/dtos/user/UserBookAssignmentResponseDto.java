package com.library.system.dtos.user;

import com.library.system.dtos.BaseDto;
import com.library.system.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBookAssignmentResponseDto extends BaseDto {
    private String memberName;
    private boolean isAssigned;

    public UserBookAssignmentResponseDto(User member, boolean isAssigned) {

        this.id = member.getId();
        this.memberName = member.getFullName();
        this.isAssigned = isAssigned;
    }
}
