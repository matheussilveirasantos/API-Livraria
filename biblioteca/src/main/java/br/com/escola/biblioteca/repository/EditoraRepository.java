package br.com.escola.biblioteca.repository;

import br.com.escola.biblioteca.entity.Editora;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
    Optional<Editora> findByCnpj(String cnpj);
    boolean existsByCnpj(String cnpj);

	boolean existsByNomeIgnoreCase(String nome);
	
	boolean existsBySiglaIgnoreCase(String sigla);

}
