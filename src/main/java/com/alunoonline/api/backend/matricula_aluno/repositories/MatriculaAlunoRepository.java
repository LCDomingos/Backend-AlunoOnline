package com.alunoonline.api.backend.matricula_aluno.repositories;

import com.alunoonline.api.backend.matricula_aluno.models.MatriculaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //informando que é um repository
public interface MatriculaAlunoRepository extends JpaRepository<MatriculaAluno, Long> {
    public List<MatriculaAluno> findByAlunoId(Long alunoId);
}