package br.com.iftm.pv.cinema.cine3m.model;

public class Reserva {

    private Integer id;
    private Boolean livre;
    private Poltrona poltrona;
    private Sessao sessao;
    private Cliente cliente;

    public Reserva(Integer id, Boolean livre, Poltrona poltrona, Sessao sessao, Cliente cliente) {
        this.id = id;
        this.livre = livre;
        this.poltrona = poltrona;
        this.sessao = sessao;
        this.cliente = cliente;
    }

    public Reserva(Boolean livre, Poltrona poltrona, Sessao sessao, Cliente cliente) {
        this.livre = livre;
        this.poltrona = poltrona;
        this.sessao = sessao;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getLivre() {
        return livre;
    }

    public void setLivre(Boolean livre) {
        this.livre = livre;
    }

    public Poltrona getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(Poltrona poltrona) {
        this.poltrona = poltrona;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", livre=" + livre + ", poltrona=" + poltrona + ", sessao=" + sessao + ", cliente=" + cliente + '}';
    }

}
