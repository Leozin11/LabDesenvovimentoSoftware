package main.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Curriculo implements Serializable {

    private static final long serialVersionUID = 30L;

    private Long id;
    private List<Disciplina> disciplinasDoCurriculo;
    private Integer numeroCurriculo;
    private String nomeCurriculo;

    public Curriculo(Long id, List<Disciplina> disciplinasDoCurriculo,
                     Integer numeroCurriculo, String nomeCurriculo) {
        this.id = id;
        this.disciplinasDoCurriculo = disciplinasDoCurriculo;
        this.numeroCurriculo = numeroCurriculo;
        this.nomeCurriculo = nomeCurriculo;
    }

    public Curriculo() {
    }

    public Curriculo(String curriculo) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Disciplina> getDisciplinasDoCurriculo() {
        return disciplinasDoCurriculo;
    }

    public void setDisciplinasDoCurriculo(List<Disciplina> disciplinasDoCurriculo) {
        this.disciplinasDoCurriculo = disciplinasDoCurriculo;
    }

    public Integer getNumeroCurriculo() {
        return numeroCurriculo;
    }

    public void setNumeroCurriculo(Integer numeroCurriculo) {
        this.numeroCurriculo = numeroCurriculo;
    }

    public String getNomeCurriculo() {
        return nomeCurriculo;
    }

    public void setNomeCurriculo(String nomeCurriculo) {
        this.nomeCurriculo = nomeCurriculo;
    }


    @Override
    public Curriculo clone(){
        Curriculo retorno = new Curriculo();

        retorno.id = this.id;
        retorno.disciplinasDoCurriculo=new LinkedList<Disciplina>(this.disciplinasDoCurriculo);
        retorno.numeroCurriculo = this.numeroCurriculo;
        retorno.nomeCurriculo = this.nomeCurriculo;

        return retorno;
    }




}
