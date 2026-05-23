package br.com.escola.biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRequestDTO(
		@NotBlank(message="Nenhum atributo pode está vazio")
		@NotNull(message="O titulo é obrigatória")
		String titulo,
		@NotNull(message="O isbn é obrigatório")
		String isbn,
		@NotNull(message="O ano de publicação é obrigatório")
		Integer anoPublicacao,
		@NotNull(message="O gênero é obrigatótio")
		String genero,
		@NotNull(message="O autor é obrigatório")
		Long autorId) {
}
