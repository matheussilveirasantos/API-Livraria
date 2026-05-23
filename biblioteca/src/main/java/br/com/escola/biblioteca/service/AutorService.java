package br.com.escola.biblioteca.service;

import br.com.escola.biblioteca.dto.AutorRequestDTO;
import br.com.escola.biblioteca.dto.AutorResponseDTO;
import br.com.escola.biblioteca.entity.Autor;
import br.com.escola.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Service;

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

    public boolean remover(Long id) {
        if (!autorRepository.existsById(id)) {
            return false;
        }
        autorRepository.deleteById(id);
        return true;
    }
}