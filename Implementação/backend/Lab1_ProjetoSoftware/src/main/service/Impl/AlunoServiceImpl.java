package main.service.Impl;

import main.model.Aluno;
import main.model.Disciplina;
import main.model.Turma;
import main.service.AlunoService;
import main.service.TurmaService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.List;

public class AlunoServiceImpl implements AlunoService {


    private TurmaService turmaService;
    private String systemPathAlunos = "c:\\SistemaMatriculas\\Alunos";
    @Override
    public Aluno criarAluno(Aluno aluno) {

        Date actualDate = new Date();
        String path = systemPathAlunos+"\\"+"Alunos.txt";
        File dest = new File(path);

        if(dest == null){
            //cria arquivo
            //instancia aluno
            //salva no arquivo

        }else{
            Aluno alunoResult = findAlunoById(aluno.getId());
            if(alunoResult==null){
                //instancia aluno
                //salva no arquivo
            }
        }
        return aluno;
    }

    @Override
    public Aluno editarAluno(Aluno aluno) {
        return null;
    }

    @Override
    public Aluno deletarAluno(Aluno aluno) {
        return null;
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
    public Aluno findAlunoById(Long idAluno) {

        Date actualDate = new Date();
        String path = systemPathAlunos+"\\"+"Alunos.txt";
        File dest = new File(path);

        if(dest == null){
            //arquivo inexistente
        }else{
            String resp ="";
            try{
                BufferedReader arquivo = new BufferedReader(new FileReader("Alunos.txt)"));
                do{
                    String linha = arquivo.readLine();
                    String[] linhaSplitada = linha.split("|");
                    if (Integer.parseInt(linhaSplitada[0]) == idAluno){
                        return builtAlunoFromString(linha);
                    }

                }while(arquivo.ready());

            }catch(Exception e){e.printStackTrace();}


        }

        return null;

    }

    private Aluno builtAlunoFromString(String linha) {
        return null;
    }
}
