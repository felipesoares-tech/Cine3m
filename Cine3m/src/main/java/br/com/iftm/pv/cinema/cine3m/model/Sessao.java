package br.com.iftm.pv.cinema.cine3m.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Sessao {

    private String nome;
    private Filme filme;
    private LocalDate data;
    private LocalTime hora;
    private Double valor;
    private Sala sala;

    public Sessao(Filme filme, LocalDate data, LocalTime hora,Sala sala, Double valor) {
        this.filme = filme;
        this.data = data;
        this.hora = hora;
        this.sala = sala;
        this.valor = valor;
        this.nome = filme.toString() + " - " + sala.toString();
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

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
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
