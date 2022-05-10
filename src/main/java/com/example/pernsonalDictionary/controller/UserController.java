package com.example.pernsonalDictionary.controller;

import com.example.pernsonalDictionary.DTO.UserDTO;
import com.example.pernsonalDictionary.model.User;
import com.example.pernsonalDictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @PutMapping
    private ResponseEntity<String>insertUser(@RequestBody UserDTO userDTO){
        try {
            if(userDTO.validate()) throw new Exception();
            service.insertUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar usuário");
        }

    }

}
