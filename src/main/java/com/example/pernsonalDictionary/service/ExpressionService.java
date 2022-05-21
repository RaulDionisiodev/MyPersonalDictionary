package com.example.pernsonalDictionary.service;

import com.example.pernsonalDictionary.DTO.ExpressionDTO;
import com.example.pernsonalDictionary.exception.ExpressionNotFoundException;
import com.example.pernsonalDictionary.model.Example;
import com.example.pernsonalDictionary.model.Expression;
import com.example.pernsonalDictionary.model.User;
import com.example.pernsonalDictionary.repository.CategoryRepository;
import com.example.pernsonalDictionary.repository.ExpressionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpressionService {

    @Autowired
    private ExpressionRepository expressionRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ExampleService exampleService;

    public List<Expression> findAll(User owner){
        return expressionRepository.findAllByOwnerOrderByTextAsc(owner);
    }

    public List<Expression> findTop10(User owner){
        return expressionRepository.findTop10ByOwnerOrderByTextAsc(owner);
    }

    public Expression insert(ExpressionDTO dto, User user){

        Expression expression = new Expression();

        expression.setText(dto.getText());
        expression.setTranslation(dto.getTranslation());
        expression.setCategory(categoryRepository.findBycategoryName(dto.getCategory()).get());
        expression.setOwner(user);

        expression = expressionRepository.save(expression);

        List<Example> exampleList = new ArrayList<>();
        for(String text: dto.getExampleList()){
            Example example = exampleService.create(text, expression);
            exampleList.add(example);
        }

        expression.setExampleList(exampleList);

        return expressionRepository.save(expression);

    }

    public void removeExpression(Expression expression){
        expressionRepository.delete(expression);
    }

    public Optional<Expression> getExpressionById(Long id){
        return expressionRepository.findByExpressionId(id);
    }

    public Expression update(ExpressionDTO dto){
        Optional<Expression> expression = expressionRepository.findByExpressionId(dto.getId());

        if(expression.isPresent()){
            Expression newExpression = expression.get();

            newExpression.setText(dto.getText());
            newExpression.setTranslation(dto.getTranslation());
            newExpression.setCategory(categoryRepository.findBycategoryName(dto.getCategory()).get());

            return expressionRepository.save(newExpression);
        }else {
            throw new ExpressionNotFoundException("Expressão não encontrada");
        }
    }

}
