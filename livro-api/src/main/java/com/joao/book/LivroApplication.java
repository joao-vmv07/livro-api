package com.joao.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Livro API", version = "1", description = "API RESTful para gerenciar catálogo de livros"))
public class LivroApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivroApplication.class, args);
	}

}
