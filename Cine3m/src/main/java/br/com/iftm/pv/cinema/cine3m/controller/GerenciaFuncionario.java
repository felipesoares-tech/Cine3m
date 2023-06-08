package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import br.com.iftm.pv.cinema.cine3m.util.ValidadorCPF;
import java.util.Iterator;
import java.util.List;

public class GerenciaFuncionario implements IGerencia<Funcionario> {

    private final List<Funcionario> funcionarios;

    public GerenciaFuncionario(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    private EnumValidacoes validarFuncionario(Funcionario funcionario) {
        EnumValidacoes retornoValidacao;
        if (funcionarios.contains(funcionario)) {
            retornoValidacao = EnumValidacoes.FUNCIONARIO_CPF_JA_CADASTRADO;
        } else if (!ValidadorCPF.isCPF(funcionario.getCpf())) {
            retornoValidacao = EnumValidacoes.FUNCIONARIO_CPF_INVALIDO;
        } else if (existeFuncionarioComLOGIN(funcionario)) {
            retornoValidacao = EnumValidacoes.FUNCIONARIO_LOGIN_JA_CADASTRADO;
        } else {
            retornoValidacao = EnumValidacoes.FUNCIONARIO_SUCESSO;
        }
        return retornoValidacao;
    }
    
    private EnumValidacoes validarFuncionario(Funcionario funcionario, Funcionario funcionarioAtualizado) {
        EnumValidacoes retornoValidacao;

        if (existeFuncionarioComCPF(funcionario, funcionarioAtualizado)) {
            retornoValidacao = EnumValidacoes.FUNCIONARIO_CPF_JA_CADASTRADO;
        } else if (!ValidadorCPF.isCPF(funcionarioAtualizado.getCpf())) {
            retornoValidacao = EnumValidacoes.FUNCIONARIO_CPF_INVALIDO;
        } else if (existeFuncionarioComLOGIN(funcionario,funcionarioAtualizado)) {
            retornoValidacao = EnumValidacoes.FUNCIONARIO_LOGIN_JA_CADASTRADO;
        } else {
            retornoValidacao = EnumValidacoes.FUNCIONARIO_SUCESSO;
        }
        return retornoValidacao;
    }

    private boolean existeFuncionarioComCPF(Funcionario funcionarioAtual, Funcionario funcionarioAtualizado) {
        Iterator<Funcionario> it = funcionarios.iterator();
        while (it.hasNext()) {
            Funcionario f = (Funcionario) it.next();
            if (!f.equals(funcionarioAtual) && f.getCpf().equals(funcionarioAtualizado.getCpf())) {
                return true;
            }
        }
        return false;
    }
    
    private boolean existeFuncionarioComLOGIN(Funcionario funcionarioAtual, Funcionario funcionarioAtualizado) {
        Iterator<Funcionario> it = funcionarios.iterator();
        while (it.hasNext()) {
            Funcionario f = (Funcionario) it.next();
            if (!f.getLogin().equals(funcionarioAtual.getLogin()) && f.getLogin().equals(funcionarioAtualizado.getLogin())) {
                return true;
            }
        }
        return false;
    }
    
    private boolean existeFuncionarioComLOGIN(Funcionario funcionarioAtual) {
        Iterator<Funcionario> it = funcionarios.iterator();
        while (it.hasNext()) {
            Funcionario f = (Funcionario) it.next();
            if (f.getLogin().equals(funcionarioAtual.getLogin())) {
                return true;
            }
        }
        return false;
    }
    
    public EnumValidacoes cadastrar(Funcionario funcionario) {
        EnumValidacoes retornoValidacao = validarFuncionario(funcionario);
        if (retornoValidacao.equals(EnumValidacoes.FUNCIONARIO_SUCESSO)) {
            funcionarios.add(funcionario);
        }
        return retornoValidacao;

    }

    public Funcionario remover(Funcionario funcionario) {
        return funcionarios.remove(funcionarios.indexOf(funcionario));
    }

    public EnumValidacoes atualizar(Funcionario funcionario, Funcionario funcionarioAtualizado) {
        EnumValidacoes retornoValidacao = validarFuncionario(funcionario, funcionarioAtualizado);
        if (retornoValidacao.equals(EnumValidacoes.FUNCIONARIO_SUCESSO)) {
            funcionarios.set(funcionarios.indexOf(funcionario), funcionarioAtualizado);
        }
        return retornoValidacao;
    }

    public Funcionario consultar(Funcionario funcionario) {
        return funcionarios.get(funcionarios.indexOf(funcionario));
    }

    public List<Funcionario> relatorio() {
        return this.funcionarios;
    }

}
