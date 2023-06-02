package br.com.iftm.pv.cinema.cine3m.model;

import java.io.Serializable;


public class Funcionario extends Pessoa implements Serializable{
    private String login;
    private String senha;
    
    public Funcionario(String nome, String cpf,String login,String senha) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
