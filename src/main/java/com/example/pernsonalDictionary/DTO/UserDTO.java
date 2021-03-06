package com.example.pernsonalDictionary.DTO;

public class UserDTO {

    private String username;
    private String password;
    private String name;

    public UserDTO(){};

    public UserDTO(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
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

    public boolean validate(){
        return this.name.isBlank() || this.password.isBlank() || this.username.isBlank();
    }


}
