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

    private EnumValidacoes validarSala(Sala sala, boolean validarEquals) {
        EnumValidacoes retornoValidacao;
        if (validarEquals && salas.contains(sala)) {
            retornoValidacao = EnumValidacoes.SALA_JA_CADASTRADA;
        } else {
            retornoValidacao = EnumValidacoes.SALA_SUCESSO;
        }
        return retornoValidacao;
    }

    public EnumValidacoes cadastrar(Sala sala) {
        EnumValidacoes retornoValidacao = validarSala(sala, true);
        if (retornoValidacao.equals(EnumValidacoes.SALA_SUCESSO)) {
            salas.add(sala);
        }
        return retornoValidacao;
    }

    public Sala remover(Sala sala) {
        return salas.remove(salas.indexOf(sala));
    }

    public EnumValidacoes atualizar(Sala sala, Sala salaAtualizado) {
        EnumValidacoes retornoValidacao = validarSala(salaAtualizado, false);
        if (retornoValidacao.equals(EnumValidacoes.FILME_SUCESSO)) {
            salas.set(salas.indexOf(sala), salaAtualizado);
        }
        return retornoValidacao;
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
