
package br.com.iftm.pv.cinema.sistemacinema.model;

import lombok.Data;


@Data
public class Cliente {
    private Integer id;
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    
    
}
