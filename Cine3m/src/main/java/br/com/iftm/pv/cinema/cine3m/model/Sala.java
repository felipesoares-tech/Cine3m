package br.com.iftm.pv.cinema.cine3m.model;

import java.util.Objects;

public class Sala {
    private Integer id;
    private String nome;
    private Integer capacidade;

    public Sala(String nome, Integer capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;   
    }
    
    public Sala(Integer id,String nome, Integer capacidade) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;   
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sala other = (Sala) obj;
        return Objects.equals(this.nome, other.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sala(String nome) {
        this.nome = nome;
    }

}
