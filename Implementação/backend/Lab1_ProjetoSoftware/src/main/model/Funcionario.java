package main.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

public abstract class Funcionario implements Serializable {

    private static final long serialVersionUID = 90L;

    private Long id;
    private Long matricula;
    private String nome;
    private String nomeFamiliar;
    private String documentoLegal;
    private String departamento;
    private String anoIngresso;
    private String anoDesligamento;
    private String endereco;
    private BigInteger salario;

    public Funcionario(Long id, Long matricula, String nome, String nomeFamiliar, String documentoLegal,
            String departamento, String anoIngresso, String anoDesligamento, String endereco, BigInteger salario) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.nomeFamiliar = nomeFamiliar;
        this.documentoLegal = documentoLegal;
        this.departamento = departamento;
        this.anoIngresso = anoIngresso;
        this.anoDesligamento = anoDesligamento;
        this.endereco = endereco;
        this.salario = salario;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(String anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public String getAnoDesligamento() {
        return anoDesligamento;
    }

    public void setAnoDesligamento(String anoDesligamento) {
        this.anoDesligamento = anoDesligamento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public BigInteger getSalario() {
        return salario;
    }

    public void setSalario(BigInteger salario) {
        this.salario = salario;
    }

    
    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", matricula=" + matricula + ", nome=" + nome + ", nomeFamiliar="
                + nomeFamiliar + ", documentoLegal=" + documentoLegal + ", departamento=" + departamento
                + ", anoIngresso=" + anoIngresso + ", anoDesligamento=" + anoDesligamento + ", endereco=" + endereco
                + ", salario=" + salario + "]";
    }
}
