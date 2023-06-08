package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Filme;
import java.util.List;

public class GerenciaFilme implements IGerencia<Filme> {

    private List<Filme> filmes;

    public GerenciaFilme(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public EnumValidacoes cadastrar(Filme filme) {
        if (filmes.contains(filme)) {
            return EnumValidacoes.FILME_JA_CADASTRADO;
        }
        filmes.add(filme);
        return EnumValidacoes.FILME_SUCESSO;
    }

    public Filme remover(Filme filme) {
        return filmes.remove(filmes.indexOf(filme));
    }

    public void atualizar(Filme filme, Filme filmeAtualizado) {
        filmes.set(filmes.indexOf(filme), filmeAtualizado);
    }

    public Filme consultar(Filme filme) {
        return filmes.get(filmes.indexOf(filme));
    }

    public List<Filme> relatorio() {
        return this.filmes;
    }

}
