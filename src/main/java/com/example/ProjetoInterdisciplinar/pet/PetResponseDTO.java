package com.example.ProjetoInterdisciplinar.pet;

public record PetResponseDTO (Long id, String nome, String especie, String sexo, String raca, Integer idade, String imagem) {
    public PetResponseDTO(Pet pet){
        this(pet.getId(), pet.getNome(), pet.getEspecie(), pet.getSexo(),pet.getRaca(), pet.getIdade(), pet.getImagem());
    }
}
