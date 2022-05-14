package com.example.pernsonalDictionary.service;

import com.example.pernsonalDictionary.model.Expression;
import com.example.pernsonalDictionary.repository.ExpressionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressionService {

    @Autowired
    private ExpressionRepository expressionRepository;

    public List<Expression> findAll(){
        return expressionRepository.findAllByOrderByTextAsc();
    }
}
