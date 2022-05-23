package com.example.pernsonalDictionary.controller;

import com.example.pernsonalDictionary.model.Category;
import com.example.pernsonalDictionary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Category>findByID(@PathVariable Long id){
        return categoryService.findById(id)
                .map(ResponseEntity :: ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "category")
    public ResponseEntity<String>insert(@RequestBody Category category){
        try {
            categoryService.insert(category);
            return ResponseEntity.status(HttpStatus.CREATED).body("Categoria inserida com sucesso");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao inserir Categoria");
        }
    }
}
