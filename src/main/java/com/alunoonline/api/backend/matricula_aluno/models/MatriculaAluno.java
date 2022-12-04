package com.alunoonline.api.backend.matricula_aluno.models;

import com.alunoonline.api.backend.secretaria.models.Aluno;
import com.alunoonline.api.backend.secretaria.models.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//com o @Entity o BD já sacou que isso seria uma tabela
//Essa será a classe que irá prover todas as ações dos alunos
public class MatriculaAluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Cada matricula de Aluno tera seu respectivo ID (sua chave primaria)
    private Long id;
    //Aqui colocamos que cada aluno terá duas notas
    private Double nota1;

    private Double nota2;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    private String status;

}