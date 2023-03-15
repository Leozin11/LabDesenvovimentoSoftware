package main.service.Impl;

import main.model.Disciplina;
import main.service.DisciplinaService;
import main.repository.Persistencia;
import main.repository.SalvarNoArquivo;

import java.util.LinkedList;

public class DisciplinaServiceImpl implements DisciplinaService {

    private Persistencia persistir = new SalvarNoArquivo();
    private String systemPathDisciplinas = "c:\\SistemaMatriculas\\Disciplinas";

    @Override
    public Disciplina criarDisciplina(Disciplina disciplina) throws Exception{

        Disciplina disciplinaAtual = findDisciplinaByName(disciplina.getNome());
        if(disciplinaAtual == null){
            Long NewId = geradorDeId();

            disciplinaAtual = new Disciplina(NewId, 
                                            disciplina.getNome(), 
                                            disciplina.getNumero(), 
                                            disciplina.getPeriodo(), 
                                            disciplina.getCargaHoraria(), 
                                            disciplina.getCurriculo(), 
                                            disciplina.getHorario(), 
                                            disciplina.getTurno(), 
                                            disciplina.getDuração(), 
                                            disciplina.getPeso(), 
                                            disciplina.isObrigatoria()
                                            );
            
            escreverDisciplinaNoArquivo(disciplinaAtual, "disciplinas.txt");
        }

        return disciplinaAtual;
    }

    private Long geradorDeId() throws Exception {

        LinkedList<Disciplina> disciplinasMatriculadas = (LinkedList<Disciplina>) carregarArquivoDisciplinaParaMemoria("Disciplinas.txt");

        if(disciplinasMatriculadas.size() <= 0) {
            return 1L;
        }else{
            Disciplina disciplina = disciplinasMatriculadas.get(disciplinasMatriculadas.size()-1);
            return (disciplina.getId()+1L);
        }
    }

    @Override
    public Disciplina editarDisciplina(Long id, Disciplina discplinaEditada) throws Exception {
        Disciplina disciplina = findDisciplinaId(id);

        if(disciplina != null){
            deletarDisciplina(id);
            disciplina = discplinaEditada.clone();
            escreverDisciplinaNoArquivo(disciplina, "Diciplinas.txt");
        }else{
            System.out.println("DISCIPLINA NÃO ENCONTRADA");
        }
            return disciplina;
    }

    @Override
    public Disciplina deletarDisciplina(Long id) throws Exception{
        Disciplina disciplina = findDisciplinaId(id);

        if(disciplina != null){
            excluirDisciplinasNoArquivo(disciplina, "Disciplinas.txt");
        }else{
            System.out.println("DISCIPLINA NÃO FOI ENCONTRADA");
        }

        return disciplina;
    }

    @Override
    public Disciplina findDisciplinaId(Long id) throws Exception {
        String path = systemPathDisciplinas + "\\" + "Disciplinas.txt";
        LinkedList<Disciplina> disciplinas = (LinkedList<Disciplina>) persistir.deserializar(path);

        for (Disciplina disciplinaAtual: disciplinas) {

            if(disciplinaAtual.getId() == id){
                return disciplinaAtual.clone();
            }

        }
        return null;
    }

    public Disciplina findDisciplinaByName(String nome) throws Exception{
        String path = systemPathDisciplinas + "\\" + "Disciplinas.txt";
        LinkedList<Disciplina> disciplinas = (LinkedList<Disciplina>) persistir.deserializar(path);

        for (Disciplina disciplinaAtual: disciplinas) {

            if(disciplinaAtual.getNome() == nome){
                return disciplinaAtual.clone();
            }

        }
        return null;
    }

    private boolean escreverDisciplinaNoArquivo(Disciplina disciplina, String nomeArquivoDisciplinas) throws Exception {

        String path = systemPathDisciplinas + "\\" + nomeArquivoDisciplinas;
        LinkedList<Disciplina> disciplinas = (LinkedList<Disciplina>) persistir.deserializar(path);
        disciplinas.add(disciplina.clone());
        return persistir.serializar(path, disciplinas);
    }

    private boolean excluirDisciplinasNoArquivo(Disciplina disciplina, String nomeArquivoDisciplinas) throws Exception {

        String path = systemPathDisciplinas + "\\" + nomeArquivoDisciplinas;
        LinkedList<Disciplina> disciplinas = (LinkedList<Disciplina>) persistir.deserializar(path);
        disciplinas.remove(disciplinas);
        return persistir.serializar(path, disciplinas);
    }

    private LinkedList<Disciplina> carregarArquivoDisciplinaParaMemoria(String nomeArquivoDisciplinas) throws Exception {

        String path = systemPathDisciplinas + "\\" + nomeArquivoDisciplinas;
        return  (LinkedList<Disciplina>) persistir.deserializar(path);
    }
}
