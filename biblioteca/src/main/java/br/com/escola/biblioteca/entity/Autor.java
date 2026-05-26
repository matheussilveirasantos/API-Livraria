package br.com.escola.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autor")
@Getter @Setter @NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do autor é obrigatório")
    @Size(max = 100, message = "O nome do autor deve ter no máximo 100 caracteres")
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "Nacionalidade do autor é obrigatória")
    @Size(max = 50, message = "A nacionalidade deve ter no máximo 50 caracteres")
    @Column(name = "nacionalidade", nullable = false, length = 50)
    private String nacionalidade;

    @NotNull(message = "Data de nascimento do autor é obrigatória")
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
    private List<Livro> livros;
}
