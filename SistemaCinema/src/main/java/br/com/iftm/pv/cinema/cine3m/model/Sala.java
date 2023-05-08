
package br.com.iftm.pv.cinema.cine3m.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sala {
    @EqualsAndHashCode.Include
    private String nome;
    private Integer capacidade;
    private List<Poltrona> poltronas;

    public Sala(String nome, Integer capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.poltronas = new ArrayList<Poltrona>(capacidade);
    }
    
    public Sala(String nome) {
        this.nome = nome;
    }
    
    
    
}
