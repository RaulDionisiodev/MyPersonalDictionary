package com.example.pernsonalDictionary.controller;

import com.example.pernsonalDictionary.DTO.ExpressionDTO;
import com.example.pernsonalDictionary.model.Expression;
import com.example.pernsonalDictionary.model.User;
import com.example.pernsonalDictionary.repository.UserRepository;
import com.example.pernsonalDictionary.service.ExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/expression")
public class ExpressionController {

    @Autowired
    private ExpressionService expressionService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Expression> findAll(){
        return expressionService.findAll();
    }

    @GetMapping
    @RequestMapping("/top10")
    public List<Expression> findTop10(){
        return expressionService.findTop10();
    }

    @PostMapping
    public Expression insert(@RequestBody ExpressionDTO dto){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName());
        return expressionService.insert(dto,user);
    }
}
