package main.model.Requests;

import java.math.BigInteger;
import java.util.Objects;

public class MatriculaRequestFuncionario {

    private String nome;
    private String nomeFamiliar;
    private String documentoLegal;
    private String departamento;
    private String anoIngresso;
    private String anoDesligamento;
    private String endereco;
    private BigInteger salario;

    public MatriculaRequestFuncionario(){

    }

    public MatriculaRequestFuncionario(String nome, String nomeFamiliar, String documentoLegal, String departamento, String anoIngresso, String anoDesligamento,
                                        String endereco, BigInteger salario){
        
        this.nome = nome;
        this.nomeFamiliar = nomeFamiliar;
        this.documentoLegal = documentoLegal;
        this.departamento = departamento;
        this.anoIngresso = anoIngresso;
        this.anoDesligamento = anoDesligamento;
        this.endereco = endereco;
        this.salario = salario;
    }

    //Setters
    public void setNome(String name){
        this.nome = name;
    }

    public void setNomeFamiliar(String FamilyName){
        this.nomeFamiliar = FamilyName;
    }

    public void setDocumentoLegal(String LegalDocument){
        this.documentoLegal = LegalDocument;
    }

    public void setDepartamento(String Department){
        this.departamento = Department;
    }

    public void setAnoIngresso(String ano){
        this.anoIngresso = ano;
    }

    public void setAnoDesligamento(String ano){
        this.anoDesligamento = ano;
    }

    public void setEndereco(String Endereco){
        this.endereco = Endereco;
    }

    public void setSalario(BigInteger Salary){
        this.salario = Salary;
    }

    //Getters
    public String getNome(){
        return this.nome;
    }

    public String getNomeFamiliar(){
        return this.nomeFamiliar;
    }

    public String getDocumentoLegal(){
        return this.documentoLegal;
    }

    public String getDepartamento(){
        return this.departamento;
    }

    public String getAnoIngresso(){
        return this.anoIngresso;
    }

    public String getAnoDesligamento(){
        return this.anoDesligamento;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public BigInteger getSalario(){
        return this.salario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getNomeFamiliar(), getDocumentoLegal(), getDepartamento(),
        getAnoIngresso(), getAnoDesligamento(), getEndereco(), getSalario());
    }

    public MatriculaRequestFuncionario clone(){
        MatriculaRequestFuncionario MatriculaFuncionario = new MatriculaRequestFuncionario();

        MatriculaFuncionario.nome = getNome();
        MatriculaFuncionario.nomeFamiliar = getNomeFamiliar();
        MatriculaFuncionario.documentoLegal = getDocumentoLegal();
        MatriculaFuncionario.departamento = getDepartamento();
        MatriculaFuncionario.anoIngresso = getAnoIngresso();
        MatriculaFuncionario.anoDesligamento = getAnoDesligamento();
        MatriculaFuncionario.endereco = getEndereco();
        MatriculaFuncionario.salario = getSalario();

        return MatriculaFuncionario;
    }

}
