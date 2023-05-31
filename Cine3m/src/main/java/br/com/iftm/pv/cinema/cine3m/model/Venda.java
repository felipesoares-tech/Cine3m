package br.com.iftm.pv.cinema.cine3m.model;

import java.util.List;

public class Venda {

    private Sessao sessao;
    private Cliente cliente;
    private String identificador;
    private Double valorFinal;
    private List<ItemVenda> itensVenda;
    private boolean desconto;

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public List<ItemVenda> getItensIngresso() {
        return itensVenda;
    }

    public void setItensIngresso(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public Venda(Sessao sessao, Double valorFinal, List<ItemVenda> itensVenda) {
        this.sessao = sessao;
        this.valorFinal = valorFinal;
        this.itensVenda = itensVenda;
        this.identificador = "VENDA" + " - " + itensVenda.toString() + " - " + sessao.toString();
    }

    public Venda(Sessao sessao, Cliente cliente, Double valorFinal, List<ItemVenda> itensVenda) {
        this.sessao = sessao;
        this.cliente = cliente;
        this.valorFinal = valorFinal;
        this.itensVenda = itensVenda;
        this.identificador = "VENDA" + " - " + itensVenda.toString() + " - " + sessao.toString();
    }

    public boolean hasDesconto() {
        return desconto;
    }

    public void setDesconto(boolean desconto) {
        this.desconto = desconto;
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        return getIdentificador();
    }

}
