package com.alunoonline.api.backend.controllers;


import com.alunoonline.api.backend.models.Aluno;
import com.alunoonline.api.backend.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
//Tudo que o creater http chamar pelo 8080/Alunos ele procura nos metodos dessa classe
@RequestMapping("/aluno")
public class AlunoController {
    //Injetando dependencia do aluno service
    @Autowired
    AlunoService service;

    //atravez do postMapping que o spring vai saber que é para criação
    //é aqui no controller que colocamos todos aqueles metodos post, patch e afins
    //Então vamos usar post para poder criar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    //para o controller se comunicar com o service
    //Aqui vai vir http além da linguagem Java
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno){
        Aluno alunoCreated = service.create(aluno);

        return ResponseEntity.status(201).body(alunoCreated);


    }

    //metodo para buscar um dado
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    //metodo para listar todos os alunos do BD
    public List<Aluno>findAll(){
        return service.findAll();
    }

    //o findbyidtras p a gente o objeto que queremos a partir do ID cadastrado
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
