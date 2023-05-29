package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.model.Venda;
import java.util.List;
import javax.swing.JOptionPane;

public class GerenciaVenda implements IGerencia<Venda> {

    private final List<Venda> vendas;
    private final GerenciaCliente gerenciaCliente;
    private boolean desconto;

    public GerenciaVenda(List<Venda> vendas, GerenciaCliente gerenciaCliente) {
        this.vendas = vendas;
        this.gerenciaCliente = gerenciaCliente;
    }

    @Override
    public Boolean cadastrar(Venda venda) {
        Cliente clienteVenda = venda.getCliente();
        if (clienteVenda != null) {
            clienteVenda.setQtdFilmesAssistidos(clienteVenda.getQtdFilmesAssistidos() + 1);
            Cliente clienteAntigo = gerenciaCliente.consultar(clienteVenda);
            if (clienteVenda.getQtdFilmesAssistidos() == 3) {
                venda.setValorFinal(venda.getValorFinal() - (venda.getValorFinal() * 0.1));
                setDesconto(true);
                clienteVenda.setQtdFilmesAssistidos(0);
                JOptionPane.showMessageDialog(null, "Cliente com promoção", "promoção", JOptionPane.INFORMATION_MESSAGE);
            }
            gerenciaCliente.atualizar(clienteAntigo, clienteVenda);
        }
        return vendas.add(venda);
    }

    @Override
    public Venda remover(Venda venda) {
        return vendas.remove(vendas.indexOf(venda));
    }

    @Override
    public void atualizar(Venda venda, Venda vendaAtualizado) {
        vendas.set(vendas.indexOf(venda), vendaAtualizado);
    }

    @Override
    public Venda consultar(Venda venda) {
        return vendas.get(vendas.indexOf(venda));
    }

    @Override
    public List<Venda> relatorio() {
        return this.vendas;
    }

    public boolean isDesconto() {
        return desconto;
    }

    public void setDesconto(boolean desconto) {
        this.desconto = desconto;
    }

}
