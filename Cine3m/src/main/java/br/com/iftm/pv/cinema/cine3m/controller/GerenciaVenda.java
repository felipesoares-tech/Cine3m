package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.dao.ItemVendaDAO;
import br.com.iftm.pv.cinema.cine3m.dao.VendaDAO;
import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.model.ItemVenda;
import br.com.iftm.pv.cinema.cine3m.model.Venda;
import java.util.List;

public class GerenciaVenda{

    private final GerenciaCliente gerenciaCliente;
    private final GerenciaSessao gerenciaSessao;
    private final VendaDAO vendaDAO;
    private final ItemVendaDAO itemVendaDAO;

    public GerenciaVenda(GerenciaCliente gerenciaCliente, GerenciaSessao gerenciaSessao, GerenciaSala gerenciaSala) {
        this.vendaDAO = new VendaDAO(gerenciaCliente, gerenciaSala, this, gerenciaSessao);
        this.itemVendaDAO = new ItemVendaDAO(gerenciaSala, this);
        this.gerenciaCliente = gerenciaCliente;
        this.gerenciaSessao = gerenciaSessao;
    }

    private Double aplicarPromocaoVenda(Double valor) {
        return valor - (valor * 0.1);
    }

    public EnumValidacoes cadastrar(Venda venda, List<ItemVenda> itensVenda) {
        Cliente clienteVenda = venda.getCliente();
        if (clienteVenda != null) {
            clienteVenda.setQtdFilmesAssistidos(clienteVenda.getQtdFilmesAssistidos() + 1);
            Cliente clienteAntigo = gerenciaCliente.consultar(clienteVenda.getId());
            if (clienteVenda.getQtdFilmesAssistidos() == 3) {
                venda.setValorFinal(aplicarPromocaoVenda(venda.getValorFinal()));
                venda.setDesconto(true);
                clienteVenda.setQtdFilmesAssistidos(0);
            }
            gerenciaCliente.atualizar(clienteAntigo, clienteVenda);
        }
        vendaDAO.incluir(venda, itensVenda);
        return venda.hasDesconto() ? EnumValidacoes.VENDA_PROMOCAO : EnumValidacoes.VENDA_SUCESSO;

    }


    public Venda consultar(Integer vendaID) {
        return vendaDAO.consultaVendaPorID(vendaID);
    }
    
    public List<Venda> relatorio() {
        return vendaDAO.listar();
    }

    public List<ItemVenda> listarItensVenda(Venda venda) {
        return itemVendaDAO.listar(venda);
    }
    
    public void incluirItemVenda(Venda venda, ItemVenda itemVenda){
        itemVenda.setVenda(venda);
        itemVendaDAO.incluir(itemVenda);
    }
    
    public List<Venda> consultarVendaSessao(Integer id) {
        return vendaDAO.consultarVendaSessao(id);
    }

    public EnumValidacoes cancelar(Venda venda) {
//        if (!venda.isCancelada()) {
//            venda.setCancelada(true);
//            List<Poltrona> poltronas = venda.consultaPoltronasVenda();
//
//            Iterator<Poltrona> it = poltronas.iterator();
//            while (it.hasNext()) {
//                Poltrona p = (Poltrona) it.next();
//                p.setLivre(true);
//                gerenciaSessao.atualizaPoltronaSessao(venda.getSessao(), p);
//            }
//            return EnumValidacoes.VENDA_CANCELADA;
//        }
//        return EnumValidacoes.VENDA_JA_CANCELADA;
        return EnumValidacoes.VENDA_JA_CANCELADA;
    }


    public Venda remover(Venda venda) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public Enum atualizar(Venda obj, Venda objAt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
