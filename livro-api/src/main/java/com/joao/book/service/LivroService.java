package com.joao.book.service;

import static com.joao.global.util.ValidateUtil.checkExist;
import static com.joao.global.util.ValidateUtil.checkIsNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.book.model.LivroEntity;
import com.joao.book.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public LivroEntity findByIsbn(String isbn) {
		return repository.findByIsbn(isbn);
	}

	public List<LivroEntity> findByTitulo(String titulo) {
		return repository.findByTitulo(titulo);
	}

	public List<LivroEntity> findByAutor(String autor) {
		return repository.findByAutor(autor);
	}

	public List<LivroEntity> findAllLivro() {
		return repository.findAll();
	}
	
	public List<LivroEntity> findByAno(Integer ano) {
		return repository.findByAnoPublicacao(ano);
	}
	
	public void save(LivroEntity livroEntity) {
		checkExist(isbnExist(livroEntity.getIsbn()), "Error cadastrar Livro, ISBN já existe");
		repository.save(livroEntity);
	}

	public void delete(LivroEntity livroEntity) {
		checkIsNull(livroEntity, "Error excluir livro não encontrado!");
		repository.delete(livroEntity);
	}

	public void update(LivroEntity livroExistente, LivroEntity livroAtualizado) {
		checkIsNull(livroExistente, "Error atualizar livro não encontrado!");
		updateAtributos(livroExistente, livroAtualizado);
		repository.save(livroExistente);
	}
	
	private Boolean isbnExist(String isbn) {
        return repository.existsByIsbn(isbn);
    }

	private void updateAtributos(LivroEntity livroExistente, LivroEntity livroAtualizado) {
		livroExistente.setTitulo(livroAtualizado.getTitulo());
		livroExistente.setAutor(livroAtualizado.getAutor());
		livroExistente.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
		livroExistente.setIsbn(livroAtualizado.getIsbn());
	}

}
