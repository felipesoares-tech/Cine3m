package br.com.iftm.pv.cinema.cine3m.model;

import java.util.Objects;


public class Poltrona {
    private Integer id;
    private String identificador;
    private Sala sala;
    private boolean livre ;

    public Poltrona() {
        this.livre = true;
    }
    
    public Poltrona(String identificador) {
        this.identificador = identificador;
    }

    public Poltrona(Integer id,String identificador, Sala sala, boolean livre) {
        this.identificador = identificador;
        this.sala = sala;
        this.livre = livre;
        this.id = id;
    }
    
    
    public String getIdentificador() {
        return identificador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public boolean isLivre() {
        return livre;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
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
        final Poltrona other = (Poltrona) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return getIdentificador();
    }
    
    
}
