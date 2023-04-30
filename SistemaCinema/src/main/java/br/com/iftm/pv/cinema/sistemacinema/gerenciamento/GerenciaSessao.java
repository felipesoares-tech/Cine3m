package br.com.iftm.pv.cinema.sistemacinema.gerenciamento;
import br.com.iftm.pv.cinema.sistemacinema.interfaces.IGerencia;
import br.com.iftm.pv.cinema.sistemacinema.model.Sessao;
import br.com.iftm.pv.cinema.sistemacinema.model.Sessao;
import java.util.ArrayList;


public class GerenciaSessao implements IGerencia<Sessao>{
    private ArrayList<Sessao> sessoes;

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

    public ArrayList<Sessao> relatorio() {
        return this.sessoes;
    }
}
