package com.alunoonline.api.backend.secretaria.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
//Todos os import acima vieram de forma automatica colocando os @ abaixo, o intellij já cria.---------------------------

//Para não precisar criar os get e set manualmente, é só colocar na criação do projeto no spring o "Lombok"
//Trás os GET e SET, é um import diretamente do Lombok------------------------------------------------------------------
@Data
//Cria o construtor da classe, é um import diretamente do Lombok--------------------------------------------------------
@NoArgsConstructor
@AllArgsConstructor
//Designa o objeto como uma tabela do BD--------------------------------------------------------------------------------
@Entity
//para se comunicar com o BD se coloca o implements Serializable, assim os dados vão ser "convertidos" para a linguagem que o BD entende
public class Aluno implements Serializable {
    //Chave primaria será o ID
    @Id
    //Generated o ID do objeto será gerado, sempre um novo, evitando se repetir.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Atributos
    private Long id;

    private String nome;

    private String email;

    private String curso;

}
