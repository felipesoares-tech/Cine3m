package br.com.iftm.pv.cinema.cine3m.model;

import br.com.iftm.pv.cinema.cine3m.enums.Genero;
import java.util.Objects;

public class Filme {
    private Genero genero;
    private String nome;
    private String descricao;
    private String diretor;

    public Filme(Genero genero, String nome, String descricao, String diretor) {
        this.genero = genero;
        this.nome = nome;
        this.descricao = descricao;
        this.diretor = diretor;
    }
    public Filme(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getNome();
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nome);
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
        final Filme other = (Filme) obj;
        return Objects.equals(this.nome, other.nome);
    }
    

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    
}
