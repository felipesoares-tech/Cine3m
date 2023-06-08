package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Filme;
import java.util.Iterator;
import java.util.List;

public class GerenciaFilme implements IGerencia<Filme> {

    private final List<Filme> filmes;

    public GerenciaFilme(List<Filme> filmes) {
        this.filmes = filmes;
    }

    private EnumValidacoes validarFilme(Filme filme) {
        EnumValidacoes retornoValidacao;
        if (filmes.contains(filme)) {
            retornoValidacao = EnumValidacoes.FILME_JA_CADASTRADO;
        } else {
            retornoValidacao = EnumValidacoes.FILME_SUCESSO;
        }
        return retornoValidacao;
    }

    private EnumValidacoes validarFilme(Filme filme, Filme filmeAtualizado) {
        EnumValidacoes retornoValidacao;
        if (existeFilmeComNOME(filme, filmeAtualizado)) {
            retornoValidacao = EnumValidacoes.FILME_JA_CADASTRADO;
        } else {
            retornoValidacao = EnumValidacoes.FILME_SUCESSO;
        }
        return retornoValidacao;
    }

    private boolean existeFilmeComNOME(Filme filmeAtual, Filme filmeAtualizado) {
        Iterator<Filme> it = filmes.iterator();
        while (it.hasNext()) {
            Filme f = (Filme) it.next();
            if (!f.equals(filmeAtual) && f.getNome().equals(filmeAtualizado.getNome())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public EnumValidacoes cadastrar(Filme filme) {
        EnumValidacoes retornoValidacao = validarFilme(filme);
        if (retornoValidacao.equals(EnumValidacoes.FILME_SUCESSO)) {
            filmes.add(filme);
        }
        return retornoValidacao;
    }

    @Override
    public Filme remover(Filme filme) {
        return filmes.remove(filmes.indexOf(filme));
    }

    @Override
    public EnumValidacoes atualizar(Filme filme, Filme filmeAtualizado) {
        EnumValidacoes retornoValidacao = validarFilme(filme,filmeAtualizado);
        if (retornoValidacao.equals(EnumValidacoes.FILME_SUCESSO)) {
            filmes.set(filmes.indexOf(filme), filmeAtualizado);
        }
        return retornoValidacao;
    }

    @Override
    public Filme consultar(Filme filme) {
        return filmes.get(filmes.indexOf(filme));
    }

    @Override
    public List<Filme> relatorio() {
        return this.filmes;
    }

}
