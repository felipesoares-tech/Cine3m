package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.model.Poltrona;
import br.com.iftm.pv.cinema.cine3m.model.Venda;
import java.util.Iterator;
import java.util.List;

public class GerenciaVenda implements IGerencia<Venda> {

    private final List<Venda> vendas;
    private final GerenciaCliente gerenciaCliente;
    private final GerenciaSessao gerenciaSessao;

    public GerenciaVenda(List<Venda> vendas, GerenciaCliente gerenciaCliente, GerenciaSessao gerenciaSessao) {
        this.vendas = vendas;
        this.gerenciaCliente = gerenciaCliente;
        this.gerenciaSessao = gerenciaSessao;
    }

    private Double aplicarPromocaoVenda(Double valor) {
        return valor - (valor * 0.1);
    }

    public EnumValidacoes cadastrar(Venda venda) {
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
        vendas.add(venda);
        return venda.hasDesconto() ? EnumValidacoes.VENDA_PROMOCAO : EnumValidacoes.VENDA_SUCESSO;

    }

    @Override
    public Venda consultar(Venda venda) {
        return vendas.get(vendas.indexOf(venda));
    }

    @Override
    public List<Venda> relatorio() {
        return this.vendas;
    }

    public EnumValidacoes cancelar(Venda venda) {
        if (!venda.isCancelada()) {
            venda.setCancelada(true);
            List<Poltrona> poltronas = venda.consultaPoltronasVenda();

            Iterator<Poltrona> it = poltronas.iterator();
            while (it.hasNext()) {
                Poltrona p = (Poltrona) it.next();
                p.setLivre(true);
                gerenciaSessao.atualizaPoltronaSessao(venda.getSessao(), p);
            }
            return EnumValidacoes.VENDA_CANCELADA;
        }
        return EnumValidacoes.VENDA_JA_CANCELADA;
    }

    @Override
    public Venda remover(Venda venda) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Enum atualizar(Venda obj, Venda objAt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
