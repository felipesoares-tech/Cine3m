
package br.com.iftm.pv.cinema.sistemacinema.gerenciamento;

import br.com.iftm.pv.cinema.sistemacinema.interfaces.IGerencia;
import br.com.iftm.pv.cinema.sistemacinema.model.Ingresso;
import java.util.List;
import lombok.Data;

@Data
public class GerenciaIngresso implements IGerencia<Ingresso>{
    private List<Ingresso> ingressos;

    public GerenciaIngresso(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }
    
    

      public Boolean cadastrar(Ingresso ingresso) {
            return ingressos.add(ingresso);
        
    }

    public Ingresso remover(Ingresso ingresso) {
        return ingressos.remove(ingressos.indexOf(ingresso));
    }

    public Ingresso atualizar(Ingresso ingresso, Ingresso ingressoAtualizado) {
        return ingressos.set(ingressos.indexOf(ingresso), ingressoAtualizado);
    }

    public Ingresso consultar(Ingresso ingresso) {
        return ingressos.get(ingressos.indexOf(ingresso));
    }

    public List<Ingresso> relatorio() {
        return this.ingressos;
    }
    
}
