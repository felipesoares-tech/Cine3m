package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Poltrona;
import br.com.iftm.pv.cinema.cine3m.model.Sala;
import java.util.List;

public class GerenciaSala implements IGerencia<Sala> {

    private List<Sala> salas;

    public GerenciaSala(List<Sala> salas) {
        this.salas = salas;
    }

    public EnumValidacoes cadastrar(Sala sala) {
        if (salas.contains(sala)) {
            return EnumValidacoes.SALA_JA_CADASTRADA;
        }
        salas.add(sala);
        return EnumValidacoes.SALA_SUCESSO;
    }

    public Sala remover(Sala sala) {
        return salas.remove(salas.indexOf(sala));
    }

    public void atualizar(Sala sala, Sala salaAtualizado) {
        salas.set(salas.indexOf(sala), salaAtualizado);
    }

    public Sala consultar(Sala sala) {
        return salas.get(salas.indexOf(sala));
    }

    public List<Sala> relatorio() {
        return this.salas;
    }

    public Boolean ConsultaPoltronaDisponivel(Sala sala, Poltrona poltrona) {
        int pos = sala.getPoltronas().indexOf(poltrona);
        return consultar(sala).getPoltronas().get(pos).isLivre();
    }

    public void AtualizaPoltrona(Sala sala, Poltrona poltrona) {
        int pos = sala.getPoltronas().indexOf(poltrona);
        sala.getPoltronas().set(pos, poltrona);
    }

}
