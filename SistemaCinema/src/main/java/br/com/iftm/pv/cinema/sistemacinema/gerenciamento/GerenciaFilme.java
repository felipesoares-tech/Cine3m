package br.com.iftm.pv.cinema.sistemacinema.gerenciamento;

import br.com.iftm.pv.cinema.sistemacinema.interfaces.IGerencia;

import br.com.iftm.pv.cinema.sistemacinema.model.Filme;
import java.util.ArrayList;
import java.util.List;

public class GerenciaFilme implements IGerencia<Filme> {

    private ArrayList<Filme> filmes;

    public Boolean cadastrar(Filme filme) {
        if (!filmes.contains(filme)) {
            return filmes.add(filme);
        }
        return false;
    }

    public Filme remover(Filme filme) {
        return filmes.remove(filmes.indexOf(filme));
    }

    public Filme atualizar(Filme filme, Filme filmeAtualizado) {
        return filmes.set(filmes.indexOf(filme), filmeAtualizado);
    }

    public Filme consultar(Filme filme) {
        return filmes.get(filmes.indexOf(filme));
    }

    public ArrayList<Filme> relatorio() {
        return this.filmes;
    }

}
