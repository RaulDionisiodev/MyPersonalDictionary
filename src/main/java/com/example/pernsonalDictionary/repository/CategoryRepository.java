package com.example.pernsonalDictionary.repository;

import com.example.pernsonalDictionary.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
