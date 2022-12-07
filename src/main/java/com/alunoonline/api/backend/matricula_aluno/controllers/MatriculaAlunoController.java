package com.alunoonline.api.backend.matricula_aluno.controllers;

import com.alunoonline.api.backend.matricula_aluno.dtos.HistoricoAlunoDto;
import com.alunoonline.api.backend.matricula_aluno.dtos.MatriculaAlunoNotasOnlyDto;
import com.alunoonline.api.backend.matricula_aluno.models.MatriculaAluno;
import com.alunoonline.api.backend.matricula_aluno.services.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //informando que é um restController
@RequestMapping("/matricula-aluno") //Requisição http
public class MatriculaAlunoController {

    @Autowired //injetando o dependencia
    MatriculaAlunoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //Aqui vamos implementar o metodo de creater já implementado no service
    public ResponseEntity<MatriculaAluno> create(@RequestBody MatriculaAluno matriculaAluno) {
        MatriculaAluno matriculaAlunoCreated = service.create(matriculaAluno);

        return ResponseEntity.status(201).body(matriculaAlunoCreated);//criando o end point para minha matricula do aluno
    }

    @PatchMapping("/updateGrades/{id}") //para atualizar a nota dada pelo professor
    @ResponseStatus(HttpStatus.OK)
    public void patchGrades(@RequestBody MatriculaAlunoNotasOnlyDto notasOnlyDto,
                            @PathVariable Long id) {
        service.updateGrades(notasOnlyDto, id);
    }

    @PatchMapping("/updateStatusToBreak/{id}") //para fazer o trancamento da disciplina
    @ResponseStatus(HttpStatus.OK)
    public void patchStatus(@PathVariable Long id) throws Exception {
        service.updateStatusToBreak(id);
    }

    @GetMapping("/studentGrades/{id}") //Historico do aluno
    @ResponseStatus(HttpStatus.OK)
    public HistoricoAlunoDto studentGrades(@PathVariable Long id) {
        return service.getHistoricoFromAluno(id);
    }


}