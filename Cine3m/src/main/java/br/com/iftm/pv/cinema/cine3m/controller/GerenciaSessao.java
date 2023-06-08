package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
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

    public EnumValidacoes cadastrar(Sessao sessao) {
        if (sessoes.contains(sessao)) {
            return EnumValidacoes.SESSAO_JA_CADASTRADA;
        }
        sessoes.add(sessao);
        return EnumValidacoes.SESSAO_SUCESSO;
    }

    public Sessao remover(Sessao sessao) {
        return sessoes.remove(sessoes.indexOf(sessao));
    }

    public void atualizar(Sessao sessao, Sessao sessaoAtualizado) {
        sessoes.set(sessoes.indexOf(sessao), sessaoAtualizado);
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
