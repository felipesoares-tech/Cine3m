package br.com.iftm.pv.cinema.cine3m.util;

import br.com.iftm.pv.cinema.cine3m.dao.FuncionarioDAO;
import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import java.util.Iterator;

public class ChecarCredenciais {

    private CriptografarSenha criptografarSenha = new CriptografarSenha();
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();


    public boolean checarCredenciais(String usuarioNome, String senha) {
        System.out.println("Passou aqui");
        Iterator<Funcionario> it = funcionarioDAO.listar().iterator();
        while (it.hasNext()) {
            Funcionario funcionario = it.next();
            if (usuarioNome.equals(funcionario.getLogin())) {
                
                return senha.equals(funcionario.getSenha());
            }
        }
        return false;
    }

}
