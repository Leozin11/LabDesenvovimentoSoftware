package main.service.Impl;

import main.model.*;
import main.model.Requests.DisciplinaRequest;
import main.model.Requests.TurmaRequest;
import main.repository.Persistencia;
import main.repository.SalvarNoArquivo;
import main.service.CursoService;
import main.service.TurmaService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TurmaServiceImpl implements TurmaService {

    private Persistencia persistir = new SalvarNoArquivo();
    private CursoService cursoService = new CursoServiceImpl();
    private String systemPathTurmas = "c:\\SistemaMatriculas\\Turmas";

    @Override
    public Turma criarTurma(TurmaRequest turma) throws Exception {
        Date dataAtual = new Date();

        Turma turmaAtual = findTurmaByDisciplinaAndProfessorAndHorario(turma.getDisciplina(),turma.getProfessor(),turma.getHorario());

        if ( turmaAtual == null){

            Long id= geradorDeId();

            turmaAtual = new Turma(
                id,
                new LinkedList<Aluno>(),
                new Sala(),
                turma.getCurso(),
                turma.getProfessor(),
                turma.getDisciplina(),
                turma.getHorario()
            );


            escreverTurmaNoArquivo(turmaAtual,"Turmas.txt");
        }
        return turmaAtual;
    }



    private Long geradorDeId() throws Exception {

        LinkedList<Turma> turmasMatriculadas = (LinkedList<Turma>) carregarArquivoTurmaParaMemoria("Turmas.txt");

        if(turmasMatriculadas.size() <= 0) {
            return 1L;
        }else{
            Turma turma = turmasMatriculadas.get(turmasMatriculadas.size()-1);
            return (turma.getId()+1L);
        }
    }

    @Override
    public Turma editarTurma(Long id, Turma turmaModificada) throws Exception {
        Turma turma = findTurmaById(id);
        if ( turma!= null){
            deletarTurma(id);
            turma = turmaModificada.clone();
            escreverTurmaNoArquivo(turma,"Turmas.txt");
        }else{
            System.out.println("TURMA NÃO ENCONTRADO");
        }
        return turma;
    }

    @Override
    public Turma deletarTurma(Long id) throws Exception {
        Turma turma = findTurmaById(id);
        if ( turma!= null){

            excluirTurmaNoArquivo(turma,"Turmas.txt");
        }else{
            System.out.println("TURMA NÃO ENCONTRADA");
        }
        return turma;
    }


    private LinkedList<Turma> carregarArquivoTurmaParaMemoria(String nomeArquivoTurma) throws Exception {

        String path = systemPathTurmas+"\\"+nomeArquivoTurma;
        return  (LinkedList<Turma>) persistir.deserializar(path);
    }

    private boolean escreverTurmaNoArquivo(Turma turma, String nomeArquivoTurma) throws Exception {

        String path = systemPathTurmas+"\\"+nomeArquivoTurma;
        LinkedList<Turma> turmas = (LinkedList<Turma>) persistir.deserializar(path);
        turmas.add(turma.clone());
        return persistir.serializar(path,turmas);

    }

    private boolean excluirTurmaNoArquivo(Turma turma, String nomeArquivoTurmas) throws Exception {

        String path = systemPathTurmas+"\\"+nomeArquivoTurmas;
        LinkedList<Turma> turmas = (LinkedList<Turma>) persistir.deserializar(path);
        turmas.remove(turma);
        return persistir.serializar(path,turmas);

    }






    @Override
    public Turma getTurma(Long idDisciplina, String numeroDisciplina) throws Exception {
        String path = systemPathTurmas+"\\"+"Turmas.txt";
        LinkedList<Turma> turmas = (LinkedList<Turma>) persistir.deserializar(path);

        for (Turma turmaAtual:
                turmas) {

            if(turmaAtual.getDisciplina().getId() == idDisciplina){
                return turmaAtual.clone();
            }

        }
        return null;

    }
    private Turma findTurmaByDisciplinaAndProfessorAndHorario(Disciplina disciplina, Professor professor, String horario) {
        return null;
    }
    @Override
    public Turma matricularAluno(Long idAluno, Disciplina disciplinaDesejada, String turno) {

        //Turma turma = turmaService.getTurma(disciplinaAtual.getId(), disciplinaAtual.getNumero());

        return null;
    }

    @Override
    public Turma findTurmaById(Long idTurma) throws Exception {
        return null;
    }
}
