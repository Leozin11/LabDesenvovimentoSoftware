package main.service;

import main.model.Requests.TurmaRequest;
import main.model.Turma;

public interface TurmaService {

//Turma turma
    Turma criarTurma(TurmaRequest turmaRequest)throws Exception;
    //Turma turma - throws Exception
    Turma editarTurma(Long id, Turma turmaModificada)throws Exception;
    //Turma turma - throws Exception
    Turma deletarTurma(Long id) throws Exception;

    Turma getTurma(Long idDisciplina, String numeroDisciplina);

    boolean matricularAluno(Long id, Turma turma);
    //criei
    Turma findTurmaById(Long idTurma) throws Exception;
}
