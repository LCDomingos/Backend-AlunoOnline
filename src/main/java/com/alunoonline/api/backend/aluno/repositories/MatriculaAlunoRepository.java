package com.alunoonline.api.backend.aluno.repositories;

import com.alunoonline.api.backend.aluno.models.MatriculaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaAlunoRepository extends JpaRepository<MatriculaAluno, Long> {
    public List<MatriculaAluno> findByAlunoId(Long alunoId);
}