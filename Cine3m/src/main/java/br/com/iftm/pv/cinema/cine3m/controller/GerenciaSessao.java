package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Poltrona;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import java.util.List;

public class GerenciaSessao implements IGerencia<Sessao> {

    private List<Sessao> sessoes;
    private GerenciaSala gerenciaSala;

    public GerenciaSessao(List<Sessao> sessoes, GerenciaSala gerenciaSala) {
        this.sessoes = sessoes;
        this.gerenciaSala = gerenciaSala;
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
    
    public Boolean poltronaDisponivel(Sessao sessao, Poltrona poltrona){
        return this.gerenciaSala.ConsultaPoltronaDisponivel(sessao.getSala(), poltrona);
    }
    
    public void AtualizaPoltronaSessao(Sessao sessao, Poltrona poltrona){
        gerenciaSala.AtualizaPoltrona(sessao.getSala(), poltrona);
    }

    public List<Sessao> relatorio() {
        return this.sessoes;
    }
}
