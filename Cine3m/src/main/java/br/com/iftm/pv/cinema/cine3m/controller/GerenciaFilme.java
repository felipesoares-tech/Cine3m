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

    private EnumValidacoes validarFilme(Filme filme, boolean validarEquals) {
        EnumValidacoes retornoValidacao;
        if (validarEquals && filmes.contains(filme)) {
            retornoValidacao = EnumValidacoes.FILME_JA_CADASTRADO;
        } else {
            retornoValidacao = EnumValidacoes.FILME_SUCESSO;
        }
        return retornoValidacao;
    }

    public EnumValidacoes cadastrar(Filme filme) {
        EnumValidacoes retornoValidacao = validarFilme(filme, true);
        if (retornoValidacao.equals(EnumValidacoes.FILME_SUCESSO)) {
            filmes.add(filme);
        }
        return retornoValidacao;
    }

    public Filme remover(Filme filme) {
        return filmes.remove(filmes.indexOf(filme));
    }

    public EnumValidacoes atualizar(Filme filme, Filme filmeAtualizado) {
        EnumValidacoes retornoValidacao = validarFilme(filmeAtualizado, false);
        if (retornoValidacao.equals(EnumValidacoes.FILME_SUCESSO)) {
            filmes.set(filmes.indexOf(filme), filmeAtualizado);
        }
        return retornoValidacao;              
    }

    public Filme consultar(Filme filme) {
        return filmes.get(filmes.indexOf(filme));
    }

    public List<Filme> relatorio() {
        return this.filmes;
    }

}
