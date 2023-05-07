
package br.com.iftm.pv.cinema.cine3m.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Poltrona {
    private String id;
    private boolean livre ;

    public Poltrona() {
        this.livre = true;
    }
    
    public Poltrona(String id) {
        this.id = id;
    }
    
}
