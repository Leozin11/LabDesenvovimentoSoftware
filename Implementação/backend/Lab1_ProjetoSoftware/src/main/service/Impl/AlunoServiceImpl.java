package main.service.Impl;

import main.model.Aluno;
import main.model.Curriculo;
import main.model.Disciplina;
import main.model.Requests.MatriculaRequestAlunos;
import main.model.Turma;
import main.repository.Persistencia;
import main.repository.SalvarNoArquivo;
import main.service.AlunoService;
import main.service.CursoService;
import main.service.TurmaService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class AlunoServiceImpl implements AlunoService {


    private TurmaService turmaService = new TurmaServiceImpl();
    private Persistencia persistir = new SalvarNoArquivo();
    private CursoService cursoService = new CursoServiceImpl();
    private String systemPathAlunos = "c:\\SistemaMatriculas\\Alunos";

    @Override
    public Aluno criarAluno(MatriculaRequestAlunos aluno) throws Exception {
        Date dataAtual = new Date();

        Aluno alunoAtual = findAlunoByDocumentoLegal(aluno.getDocumentoLegal());
        if ( alunoAtual == null){

            Long id= geradorDeId();
            alunoAtual = new Aluno(
            id,
            id,
            aluno.getNome(),
            aluno.getNomeFamiliar(),
            aluno.getDocumentoLegal(),
            new LinkedList<Disciplina>(),
            new LinkedList<Disciplina>   (), //retirar () e colocar isso qdo ficar pronto->//(cursoService.getCurriculo(aluno.getCurso(),aluno.getCurriculo()).getDisciplinasDoCurriculo()),
            new LinkedList<Disciplina>(),
            new LinkedList<Disciplina>(),
            new Curriculo(), //retirar () e colocar isso qdo ficar pronto ->//cursoService.getCurriculo(aluno.getCurso(),aluno.getCurriculo()).clone(),
            aluno.getCurso(),
            ""+dataAtual.getYear(),
            null,
            aluno.getEndereco()
            );
            escreverAlunoNoArquivo(alunoAtual,"Alunos.txt");
        }
        return alunoAtual;
    }

    private Long geradorDeId() throws Exception {

        LinkedList<Aluno> alunosMatriculados = (LinkedList<Aluno>) carregarArquivoAlunoParaMemoria("Alunos.txt");

        if(alunosMatriculados.size() <= 0) {
            return 1L;
        }else{
            Aluno aluno = alunosMatriculados.get(alunosMatriculados.size()-1);
            return (aluno.getId()+1L);
        }
    }

    @Override
    public Aluno editarAluno(Long id, Aluno alunoModificado) throws Exception {
        Aluno aluno = findAlunoById(id);
        if ( aluno!= null){
            deletarAluno(id);
            aluno = alunoModificado.clone();
            escreverAlunoNoArquivo(aluno,"Alunos.txt");
        }else{
            System.out.println("ALUNO NÃO ENCONTRADO");
        }
        return aluno;
    }

    @Override
    public Aluno deletarAluno(Long id) throws Exception {
        Aluno aluno = findAlunoById(id);
        if ( aluno!= null){

            excluirAlunoNoArquivo(aluno,"Alunos.txt");
        }else{
            System.out.println("ALUNO NÃO ENCONTRADO");
        }
        return aluno;

    }

    @Override
    public List<Disciplina> matricularEmDisciplinas(List<Disciplina> disciplinasDesejadas, Long idAluno) {

        int somatorioPeso = 0 ;
        int somatorioDisciplinasObrigatorias =0;
        int somatorioDisciplinasOptativas=0;


        //verifica se a lista é vlida de acordo com as regras
        for (Disciplina disciplinaAtual: disciplinasDesejadas) {

            somatorioPeso+=disciplinaAtual.getPeso();
            if(disciplinaAtual.isObrigatoria()){
                somatorioDisciplinasObrigatorias++;
            }else{
                somatorioDisciplinasOptativas++;
            }
        }

        // solicita ao serviço da turma para incluir este aluno na sua lista,
        // turma service procura a turma por ID e salva o aluno la dentro
        // depois escreve no txt desta turma denovo a turma atualizada

        if (somatorioDisciplinasObrigatorias>=4 && somatorioDisciplinasOptativas >=2 && somatorioPeso > 3){

            for (Disciplina disciplinaAtual: disciplinasDesejadas) {

                Turma turma = turmaService.getTurma(disciplinaAtual.getId(), disciplinaAtual.getNumero());
                turmaService.matricularAluno(idAluno,turma);

            }
            return disciplinasDesejadas;

        }
        return null;
    }

    @Override
    public Aluno findAlunoById(Long idAluno) throws Exception {
        String path = systemPathAlunos+"\\"+"Alunos.txt";
        LinkedList<Aluno> alunos = (LinkedList<Aluno>) persistir.deserializar(path);

        for (Aluno alunoAtual:
                alunos) {

            if(alunoAtual.getId() == idAluno){
                return alunoAtual.clone();
            }

        }
        return null;
    }

    public Aluno findAlunoByDocumentoLegal(String documentoLegal) throws Exception {
        String path = systemPathAlunos+"\\"+"Alunos.txt";
        LinkedList<Aluno> alunos = (LinkedList<Aluno>) persistir.deserializar(path);

        for (Aluno alunoAtual:
                alunos) {

            if(alunoAtual.getDocumentoLegal().equals(documentoLegal)){
                return alunoAtual.clone();
            }

        }
        return null;
    }

    private boolean escreverAlunoNoArquivo(Aluno aluno, String nomeArquivoAluno) throws Exception {

        String path = systemPathAlunos+"\\"+nomeArquivoAluno;
        LinkedList<Aluno> alunos = (LinkedList<Aluno>) persistir.deserializar(path);
        alunos.add(aluno.clone());
        return persistir.serializar(path,alunos);

    }

    private LinkedList<Aluno> carregarArquivoAlunoParaMemoria(String nomeArquivoAluno) throws Exception {

        String path = systemPathAlunos+"\\"+nomeArquivoAluno;
        return  (LinkedList<Aluno>) persistir.deserializar(path);
    }

    private boolean excluirAlunoNoArquivo(Aluno aluno, String nomeArquivoAluno) throws Exception {

        String path = systemPathAlunos+"\\"+nomeArquivoAluno;
        LinkedList<Aluno> alunos = (LinkedList<Aluno>) persistir.deserializar(path);
        alunos.remove(aluno);
        return persistir.serializar(path,alunos);

    }

}
