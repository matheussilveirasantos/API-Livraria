package br.com.escola.biblioteca.service;

import br.Enum.Estado;
import br.com.escola.biblioteca.dto.EditoraRequestDTO;
import br.com.escola.biblioteca.dto.EditoraResponseDTO;
import br.com.escola.biblioteca.entity.Editora;
import br.com.escola.biblioteca.repository.EditoraRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EditoraService {

    private final EditoraRepository editoraRepository;

    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    public List<EditoraResponseDTO> listar() {
        return editoraRepository.findAll()
                .stream()
                .map(EditoraResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<EditoraResponseDTO> buscarPorId(Long id) {
        return editoraRepository.findById(id)
                .map(EditoraResponseDTO::fromEntity);
    }

    public EditoraResponseDTO salvar(EditoraRequestDTO dto) {

        if (editoraRepository.existsByCnpj(dto.cnpj())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Já existe uma editora cadastrada com este CNPJ."
            );
        }

        Editora editora = new Editora();
        editora.setNome(dto.nome());
        editora.setCnpj(dto.cnpj());
        editora.setEstado(converterEstado(dto.estado()));

        return EditoraResponseDTO.fromEntity(
                editoraRepository.save(editora)
        );
    }

    public Optional<EditoraResponseDTO> atualizar(Long id, EditoraRequestDTO dto) {

        return editoraRepository.findById(id)
                .map(editora -> {

                    editora.setNome(dto.nome());
                    editora.setCnpj(dto.cnpj());
                    editora.setEstado(converterEstado(dto.estado()));

                    return EditoraResponseDTO.fromEntity(
                            editoraRepository.save(editora)
                    );
                });
    }

    public void remover(Long id) {

        Editora editora = editoraRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Editora não encontrada com id: " + id)
                );

        if (editora.getLivros() != null &&
                !editora.getLivros().isEmpty()) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Não é possível excluir a editora porque ela possui livros associados."
            );
        }

        editoraRepository.deleteById(id);
    }

    private Estado converterEstado(String estado) {

        try {
            return Estado.valueOf(estado.toUpperCase());

        } catch (IllegalArgumentException e) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Estado inválido."
            );
        }
    }
}
