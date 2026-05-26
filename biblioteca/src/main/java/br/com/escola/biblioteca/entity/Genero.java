package br.com.escola.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do gênero é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100, unique = true)
    private String nome;

    @NotBlank(message = "A sigla do gênero é obrigatória")
    @Size(max = 10, message = "A sigla deve ter no máximo 10 caracteres")
    @Column(nullable = false, length = 10, unique = true)
    private String sigla;

    @OneToMany(mappedBy = "genero")
    private List<Livro> livros;
}