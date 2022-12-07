package com.alunoonline.api.backend.matricula_aluno.dtos;

import lombok.Data;

@Data
//Essa tabela será a list usada no historico, pois é cada disciplina que será mostrada no historico
public class DisciplinasAlunoDto {
    private String nomeDisciplina;
    private String professorDisciplina;
    private Double nota1;
    private Double nota2;
    private Double media; // com a media se sabe se o aluno ta aprovado ou reprovado
    private String status;
}