package com.example.pernsonalDictionary.repository;

import com.example.pernsonalDictionary.model.Expression;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpressionRepository extends JpaRepository<Expression, Integer> {

     List<Expression> findAllByOrderByTextAsc();

     List<Expression> findTop10ByOrderByTextAsc();

}