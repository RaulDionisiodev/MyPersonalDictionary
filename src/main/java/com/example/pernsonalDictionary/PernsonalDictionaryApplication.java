package com.example.pernsonalDictionary;

import com.example.pernsonalDictionary.model.Category;
import com.example.pernsonalDictionary.model.Example;
import com.example.pernsonalDictionary.model.Expression;
import com.example.pernsonalDictionary.model.User;
import com.example.pernsonalDictionary.repository.CategoryRepository;
import com.example.pernsonalDictionary.repository.ExampleRepository;
import com.example.pernsonalDictionary.repository.ExpressionRepository;
import com.example.pernsonalDictionary.repository.UserRepository;
import com.example.pernsonalDictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class PernsonalDictionaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PernsonalDictionaryApplication.class, args);
	}

}
