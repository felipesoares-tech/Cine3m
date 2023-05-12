
package br.com.iftm.pv.cinema.cine3m.model;


public class Funcionario extends Pessoa{
    private String login;
    private String senha;
    
    public Funcionario(String nome, String cpf,String login,String senha) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.login = login;
        this.senha = senha;
    }

}
