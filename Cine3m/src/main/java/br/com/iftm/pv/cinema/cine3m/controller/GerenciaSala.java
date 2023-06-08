package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Poltrona;
import br.com.iftm.pv.cinema.cine3m.model.Sala;
import java.util.Iterator;
import java.util.List;

public class GerenciaSala implements IGerencia<Sala> {
    private final List<Sala> salas;

    public GerenciaSala(List<Sala> salas) {
        this.salas = salas;
    }

    private EnumValidacoes validarSala(Sala sala) {
        EnumValidacoes retornoValidacao;
        if (salas.contains(sala)) {
            retornoValidacao = EnumValidacoes.SALA_JA_CADASTRADA;
        } else {
            retornoValidacao = EnumValidacoes.SALA_SUCESSO;
        }
        return retornoValidacao;
    }

    private EnumValidacoes validarSala(Sala sala, Sala salaAtualizado) {
        EnumValidacoes retornoValidacao;
        if (existeSalaComNOME(sala, salaAtualizado)) {
            retornoValidacao = EnumValidacoes.SALA_JA_CADASTRADA;
        } else {
            retornoValidacao = EnumValidacoes.SALA_SUCESSO;
        }
        return retornoValidacao;
    }
    
    private boolean existeSalaComNOME(Sala salaAtual, Sala salaAtualizada) {
        Iterator<Sala> it = salas.iterator();
        while (it.hasNext()) {
            Sala f = (Sala) it.next();
            if (!f.equals(salaAtual) && f.getNome().equals(salaAtualizada.getNome())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public EnumValidacoes cadastrar(Sala sala) {
        EnumValidacoes retornoValidacao = validarSala(sala);
        if (retornoValidacao.equals(EnumValidacoes.SALA_SUCESSO)) {
            salas.add(sala);
        }
        return retornoValidacao;
    }

    @Override
    public Sala remover(Sala sala) {
        return salas.remove(salas.indexOf(sala));
    }

    @Override
    public EnumValidacoes atualizar(Sala sala, Sala salaAtualizado) {
        EnumValidacoes retornoValidacao = validarSala(sala,salaAtualizado);
        if (retornoValidacao.equals(EnumValidacoes.SALA_SUCESSO)) {
            salas.set(salas.indexOf(sala), salaAtualizado);
        }
        return retornoValidacao;
    }

    @Override
    public Sala consultar(Sala sala) {
        return salas.get(salas.indexOf(sala));
    }

    @Override
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
