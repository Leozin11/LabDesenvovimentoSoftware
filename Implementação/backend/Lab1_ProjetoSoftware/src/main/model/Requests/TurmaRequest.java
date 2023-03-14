package main.model.Requests;

import main.model.Curso;
import main.model.Disciplina;
import main.model.Professor;
import main.model.Sala;

public class TurmaRequest {

    private Sala sala;
    private Curso curso;
    private Professor professor;

    private Disciplina disciplina;
    private String horario;

    public TurmaRequest(Sala sala, Curso curso, Professor professor, Disciplina disciplina, String horario) {
        this.sala = sala;
        this.curso = curso;
        this.professor = professor;
        this.disciplina = disciplina;
        this.horario = horario;
    }

    public TurmaRequest() {
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
