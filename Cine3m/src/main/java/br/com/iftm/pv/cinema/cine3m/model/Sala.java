package br.com.iftm.pv.cinema.cine3m.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sala {

    private String nome;
    private Integer capacidade;
    private List<Poltrona> poltronas;

    public Sala(String nome, Integer capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.poltronas = new ArrayList<Poltrona>(capacidade);

        int numFilas = (capacidade + 9) / 10; // Número de filas necessárias

        for (int fila = 0; fila < numFilas; fila++) {
            char fileira = (char) ('A' + fila);

            for (int numero = 1; numero <= 10; numero++) {
                if (poltronas.size() >= capacidade) {
                    break; // Parar se atingir a capacidade total
                }

                String id = fileira + Integer.toString(numero);
                Poltrona poltrona = new Poltrona(id);
                poltronas.add(poltrona);
            }
        }
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

    public List<Poltrona> getPoltronas() {
        return poltronas;
    }

    public void setPoltronas(List<Poltrona> poltronas) {
        this.poltronas = poltronas;
    }

    public Sala(String nome) {
        this.nome = nome;
    }

}
