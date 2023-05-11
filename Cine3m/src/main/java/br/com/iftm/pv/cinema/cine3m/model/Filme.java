package br.com.iftm.pv.cinema.cine3m.model;

import br.com.iftm.pv.cinema.cine3m.enums.Genero;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Filme {
    private Genero genero;
    @EqualsAndHashCode.Include
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
}
