package com.example.pernsonalDictionary.controller;

import com.example.pernsonalDictionary.model.Expression;
import com.example.pernsonalDictionary.service.ExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/expression")
public class ExpressionController {

    @Autowired
    private ExpressionService expressionService;

    @GetMapping
    private List<Expression> findAll(){
        return expressionService.findAll();
    }
}