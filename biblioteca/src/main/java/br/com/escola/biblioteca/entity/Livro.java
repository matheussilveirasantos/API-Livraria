package br.com.escola.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "livro")
@Getter @Setter @NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título não pode estar vazio")
    @Size(max = 200, message = "O título ultrapassou o limite de 200 caracteres")
    @Column(nullable = false, length = 200)
    private String titulo;

    @NotBlank(message = "O ISBN não pode estar vazio")
    @Size(max = 13, message = "O ISBN deve ter no máximo 13 caracteres")
    @Column(nullable = false, length = 13)
    private String isbn;

    @NotNull(message = "O ano de publicação não pode estar vazio")
    @Column(nullable = false)
    private Integer anoPublicacao;

    @NotNull(message = "O autor é obrigatório")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    @NotNull(message = "O gênero é obrigatório")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_genero", nullable = false)
    private Genero genero;

    @NotNull(message = "A editora é obrigatória")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_editora", nullable = false)
    private Editora editora;
}
