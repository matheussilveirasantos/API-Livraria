package br.com.escola.biblioteca.controller;

import br.com.escola.biblioteca.dto.AutorRequestDTO;
import br.com.escola.biblioteca.dto.AutorResponseDTO;
import br.com.escola.biblioteca.service.AutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Tag(name = "Autores", description = "Gerenciamento de autores")
@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    @Operation(summary = "Lista todos os autores")
    public ResponseEntity<List<AutorResponseDTO>> listar() {
        return ResponseEntity.ok(autorService.listar());
    }
        
    @GetMapping("/{id}")
    @Operation(summary = "Busca autor por ID")
    public ResponseEntity<AutorResponseDTO> buscarPorId(@PathVariable Long id) {
        Optional<AutorResponseDTO> autor = autorService.buscarPorId(id);
        if (autor.isPresent()) {
            return ResponseEntity.ok(autor.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Cadastra novo autor")
    @ResponseStatus(HttpStatus.CREATED)
    public AutorResponseDTO criar(@Valid @RequestBody AutorRequestDTO dto) {
        return autorService.salvar(dto);
    }

    @PostMapping("/lote")
    @Operation(summary = "Cadastra vários autores de uma vez")
    @ResponseStatus(HttpStatus.CREATED)
    public List<AutorResponseDTO> criarLote(@Valid @RequestBody List<AutorRequestDTO> dtos) {
        return autorService.salvarLote(dtos);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza autor")
    public ResponseEntity<AutorResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody AutorRequestDTO dto) {
        Optional<AutorResponseDTO> atualizado = autorService.atualizar(id, dto);
        if (atualizado.isPresent()) {
            return ResponseEntity.ok(atualizado.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove autor")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (autorService.remover(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}