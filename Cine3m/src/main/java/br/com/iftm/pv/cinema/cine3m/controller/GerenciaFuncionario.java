package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import java.util.List;

public class GerenciaFuncionario implements IGerencia<Funcionario> {

    private List<Funcionario> funcionarios;

    public GerenciaFuncionario(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Boolean cadastrar(Funcionario funcionario) {
        if (verificarCpf(funcionario.getCpf()) || verificarNome(funcionario.getNome())
                || verificarLogin(funcionario.getLogin())) {
            return false;
        }
        return funcionarios.add(funcionario);
    }

    public Funcionario remover(Funcionario funcionario) {
        return funcionarios.remove(funcionarios.indexOf(funcionario));
    }

    public void atualizar(Funcionario funcionario, Funcionario funcionarioAtualizado) {
        funcionarios.set(funcionarios.indexOf(funcionario), funcionarioAtualizado);
    }

    public Funcionario consultar(Funcionario funcionario) {
        return funcionarios.get(funcionarios.indexOf(funcionario));
    }

    public List<Funcionario> relatorio() {
        return this.funcionarios;
    }

    public Boolean verificarCpf(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public Boolean verificarNome(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public Boolean verificarLogin(String login) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }
}
