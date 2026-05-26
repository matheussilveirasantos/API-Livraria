package br.com.escola.biblioteca.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "autor")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome do autor é obrigatório")
	@Size(max = 100, message = "O nome do autor deve ter no máximo 100 caracteres")
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;

	@NotBlank(message = "Nacionalidade do autor é obrigatório")
	@Size(max = 50, message = "A nacionalidade do autor deve ter no máximo 50 caracteres")
	@Column(name = "nacionalidade", nullable = false, length = 50)
	private String nacionalidade;

	@NotNull(message = "Data de nascimento do autor é obrigatória")
	@Column(name = "dataNascimento", nullable = false)
	private LocalDate dataNascimento;

	@OneToMany(mappedBy = "autor",fetch =FetchType.EAGER)
	private List<Livro> livros;

}

	
