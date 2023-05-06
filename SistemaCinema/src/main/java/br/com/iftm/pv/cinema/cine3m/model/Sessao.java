package br.com.iftm.pv.cinema.cine3m.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Sessao {
    private Integer id;
    private Filme filme;
    private LocalDateTime dataHora;
    private Double valor;
    private Sala sala;

    public Sessao(Filme filme, LocalDateTime dataHora, Sala sala) {
        this.filme = filme;
        this.dataHora = dataHora;
        this.sala = sala;
    }
    
}
