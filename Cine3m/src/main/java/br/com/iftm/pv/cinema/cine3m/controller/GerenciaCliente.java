package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.dao.ClienteDAO;
import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.util.ValidadorCPF;
import java.util.Iterator;
import java.util.List;

public class GerenciaCliente implements IGerencia<Cliente> {

    private final ClienteDAO clienteDAO;

    public GerenciaCliente() {
        this.clienteDAO = new ClienteDAO();
    }

    private EnumValidacoes validarCliente(Cliente cliente) {
        EnumValidacoes retornoValidacao;
        if (clienteDAO.consultar(cliente) != null) {
            retornoValidacao = EnumValidacoes.CLIENTE_CPF_JA_CADASTRADO;
        } else if (!ValidadorCPF.isCPF(cliente.getCpf())) {
            retornoValidacao = EnumValidacoes.CLIENTE_CPF_INVALIDO;
        } else {
            retornoValidacao = EnumValidacoes.CLIENTE_SUCESSO;
        }
        return retornoValidacao;
    }

    private boolean existeClienteComCPF(Cliente clienteAtual, Cliente clienteAtualizado) {
        Iterator<Cliente> it = clienteDAO.listar().iterator();
        while (it.hasNext()) {
            Cliente c = (Cliente) it.next();
            if (!c.equals(clienteAtual) && c.getCpf().equals(clienteAtualizado.getCpf())) {
                return true;
            }
        }
        return false;
    }

    private EnumValidacoes validarCliente(Cliente cliente, Cliente clienteAtualizado) {
        EnumValidacoes retornoValidacao;

        if (existeClienteComCPF(cliente, clienteAtualizado)) {
            retornoValidacao = EnumValidacoes.CLIENTE_CPF_JA_CADASTRADO;
        } else if (!ValidadorCPF.isCPF(clienteAtualizado.getCpf())) {
            retornoValidacao = EnumValidacoes.CLIENTE_CPF_INVALIDO;
        } else {
            retornoValidacao = EnumValidacoes.CLIENTE_SUCESSO;
        }
        return retornoValidacao;
    }

    @Override
    public EnumValidacoes cadastrar(Cliente cliente) {
        EnumValidacoes retornoValidacao = validarCliente(cliente);
        if (retornoValidacao.equals(EnumValidacoes.CLIENTE_SUCESSO)) {
            clienteDAO.incluir(cliente);
        }
        return retornoValidacao;
    }

    @Override
    public Cliente remover(Cliente cliente) {
        clienteDAO.apagar(cliente);
        return null;
    }

    @Override
    public EnumValidacoes atualizar(Cliente cliente, Cliente clienteAtualizado) {
        EnumValidacoes retornoValidacao = validarCliente(cliente, clienteAtualizado);
        if (retornoValidacao.equals(EnumValidacoes.CLIENTE_SUCESSO)) {
            clienteDAO.alterar(cliente, clienteAtualizado);
        }
        return retornoValidacao;
    }

    @Override
    public Cliente consultar(Cliente cliente) {
        return clienteDAO.consultar(cliente);
    }

    @Override
    public List<Cliente> relatorio() {
        return clienteDAO.listar();
    }

}
