package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.auxiliares;

import br.com.iftm.pv.cinema.cine3m.config.ParametrosSistema;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSessao;
import br.com.iftm.pv.cinema.cine3m.model.ItemVenda;
import br.com.iftm.pv.cinema.cine3m.model.Poltrona;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.CadastroVenda;
import br.com.iftm.pv.cinema.cine3m.view.util.ListennerBtn;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ConsultaPoltronas extends javax.swing.JInternalFrame {

    private List<JButton> listBotoes;
    private final JButton btnConfirmar;

    public ConsultaPoltronas(CadastroVenda cadastroVenda, GerenciaSessao gerenciaSessao, Sessao sessaoSelecionada) {
        this.listBotoes = new ArrayList<>();
        this.btnConfirmar = null;

        initComponents();
        initComponentsPersonalizado(sessaoSelecionada, btnConfirmar, cadastroVenda, this);
        this.getContentPane().setBackground(ParametrosSistema.getInstance().getCorDeFundo());

    }

    private void initComponentsPersonalizado(Sessao sessaoSelecionada, JButton btnConfirmar, CadastroVenda cadastroVenda, ConsultaPoltronas consultaPoltronas) {
        ListennerBtn btnListener = new ListennerBtn();
        JPanel panel = new JPanel(new GridLayout(0, 10));

        int capacidadeTotal = sessaoSelecionada.getSala().getCapacidade();
        Color btnDefaultColor = Color.getHSBColor(0.66371644f, 0.6097561f, 0.76862746f);

        char row = 'A';
        int col = 1;

        for (int i = 1; i <= capacidadeTotal; i++) {
            String PoltronaID = Character.toString(row) + col;
            JButton button = new JButton(PoltronaID);

            button.setBackground(btnDefaultColor);
            button.setForeground(Color.WHITE);

            int pos = sessaoSelecionada.getSala().getPoltronas().indexOf(new Poltrona(PoltronaID));
            Poltrona pol = sessaoSelecionada.getSala().getPoltronas().get(pos);

            System.out.println(pol.getId());

            if (!pol.isLivre()) {
                button.setEnabled(false);
            }

            button.addActionListener(btnListener);
            listBotoes.add(button);
            panel.add(button);

            if (col == 10) {
                row++;
                col = 1;
            } else {
                col++;
            }
        }
        btnListener.setDefaultColor(btnDefaultColor);
        btnConfirmar = new JButton("Confirmar");

        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<ItemVenda> model = new DefaultListModel<>();

                Iterator<JButton> it = listBotoes.iterator();
                while (it.hasNext()) {
                    JButton btn = it.next();
                    if (btn.getBackground().equals(Color.getHSBColor(0.4036159f, 0.95801526f, 0.6392157f))) {
                        model.addElement(new ItemVenda(new Poltrona(btn.getText())));
                    }
                }
                cadastroVenda.getListItensIngresso().setModel(model);
                if (cadastroVenda.getListItensIngresso().getModel().getSize() > 0) {
                    cadastroVenda.getBtnContinuarCompra().setEnabled(true);
                } else {
                    cadastroVenda.getBtnContinuarCompra().setEnabled(false);
                }
                consultaPoltronas.setVisible(false);
                getDesktopPane().remove(consultaPoltronas);

            }
        });

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(panel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.insets = new Insets(0, 10, 0, 0);
        mainPanel.add(btnConfirmar, gbc);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        pack();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
