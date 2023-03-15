package main.model.Requests;

import main.model.Disciplina;

import java.util.LinkedList;
import java.util.List;


public class MatriculaRequestDisciplinas {
    Disciplina disciplina;
    String turno;

    public MatriculaRequestDisciplinas(Disciplina disciplina, String turno) {
        this.disciplina = disciplina.clone();
        this.turno = turno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
