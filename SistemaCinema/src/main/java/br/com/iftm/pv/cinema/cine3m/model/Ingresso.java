
package br.com.iftm.pv.cinema.cine3m.model;

import java.util.List;


public class Ingresso {
    private Sessao sessao;
    private Cliente cliente;
    private Double valorFinal;
    private List<ItemIngresso> itensIngresso;


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

    public List<ItemIngresso> getItensIngresso() {
        return itensIngresso;
    }

    public void setItensIngresso(List<ItemIngresso> itensIngresso) {
        this.itensIngresso = itensIngresso;
    }
    
}
