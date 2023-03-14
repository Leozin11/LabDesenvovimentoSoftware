package main.service.Impl;

import main.model.Funcionario;
import main.service.FuncionarioService;

public class FuncionarioServiceImpl implements FuncionarioService {
    @Override
    public Funcionario criarFuncionario(Funcionario funcionario, String tipo) {
        return new Funcionario(funcionario.getId(), funcionario.getMatricula(), funcionario.getNome(),
                        funcionario.getNomeFamiliar(), funcionario.getDocumentoLegal(), funcionario.getDepartamento(),
                        funcionario.getAnoIngresso(), funcionario.getAnoDesligamento(), funcionario.getEndereco(),
                        funcionario.getSalario());;
    }

    @Override
    public Funcionario editarFuncionario(Funcionario funcionario, String tipo) {
        if (funcionario.getId() != null) {
            this.setId(funcionario.getId());
        }
        if (funcionario.getMatricula() != null) {
            this.setMatricula(funcionario.getMatricula());
        }
        if (funcionario.getNome() != null) {
            this.setNome(funcionario.getNome());
        }
        if (funcionario.getNomeFamiliar() != null) {
            this.setNomeFamiliar(funcionario.getNomeFamiliar());
        }
        if (funcionario.getDocumentoLegal() != null) {
            this.setDocumentoLegal(funcionario.getDocumentoLegal());
        }
        if (funcionario.getDepartamento() != null) {
            this.setDepartamento(funcionario.getDepartamento());
        }
        if (funcionario.getAnoIngresso() != null) {
            this.setAnoIngresso(funcionario.getAnoIngresso());
        }
        if (funcionario.getAnoDesligamento() != null) {
           this.setAnoDesligamento(funcionario.getAnoDesligamento());
        }
        if (funcionario.getEndereco() != null) {
            this.setEndereco(funcionario.getEndereco());
        }
        if (funcionario.getSalario() != null) {
            this.setSalario(funcionario.getSalario());
        }
        return Funcionario();
    }
    

    @Override
    public Funcionario deletarFuncionario(Funcionario funcionario, String tipo) {
        return null;
    }
}
