
package br.com.iftm.pv.cinema.sistemacinema.model;


public class Funcionario {
    private Integer id;
    private String nome;
    private String cpf;
    private Conta conta;

    public Funcionario(String nome, String cpf, Conta conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = conta;
    }
    
    
    
}
