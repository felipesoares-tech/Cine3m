package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Venda;
import java.util.List;

public class GerenciaVenda implements IGerencia<Venda> {

    private List<Venda> ingressos;

    public GerenciaVenda(List<Venda> ingressos) {
        this.ingressos = ingressos;
    }

    public Boolean cadastrar(Venda ingresso) {
        return ingressos.add(ingresso);

    }

    public Venda remover(Venda ingresso) {
        return ingressos.remove(ingressos.indexOf(ingresso));
    }

    public void atualizar(Venda ingresso, Venda ingressoAtualizado) {
        ingressos.set(ingressos.indexOf(ingresso), ingressoAtualizado);
    }

    public Venda consultar(Venda ingresso) {
        return ingressos.get(ingressos.indexOf(ingresso));
    }

    public List<Venda> relatorio() {
        return this.ingressos;
    }

}
