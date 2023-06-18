package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.dao.PoltronaDAO;
import br.com.iftm.pv.cinema.cine3m.dao.SalaDAO;
import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Poltrona;
import br.com.iftm.pv.cinema.cine3m.model.Sala;
import java.util.Iterator;
import java.util.List;

public class GerenciaSala implements IGerencia<Sala> {

    private final PoltronaDAO poltronaDAO;
    private final SalaDAO salaDAO;

    public GerenciaSala() {
        this.poltronaDAO = new PoltronaDAO();
        this.salaDAO = new SalaDAO();
    }

    private EnumValidacoes validarSala(Sala sala) {
        EnumValidacoes retornoValidacao;
        if (salaDAO.consultarSalaNome(sala) != null) {
            retornoValidacao = EnumValidacoes.SALA_JA_CADASTRADA;
        } else {
            retornoValidacao = EnumValidacoes.SALA_SUCESSO;
        }
        return retornoValidacao;
    }

    private EnumValidacoes validarSala(Sala sala, Sala salaAtualizado) {
        EnumValidacoes retornoValidacao;
        if (existeSalaComNome(sala, salaAtualizado)) {
            retornoValidacao = EnumValidacoes.SALA_JA_CADASTRADA;
        } else {
            retornoValidacao = EnumValidacoes.SALA_SUCESSO;
        }
        return retornoValidacao;
    }

    private boolean existeSalaComNome(Sala salaAtual, Sala salaAtualizada) {
        Iterator<Sala> it = salaDAO.listar().iterator();
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
            salaDAO.incluir(sala);
        }
        return retornoValidacao;
    }

    @Override
    public Sala remover(Sala sala) {
        // return salas.remove(salas.indexOf(sala));
        return null;
    }

    @Override
    public EnumValidacoes atualizar(Sala sala, Sala salaAtualizado) {
        EnumValidacoes retornoValidacao = validarSala(sala, salaAtualizado);
        if (retornoValidacao.equals(EnumValidacoes.SALA_SUCESSO)) {
            //salas.set(salas.indexOf(sala), salaAtualizado);
        }
        return retornoValidacao;
    }

    @Override
    public Sala consultar(Integer salaID) {
        return salaDAO.consultarSalaID(salaID);
    }

    @Override
    public List<Sala> relatorio() {
        return salaDAO.listar();
    }
    
    public Poltrona consultarPoltrona(Integer salaID){
        return poltronaDAO.consultaPoltronaPorID(salaID);
    }

}
