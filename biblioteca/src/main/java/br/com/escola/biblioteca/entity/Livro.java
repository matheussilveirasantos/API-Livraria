package br.com.escola.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="livro")

public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título não pode estar vazio")
    @Size(max = 200, message = "O título ultrapassou o limite de caracteres")
    @Column(nullable = false, length = 200)
    private String titulo;

    @NotBlank(message = "O ISBN não pode estar vazio")
    @Size (max = 13, message = "Você ultrapassou o numero máximo de caracteres")
    @Column(nullable = false, length = 13)
    private String isbn;

    @NotNull(message = "O ano de publicação não pode estar vazio")
    @Column(nullable = false)
    private Integer anoPublicacao;

    @NotBlank(message = "O gênero não pode estar vazio")
    @Size(max = 30, message = "Você ultrapassou o número máximo de caracteres")
    @Column(nullable = false, length = 30)
    private String genero;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    public Livro(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }



}
