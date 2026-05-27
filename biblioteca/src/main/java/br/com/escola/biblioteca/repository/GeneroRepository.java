package br.com.escola.biblioteca.repository;

import br.com.escola.biblioteca.entity.Genero;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Optional<Genero> findBySiglaIgnoreCase(String sigla);

	boolean existsByNomeIgnoreCase(String nome);

	boolean existsBySiglaIgnoreCase(String sigla);


}