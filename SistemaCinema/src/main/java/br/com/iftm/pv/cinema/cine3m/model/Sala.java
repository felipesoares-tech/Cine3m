
package br.com.iftm.pv.cinema.cine3m.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Sala {
    private Integer id;
    private String nome;
    private Integer capacidade;
    private List<Poltrona> poltronas;

    public Sala(String nome, Integer capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.poltronas = new ArrayList<Poltrona>(capacidade);
    }
    
    
    
}
