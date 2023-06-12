package br.com.iftm.pv.cinema.cine3m.model;

import br.com.iftm.pv.cinema.cine3m.enums.Genero;
import java.time.LocalTime;
import java.util.Objects;

public class Filme {

    private Genero genero;
    private String nome;
    private String descricao;
    private String diretor;
    private LocalTime duracao;
    private Integer id;
    private boolean del;

    public Filme(Genero genero, String nome, String descricao, String diretor, LocalTime duracao) {
        this.genero = genero;
        this.nome = nome;
        this.descricao = descricao;
        this.diretor = diretor;
        this.duracao = duracao;
    }

    public Filme(Genero genero, String nome, String descricao, String diretor, LocalTime duracao, Integer id, boolean del) {
        this.genero = genero;
        this.nome = nome;
        this.descricao = descricao;
        this.diretor = diretor;
        this.duracao = duracao;
        this.id = id;
        this.del = del;
    }
    
    public Filme(){
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
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

    public LocalTime getDuracao() {
        return duracao;
    }

    public void setDuracao(LocalTime duracao) {
        this.duracao = duracao;
    }

}
