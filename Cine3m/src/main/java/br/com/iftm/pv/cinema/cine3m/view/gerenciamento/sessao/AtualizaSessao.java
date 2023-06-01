package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSessao;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JList;

public class AtualizaSessao extends javax.swing.JInternalFrame {

    private final CadastroSessao cadastroSessao;
    private final GerenciaSessao gerenciaSessao;
    private List<Sessao> listaSessoes;

    public AtualizaSessao(CadastroSessao cadastroSessao, GerenciaSessao gerenciaSessao) {
        initComponents();
        this.cadastroSessao = cadastroSessao;
        this.gerenciaSessao = gerenciaSessao;
        this.btnConfirmar.setEnabled(false);
    }

    public JList<Sessao> getListSessao() {
        return listSessao;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTituloTelaCliente = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSessao = new javax.swing.JList<>();

        setClosable(true);

        lbTituloTelaCliente.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbTituloTelaCliente.setText("Atualizar Sessão");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        listSessao.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listSessao.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                listSessaoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        listSessao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listSessaoFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(listSessao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTituloTelaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbTituloTelaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        Sessao sessaoSelecionada = (Sessao) this.listSessao.getSelectedValue();
        this.cadastroSessao.setSessaoSelecionada(sessaoSelecionada);
        this.cadastroSessao.getCbFilmesSessao().setSelectedItem(sessaoSelecionada.getFilme());
        this.cadastroSessao.getCbSalasSessao().setSelectedItem(sessaoSelecionada.getSala());
        this.cadastroSessao.getTfDataSessao().setText(sessaoSelecionada.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.cadastroSessao.getTfHorarioSessao().setText(sessaoSelecionada.getHora().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        this.cadastroSessao.getTfValorSessao().setText(String.valueOf(sessaoSelecionada.getValor()));
        this.cadastroSessao.getLbTituloTelaSessao().setText("Atualização de Sessão");
        this.cadastroSessao.getBtnCadastrarSessao().setText("Atualizar");
        this.cadastroSessao.getBtnCadastrarSessao().setVisible(true);
        this.cadastroSessao.getCbFilmesSessao().setEnabled(true);
        this.cadastroSessao.getCbSalasSessao().setEnabled(true);
        this.cadastroSessao.getTfValorSessao().setEditable(true);
        this.cadastroSessao.getTfDataSessao().setEditable(true);
        this.cadastroSessao.getTfHorarioSessao().setEditable(true);
        getDesktopPane().add(cadastroSessao);
        this.cadastroSessao.setVisible(true);
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void listSessaoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listSessaoAncestorAdded
        listaSessoes = gerenciaSessao.relatorio();
        ListUtils.carregarList(listSessao, listaSessoes);

        if (!listaSessoes.isEmpty()) {
            btnConfirmar.setEnabled(true);
            listSessao.setSelectedIndex(0);
        } else {
            btnConfirmar.setEnabled(false);
        }
    }//GEN-LAST:event_listSessaoAncestorAdded

    private void listSessaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listSessaoFocusGained
        listSessaoAncestorAdded(null);
    }//GEN-LAST:event_listSessaoFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTituloTelaCliente;
    private javax.swing.JList<Sessao> listSessao;
    // End of variables declaration//GEN-END:variables
}
