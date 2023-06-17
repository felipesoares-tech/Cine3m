
package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.dao.ReservaDAO;
import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Reserva;
import java.util.List;


public class GerenciaReserva  implements IGerencia<Reserva>{
    
    private ReservaDAO reservaDAO;

    @Override
    public Enum cadastrar(Reserva reserva) {
        reservaDAO.incluir(reserva);
         return EnumValidacoes.RESERVA_SUCESSO; 
      }

    @Override
    public Reserva remover(Reserva obj) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Enum atualizar(Reserva obj, Reserva objAt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Reserva consultar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Reserva> relatorio() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
