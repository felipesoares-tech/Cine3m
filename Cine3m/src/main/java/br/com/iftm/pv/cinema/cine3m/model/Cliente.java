package br.com.iftm.pv.cinema.cine3m.model;

import lombok.Data;

@Data
public class Cliente extends Pessoa {

    private Integer id;
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

}