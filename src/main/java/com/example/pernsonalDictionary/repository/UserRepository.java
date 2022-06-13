package com.example.pernsonalDictionary.repository;

import com.example.pernsonalDictionary.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);

    boolean existsUserByUsername (String username);
}
