package br.com.escola.biblioteca.dto;

import br.com.escola.biblioteca.entity.Autor;

import java.time.LocalDate;

public record AutorResponseDTO(
        Long id,
        String nome,
        String nacionalidade,
        LocalDate dataNascimento) {

    public AutorResponseDTO(Autor autor) {
        this(
                autor.getId(),
                autor.getNome(),
                autor.getNacionalidade(),
                autor.getDataNascimento()
        );
    }
}