
package br.com.iftm.pv.cinema.sistemacinema.model;


public class Sala {
    private Integer id;
    private String nome;
    private Integer capacidade;
    private Poltrona[] poltronas;

    public Sala(String nome, Integer capacidade, Poltrona[] poltronas) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.poltronas = poltronas;
    }
    
    
    
}
