package br.com.iftm.pv.cinema.cine3m.interfaces;

import java.util.ArrayList;
import java.util.List;


public interface IGerencia<E> {
    Boolean cadastrar (E obj);
    E remover(E obj);
    void atualizar(E obj, E objAt);
    E consultar(E obj);
    List<E> relatorio();
}
