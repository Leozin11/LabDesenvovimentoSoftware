package main.service.Impl;

import main.model.Funcionario;
import main.model.Sala;
import main.service.SalaService;
import main.repository.Persistencia;
import main.repository.SalvarNoArquivo;

import java.util.LinkedList;

public class SalaServiceImpl implements SalaService {

    private Persistencia persistir = new SalvarNoArquivo();
    private String systemPathSalas = "c:\\SistemaMatriculas\\Salas";

    @Override
    public Sala criarSala(Sala sala) throws Exception{

        Sala SalaNova = findSalaByNumber(sala.getNumero());

        if(SalaNova.getId() == null){
            Long NewID = geradorDeId();

            SalaNova = new Sala(NewID,
                                sala.getNumero(),
                                sala.getPrédio(),
                                sala.getTurma()
                                );
                
            EscreverSalasNoArquivo(SalaNova, "Salas.txt");
        }

        return SalaNova;
    }

    @Override
    public Sala editarSala(Long id, Sala salaEditada) throws Exception{
        Sala sala = findSalaById(id);

        if(sala != null){
            deletarSala(id);
            sala = salaEditada.clone();
            EscreverSalasNoArquivo(sala, "Salas.txt");
        }else{
            System.out.println("Sala NÃO ENCONTRADA");
        }
            return sala;
    }

    @Override
    public Sala deletarSala(Long id) throws Exception{
        Sala sala = findSalaById(id);

        if(sala != null){
            excluirSalasNoArquivo(sala, "Salas.txt");
        }else{
            System.out.println("SALA NÃO FOI ENCONTRADA");
        }

        return sala;
    }

    private Long geradorDeId() throws Exception {

        LinkedList<Sala> SalasExistentes = (LinkedList<Sala>) carregarArquivoSalasParaMemoria("Salas.txt");

        if(SalasExistentes.size() <= 0) {
            return 1L;
        }else{
            Sala sala = SalasExistentes.get(SalasExistentes.size()-1);
            return (sala.getId()+1L);
        }
    }

    public Sala findSalaByNumber(int Numero) throws Exception{
        String path = systemPathSalas + "\\" + "Salas.txt";
        LinkedList<Sala> salas = (LinkedList<Sala>) persistir.deserializar(path);

        for (Sala SalaNova: salas) {

            if(SalaNova.getNumero() == Numero){
                return SalaNova.clone();
            }

        }
        return null;
    }

    @Override
    public Sala findSalaById(Long id) throws Exception {
        String path = systemPathSalas + "\\" + "Salas.txt";
        LinkedList<Sala> salas = (LinkedList<Sala>) persistir.deserializar(path);

        for (Sala SalaNova: salas) {

            if(SalaNova.getId() == id){
                return SalaNova.clone();
            }

        }
        return null;
    }

    private boolean EscreverSalasNoArquivo(Sala sala, String nomeArquivoSalas) throws Exception {

        String path = systemPathSalas + "\\" + nomeArquivoSalas;
        LinkedList<Sala> salas = (LinkedList<Sala>) persistir.deserializar(path);
        salas.add(sala.clone());
        return persistir.serializar(path, salas);
    }

    private LinkedList<Sala> carregarArquivoSalasParaMemoria(String nomeArquivoSalas) throws Exception {

        String path = systemPathSalas + "\\" + nomeArquivoSalas;
        return  (LinkedList<Sala>) persistir.deserializar(path);
    }

    private boolean excluirSalasNoArquivo(Sala sala, String nomeArquivoSalas) throws Exception {

        String path = systemPathSalas + "\\" + nomeArquivoSalas;
        LinkedList<Sala> salas = (LinkedList<Sala>) persistir.deserializar(path);
        salas.remove(salas);
        return persistir.serializar(path, salas);
    }
}
