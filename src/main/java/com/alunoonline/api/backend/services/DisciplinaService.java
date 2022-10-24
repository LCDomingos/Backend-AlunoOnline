package com.alunoonline.api.backend.services;

import com.alunoonline.api.backend.models.Disciplina;
import com.alunoonline.api.backend.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository repository;

    public Disciplina create (Disciplina disciplina){

        return repository.save(disciplina);
    }


}
