package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import java.util.List;
import lombok.Data;


@Data
public class GerenciaSessao implements IGerencia<Sessao> {

    private List<Sessao> sessoes;

    public GerenciaSessao(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

   

    public Boolean cadastrar(Sessao sessao) {
        if (!sessoes.contains(sessao)) {
            return sessoes.add(sessao);
        }
        return false;
    }

    public Sessao remover(Sessao sessao) {
        return sessoes.remove(sessoes.indexOf(sessao));
    }

    public Sessao atualizar(Sessao sessao, Sessao sessaoAtualizado) {
        return sessoes.set(sessoes.indexOf(sessao), sessaoAtualizado);
    }

    public Sessao consultar(Sessao sessao) {
        return sessoes.get(sessoes.indexOf(sessao));
    }

    public List<Sessao> relatorio() {
        return this.sessoes;
    }
}
