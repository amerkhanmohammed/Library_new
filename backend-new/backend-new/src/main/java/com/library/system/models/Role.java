package com.library.system.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role extends BaseModel{
    @Column(unique = true, nullable = false)
    private String role;

    public Role() {
        role = "";
    }

    public Role(String role) {
        this.role = role;
    }
}
