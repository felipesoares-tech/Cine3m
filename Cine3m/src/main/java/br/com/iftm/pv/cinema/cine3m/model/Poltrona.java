
package br.com.iftm.pv.cinema.cine3m.model;

import java.util.Objects;


public class Poltrona {
    private String id;
    private boolean livre ;

    public Poltrona() {
        this.livre = true;
    }
    
    public Poltrona(String id) {
        this.id = id;
        this.livre = true;
    }

    public String getId() {
        return id;
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
        return getId();
    }
    
    
}
