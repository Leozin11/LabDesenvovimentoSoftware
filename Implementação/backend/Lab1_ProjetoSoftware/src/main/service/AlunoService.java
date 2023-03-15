package main.service;

import main.model.Aluno;
import main.model.Disciplina;
import main.model.Requests.MatriculaRequestAlunos;
import main.model.Requests.MatriculaRequestDisciplinas;
import main.model.Turma;

import java.util.List;

public interface AlunoService {


    Aluno criarAluno(MatriculaRequestAlunos aluno) throws Exception;
    Aluno editarAluno(Long id,Aluno alunoModificado) throws Exception;

    Aluno deletarAluno(Long id) throws Exception;

    List<Turma> matricularEmDisciplinas(List<MatriculaRequestDisciplinas> disciplinasDesejadas, Long idAluno) throws Exception;

    Aluno findAlunoById(Long idAluno) throws Exception;
}
