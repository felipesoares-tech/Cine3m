package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.model.Venda;
import java.util.List;

public class GerenciaVenda {

    private final List<Venda> vendas;
    private final GerenciaCliente gerenciaCliente;

    public GerenciaVenda(List<Venda> vendas, GerenciaCliente gerenciaCliente) {
        this.vendas = vendas;
        this.gerenciaCliente = gerenciaCliente;
    }

    private Double aplicarPromocaoVenda(Double valor) {
        return valor - (valor * 0.1);
    }

    public Venda cadastrar(Venda venda) {
        Cliente clienteVenda = venda.getCliente();
        if (clienteVenda != null) {
            clienteVenda.setQtdFilmesAssistidos(clienteVenda.getQtdFilmesAssistidos() + 1);
            Cliente clienteAntigo = gerenciaCliente.consultar(clienteVenda);
            if (clienteVenda.getQtdFilmesAssistidos() == 3) {
                venda.setValorFinal(aplicarPromocaoVenda(venda.getValorFinal()));
                venda.setDesconto(true);
                clienteVenda.setQtdFilmesAssistidos(0);
            }
            gerenciaCliente.atualizar(clienteAntigo, clienteVenda);
        }
        if (vendas.add(venda)) {
            return venda;
        }
        return null;
    }

    public Venda consultar(Venda venda) {
        return vendas.get(vendas.indexOf(venda));
    }

    public List<Venda> relatorio() {
        return this.vendas;
    }
}
