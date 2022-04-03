package com.example.pernsonalDictionary.service;

import com.example.pernsonalDictionary.model.Category;
import com.example.pernsonalDictionary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id){
        return categoryRepository.findByCategoryId(id);
    }

    public void insert(Category category){
        categoryRepository.save(category);
    }
}
