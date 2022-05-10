package com.example.pernsonalDictionary.model;

import com.example.pernsonalDictionary.DTO.UserDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String username;


    private String password;

    private String name;

    private boolean admin;

    public User(Long userId, String username, String password, String name, boolean admin) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.admin = admin;
    }

    public User(){}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
