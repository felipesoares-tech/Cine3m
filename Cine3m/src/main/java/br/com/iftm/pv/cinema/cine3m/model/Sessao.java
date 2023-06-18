package br.com.iftm.pv.cinema.cine3m.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Sessao {

    private Integer id;
    private String identificador;
    private Filme filme;
    private LocalDate data;
    private LocalTime hora;
    private LocalTime horaFinal;
    private Double valor;
    private Sala sala;

    public Sessao(Filme filme, LocalDate data, LocalTime hora, Sala sala, Double valor) {
        this.filme = filme;
        this.data = data;
        this.hora = hora;
        this.sala = sala;
        this.valor = valor;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.identificador = filme.toString() + " - " + sala.toString() + " " + String.valueOf(data.format(formato)) + " " + String.valueOf(hora);
        this.horaFinal = hora.plusHours(filme.getDuracao().getHour())
                .plusMinutes(filme.getDuracao().getMinute());

    }

    public Sessao(Integer id, Filme filme, LocalDate data, LocalTime hora, Sala sala, Double valor, String identificador, LocalTime horaFinal) {
        this.filme = filme;
        this.data = data;
        this.hora = hora;
        this.sala = sala;
        this.valor = valor;
        this.identificador = identificador;
        this.horaFinal = horaFinal;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
    @Override
    public String toString() {
        return getIdentificador();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
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

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.data);
        hash = 23 * hash + Objects.hashCode(this.hora);
        hash = 23 * hash + Objects.hashCode(this.sala);
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
        final Sessao other = (Sessao) obj;
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        return Objects.equals(this.sala, other.sala);
    }
}
