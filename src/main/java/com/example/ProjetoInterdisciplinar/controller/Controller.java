package com.example.ProjetoInterdisciplinar.controller;

import com.example.ProjetoInterdisciplinar.pet.Pet;
import com.example.ProjetoInterdisciplinar.pet.PetRepository;
import com.example.ProjetoInterdisciplinar.pet.PetRequestDTO;
import com.example.ProjetoInterdisciplinar.pet.PetResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("bobconnect")
public class Controller {
    @Autowired
    private PetRepository repository;

    @PostMapping
    public void inserirPet(@RequestBody PetRequestDTO data){
        Pet petData = new Pet(data);
        repository.save(petData);
        return;
    }

    @GetMapping
    public List<PetResponseDTO> getAll(){
        List<PetResponseDTO> petList = repository.findAll().stream().map(PetResponseDTO::new).toList();
        return petList;
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id){
        repository.deleteById(id);
        System.out.println("Deletado com sucesso");
    }

    @PutMapping("/{id}")
    public PetResponseDTO updatePet(@PathVariable Long id, @RequestBody PetRequestDTO data){

        Pet pet = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        pet.setNome(data.nome());
        pet.setEspecie(data.especie());
        pet.setSexo(data.sexo());
        pet.setRaca(data.raca());
        pet.setIdade(data.idade());
        pet.setImagem(data.imagem());

        repository.save(pet);

        return new PetResponseDTO(pet);
    }

}
