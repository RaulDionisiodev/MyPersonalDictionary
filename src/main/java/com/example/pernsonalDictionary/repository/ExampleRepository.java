package com.example.pernsonalDictionary.repository;

import com.example.pernsonalDictionary.model.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<Example, Integer> {
}
