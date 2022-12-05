package com.alunoonline.api.backend.matricula_aluno.models;

import com.alunoonline.api.backend.secretaria.models.Aluno;
import com.alunoonline.api.backend.secretaria.models.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data //para poder usar os gets e set
@NoArgsConstructor //oara acrescentar os construtores, com e sem argumentos
@AllArgsConstructor
@Entity
//com o @Entity o BD já sacou que isso seria uma tabela
//Essa será a classe que irá prover todas as ações dos alunos
public class MatriculaAluno implements Serializable { //Aqui implementamos o serializable e os atributos da classe

    @Id //informando para o spring que isso é o ID da minha tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Cada matricula de Aluno tera seu respectivo ID (sua chave primaria)
    private Long id;
    //Aqui colocamos que cada aluno terá duas notas para poder passar de ano
    private Double nota1;

    private Double nota2;
    //vamos colocar a disciplina ligada a matricula
    //Não precisamos de professor pois o professor já está ligado a disciplina
    @ManyToOne
    @JoinColumn(name = "aluno_id") //Join para ligar as duas tabelas
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    private String status;

}