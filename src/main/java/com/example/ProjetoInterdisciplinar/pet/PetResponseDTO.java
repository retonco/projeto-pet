package com.example.ProjetoInterdisciplinar.pet;

public record PetResponseDTO(
        Long id,
        String nome,
        String especie,
        String sexo,
        String raca,
        Integer idade,
        String imagem,
        String adotanteNome
) {
    public PetResponseDTO(Pet pet){
        this(
                pet.getId(),
                pet.getNome(),
                pet.getEspecie(),
                pet.getSexo().getValor(),
                pet.getRaca(),
                pet.getIdade(),
                pet.getImagem(),
                pet.getAdotante() != null ? pet.getAdotante().getNome() : null
        );
    }
}