package br.com.iftm.pv.cinema.cine3m.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sala {

    @EqualsAndHashCode.Include
    private String nome;
    private Integer capacidade;
    private List<Poltrona> poltronas;

    public Sala(String nome, Integer capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.poltronas = new ArrayList<Poltrona>(capacidade);
        int i = 0;

        for (char fileira = 'A'; i < capacidade / 10; fileira++) {
            for (int numero = 1; numero <= 10; numero++) {

                String id = fileira + Integer.toString(numero);
                Poltrona poltrona = new Poltrona(id);
                poltronas.add(poltrona);

            }
            i++;
        }
        Iterator<Poltrona> it = poltronas.iterator();
        while(it.hasNext()){
            Poltrona poltrona = it.next();
            System.out.println(poltrona.getId());
        }

    }

    public Sala(String nome) {
        this.nome = nome;
    }

}
