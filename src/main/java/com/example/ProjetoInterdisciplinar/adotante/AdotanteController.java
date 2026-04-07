package com.example.ProjetoInterdisciplinar.adotante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adotantes")
@CrossOrigin(origins = "*")
public class AdotanteController {

    @Autowired
    private AdotanteRepository repository;

    @PostMapping
    public void salvar(@RequestBody Adotante adotante){
        repository.save(adotante);
    }

    @GetMapping
    public List<Adotante> listar(){
        return repository.findAll();
    }
}