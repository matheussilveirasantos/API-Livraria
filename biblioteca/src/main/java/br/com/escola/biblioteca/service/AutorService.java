package br.com.escola.biblioteca.service;

import br.com.escola.biblioteca.dto.AutorRequestDTO;
import br.com.escola.biblioteca.dto.AutorResponseDTO;
import br.com.escola.biblioteca.entity.Autor;
import br.com.escola.biblioteca.repository.AutorRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<AutorResponseDTO> listar() {
        return autorRepository.findAll()
                .stream()
                .map(AutorResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<AutorResponseDTO> buscarPorId(Long id) {
        return autorRepository.findById(id)
                .map(AutorResponseDTO::fromEntity);
    }

    public AutorResponseDTO salvar(AutorRequestDTO dto) {
        Autor autor = new Autor();
        autor.setNome(dto.nome());
        autor.setNacionalidade(dto.nacionalidade());
        autor.setDataNascimento(dto.dataNascimento());
        return AutorResponseDTO.fromEntity(autorRepository.save(autor));
    }
   
    public List<AutorResponseDTO> salvarLote(List<AutorRequestDTO> dtos) {
        List<Autor> autores = dtos.stream()
                .map(dto -> {
                    Autor autor = new Autor();
                    autor.setNome(dto.nome());
                    autor.setNacionalidade(dto.nacionalidade());
                    autor.setDataNascimento(dto.dataNascimento());
                    return autor;
                })
                .collect(Collectors.toList());

        return autorRepository.saveAll(autores)
                .stream()
                .map(AutorResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<AutorResponseDTO> atualizar(Long id, AutorRequestDTO dto) {
        return autorRepository.findById(id)
                .map(autor -> {
                    autor.setNome(dto.nome());
                    autor.setNacionalidade(dto.nacionalidade());
                    autor.setDataNascimento(dto.dataNascimento());
                    return AutorResponseDTO.fromEntity(autorRepository.save(autor));
                });
    }

  
    public void remover(Long id) {
        Autor autor = autorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Autor não encontrado com id: " + id));

        if (autor.getLivros() != null && !autor.getLivros().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Não é possível excluir o autor porque ele possui livros associados.");
        }
        autorRepository.deleteById(id);
       
    }
}