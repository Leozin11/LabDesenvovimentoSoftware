package main.model;

import java.io.Serializable;

public class Sala implements Serializable {

    private static final long serialVersionUID = 130L;


    private Long id;
    private int numero;
    private String predio;
    private String turma;

    public Sala() {
    }

    public Sala(Long id, int numero, String predio, String turma) {
        this.id = id;
        this.numero = numero;
        this.predio = predio;
        this.turma = turma;
    }
    
    public void setId(Long Id){
        this.id = Id;
    }

    public Long getId(){
        return this.id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPrédio() {
        return predio;
    }

    public void setPrédio(String prédio) {
        this.predio = prédio;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public Sala clone(){
        Sala retorno = new Sala();

        retorno.id = this.id;
        retorno.numero = this.numero;
        retorno.predio = this.predio;
        retorno.turma = this.turma;

        return retorno;
    }

}
