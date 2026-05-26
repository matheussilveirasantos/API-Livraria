package br.com.escola.biblioteca.controller;

import br.com.escola.biblioteca.dto.GeneroRequestDTO;
import br.com.escola.biblioteca.dto.GeneroResponseDTO;
import br.com.escola.biblioteca.service.GeneroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/editora")
@Tag(name = "Gênero", description = "CRUD completo de gênero")
@SecurityRequirement(name = "BearerAuth")

public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @Operation(summary="Listar todos os gêneros")
    @GetMapping
    public ResponseEntity<List<GeneroResponseDTO>> listar() {
        return ResponseEntity.ok(generoService.listar());
    }

    @Operation(summary="Busca o gênero que você escolheu")
    @GetMapping("/{id}")
    public ResponseEntity<GeneroResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(generoService.buscarPorId(id));
    }

    @Operation(summary="Atualizar gênero por id")
    @PostMapping
    public ResponseEntity<GeneroResponseDTO> criar(@Valid @RequestBody GeneroResquestDTO generoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(generoService.criar(generoRequest));
    }

    @Operation(summary="Atualizar o gênero")
    @PutMapping("/{id}")
    public ResponseEntity<GeneroResponseDTO>atualizar(@Valid @RequestBody GeneroRequestDTO generoRequest,@PathVariable long id){
        return ResponseEntity.ok(generoService.atualizar(generoRequest, id));
    }


    @Operation(summary="Deletar gênero por id")
    @DeleteMapping("/{id}")
     public ResponseEntity <GeneroResponseDTO>deletar(@PathVariable long id){
        generoService.deletar(id);
        return ResponseEntity.noContent().build();
     }
}
