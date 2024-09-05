package com.joao.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joao.book.model.LivroEntity;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
	
	LivroEntity findByIsbn(String isbn);

	Boolean existsByIsbn(String isbn);

	List<LivroEntity> findByTitulo(String titulo);

	List<LivroEntity> findByAutor(String autor);

	List<LivroEntity> findByAnoPublicacao(Integer anoPublicacao);
	
}