package main.model;

import java.io.Serializable;
import java.util.Objects;

public class Disciplina implements Serializable {

    private static final long serialVersionUID = 70L;

    private Long id;
    private String nome;
    private String numero;
    private String periodo;
    private String cargaHoraria;
    private Curriculo curriculo;

    private Curso curso;

    private Integer peso;
    private boolean obrigatoria;

    public Disciplina() {
    }

    public Disciplina(Long id, String nome, String numero, String periodo,
                      String cargaHoraria, Curriculo curriculo, Curso curso,
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

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public boolean isObrigatoria() {
        return obrigatoria;
    }

    public void setObrigatoria(boolean obrigatoria) {
        this.obrigatoria = obrigatoria;
    }


    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCargaHoraria(), getCurriculo(), getPeso(), isObrigatoria());
    }

    @Override
    public Disciplina clone(){
        Disciplina disc = new Disciplina();

        disc.id = getId();
        disc.nome = getNome();
        disc.cargaHoraria = getCargaHoraria();
        disc.curriculo = getCurriculo().clone();
        disc.peso = getPeso();
        disc.obrigatoria = isObrigatoria();
        disc.curso = getCurso().clone();

        return disc;
    }
}