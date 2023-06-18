package br.com.iftm.pv.cinema.cine3m.interfaces;

import java.util.List;

public interface IGerencia<E> {
    Enum cadastrar(E obj);
    Enum remover(E obj);
    Enum atualizar(E obj, E objAt);
    E consultar(Integer id);
    List<E> relatorio();
}
