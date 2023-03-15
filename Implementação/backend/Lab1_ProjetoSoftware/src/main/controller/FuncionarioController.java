package main.controller;

import main.model.Disciplina;
import main.model.Requests.DisciplinaRequest;
import main.service.DisciplinaService;
import main.service.Impl.DisciplinaServiceImpl;

public class FuncionarioController {


    DisciplinaService disciplinaService = new DisciplinaServiceImpl();

    public Disciplina criarDisciplina(DisciplinaRequest disciplinaDesejada) throws Exception {

        return disciplinaService.criarDisciplina(disciplinaDesejada);

    }
}
