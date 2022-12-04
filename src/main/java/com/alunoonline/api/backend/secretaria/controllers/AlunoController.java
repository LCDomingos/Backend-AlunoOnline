package com.alunoonline.api.backend.secretaria.controllers;


import com.alunoonline.api.backend.secretaria.models.Aluno;
import com.alunoonline.api.backend.secretaria.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//é aqui no controller que colocamos todos aqueles metodos post, patch e afins--------------------------------------

//Mostrando para o spring que isso é um  controller
@RestController
//mapeamento para que se consiga diferenciar as classes quando se usar o HTTP
@RequestMapping("/aluno")
public class AlunoController {
    //Injetando dependencia do aluno service
    @Autowired
    AlunoService service;


    //atravez do postMapping que o spring vai saber que é para criação
    //Post Mapping: para comunicação com o Json do HTTP
    @PostMapping
    //Resposta do HTTP
    @ResponseStatus(HttpStatus.CREATED)

    //para o controller se comunicar com o service
    //Aqui vai vir http além da linguagem Java
    //vai ser feito a requisição ao corpo do objeto
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno){
        Aluno alunoCreated = service.create(aluno);

        return ResponseEntity.status(201).body(alunoCreated);


    }

    //metodo para buscar qualquer dado
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    //metodo para listar todos os alunos do BD
    public List<Aluno>findAll(){
        return service.findAll();
    }

    //o findbyid tras p a gente o objeto que queremos a partir do ID cadastrado
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
