package main.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class Professor extends Funcionario implements Serializable {

    private static final long serialVersionUID = 110L;

    private List<Turma> turmas;

    public Professor(Long id, Long matricula, String nome, String nomeFamiliar, String documentoLegal, String departamento, String anoIngresso, String anoDesligamento, String endereco, BigInteger salario, List<Turma> turmas) {
        super(id, matricula, nome, nomeFamiliar, documentoLegal, departamento, anoIngresso, anoDesligamento, endereco, salario);
        this.turmas = turmas;
    }


    public Professor() {
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }


    @Override

    public Professor clone() {
        Professor retorno = new Professor();

        retorno.turmas= new LinkedList<Turma>(this.turmas);


        return retorno;
    }
}
