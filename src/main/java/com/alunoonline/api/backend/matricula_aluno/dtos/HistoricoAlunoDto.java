package com.alunoonline.api.backend.matricula_aluno.dtos;

import lombok.Data;

import java.util.List;

@Data
public class HistoricoAlunoDto {
    //atributos para o historico
    private String nomeAluno;
    private String cursoAluno;
    private List<DisciplinasAlunoDto> disciplinasAlunoList; //aqui vamos precisar criar uma classe DisciplinasAluniDTO
}