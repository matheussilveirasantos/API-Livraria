package br.com.escola.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escola.biblioteca.dto.LivroRequestDTO;
import br.com.escola.biblioteca.dto.LivroResponseDTO;
import br.com.escola.biblioteca.entity.Autor;
import br.com.escola.biblioteca.entity.Livro;
import br.com.escola.biblioteca.repository.AutorRepository;
import br.com.escola.biblioteca.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private AutorRepository autorRepository;

	// POST /livros

	public LivroResponseDTO criar(LivroRequestDTO requestLivro) {

		Optional<Autor> autorOptional = Optional.ofNullable(autorRepository.findById(requestLivro.autorId())
				.orElseThrow(() -> new RuntimeException("Autor não encontrado com id")));

		Livro livro = new Livro();
		livro.setTitulo(requestLivro.titulo());
		livro.setIsbn(requestLivro.isbn());
		livro.setAnoPublicacao(requestLivro.anoPublicacao());
		livro.setGenero(requestLivro.genero());
		livro.setAutor(autorOptional.get());

		return LivroResponseDTO.fromEntity(livroRepository.save(livro));

	}

	public List<LivroResponseDTO> criarLote(List<LivroRequestDTO> listaRequest) {

		List<Livro> livros = listaRequest.stream().map(listaDTO -> {
			Autor autor = autorRepository.findById(listaDTO.autorId())
					.orElseThrow(() -> new RuntimeException("Autor não encontrado com id: " + listaDTO.autorId()));
			Livro livro = new Livro();
			livro.setTitulo(listaDTO.titulo());
			livro.setIsbn(listaDTO.isbn());
			livro.setAnoPublicacao(listaDTO.anoPublicacao());
			livro.setGenero(listaDTO.genero());
			livro.setAutor(autor);
			return livro;

		}).collect(Collectors.toList());

		return livroRepository.saveAll(livros).stream().map(LivroResponseDTO::fromEntity).collect(Collectors.toList());

	}

	// GET /livros
	public List<LivroResponseDTO> listarTodos() {
		List<Livro> livros = livroRepository.findAll();
		List<LivroResponseDTO> listaResposta = new ArrayList<>();

		for (Livro livro : livros) {
			listaResposta.add(LivroResponseDTO.fromEntity(livro));
		}

		return listaResposta;
	}

	// GET /livros/{id}

	public LivroResponseDTO buscarPorId(Long id) {
		Optional<Livro> livroOptional = livroRepository.findById(id);
		if (livroOptional.isPresent()) {
			return LivroResponseDTO.fromEntity(livroOptional.get());

		}
		return null;
	}

	// PUT /livros/{id}

	public LivroResponseDTO atualizar(LivroRequestDTO livroRequest, Long id) {
		Livro livro = livroRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Livro não encontrado com id " + id));
		livro.setTitulo(livroRequest.titulo());
		livro.setIsbn(livroRequest.isbn());
		livro.setGenero(livroRequest.genero());
		livro.setAnoPublicacao(livroRequest.anoPublicacao());

		Autor autor = autorRepository.findById(livroRequest.autorId())
				.orElseThrow(() -> new RuntimeException("Autor não encontrado com id: " + livroRequest.autorId()));
		livro.setAutor(autor);
		return LivroResponseDTO.fromEntity(livroRepository.save(livro));

	}

	// DELETE /livros/{id}

	public void deletar(Long id) {
		if (livroRepository.existsById(id)) {
			livroRepository.deleteById(id);

		}

	}

}
