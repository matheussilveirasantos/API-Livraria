package br.com.escola.biblioteca.controller;

import br.com.escola.biblioteca.dto.LivroRequestDTO;
import br.com.escola.biblioteca.dto.LivroResponseDTO;
import br.com.escola.biblioteca.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
@Tag(name = "Livros", description = "Operações relacionadas aos livros")
public class LivroController {

	private final LivroService livroService;

	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}

	@Operation(summary = "Cadastrar livro", description = "Cria um novo livro vinculado a um autor")
	@PostMapping
	public ResponseEntity<LivroResponseDTO > criar(@Valid @RequestBody LivroRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(livroService.criar(dto));
	}

	@Operation(summary = "Cadastrar vários livros", description = "Cria múltiplos livros de uma vez")
	@PostMapping("/lote")
	public ResponseEntity<List<LivroResponseDTO>> criarLote(@RequestBody @Valid List<LivroRequestDTO> dtos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(livroService.criarLote(dtos));
	}

	@Operation(summary = "Listar livros", description = "Retorna todos os livros cadastrados")
	@GetMapping
	public ResponseEntity<List<LivroResponseDTO>> listarTodos() {
		return ResponseEntity.ok(livroService.listarTodos());
	}

	@Operation(summary = "Buscar livro por ID", description = "Retorna um livro pelo seu ID")
	@GetMapping("/{id}")
	public ResponseEntity<LivroResponseDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(livroService.buscarPorId(id));
	}

	@Operation(summary = "Atualizar livro", description = "Atualiza os dados de um livro existente")
	
	@PutMapping("/{id}")
	public ResponseEntity<LivroResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody LivroRequestDTO dto) {
		return ResponseEntity.ok(livroService.atualizar(dto,id));
	}

	@Operation(summary = "Deletar livro", description = "Remove um livro do sistema")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		livroService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
