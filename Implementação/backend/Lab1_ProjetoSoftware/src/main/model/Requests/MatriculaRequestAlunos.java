package main.model.Requests;

import main.model.Curriculo;

import java.util.Date;

public class MatriculaRequestAlunos {


    private String nome;
    private String nomeFamiliar;
    private String documentoLegal;
    private String curriculo;
    private String curso;
    private Date dataAtual;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFamiliar() {
        return nomeFamiliar;
    }

    public void setNomeFamiliar(String nomeFamiliar) {
        this.nomeFamiliar = nomeFamiliar;
    }

    public String getDocumentoLegal() {
        return documentoLegal;
    }

    public void setDocumentoLegal(String documentoLegal) {
        this.documentoLegal = documentoLegal;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
