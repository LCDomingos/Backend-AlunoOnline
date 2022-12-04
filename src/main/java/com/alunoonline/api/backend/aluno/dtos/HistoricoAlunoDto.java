package com.alunoonline.api.backend.aluno.dtos;

import lombok.Data;

import java.util.List;

@Data
public class HistoricoAlunoDto {

    private String nomeAluno;
    private String cursoAluno;
    private List<DisciplinasAlunoDto> disciplinasAlunoList;
}