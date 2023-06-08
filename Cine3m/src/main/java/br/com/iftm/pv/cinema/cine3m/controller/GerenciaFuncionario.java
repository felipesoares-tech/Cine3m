package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import br.com.iftm.pv.cinema.cine3m.util.ValidadorCPF;
import java.util.List;

public class GerenciaFuncionario implements IGerencia<Funcionario>{

    private List<Funcionario> funcionarios;
    private EnumValidacoes en;

    public GerenciaFuncionario(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public EnumValidacoes cadastrar(Funcionario funcionario) {
        if (funcionarios.contains(funcionario)) {
            return EnumValidacoes.FUNCIONARIO_CPF_JA_CADASTRADO;
        } else if (verificarLogin(funcionario.getLogin())) {
            return EnumValidacoes.FUNCIONARIO_LOGIN_JA_CADASTRADO;
        }else if(!ValidadorCPF.isCPF(funcionario.getCpf())){
            return EnumValidacoes.FUNCIONARIO_CPF_INVALIDO;
        }
        funcionarios.add(funcionario);
        return EnumValidacoes.FUNCIONARIO_SUCESSO;

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
