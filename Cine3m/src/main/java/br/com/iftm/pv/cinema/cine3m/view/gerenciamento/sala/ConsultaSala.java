package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sala;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSala;
import br.com.iftm.pv.cinema.cine3m.model.Sala;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import javax.swing.JList;

public class ConsultaSala extends javax.swing.JInternalFrame {

    private CadastroSala cadastroSala;
    private GerenciaSala gerenciaSala;

    public ConsultaSala(CadastroSala cadastroSala, GerenciaSala gerenciaSala) {
        initComponents();
        this.cadastroSala = cadastroSala;
        this.gerenciaSala = gerenciaSala;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTituloTelaCliente = new javax.swing.JLabel();
        btnConsultarSala = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstSalas = new javax.swing.JList<>();

        setClosable(true);

        lbTituloTelaCliente.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbTituloTelaCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTituloTelaCliente.setText("Consultar Sala");

        btnConsultarSala.setText("Consultar");
        btnConsultarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarSalaActionPerformed(evt);
            }
        });

        lstSalas.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lstSalasAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(lstSalas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(btnConsultarSala, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTituloTelaCliente)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(lbTituloTelaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConsultarSala, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JList<Sala> getLstSalas() {
        return lstSalas;
    }

    private void btnConsultarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarSalaActionPerformed
        Sala salaSelecionada = (Sala) this.lstSalas.getSelectedValue();
        this.cadastroSala.getBtnCadastrarSala().setVisible(false);
        this.cadastroSala.getTfNomeSala().setText(salaSelecionada.getNome());
        this.cadastroSala.getJsCapacidade().setValue(salaSelecionada.getCapacidade());
        this.cadastroSala.getJsCapacidade().setEnabled(false);
        this.cadastroSala.getTfNomeSala().setEditable(false);
        this.cadastroSala.getJsCapacidade().setEnabled(false);
        getDesktopPane().add(cadastroSala);
        this.cadastroSala.setVisible(true);

    }//GEN-LAST:event_btnConsultarSalaActionPerformed

    private void lstSalasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lstSalasAncestorAdded
        ListUtils.carregarList(lstSalas, gerenciaSala.relatorio());
        if (!gerenciaSala.relatorio().isEmpty()) {
            btnConsultarSala.setEnabled(true);
            lstSalas.setSelectedIndex(0);
        } else {
            btnConsultarSala.setEnabled(false);
        }
    }//GEN-LAST:event_lstSalasAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarSala;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTituloTelaCliente;
    private javax.swing.JList<Sala> lstSalas;
    // End of variables declaration//GEN-END:variables
}
