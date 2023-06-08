package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.util.ValidadorCPF;
import java.util.List;

public class GerenciaCliente {

    private List<Cliente> clientes;

    public GerenciaCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public EnumValidacoes validarCliente(Cliente cliente, boolean validarEquals) {
        EnumValidacoes retornoValidacao;
        if (validarEquals && clientes.contains(cliente)) {
            retornoValidacao = EnumValidacoes.CLIENTE_CPF_JA_CADASTRADO;
        } else if (!ValidadorCPF.isCPF(cliente.getCpf())) {
            retornoValidacao = EnumValidacoes.CLIENTE_CPF_INVALIDO;
        } else {
            retornoValidacao = EnumValidacoes.CLIENTE_SUCESSO;
        }
        return retornoValidacao;
    }

    public EnumValidacoes cadastrar(Cliente cliente) {
        EnumValidacoes retornoValidacao = validarCliente(cliente, true);
        if (retornoValidacao.equals(EnumValidacoes.CLIENTE_SUCESSO)) {
            clientes.add(cliente);
        }
        return retornoValidacao;
    }

    public Cliente remover(Cliente cliente) {
        return clientes.remove(clientes.indexOf(cliente));
    }

    public EnumValidacoes atualizar(Cliente cliente, Cliente clienteAtualizado) {
        EnumValidacoes retornoValidacao = validarCliente(clienteAtualizado, false);
        if (retornoValidacao.equals(EnumValidacoes.CLIENTE_SUCESSO)) {
            clientes.set(clientes.indexOf(cliente), clienteAtualizado);
        }
        return retornoValidacao;
    }

    public Cliente consultar(Cliente cliente) {
        return clientes.get(clientes.indexOf(cliente));
    }

    public List<Cliente> relatorio() {
        return this.clientes;
    }

}
