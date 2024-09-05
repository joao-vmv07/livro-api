package com.joao.book.model;

import static com.joao.book.util.ValidateUtil.validarEntity;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.validation.ConstraintViolationException;

@SpringBootTest
public class LivroResourceTest {
	
	private LivroResource livroValido;

	@BeforeEach
	void setup() {
		livroValido = new LivroResource();
		livroValido.setTitulo("O Senhor dos Anéis");
		livroValido.setAutor("J.R.R. Tolkien");
		livroValido.setAnoPublicacao(1954);
		livroValido.setIsbn("9780261103573");
	}

	// Testes para o título
	@Test
	void deve_aceitar_titulo_valido() {
		livroValido.setTitulo("Título Válido");
		assertDoesNotThrow(() -> validarEntity(livroValido));
	}

	@Test
	void nao_deve_aceitar_titulo_nulo() {
		livroValido.setTitulo(null);
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}

	@Test
	void nao_deve_aceitar_titulo_vazio() {
		livroValido.setTitulo("");
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}
	
	@Test
	void nao_deve_aceitar_titulo_vazio_space() {
		livroValido.setTitulo(" ");
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}
	
	@Test
	void nao_deve_aceitar_titulo_acima_size() {
		livroValido.setTitulo("TituloTituloTituloTituloTituloTituloTituloTitulo");
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}

	// Testes para o autor
	@Test
	void deve_aceitar_autor_valido() {
		livroValido.setAutor("Autor Válido");
		assertDoesNotThrow(() -> validarEntity(livroValido));
	}

	@Test
	void nao_deve_aceitar_autor_nulo() {
		livroValido.setAutor(null);
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}

	@Test
	void nao_deve_aceitar_autor_vazio() {
		livroValido.setAutor("");
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}
	
	@Test
	void nao_deve_aceitar_autor_vazio_space() {
		livroValido.setTitulo(" ");
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}
	
	@Test
	void nao_deve_aceitar_autor_acima_size() {
		livroValido.setAutor("autorautorautorautorautorautorautorautorautorautorautor");
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}

	// Testes para o ano de publicação
	@Test
	void deve_aceitar_ano_publicacao_valido() {
		livroValido.setAnoPublicacao(2024);
		assertDoesNotThrow(() -> validarEntity(livroValido));
	}

	@Test
	void nao_deve_aceitar_ano_publicacao_nulo() {
		livroValido.setAnoPublicacao(null);
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}

	// Testes para o ISBN
	@Test
	void deve_aceitar_isbn_valido() {
		livroValido.setIsbn("9781234567890");
		assertDoesNotThrow(() -> validarEntity(livroValido));
	}

	@Test
	void nao_deve_aceitar_isbn_nulo() {
		livroValido.setIsbn(null);
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}

	@Test
	void nao_deve_aceitar_isbn_vazio() {
		livroValido.setIsbn("");
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}

	@Test
	void nao_deve_aceitar_isbn_vazio_com_space() {
		livroValido.setIsbn(" ");
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}

	@Test
	void nao_deve_aceitar_isbn_com_tamanho_maior_requerido() {
		livroValido.setIsbn("97812345678"); 
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}
	
	@Test
	void nao_deve_aceitar_isbn_com_tamanho_maenor_requerido() {
		livroValido.setIsbn("9781"); 
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}

	@Test
	void nao_deve_aceitar_isbn_com_letras_invalidas() {
		livroValido.setIsbn("9781234A6789");
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}
	
	
	@Test
	void nao_deve_aceitar_isbn_com_espacos() {
		livroValido.setIsbn("978 123456789");
		assertThrows(ConstraintViolationException.class, () -> validarEntity(livroValido));
	}
}
