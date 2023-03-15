package main.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Turma implements Serializable {

    private static final long serialVersionUID = 170L;

    private Long id;
    private List<Aluno> alunos;
    private Sala sala;
    private Curso curso;
    private Professor professor;

    private Disciplina disciplina;

    private String horario;

    public Turma(){

    }

    public Turma(Long id, List<Aluno> alunos, Sala sala, Curso curso, Professor professor, Disciplina disciplina, String horario){
        this.id = id;
        this.alunos = alunos;
        this.sala = sala;
        this.curso = curso;
        this.professor = professor;
        this.disciplina = disciplina;
        this.horario = horario;
    }

    //Setter
    public void setId(long Id){
        this.id = Id;
    }

    public void setAlunos(List<Aluno> Alunos){
        this.alunos = Alunos;
    }

    public void setSala(Sala Sala){
        this.sala = Sala;
    }

    public void setCurso(Curso Curso){
        this.curso = Curso;
    }

    public void setProfessor(Professor Professor){
        this.professor = Professor;
    }

    //Getter
    public Long getId(){
        return this.id;
    }

    public List<Aluno> getAlunos(){
        return this.alunos;
    }

    public Sala getSala(){
        return this.sala;
    }

    public Curso getCurso(){
        return this.curso;
    }

    public Professor getProfessor(){
        return this.professor;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public Turma clone(){
        Turma retorno = new Turma();

        retorno.id = this.id;
        new LinkedList<Aluno>(this.alunos);
        retorno.sala = this.sala.clone();
        retorno.curso = this.curso.clone();
        retorno.professor = this.professor.clone();
        retorno.disciplina = this.disciplina.clone();
        retorno.horario = this.horario;


        return retorno;
    }
}
