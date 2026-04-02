package com.example.ProjetoInterdisciplinar.pet;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "pets")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String especie;
    private String sexo;
    private String raca;
    private Integer idade;
    private String imagem;

    public Pet(PetRequestDTO data) {
        this.nome = data.nome();
        this.especie = data.especie();
        this.sexo = data.sexo();
        this.raca = data.raca();
        this.idade = data.idade();
        this.imagem = data.imagem();
    }
}
