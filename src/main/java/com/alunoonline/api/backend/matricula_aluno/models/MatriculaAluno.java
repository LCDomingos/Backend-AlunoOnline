package com.alunoonline.api.backend.matricula_aluno.models;

import com.alunoonline.api.backend.secretaria.models.Aluno;
import com.alunoonline.api.backend.secretaria.models.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data //inserção dos gets e set
@NoArgsConstructor //construtores sem argumentos
@AllArgsConstructor // construtores sem argumentos
@Entity //Mostra ao bd que é referente a uma tabela
public class MatriculaAluno implements Serializable { //Abaixo atributos da classe

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera um ID aleatório
    private Long id;
    private Double nota1;
    private Double nota2;

    //Não precisamos de professor pois o professor já está ligado a disciplina
    @ManyToOne //Todos para um
    @JoinColumn(name = "aluno_id") //Join para ligar as duas tabelas
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "disciplina_id") //chave extrangeira
    private Disciplina disciplina;

    private String status;

}