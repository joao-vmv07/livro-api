package com.joao.book.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "Resource Livro")
public class LivroResource {
	

    @Schema(description = "Título do livro", example = "O Senhor dos Anéis")
	@NotBlank(message = "Título deve ser informado!")
	@Size(max = 35, message = "Título deve ter no máximo 255 caracteres")
	private String titulo;

    @Schema(description = "Nome do autor", example = "J.R.R. Tolkien")
	@NotBlank(message = "Autor deve ser informado!")
	@Size(max = 35, message = "Autor deve ter no máximo 255 caracteres")
	private String autor;

    @Schema(description = "Ano publicado", example = "1980")
	@NotNull(message = "Ano de publicação deve ser informado!")
	private Integer anoPublicacao;


    @Schema(description = "ISBN do livro (codigo indentificador)", example = "9783161484100")
	@NotBlank(message = "ISBN deve ser informado!")
	@Size(min = 10, max = 13, message = "ISBN deve ter entre 10 e 13 caracteres")
	@Pattern(regexp = "^(978|979)?[0-9]{9}[0-9X]$", message = "ISBN Invalido!")
	private String isbn;

}
