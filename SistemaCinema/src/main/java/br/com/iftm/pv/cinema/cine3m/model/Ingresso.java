
package br.com.iftm.pv.cinema.cine3m.model;

import br.com.iftm.pv.cinema.cine3m.enums.TipoIngresso;

public class Ingresso {
    private Integer id;
    private Sessao sessao;
    private Cliente cliente;
    private TipoIngresso tipoIngresso;
    private Double valor;
    private Poltrona poltrona;

    public Ingresso(Sessao sessao, Cliente cliente, TipoIngresso tipoIngresso, Double valor,Poltrona poltrona) {
        this.sessao = sessao;
        this.cliente = cliente;
        this.tipoIngresso = tipoIngresso;
        this.valor = valor;
        this.poltrona = poltrona;
    }
    
}
