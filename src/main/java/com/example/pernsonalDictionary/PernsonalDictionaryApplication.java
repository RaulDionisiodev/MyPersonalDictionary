package com.example.pernsonalDictionary;

import com.example.pernsonalDictionary.model.Category;
import com.example.pernsonalDictionary.model.Example;
import com.example.pernsonalDictionary.model.Expression;
import com.example.pernsonalDictionary.repository.CategoryRepository;
import com.example.pernsonalDictionary.repository.ExampleRepository;
import com.example.pernsonalDictionary.repository.ExpressionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class PernsonalDictionaryApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ExampleRepository exampleRepository;
	@Autowired
	private ExpressionRepository expressionRepository;

	public static void main(String[] args) {
		SpringApplication.run(PernsonalDictionaryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category firstCategory = new Category(null, "Noum");
		Category secondCategory = new Category(null, "Adjectuve");
		categoryRepository.saveAll(Arrays.asList(firstCategory, secondCategory));
		Expression firstExpression = new Expression(null, "Book", "Livro");
		firstExpression.setCategory(firstCategory);
		Expression secondExpression =  new Expression(null, "Beautiful",
				"bonita");
		secondExpression.setCategory(secondCategory);
		expressionRepository.saveAll(Arrays.asList(firstExpression, secondExpression));
		Example firstExample = new Example(null, firstExpression, "The book is on the table");
		Example secondExample = new Example(null, secondExpression, "You are Beautiful");
		exampleRepository.save(firstExample);

	}
}
