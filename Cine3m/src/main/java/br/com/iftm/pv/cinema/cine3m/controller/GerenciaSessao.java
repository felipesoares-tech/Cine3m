package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Poltrona;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import java.util.List;

public class GerenciaSessao implements IGerencia<Sessao> {

    private final List<Sessao> sessoes;
    private final GerenciaSala gerenciaSala;

    public GerenciaSessao(List<Sessao> sessoes, GerenciaSala gerenciaSala) {
        this.sessoes = sessoes;
        this.gerenciaSala = gerenciaSala;
    }

    private EnumValidacoes validarSessao(Sessao sessao) {
        EnumValidacoes retornoValidacao;
        if (sessoes.contains(sessao)) { //O Contains, verifica somente oq está no Equals!
            retornoValidacao = EnumValidacoes.SESSAO_JA_CADASTRADA;
        } else if (existeSessaoComHORARIO(sessao)) {
            retornoValidacao = EnumValidacoes.SESSAO_HORARIO_JA_UTILIZADO;
        } else {
            retornoValidacao = EnumValidacoes.SESSAO_SUCESSO;
        }

        //TODO: adicionar outras condicoes a serem validadas
        return retornoValidacao;
    }

    private EnumValidacoes validarSessao(Sessao sessao, Sessao sessaoAtualizada) {
        EnumValidacoes retornoValidacao;
        if (existeSessaoComHORARIO(sessao, sessaoAtualizada)) {
            retornoValidacao = EnumValidacoes.SESSAO_HORARIO_JA_UTILIZADO;
        } else {
            retornoValidacao = EnumValidacoes.SESSAO_SUCESSO;
        }
        return retornoValidacao;
    }

    private boolean existeSessaoComHORARIO(Sessao sessao, Sessao sessaoAtualizada) {
        return false; //TODO: implementar, provavelmente igual a login em validacao de funcionario
    }

    private boolean existeSessaoComHORARIO(Sessao sessao) {
        return false; //TODO: implementar, provavelmente igual a login em validacao de funcionario
    }

    @Override
    public EnumValidacoes cadastrar(Sessao sessao) {
        EnumValidacoes retornoValidacao = validarSessao(sessao);
        if (retornoValidacao.equals(EnumValidacoes.SESSAO_SUCESSO)) {
            sessoes.add(sessao);
        }
        return retornoValidacao;
    }

    @Override
    public Sessao remover(Sessao sessao) {
        return sessoes.remove(sessoes.indexOf(sessao));
    }

    @Override
    public EnumValidacoes atualizar(Sessao sessao, Sessao sessaoAtualizada) {
        EnumValidacoes retornoValidacao = validarSessao(sessao, sessaoAtualizada);
        if (retornoValidacao.equals(EnumValidacoes.SESSAO_SUCESSO)) {
            sessoes.set(sessoes.indexOf(sessao), sessaoAtualizada);
        }
        return retornoValidacao;
    }

    @Override
    public Sessao consultar(Sessao sessao) {
        return sessoes.get(sessoes.indexOf(sessao));
    }

    public Boolean poltronaDisponivel(Sessao sessao, Poltrona poltrona) {
        return gerenciaSala.ConsultaPoltronaDisponivel(sessao.getSala(), poltrona);
    }

    public void AtualizaPoltronaSessao(Sessao sessao, Poltrona poltrona) {
        gerenciaSala.AtualizaPoltrona(sessao.getSala(), poltrona);
    }

    @Override
    public List<Sessao> relatorio() {
        return this.sessoes;
    }
}
