package br.com.escola.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import br.Enum.Estado;

@Entity
@Table(name = "editora")
@Getter
@Setter
@NoArgsConstructor

public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Infelizmente o nome não pode ser nulo!")
    @Size(max = 100, message = "Tamanho maximo atigido de 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O cnpj é obrigatorio")
    @Column(length = 18, nullable = false)
    private String cnpj;

    private Estado estado;

    @OneToMany(mappedBy = "editora", fetch = FetchType.LAZY)
    private List<Livro> livros;

    

}
