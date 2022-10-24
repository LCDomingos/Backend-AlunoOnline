package com.alunoonline.api.backend.repositories;

import com.alunoonline.api.backend.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Mostrando para o spring que isso é um  repository
@Repository
//extends JpaRepository: utiliza o SpringData para realizar a comunicação com o BD
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
