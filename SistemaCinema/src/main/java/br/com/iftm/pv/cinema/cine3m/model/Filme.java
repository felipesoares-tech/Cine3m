
package br.com.iftm.pv.cinema.cine3m.model;

import br.com.iftm.pv.cinema.cine3m.enums.Genero;
import lombok.Data;

@Data
public class Filme {
    private Integer id;
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
    
    
    
}
