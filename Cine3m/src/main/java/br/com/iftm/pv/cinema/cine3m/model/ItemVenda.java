package br.com.iftm.pv.cinema.cine3m.model;

import br.com.iftm.pv.cinema.cine3m.enums.TipoVenda;

public class ItemVenda {
    private Integer id;
    private Poltrona poltrona;
    private TipoVenda tipoVenda;
    private Venda venda;
    private Double valor;

    public ItemVenda(Poltrona poltrona, TipoVenda tipoVenda, Double valor) {
        this.poltrona = poltrona;
        this.tipoVenda = tipoVenda;
        this.valor = valor;
    }

    public ItemVenda(Integer id, Poltrona poltrona, TipoVenda tipoVenda, Venda venda, Double valor) {
        this.id = id;
        this.poltrona = poltrona;
        this.tipoVenda = tipoVenda;
        this.venda = venda;
        this.valor = valor;
    }
    
    public ItemVenda(Poltrona poltrona) {
        this.poltrona = poltrona;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoVenda getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(TipoVenda tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Poltrona getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(Poltrona poltrona) {
        this.poltrona = poltrona;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return getPoltrona().toString();
    }

}
