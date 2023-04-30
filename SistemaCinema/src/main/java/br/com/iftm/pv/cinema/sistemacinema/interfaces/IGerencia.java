package br.com.iftm.pv.cinema.sistemacinema.interfaces;
import java.util.List;


public interface IGerencia {
    Boolean cadastrar ();
    Boolean remover();
    Boolean atualizar();
    Object consultar();
    List<Object> relatorio();
}
