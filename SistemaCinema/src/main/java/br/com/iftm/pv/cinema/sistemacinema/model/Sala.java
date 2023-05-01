
package br.com.iftm.pv.cinema.sistemacinema.model;

import lombok.Data;

@Data
public class Sala {
    private Integer id;
    private String nome;
    private Integer capacidade;
    private Poltrona[] poltronas;

    public Sala(String nome, Integer capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.poltronas = new Poltrona[capacidade];
    }
    
    
    
}
