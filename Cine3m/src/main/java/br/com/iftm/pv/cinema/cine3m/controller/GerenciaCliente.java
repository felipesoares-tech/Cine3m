package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.util.ValidadorCPF;
import java.util.List;

public class GerenciaCliente implements IGerencia<Cliente> {

    private List<Cliente> clientes;

    public GerenciaCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    public EnumValidacoes cadastrar(Cliente cliente) {
        if (clientes.contains(cliente)) {
            return EnumValidacoes.CLIENTE_CPF_JA_CADASTRADO;
        }else if(!ValidadorCPF.isCPF(cliente.getCpf())){
            return EnumValidacoes.CLIENTE_CPF_INVALIDO;
        }
        clientes.add(cliente);
        return EnumValidacoes.CLIENTE_SUCESSO;
    }

    public Cliente remover(Cliente cliente) {
        return clientes.remove(clientes.indexOf(cliente));
    }

    public void atualizar(Cliente cliente, Cliente clienteAtualizado) {
        clientes.set(clientes.indexOf(cliente), clienteAtualizado);
    }
    
    public Cliente consultar(Cliente cliente) {
        return clientes.get(clientes.indexOf(cliente));
    }

    public List<Cliente> relatorio(){
        return this.clientes;
    }

}
