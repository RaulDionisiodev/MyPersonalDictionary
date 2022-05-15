package com.example.pernsonalDictionary.repository;

import com.example.pernsonalDictionary.model.Expression;
import com.example.pernsonalDictionary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpressionRepository extends JpaRepository<Expression, Integer> {

     List<Expression> findAllByOrderByTextAsc();

     List<Expression> findTop10ByOwnerOrderByTextAsc(User owner);

     List<Expression> findAllByOwnerOrderByTextAsc(User owner);

     Optional<Expression> findByExpressionId(Long id);

}