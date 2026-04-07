package com.example.ProjetoInterdisciplinar.adotante;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "adotantes")
public class Adotante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public Adotante() {
    }

    public Adotante(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
}