package br.com.iftm.pv.cinema.cine3m.view.util;

import br.com.iftm.pv.cinema.cine3m.interfaces.IGerencia;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.model.Filme;
import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import br.com.iftm.pv.cinema.cine3m.model.Sala;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

public class PesquisaLike<T> {
    private final IGerencia<T> gerencia;

    public PesquisaLike(IGerencia<T> gerencia) {
        this.gerencia = gerencia;
    }
    
    public void filterList(JTextField tf, JList<T> jl) {
        String palavraDigitada = tf.getText().toLowerCase();
        if (palavraDigitada.isEmpty() || palavraDigitada.isBlank()) {
            ListUtils.carregarList(jl, gerencia.relatorio());
        } else {
            DefaultListModel<T> model = new DefaultListModel<>();
            for (int i = 0; i < jl.getModel().getSize(); i++) {
                T item = jl.getModel().getElementAt(i);
                String nomeItem = "";
                if (item instanceof Cliente) {
                    nomeItem = ((Cliente) item).getNome();
                } else if (item instanceof Funcionario) {
                    nomeItem = ((Funcionario) item).getNome();
                } else if (item instanceof Sessao) {
                    nomeItem = ((Sessao) item).getIdentificador();
                } else if (item instanceof Filme) {
                    nomeItem = ((Filme) item).getNome();
                } else if (item instanceof Sala) {
                    nomeItem = ((Sala) item).getNome();
                }

                if (nomeItem.toLowerCase().contains(palavraDigitada)) {
                    model.addElement(item);
                }
            }
            jl.setModel(model);
        }
    }
}