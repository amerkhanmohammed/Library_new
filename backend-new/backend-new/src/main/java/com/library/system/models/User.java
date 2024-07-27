package com.library.system.models;


import com.library.system.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    @Column(unique = true, nullable = false)
    private String  username;
    @Column(nullable = false)
    private String  password;
    private boolean isActive;
    private boolean isCredentialsExpired;
    private boolean isAccountLocked;
    private boolean isAccountExpired;
    @ManyToMany(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    private String fullName;
    private Gender gender;
    private String institute;

    private String address;
    //Add extra user info if needed

    public User() {
        this.username = "";
        this.password = "";
        this.isActive = true;
        this.isAccountExpired = false;
        this.isAccountLocked = false;
        this.isCredentialsExpired = false;
        this.roles = new HashSet<>();
    }
}
