package com.example.pernsonalDictionary.repository;

import com.example.pernsonalDictionary.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findByCategoryId(Long id);
}
