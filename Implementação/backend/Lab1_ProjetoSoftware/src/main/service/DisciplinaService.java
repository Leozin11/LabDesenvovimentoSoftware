package main.service;

import main.model.Disciplina;
import main.model.Requests.DisciplinaRequest;

public interface DisciplinaService {

    Disciplina criarDisciplina(DisciplinaRequest disciplina) throws Exception;
    Disciplina editarDisciplina(Long id, Disciplina disciplinaEditada) throws Exception;
    Disciplina deletarDisciplina(Long id) throws Exception;

    Disciplina findDisciplinaByName(String nome) throws Exception;
    Disciplina findDisciplinaId(Long id) throws Exception;
}
