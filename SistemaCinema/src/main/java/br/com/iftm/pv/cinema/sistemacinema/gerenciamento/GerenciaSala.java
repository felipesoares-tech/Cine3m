
package br.com.iftm.pv.cinema.sistemacinema.gerenciamento;

import br.com.iftm.pv.cinema.sistemacinema.interfaces.IGerencia;
import br.com.iftm.pv.cinema.sistemacinema.model.Sala;
import br.com.iftm.pv.cinema.sistemacinema.model.Sala;
import java.util.ArrayList;
import java.util.List;


public class GerenciaSala implements IGerencia<Sala>{
    private ArrayList<Sala> salas;

      public Boolean cadastrar(Sala sala) {
        if (!salas.contains(sala)) {
            return salas.add(sala);
        }
        return false;
    }

    public Sala remover(Sala sala) {
        return salas.remove(salas.indexOf(sala));
    }

    public Sala atualizar(Sala sala, Sala salaAtualizado) {
        return salas.set(salas.indexOf(sala), salaAtualizado);
    }

    public Sala consultar(Sala sala) {
        return salas.get(salas.indexOf(sala));
    }

    public ArrayList<Sala> relatorio() {
        return this.salas;
    }
}
