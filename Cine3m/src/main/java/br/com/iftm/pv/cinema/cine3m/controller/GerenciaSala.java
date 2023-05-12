
package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Sala;
import java.util.List;
import lombok.Data;


@Data
public class GerenciaSala implements IGerencia<Sala>{
    private List<Sala> salas;

    public GerenciaSala(List<Sala> salas) {
        this.salas = salas;
    }

    
    
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

    public List<Sala> relatorio() {
        return this.salas;
    }
}
