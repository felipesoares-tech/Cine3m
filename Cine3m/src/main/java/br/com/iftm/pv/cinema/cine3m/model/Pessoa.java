package br.com.iftm.pv.cinema.cine3m.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
abstract class Pessoa {
    @EqualsAndHashCode.Include
    protected String nome;
    @EqualsAndHashCode.Include
    protected String cpf;
}