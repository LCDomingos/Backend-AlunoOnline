package com.alunoonline.api.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//Todos os import acima vieram de forma automatica colocando os @ abaixo, o intellij já cria.
//Para não precisar criar os get e set, é só colocar na criação do projeto no spring o "Lombok", mas ele não cria construtor
@Data
//Criando o construtor da classe, tudo vindo do Lombok
@NoArgsConstructor
@AllArgsConstructor
//para o spring saber que essa classe que será salva em uma tabela do banco de dados (BD) se usa o @Entity
@Entity
//para se comunicar com o BD (h2 nesse caso) se coloca o implements Serializable, assim ps dados vão ser "convertidos" para a linguagem que o BD entende
public class Aluno implements Serializable {
    //Para ter a chave primaria colocar o @Id do BD
    @Id
    //Com o Generated o ID do objeto será gerado, sempre um novo, evitando repetir. e mostrara para o BD qual o ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String curso;

}
