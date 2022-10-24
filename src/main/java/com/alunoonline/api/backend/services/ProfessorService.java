package com.alunoonline.api.backend.services;


import com.alunoonline.api.backend.models.Professor;
import com.alunoonline.api.backend.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository repository;

    public Professor create (Professor professor){

        return repository.save(professor);
    }


}
