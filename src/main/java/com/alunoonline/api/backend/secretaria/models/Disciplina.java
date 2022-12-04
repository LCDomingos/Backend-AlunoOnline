package com.alunoonline.api.backend.secretaria.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Disciplina implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    //trazendo duas chaves externas FK /vamos ligar uma tabela com outra --> ManyToOne> muitas disciplinas para um unico professor
    @ManyToOne
    //JoinColumn: Aqui que fazemos a ligação de professor com disciplina pois toda disciplina tem um professor
    @JoinColumn(name="professor_id")
    private Professor professor;
}
