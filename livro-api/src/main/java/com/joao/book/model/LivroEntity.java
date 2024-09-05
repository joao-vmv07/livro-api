package com.joao.book.model;
import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "tb_livro",indexes = {@Index(name = "idx_isbn", columnList = "isbn", unique = true)})
public class LivroEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@NotBlank(message = "Título deve ser informado!")
	@Size(max = 35, message = "Título deve ter no máximo 35 caracteres")
	private String titulo;

	@NotBlank(message = "Autor deve ser informado!")
	@Size(max = 35, message = "Autor deve ter no máximo 35 caracteres")
	private String autor;

	@NotNull(message = "Ano de publicação deve ser informado!")
	private Integer anoPublicacao;

	
	@NotBlank(message = "ISBN deve ser informado!")
	@Size(min = 10, max = 13, message = "ISBN deve ter entre 10 e 13 caracteres")
	@Pattern(regexp = "^(978|979)?[0-9]{9}[0-9X]$", message = "ISBN Invalido!")
	private String isbn;
	
	
}
