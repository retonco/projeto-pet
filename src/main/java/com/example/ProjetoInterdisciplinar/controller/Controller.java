package com.example.ProjetoInterdisciplinar.controller;

import com.example.ProjetoInterdisciplinar.pet.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("bobconnect/pets") // 🔥 AQUI
public class Controller {

    @Autowired
    private PetRepository repository;

    @PostMapping
    public void inserirPet(@RequestBody @Valid PetRequestDTO data){
        Pet petData = new Pet(data);
        repository.save(petData);
    }

    @GetMapping
    public List<PetResponseDTO> getAll(){
        return repository.findAll()
                .stream()
                .map(PetResponseDTO::new)
                .toList();
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public PetResponseDTO updatePet(@PathVariable Long id, @RequestBody @Valid PetRequestDTO data){

        Pet pet = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        pet.setNome(data.nome());
        pet.setEspecie(data.especie());
        pet.setSexo(Sexo.fromString(data.sexo()));
        pet.setRaca(data.raca());
        pet.setIdade(data.idade());
        pet.setImagem(data.imagem());

        repository.save(pet);

        return new PetResponseDTO(pet);
    }
}