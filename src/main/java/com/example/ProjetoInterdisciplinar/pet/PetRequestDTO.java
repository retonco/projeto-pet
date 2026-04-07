package com.example.ProjetoInterdisciplinar.pet;

import jakarta.validation.constraints.*;

public record PetRequestDTO (

        @NotBlank
        String nome,

        @NotBlank
        String especie,

        @NotBlank
        @Pattern(regexp = "MACHO|FEMEA", message = "Sexo deve ser MACHO ou FEMEA")
        String sexo,

        String raca,

        @NotNull
        @Min(0)
        @Max(360)
        Integer idade,

        String imagem
) {}