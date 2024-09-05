package com.joao.book;

import static com.joao.global.util.ValidateUtil.checkListIsEmpty;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.book.assembler.LivroMapper;
import com.joao.book.model.LivroEntity;
import com.joao.book.model.LivroResource;
import com.joao.book.service.LivroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/livro")
@Tag(name = "/livro")
public class LivroController {

	@Autowired
	private LivroService service;

	@Autowired
	private LivroMapper assembler;

	
	@GetMapping(produces = APPLICATION_JSON_VALUE, path = "/titulo/{titulo}")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Livros encontrados com sucesso"),
			@ApiResponse(responseCode = "404", description = "Nenhum Livro encontrado"),
			@ApiResponse(responseCode = "422", description = "Dados da requisição Inválida")
			})
	@Operation(summary = "Buscar Livros pelo Titulo", method = "GET")
	public ResponseEntity<List<LivroResource>> getLivroByTitulo(@PathVariable String titulo) {
		log.info("GET /livro/titulo/{} started", titulo);
		List<LivroEntity> livrosBuscarrrrAutor = service.findByTitulo(titulo);
		checkListIsEmpty(livrosBuscarrrrAutor, format("Nenhum livro encontrado Titulo %s", titulo));
		List<LivroResource> resources = livrosBuscarrrrAutor.stream().map(assembler::toResource).collect(toList());
		log.info("GET /livro/autor/{} completed", titulo);
		return new ResponseEntity<>(resources, OK);
	}

	@GetMapping(produces = APPLICATION_JSON_VALUE, path = "/autor/{autor}")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Livros encontrados"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "404", description = "Nenhum livro encontrado"),
			@ApiResponse(responseCode = "422", description = "Dados da requisição Inválida") })
	@Operation(summary = "Buscarrrr Livros pelo Autor", method = "GET")
	public ResponseEntity<List<LivroResource>> getLivrosByAutor(@PathVariable String autor) {
		log.info("GET /livro/autor/{} started", autor);
		List<LivroEntity> livrosBuscarrrrAutor = service.findByAutor(autor);
		checkListIsEmpty(livrosBuscarrrrAutor, format("Nenhum livro encontrado do Autor %s", autor));
		List<LivroResource> resources = livrosBuscarrrrAutor.stream().map(assembler::toResource).collect(toList());
		log.info("GET /livro/autor/{} completed", autor);
		return new ResponseEntity<>(resources, OK);
	}
	
	@GetMapping(produces = APPLICATION_JSON_VALUE, path = "/ano/{ano}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Livros encontrados"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "404", description = "Nenhum livro encontrado"),
			@ApiResponse(responseCode = "422", description = "Dados da requisição Inválida") })
	@Operation(summary = "Buscar Livros pelo Ano", method = "GET")
	public ResponseEntity<List<LivroResource>> getLivrosByAno(@PathVariable Integer ano) {
		log.info("GET /livro/ano/{} started", ano);
		List<LivroEntity> livrosBuscarrrrAno = service.findByAno(ano);
		checkListIsEmpty(livrosBuscarrrrAno, format("Nenhum livro encontrado no Ano %s", ano));
		List<LivroResource> resources = livrosBuscarrrrAno.stream().map(assembler::toResource).collect(toList());
		log.info("GET /livro/ano/{} completed", ano);
		return new ResponseEntity<>(resources, OK);
	}

	@GetMapping(produces = APPLICATION_JSON_VALUE, path = "/listagem")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Livros encontrados"),
			@ApiResponse(responseCode = "404", description = "Nenhum livro encontrado"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "422", description = "Dados da requisição Inválida")})
	@Operation(summary = "Buscar todos Livros", method = "GET" )
	public ResponseEntity<List<LivroResource>> getAllLivros() {
		log.info("GET /livro/listagem started");
		List<LivroEntity> entityLivros = service.findAllLivro();
		List<LivroResource> resourceLivros = entityLivros.stream().map(assembler::toResource).collect(toList());
		log.info("GET /livro/listagem completed");
		return new ResponseEntity<>(resourceLivros, OK);
	}
	
	@PostMapping(produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "201", description = "Livros salvo com Sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados da requisição Inválida")})
	@Operation(summary = "Salvar Livro", method = "POST" )
	public ResponseEntity<LivroResource> createLivro(@Valid @RequestBody LivroResource livroDto) {
		log.info("POST /livro {} Iniciado crated", livroDto);
		LivroEntity livroModel = assembler.toEntity(livroDto);
		service.save(livroModel);
		log.info("POST /livro Finalizado crated");
		return new ResponseEntity<>(assembler.toResource(livroModel), CREATED);
	}

	@PutMapping(produces = APPLICATION_JSON_VALUE, path = "/{isbn}")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "422", description = "Dados da requisição Inválida") })
	@Operation(summary = "Atualizar Livro pelo IBSN", method = "PUT" )
	public ResponseEntity<LivroResource> updateLivroByIsbn(@PathVariable String isbn, @Valid @RequestBody LivroResource livroDto) {
		log.info("PUT /livro/edit/{} started", isbn);
		LivroEntity livroExistente = service.findByIsbn(isbn);
		service.update(livroExistente, assembler.toEntity(livroDto));
		log.info("PUT /livro/{} completed", isbn);
		return new ResponseEntity<>(NO_CONTENT);
	}

	@DeleteMapping("/{isbn}")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Livro deletado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida"),
			@ApiResponse(responseCode = "404", description = "Livro não encontrado"),
			@ApiResponse(responseCode = "422", description = "Entidade não processável") })
	@Operation(summary = "Excluir Livro pelo IBSN", method = "DELETE" )
	public ResponseEntity<LivroResource> deleteLivroByIsbn(@PathVariable String isbn) {
		log.info("DELETE /livro/{} started", isbn);
		LivroEntity livroExistente = service.findByIsbn(isbn);
		service.delete(livroExistente);
		log.info("DELETE /livro/{} completed", isbn);
		return new ResponseEntity<>(NO_CONTENT);
	}
}
