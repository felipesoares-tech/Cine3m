package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.dao.ClienteDAO;
import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.util.ValidadorCPF;
import java.util.Iterator;
import java.util.List;

public class GerenciaCliente implements IGerencia<Cliente> {
    private final List<Cliente> clientes;
    private final ClienteDAO clienteDAO;
    

    public GerenciaCliente(List<Cliente> clientes) {
        this.clientes = clientes;
        this.clienteDAO = new ClienteDAO();
    }

    private EnumValidacoes validarCliente(Cliente cliente) {
        EnumValidacoes retornoValidacao;
        if (clientes.contains(cliente)) {
            retornoValidacao = EnumValidacoes.CLIENTE_CPF_JA_CADASTRADO;
        } else if (!ValidadorCPF.isCPF(cliente.getCpf())) {
            retornoValidacao = EnumValidacoes.CLIENTE_CPF_INVALIDO;
        } else {
            retornoValidacao = EnumValidacoes.CLIENTE_SUCESSO;
        }
        return retornoValidacao;
    }
    
    private boolean existeClienteComCPF(Cliente clienteAtual, Cliente clienteAtualizado) {
        Iterator<Cliente> it = clientes.iterator();
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
            clientes.add(cliente);
        }
        return retornoValidacao;
    }

    @Override
    public Cliente remover(Cliente cliente) {
        return clientes.remove(clientes.indexOf(cliente));
    }

    @Override
    public EnumValidacoes atualizar(Cliente cliente, Cliente clienteAtualizado) {
        EnumValidacoes retornoValidacao = validarCliente(cliente,clienteAtualizado);
        if (retornoValidacao.equals(EnumValidacoes.CLIENTE_SUCESSO)) {
            clientes.set(clientes.indexOf(cliente), clienteAtualizado);
        }
        return retornoValidacao;
    }

    @Override
    public Cliente consultar(Cliente cliente) {
        return clientes.get(clientes.indexOf(cliente));
    }

    @Override
    public List<Cliente> relatorio() {
        return this.clientes;
    }

}
