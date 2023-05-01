
package br.com.iftm.pv.cinema.sistemacinema.model;


public class Conta {
    private Integer id;
    private String login;
    private String senha;

    public Conta(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
}
