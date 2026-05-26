package br.com.escola.biblioteca.service;

import br.com.escola.biblioteca.dto.GeneroRequestDTO;
import br.com.escola.biblioteca.dto.GeneroResponseDTO;
import br.com.escola.biblioteca.entity.Genero;
import br.com.escola.biblioteca.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneroService {

    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public GeneroResponseDTO criar(GeneroRequestDTO dto) {
        if (generoRepository.existsByNome(dto.nome())) {
            throw new RuntimeException("Já existe um gênero com o nome: " + dto.nome());
        }
        if (generoRepository.existsBySigla(dto.sigla())) {
            throw new RuntimeException("Já existe um gênero com a sigla: " + dto.sigla());
        }
        Genero genero = new Genero();
        genero.setNome(dto.nome());
        genero.setSigla(dto.sigla().toUpperCase());
        return GeneroResponseDTO.fromEntity(generoRepository.save(genero));
    }

    public List<GeneroResponseDTO> listarTodos() {
        return generoRepository.findAll()
                .stream()
                .map(GeneroResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public GeneroResponseDTO buscarPorId(Long id) {
        return generoRepository.findById(id)
                .map(GeneroResponseDTO::fromEntity)
                .orElseThrow(() -> new RuntimeException("Gênero não encontrado com id: " + id));
    }

    public GeneroResponseDTO atualizar(Long id, GeneroRequestDTO dto) {
        Genero genero = generoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gênero não encontrado com id: " + id));
        genero.setNome(dto.nome());
        genero.setSigla(dto.sigla().toUpperCase());
        return GeneroResponseDTO.fromEntity(generoRepository.save(genero));
    }

    public void deletar(Long id) {
        if (!generoRepository.existsById(id)) {
            throw new RuntimeException("Gênero não encontrado com id: " + id);
        }
        try {
            generoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir o gênero pois ele está vinculado a um ou mais livros.");
        }
    }
}
