/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.auxiliares;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaCliente;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.model.Pessoa;
import br.com.iftm.pv.cinema.cine3m.view.util.ComboBoxUtils;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Soares
 */
public class VincularCliente extends javax.swing.JInternalFrame {

    private final GerenciaCliente gerenciaCliente;
    private Cliente clienteSelecionado;

    public VincularCliente(GerenciaCliente gerenciaCliente) {
        initComponents();
        this.gerenciaCliente = gerenciaCliente;
        btnConfirmar.setEnabled(false);
        this.clienteSelecionado = null;
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbVendaClientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();

        setClosable(true);

        cbVendaClientes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbVendaClientesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cbVendaClientes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbVendaClientesFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Cliente");

        btnConfirmar.setText("Confimar");
        btnConfirmar.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                btnConfirmarAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addComponent(cbVendaClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbVendaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbVendaClientesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbVendaClientesAncestorAdded
        ComboBoxUtils.carregarComboBox(cbVendaClientes, gerenciaCliente.relatorio());
    }//GEN-LAST:event_cbVendaClientesAncestorAdded

    private void cbVendaClientesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbVendaClientesFocusGained
        cbVendaClientesAncestorAdded(null);
    }//GEN-LAST:event_cbVendaClientesFocusGained

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        setClienteSelecionado((Cliente) cbVendaClientes.getSelectedItem());
        JOptionPane.showMessageDialog(this, "Cliente Vinculado!", "Vínculo", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
        getDesktopPane().remove(this);
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnConfirmarAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btnConfirmarAncestorAdded
        if (cbVendaClientes.getModel().getSize() > 0) {
            btnConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_btnConfirmarAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<Pessoa> cbVendaClientes;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
