package com.alunoonline.api.backend.matricula_aluno.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

// O que é uma classe DTO?
// A ideia é agrupar um conjunto de atributos em uma classe simples
// É uma classe que provê apenas os atributos necessários em um determinado processo.

public class MatriculaAlunoNotasOnlyDto {
//classe abstrata
    private Double nota1;
    private Double nota2;
}
