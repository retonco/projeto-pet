package com.example.ProjetoInterdisciplinar.pet;

import com.example.ProjetoInterdisciplinar.adotante.Adotante;
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
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;
    private String raca;
    @Column(nullable = false)
    private Integer idade;
    private String imagem;

    public Pet(PetRequestDTO data) {
        this.nome = data.nome();
        this.especie = data.especie();
        this.sexo = Sexo.fromString(data.sexo());
        this.raca = data.raca();
        this.idade = data.idade();
        this.imagem = data.imagem();
    }

    //Relacionamento
    @ManyToOne
    @JoinColumn(name = "adotante_id")
    private Adotante adotante;
}
