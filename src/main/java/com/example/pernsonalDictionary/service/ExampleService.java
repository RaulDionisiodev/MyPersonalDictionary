package com.example.pernsonalDictionary.service;

import com.example.pernsonalDictionary.model.Example;
import com.example.pernsonalDictionary.model.Expression;
import com.example.pernsonalDictionary.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @Autowired
    private ExampleRepository exampleRepository;

    public Example create(String text, Expression expression){
        Example example = new Example(null, expression, text);
        return exampleRepository.save(example);
    }

    public void delete(Example example){
        exampleRepository.delete(example);
    }
}
