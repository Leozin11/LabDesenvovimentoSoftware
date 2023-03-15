package main.model.Requests;

import java.io.Serializable;

public class DisciplinaRequest implements Serializable {

    private static final long serialVersionUID = 500L;

    private Long id;
    private String nome;
    private String numero;
    private String periodo;
    private String cargaHoraria;
    private String curriculo;
    private String curso;
    private Integer peso;
    private boolean obrigatoria;


    public DisciplinaRequest() {
    }

    public DisciplinaRequest(Long id, String nome, String numero, String periodo,
                             String cargaHoraria, String curriculo, String curso,
                             Integer peso, boolean obrigatoria) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.periodo = periodo;
        this.cargaHoraria = cargaHoraria;
        this.curriculo = curriculo;
        this.curso = curso;
        this.peso = peso;
        this.obrigatoria = obrigatoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
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


    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public boolean isObrigatoria() {
        return obrigatoria;
    }

    public void setObrigatoria(boolean obrigatoria) {
        this.obrigatoria = obrigatoria;
    }
}
