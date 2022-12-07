package com.alunoonline.api.backend.matricula_aluno.models;

import com.alunoonline.api.backend.secretaria.models.Aluno;
import com.alunoonline.api.backend.secretaria.models.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data //para poder usar os gets e set
@NoArgsConstructor //para acrescentar os construtores, com e sem argumentos
@AllArgsConstructor
@Entity
//com o @Entity o BD já sabe que será uma tabela do BD
//Essa será a classe que irá prover todas as ações dos alunos
public class MatriculaAluno implements Serializable { //Aqui implementamos o serializable e os atributos da classe

    @Id //informando que é o ID da minha tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera um ID aleatório
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
    @JoinColumn(name = "disciplina_id") //chave extrangeira
    private Disciplina disciplina;

    private String status;

}