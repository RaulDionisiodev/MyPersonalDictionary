package com.example.pernsonalDictionary.controller;

import com.example.pernsonalDictionary.DTO.ExpressionDTO;
import com.example.pernsonalDictionary.model.Expression;
import com.example.pernsonalDictionary.model.User;
import com.example.pernsonalDictionary.repository.UserRepository;
import com.example.pernsonalDictionary.service.ExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = "/expression")
public class ExpressionController {

    @Autowired
    private ExpressionService expressionService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Expression> findAll(){
        return expressionService.findAll(getLoggedUser());
    }

    @GetMapping
    @RequestMapping("/top10")
    public List<Expression> findTop10(){
        return expressionService.findTop10(getLoggedUser());
    }

    @PostMapping
    public Expression insert(@RequestBody ExpressionDTO dto){
        return expressionService.insert(dto,getLoggedUser());
    }

    private User getLoggedUser(){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUsername(authentication.getName());
    }
    @DeleteMapping
    @RequestMapping("/{id}")
    public String deleteExpression(@PathVariable Long id){
        Optional<Expression> expressionOptional = expressionService.getExpressionById(id);

        if(!expressionOptional.isPresent()){
            return "Expressão não encontrada";
        }

        Expression expression = expressionOptional.get();

        if(Objects.equals(expression.getOwner().getUserId(), getLoggedUser().getUserId())){
            expressionService.removeExpression(expression);
            return "Expressão removida com sucesso";
        }else {
            return "Expressão não encontrada";
        }
    }

    @PostMapping
    @RequestMapping("/update")
    public ResponseEntity<Expression> update(@RequestBody ExpressionDTO dto){
        try {
             Expression expression = expressionService.update(dto);
             return ResponseEntity.ok(expression);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
