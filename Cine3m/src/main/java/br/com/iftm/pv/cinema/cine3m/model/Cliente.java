package br.com.iftm.pv.cinema.cine3m.model;

public class Cliente extends Pessoa {

    private Integer qtdFilmesAssistidos;

    public Cliente(String nome, String cpf) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.qtdFilmesAssistidos = 0;
    }
    
    public Cliente(Integer id,String nome, String cpf, boolean del,Integer qtdFilmesAssistidos) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setDel(del);
        this.setQtdFilmesAssistidos(qtdFilmesAssistidos);
    }

    public Integer getQtdFilmesAssistidos() {
        return qtdFilmesAssistidos;
    }

    public void setQtdFilmesAssistidos(Integer qtdFilmesAssistidos) {
        this.qtdFilmesAssistidos = qtdFilmesAssistidos;
    }

}
