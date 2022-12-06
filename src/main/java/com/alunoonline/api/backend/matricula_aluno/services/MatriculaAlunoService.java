package com.alunoonline.api.backend.matricula_aluno.services;

import com.alunoonline.api.backend.matricula_aluno.dtos.DisciplinasAlunoDto;
import com.alunoonline.api.backend.matricula_aluno.dtos.HistoricoAlunoDto;
import com.alunoonline.api.backend.matricula_aluno.dtos.MatriculaAlunoNotasOnlyDto;
import com.alunoonline.api.backend.matricula_aluno.models.MatriculaAluno;
import com.alunoonline.api.backend.matricula_aluno.repositories.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //informando que é um service
public class MatriculaAlunoService {

    static final Double gradesAvgToApprove = 7.0;

    @Autowired //injeção de dependencia
    MatriculaAlunoRepository repository;

    //metodo create para quando o aluno se matricular já ficar com status MATRICULADO
    public MatriculaAluno create(MatriculaAluno matriculaAluno) {
        matriculaAluno.setStatus("MATRICULADO");
        return repository.save(matriculaAluno);
    }
    //updateGrades para salvar as notas dos alunos e fazer o patch das notas com o statos aprovado e reprovado
    //criamos os DTOS para abstrair as mudanças das notas, e assim usamos o metodos DTO que é mais simples para fazer update nas notas
    //update nas notas não precisamos do objeto geral para isso, por isso usamos o DTO //

    public void updateGrades(MatriculaAlunoNotasOnlyDto notasOnlyDto, Long matriculaAlunoId) {
        Optional<MatriculaAluno> matriculaAlunoToUpdate = repository.findById(matriculaAlunoId);

        boolean needUpdate = false;

        if (StringUtils.hasLength(notasOnlyDto.getNota1().toString())) {
            matriculaAlunoToUpdate.ifPresent(matriculaAluno -> matriculaAluno.setNota1(notasOnlyDto.getNota1()));
            needUpdate = true;
        }

        if (StringUtils.hasLength(notasOnlyDto.getNota1().toString())) {
            matriculaAlunoToUpdate.ifPresent(matriculaAluno -> matriculaAluno.setNota2(notasOnlyDto.getNota2()));
            needUpdate = true;
        }

        if (needUpdate) {
            if (matriculaAlunoToUpdate.get().getNota1() != null && matriculaAlunoToUpdate.get().getNota2() != null) {
                if (matriculaAlunoToUpdate.get().getNota1() + matriculaAlunoToUpdate.get().getNota2() / 2 >= 7) {
                    matriculaAlunoToUpdate.ifPresent(matriculaAluno -> matriculaAluno.setStatus("APROVADO"));
                } else {
                    matriculaAlunoToUpdate.ifPresent(matriculaAluno -> matriculaAluno.setStatus("REPROVADO"));
                }

            }
            repository.save(matriculaAlunoToUpdate.get());
        }

    }

    //mudando o status de aprovado para trancado
    //só pode acontecer se ele estiver como "matriculado" , antes de já ter uma nota media e status como aprovado ou reprovado
    //não tem logica trancar se ele já estiver reprovado
    public void updateStatusToBreak(Long matriculaAlunoId) throws Exception {
        Optional<MatriculaAluno> matriculaAlunoToUpdate = repository.findById(matriculaAlunoId);

        if (matriculaAlunoToUpdate.isPresent()) { //Qualquer status que for diferente de matriculado não irá conseguir trancar
            if (Objects.equals(matriculaAlunoToUpdate.get().getStatus(), "MATRICULADO")) {
                matriculaAlunoToUpdate.ifPresent(matriculaAluno -> matriculaAluno.setStatus("TRANCADA"));
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Só é possível trancar com status MATRICULADO."); //msg apenas p o backend
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Matrícula não encontrada.");
        }
        repository.save(matriculaAlunoToUpdate.get());
    }
    //implementando um metodo que retorne um historico de determinado aluno
    public HistoricoAlunoDto getHistoricoFromAluno(Long alunoId) {
        List<MatriculaAluno> matriculasDoAluno = repository.findByAlunoId(alunoId);

        if (!matriculasDoAluno.isEmpty()) {
            HistoricoAlunoDto historico = new HistoricoAlunoDto();

            historico.setNomeAluno(matriculasDoAluno.get(0).getAluno().getNome());
            historico.setCursoAluno(matriculasDoAluno.get(0).getAluno().getCurso());
            List<DisciplinasAlunoDto> disciplinasList = new ArrayList<>();

            for (MatriculaAluno matricula: matriculasDoAluno) {
                DisciplinasAlunoDto disciplinasAlunoDto = new DisciplinasAlunoDto();

                disciplinasAlunoDto.setNomeDisciplina(matricula.getDisciplina().getNome());
                disciplinasAlunoDto.setProfessorDisciplina(matricula.getDisciplina().getProfessor().getNome());
                disciplinasAlunoDto.setNota1(matricula.getNota1()); //Aqui tenho nota 1 e 2
                disciplinasAlunoDto.setNota2(matricula.getNota2());
                if ((matricula.getNota1() != null && matricula.getNota2() != null)) {
                    disciplinasAlunoDto.setMedia(matricula.getNota1() + matricula.getNota2() / 2); //fazendo a media apenas se as duas forem preenchidas
                } else {
                    disciplinasAlunoDto.setMedia(null); // se não tiver notas a media será null
                }
                disciplinasAlunoDto.setStatus(matricula.getStatus());

                disciplinasList.add(disciplinasAlunoDto); // Aqui no final vamos armazenar na lista
            }

            historico.setDisciplinasAlunoList(disciplinasList); // disciplinaList pronta

            return historico;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Esse aluno não possui matrículas.");
    }



}