package com.alunoonline.api.backend.secretaria.services;

import com.alunoonline.api.backend.secretaria.models.Aluno;
import com.alunoonline.api.backend.secretaria.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Mostrando ao spring que essa classe é um service
@Service
public class AlunoService {
    //Injeta a dependencia do repository
    @Autowired
    AlunoRepository repository;

    //create vai retornar o objeto quando for chamado pelo controle
    public Aluno create (Aluno aluno){

        return repository.save(aluno);
    }

    public List<Aluno> findAll(){
        //chama o repository que foi colocado, vai me retornar todos os alunos
        return repository.findAll();
    }

    //findById vai retornar o aluno especifico, a depender do ID
    public Optional<Aluno> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
