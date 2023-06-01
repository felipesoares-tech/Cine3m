package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSessao;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ApagaSessao extends javax.swing.JInternalFrame {

    private GerenciaSessao gerenciaSessao;
    private List<Sessao> sessoes;

    public ApagaSessao(GerenciaSessao gerenciaSessao) {
        initComponents();
        this.gerenciaSessao = gerenciaSessao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTituloTelaCliente = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listApagaSessao = new javax.swing.JList<>();
        btnConfirmarApagaSessao1 = new javax.swing.JButton();

        setClosable(true);

        lbTituloTelaCliente.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbTituloTelaCliente.setText("Apagar Sessão");

        listApagaSessao.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listApagaSessao.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                listApagaSessaoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(listApagaSessao);

        btnConfirmarApagaSessao1.setText("Confirmar");
        btnConfirmarApagaSessao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarApagaSessao1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(btnConfirmarApagaSessao1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTituloTelaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(lbTituloTelaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfirmarApagaSessao1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JList<Sessao> getListApagaSessao() {
        return listApagaSessao;
    }

    private void listApagaSessaoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listApagaSessaoAncestorAdded
        sessoes = gerenciaSessao.relatorio();
        ListUtils.carregarList(listApagaSessao, sessoes);
          if(!sessoes.isEmpty()){
            btnConfirmarApagaSessao1.setEnabled(true);
            listApagaSessao.setSelectedIndex(0);
        }else{
            btnConfirmarApagaSessao1.setEnabled(false);
        }
    }//GEN-LAST:event_listApagaSessaoAncestorAdded

    private void btnConfirmarApagaSessao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarApagaSessao1ActionPerformed
        Sessao sessaoSelecionada = listApagaSessao.getSelectedValue();
        Integer resp = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja apagar ??",
                "Apagar Sessao", WIDTH, JOptionPane.WARNING_MESSAGE);

        if (resp.equals(JOptionPane.OK_OPTION)) {
            gerenciaSessao.remover(sessaoSelecionada);
            listApagaSessaoAncestorAdded(null);
            JOptionPane.showMessageDialog(this, "Sessão removido!", "Remover", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarApagaSessao1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmarApagaSessao1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTituloTelaCliente;
    private javax.swing.JList<Sessao> listApagaSessao;
    // End of variables declaration//GEN-END:variables
}
