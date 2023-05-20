package br.com.iftm.pv.cinema.cine3m.model;

import java.time.LocalDateTime;



public class Sessao {
    private String nome;
    private Integer id;
    private Filme filme;
    private LocalDateTime dataHora;
    private Double valor;
    private Sala sala;

    public Sessao(Filme filme, LocalDateTime dataHora, Sala sala, Double valor) {
        this.filme = filme;
        this.dataHora = dataHora;
        this.sala = sala;
        this.valor = valor;
        this.nome = filme.toString() + sala.toString();
    }

    @Override
    public String toString() {
        return getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
}
