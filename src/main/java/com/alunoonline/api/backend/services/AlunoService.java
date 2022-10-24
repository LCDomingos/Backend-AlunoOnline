package com.alunoonline.api.backend.services;

import com.alunoonline.api.backend.models.Aluno;
import com.alunoonline.api.backend.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Mostrando abaixo com @Service que essa classe é um service ao spring
@Service
public class AlunoService {
    //injetando_todo o repository no Service
    @Autowired
    AlunoRepository repository;

    public Aluno create (Aluno aluno){

        return repository.save(aluno);
    }

    public List<Aluno> findAll(){
        //chama o repository que coloquei
        return repository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
