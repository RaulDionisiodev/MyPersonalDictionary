package com.example.pernsonalDictionary.repository;

import com.example.pernsonalDictionary.model.Expression;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpressionRepository extends JpaRepository<Expression, Integer> {
}
