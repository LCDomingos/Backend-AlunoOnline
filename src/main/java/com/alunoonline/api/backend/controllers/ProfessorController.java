package com.alunoonline.api.backend.controllers;


import com.alunoonline.api.backend.models.Aluno;
import com.alunoonline.api.backend.models.Professor;
import com.alunoonline.api.backend.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    ProfessorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public ResponseEntity<Professor> create(@RequestBody Professor professor){
        Professor professorCreated = service.create(professor);

        return ResponseEntity.status(201).body(professorCreated);
    }






}
