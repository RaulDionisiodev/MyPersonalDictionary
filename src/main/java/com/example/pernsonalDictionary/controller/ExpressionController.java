package com.example.pernsonalDictionary.controller;

import com.example.pernsonalDictionary.DTO.ExpressionDTO;
import com.example.pernsonalDictionary.exception.ExpressionNotFoundException;
import com.example.pernsonalDictionary.model.Expression;
import com.example.pernsonalDictionary.model.User;
import com.example.pernsonalDictionary.repository.UserRepository;
import com.example.pernsonalDictionary.service.ExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<Expression>> findAll(){
        return ResponseEntity.ok(expressionService.findAll(getLoggedUser()));
    }

    @GetMapping
    @RequestMapping("/top10")
    public ResponseEntity<List<Expression>> findTop10(){
        return ResponseEntity.ok(expressionService.findTop10(getLoggedUser()));
    }

    @PostMapping
    public ResponseEntity<Expression> insert(@RequestBody ExpressionDTO dto){
        return ResponseEntity.ok(expressionService.insert(dto,getLoggedUser()));
    }

    private User getLoggedUser(){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUsername(authentication.getName());
    }
    @DeleteMapping
    @RequestMapping("/{id}")
    public ResponseEntity<String> deleteExpression(@PathVariable Long id){
        Optional<Expression> expressionOptional = expressionService.getExpressionById(getLoggedUser(), id);

        if(!expressionOptional.isPresent()){
            throw new ExpressionNotFoundException("Express??o n??o encontrada");
        }

        Expression expression = expressionOptional.get();

        if(Objects.equals(expression.getOwner().getUserId(), getLoggedUser().getUserId())){
            expressionService.removeExpression(expression);
            return ResponseEntity.accepted().body("Express??o removida com sucesso");
        }else {
            throw new ExpressionNotFoundException("Express??o n??o encontrada");
        }
    }

    @PostMapping
    @RequestMapping("/update")
    public ResponseEntity<Expression> update(@RequestBody ExpressionDTO dto){
        try {
             Expression expression = expressionService.update(dto);
             return ResponseEntity.ok(expression);
        }catch (Exception e){
            throw new ExpressionNotFoundException("Express??o n??o encontrada");
        }
    }

    @GetMapping
    @RequestMapping("/id={id}")
    public ResponseEntity<Expression>findExpressionById(@PathVariable Long id){
        Optional<Expression> expression = expressionService.getExpressionById(getLoggedUser(), id);

        return expression.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    @RequestMapping("/text={text}")
    public ResponseEntity<List<Expression>>findByText(@PathVariable String text){

        List<Expression> expressionList = new ArrayList<>();
        Optional<Expression> expression = expressionService.findByText(getLoggedUser(), text);
        expression.ifPresent(expressionList::add);
        
        return ResponseEntity.ok(expressionList);

    }
}
