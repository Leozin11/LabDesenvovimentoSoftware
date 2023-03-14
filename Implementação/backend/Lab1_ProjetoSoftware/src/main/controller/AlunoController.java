package main.controller;

import main.model.Aluno;
import main.model.Disciplina;
import main.service.AlunoService;
import main.service.Impl.AlunoServiceImpl;

import java.util.LinkedList;
import java.util.List;

public class AlunoController {

    AlunoService alunoService =  new AlunoServiceImpl();

    public Aluno editarMeuCadastro(Long id){

        return  null;
    }

    public Aluno visualizarMeuCurriculo(Long id){
        return  null;
    }

    public Aluno visualizarDisciplinasCursadas (Long id){
        return null;
    }

    public Aluno visualizarDisciplinasPendentes (Long id){
        return null;
    }

    public Aluno visualizarDisciplinasEmAndamento(Long id){
        return null;
    }

    public List<Disciplina> matricularEmDisciplinas (List<Disciplina> disciplinas, Long idAluno) throws Exception{

        Aluno aluno = alunoService.findAlunoById(idAluno);

        if ( aluno != null) {
            List<Disciplina> matricula = alunoService.matricularEmDisciplinas(disciplinas, idAluno);
            return matricula;
        }else{
            return null;
        }

    }




}
