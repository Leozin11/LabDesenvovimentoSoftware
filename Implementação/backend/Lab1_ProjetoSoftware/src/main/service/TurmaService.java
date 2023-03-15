package main.service;

import main.model.Disciplina;
import main.model.Requests.TurmaRequest;
import main.model.Turma;

public interface TurmaService {

//Turma turma
    Turma criarTurma(TurmaRequest turmaRequest)throws Exception;
    //Turma turma - throws Exception
    Turma editarTurma(Long id, Turma turmaModificada)throws Exception;
    //Turma turma - throws Exception
    Turma deletarTurma(Long id) throws Exception;

    Turma getTurma(Long idDisciplina, String numeroDisciplina) throws Exception;

    Turma matricularAluno(Long idAluno, Disciplina disciplinaDesejada, String turno);
    //criei
    Turma findTurmaById(Long idTurma) throws Exception;
}
