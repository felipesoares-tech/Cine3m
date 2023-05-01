
package br.com.iftm.pv.cinema.sistemacinema.model;


public class Funcionario extends Pessoa{
    private Integer id;
    private Conta conta;

    public Funcionario(String nome, String cpf, Conta conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = conta;
    }
   
}
