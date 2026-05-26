package br.com.escola.biblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.com.escola.biblioteca.dto.EditoraRequestDTO;
import br.com.escola.biblioteca.dto.EditoraResponseDTO;
import br.com.escola.biblioteca.service.EditoraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Editoras", description = "Gerenciamento de editoras")
@RestController 
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @GetMapping
    @Operation(summary = "Lista todas as editoras")
    public ResponseEntity<List<EditoraResponseDTO>> listar() {
        return ResponseEntity.ok(editoraService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca editora por ID")
    public ResponseEntity<EditoraResponseDTO> buscarPorId(@PathVariable Long id) {
        return editoraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cadastra nova editora")
    @ResponseStatus(HttpStatus.CREATED)
    public EditoraResponseDTO criar(@Valid @RequestBody EditoraRequestDTO dto) {
        return editoraService.salvar(dto);

    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza editora")
    public ResponseEntity<EditoraResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody EditoraRequestDTO dto) {
        Optional<EditoraResponseDTO> atualizado = editoraService.atualizar(id, dto);
        if (atualizado.isPresent()) {
            return ResponseEntity.ok(atualizado.get());
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove editora")  
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (editoraService.remover(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
