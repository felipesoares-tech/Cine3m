
package br.com.iftm.pv.cinema.cine3m.controller;

import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import java.util.List;
import lombok.Data;

@Data
public class GerenciaFuncionario implements IGerencia<Funcionario>{
    private List<Funcionario> funcionarios;

    public GerenciaFuncionario(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    

     public Boolean cadastrar(Funcionario funcionario) {
        if (!funcionarios.contains(funcionario)) {
            return funcionarios.add(funcionario);
        }
        return false;
    }

    public Funcionario remover(Funcionario funcionario) {
        return funcionarios.remove(funcionarios.indexOf(funcionario));
    }

    public Funcionario atualizar(Funcionario funcionario, Funcionario funcionarioAtualizado) {
        return funcionarios.set(funcionarios.indexOf(funcionario), funcionarioAtualizado);
    }

    public Funcionario consultar(Funcionario funcionario) {
        return funcionarios.get(funcionarios.indexOf(funcionario));
    }

    public List<Funcionario> relatorio() {
        return this.funcionarios;
    }
}
