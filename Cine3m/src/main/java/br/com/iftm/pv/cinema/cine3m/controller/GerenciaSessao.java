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

    private EnumValidacoes validarSessao(Sessao sessao, boolean validarEquals) {
        EnumValidacoes retornoValidacao;
        if (validarEquals && sessoes.contains(sessao)) {
            retornoValidacao = EnumValidacoes.SESSAO_JA_CADASTRADA;
        } else {
            retornoValidacao = EnumValidacoes.SESSAO_SUCESSO;
        }
        return retornoValidacao;
    }

    public EnumValidacoes cadastrar(Sessao sessao) {
        EnumValidacoes retornoValidacao = validarSessao(sessao, true);
        if (retornoValidacao.equals(EnumValidacoes.SESSAO_SUCESSO)) {
            sessoes.add(sessao);
        }
        return retornoValidacao;
    }

    public Sessao remover(Sessao sessao) {
        return sessoes.remove(sessoes.indexOf(sessao));
    }

    public EnumValidacoes atualizar(Sessao sessao, Sessao sessaoAtualizada) {
        EnumValidacoes retornoValidacao = validarSessao(sessaoAtualizada, false);
        if (retornoValidacao.equals(EnumValidacoes.SESSAO_SUCESSO)) {
            sessoes.set(sessoes.indexOf(sessao), sessaoAtualizada);
        }
        return retornoValidacao;
    }

    public Sessao consultar(Sessao sessao) {
        return sessoes.get(sessoes.indexOf(sessao));
    }

    public Boolean poltronaDisponivel(Sessao sessao, Poltrona poltrona) {
        return gerenciaSala.ConsultaPoltronaDisponivel(sessao.getSala(), poltrona);
    }

    public void AtualizaPoltronaSessao(Sessao sessao, Poltrona poltrona) {
         gerenciaSala.AtualizaPoltrona(sessao.getSala(), poltrona);
    }

    public List<Sessao> relatorio() {
        return this.sessoes;
    }
}
