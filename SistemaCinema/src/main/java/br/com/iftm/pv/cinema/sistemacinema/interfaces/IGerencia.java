package br.com.iftm.pv.cinema.sistemacinema.interfaces;

import java.util.ArrayList;


public interface IGerencia<E> {
    Boolean cadastrar (E obj);
    E remover(E obj);
    E atualizar(E obj, E objAt);
    E consultar(E obj);
    ArrayList<E> relatorio();
}
