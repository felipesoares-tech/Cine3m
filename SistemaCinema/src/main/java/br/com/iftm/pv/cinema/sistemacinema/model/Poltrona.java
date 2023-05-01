
package br.com.iftm.pv.cinema.sistemacinema.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Poltrona {
    private static int poltronaId = 0;
    private Integer id;
    private boolean livre ;

    public Poltrona() {
        this.livre = true;
        this.id = poltronaId++;
    }
    
}
