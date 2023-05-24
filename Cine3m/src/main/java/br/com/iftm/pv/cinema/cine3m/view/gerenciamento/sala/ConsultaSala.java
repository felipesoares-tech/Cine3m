/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sala;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSala;
import br.com.iftm.pv.cinema.cine3m.model.Sala;
import br.com.iftm.pv.cinema.cine3m.view.util.ComboBoxUtils;
import javax.swing.JDesktopPane;

/**
 *
 * @author Felipe Soares
 */
public class ConsultaSala extends javax.swing.JInternalFrame {

    private CadastroSala cadastroSala;
    private GerenciaSala gerenciaSala;

    public ConsultaSala(CadastroSala cadastroSala, GerenciaSala gerenciaSala) {
        initComponents();
        this.cadastroSala = cadastroSala;
        this.gerenciaSala = gerenciaSala;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTituloTelaCliente = new javax.swing.JLabel();
        cbSalaConsulta = new javax.swing.JComboBox<>();
        lbSalaConsulta = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();

        setClosable(true);

        lbTituloTelaCliente.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbTituloTelaCliente.setText("Consulta de Salas");

        cbSalaConsulta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbSalaConsulta.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbSalaConsultaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lbSalaConsulta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbSalaConsulta.setText("Sala");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTituloTelaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSalaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSalaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbTituloTelaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSalaConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(cbSalaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSalaConsultaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbSalaConsultaAncestorAdded
        ComboBoxUtils.carregarComboBox(cbSalaConsulta, gerenciaSala.relatorio());
    }//GEN-LAST:event_cbSalaConsultaAncestorAdded

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        Sala salaSelecionada = (Sala) this.cbSalaConsulta.getSelectedItem();
        this.cadastroSala.getBtnCadastrarSala().setVisible(false);
        this.cadastroSala.getTfNomeSala().setText(salaSelecionada.getNome());
        this.cadastroSala.getCbCapacidade().setSelectedItem(salaSelecionada.getCapacidade().toString());
        this.cadastroSala.getCbCapacidade().setEnabled(false);
        this.cadastroSala.getTfNomeSala().setEditable(false);
        this.cadastroSala.getCbCapacidade().setEditable(false);
        getDesktopPane().add(cadastroSala);
        this.cadastroSala.setVisible(true);

    }//GEN-LAST:event_btnConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JComboBox<Sala> cbSalaConsulta;
    private javax.swing.JLabel lbSalaConsulta;
    private javax.swing.JLabel lbTituloTelaCliente;
    // End of variables declaration//GEN-END:variables
}
