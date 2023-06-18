package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.dao.FilmeDAO;
import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Filme;
import java.util.Iterator;
import java.util.List;

public class GerenciaFilme implements IGerencia<Filme> {
    private final FilmeDAO filmeDAO;

    public GerenciaFilme() {
        filmeDAO = new FilmeDAO();
    }

    private EnumValidacoes validarFilme(Filme filme) {
        EnumValidacoes retornoValidacao;
        if (filmeDAO.consultarFilmeNome(filme) != null) {
            retornoValidacao = EnumValidacoes.FILME_JA_CADASTRADO;
        } else {
            retornoValidacao = EnumValidacoes.FILME_SUCESSO;
        }
        return retornoValidacao;
    }

    private EnumValidacoes validarFilme(Filme filme, Filme filmeAtualizado) {
        EnumValidacoes retornoValidacao;
        if (existeFilmeComNome(filme, filmeAtualizado)) {
            retornoValidacao = EnumValidacoes.FILME_JA_CADASTRADO;
        } else {
            retornoValidacao = EnumValidacoes.FILME_SUCESSO;
        }
        return retornoValidacao;
    }

    private boolean existeFilmeComNome(Filme filmeAtual, Filme filmeAtualizado) {
        Iterator<Filme> it = filmeDAO.listar().iterator();
        while (it.hasNext()) {
            Filme f = (Filme) it.next();
            if (!f.equals(filmeAtual) && f.getNome().equals(filmeAtualizado.getNome())) {
                return true;
            }
        }
        return false;
    }
    
    private boolean filmeVinculadoSessao(Filme filme){
        //GerenciaSessao gerenciaSessao = new GerenciaSessao(gerenciaSala);
        return true;
    }

    @Override
    public EnumValidacoes cadastrar(Filme filme) {
        EnumValidacoes retornoValidacao = validarFilme(filme);
        if (retornoValidacao.equals(EnumValidacoes.FILME_SUCESSO)) {
            filmeDAO.incluir(filme);
        }
        return retornoValidacao;
    }

    @Override
    public Filme remover(Filme filme) {
        filmeDAO.apagar(filme.getId());
        return null;
    }

    @Override
    public EnumValidacoes atualizar(Filme filme, Filme filmeAtualizado) {
        EnumValidacoes retornoValidacao = validarFilme(filme,filmeAtualizado);
        if (retornoValidacao.equals(EnumValidacoes.FILME_SUCESSO)) {
            filmeDAO.alterar(filme.getId(), filmeAtualizado);            
        }
        return retornoValidacao;
    }

    @Override
    public Filme consultar(Integer filmeID) {        
        return filmeDAO.consultarFilmeID(filmeID);
    }

    @Override
    public List<Filme> relatorio() {
        return filmeDAO.listar();
    }

}