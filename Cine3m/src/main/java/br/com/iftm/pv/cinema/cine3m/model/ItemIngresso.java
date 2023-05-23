package br.com.iftm.pv.cinema.cine3m.model;

import br.com.iftm.pv.cinema.cine3m.enums.TipoIngresso;

public class ItemIngresso {

    private Poltrona poltrona;
    private TipoIngresso tipoIngresso;
    private Double valor;

    public ItemIngresso(Poltrona poltrona, TipoIngresso tipoIngresso, Double valor) {
        this.poltrona = poltrona;
        this.tipoIngresso = tipoIngresso;
        this.valor = valor;
    }
    
    public ItemIngresso(Poltrona poltrona) {
        this.poltrona = poltrona;
    }

    public Poltrona getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(Poltrona poltrona) {
        this.poltrona = poltrona;
    }

    public TipoIngresso getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(TipoIngresso tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
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
