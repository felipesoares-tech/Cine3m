
package br.com.iftm.pv.cinema.cine3m.model;

import br.com.iftm.pv.cinema.cine3m.enums.TipoIngresso;
import lombok.Data;

@Data
public class ItemIngresso {
    private Poltrona poltrona;
    private TipoIngresso tipoIngresso;
    private Double valor;

    public ItemIngresso(Poltrona poltrona, TipoIngresso tipoIngresso,Double valor) {
        this.poltrona = poltrona;
        this.tipoIngresso = tipoIngresso;
        this.valor = valor;
    }
   
    
    
}
