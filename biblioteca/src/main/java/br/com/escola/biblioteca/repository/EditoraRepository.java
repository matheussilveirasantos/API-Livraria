package br.com.escola.biblioteca.repository;

import br.com.escola.biblioteca.entity.Editora;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

    boolean existsByCnpj(String cnpj);

	boolean existsByNomeIgnoreCase(String nome);
	
	boolean existsBySiglaIgnoreCase(String sigla);

}
