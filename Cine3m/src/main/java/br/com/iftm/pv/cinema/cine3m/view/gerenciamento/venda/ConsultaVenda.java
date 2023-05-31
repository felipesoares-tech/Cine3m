/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaVenda;
import br.com.iftm.pv.cinema.cine3m.model.Venda;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.auxiliares.TelaAuxiliarConsultaVenda;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import javax.swing.JList;

/**
 *
 * @author Felipe Soares
 */
public class ConsultaVenda extends javax.swing.JInternalFrame {

    private final TelaAuxiliarConsultaVenda telaAuxiliarConsultaVenda;
    private final GerenciaVenda gerenciaVenda;

    public ConsultaVenda(GerenciaVenda gerenciaVenda) {
        initComponents();
        this.telaAuxiliarConsultaVenda = new TelaAuxiliarConsultaVenda();
        this.gerenciaVenda = gerenciaVenda;
    }

    public JList<Venda> getLstVendas() {
        return lstVendas;
    }

    public void setLstVendas(JList<Venda> lstVendas) {
        this.lstVendas = lstVendas;
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
        btnConsultarVendas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstVendas = new javax.swing.JList<>();

        setClosable(true);

        lbTituloTelaCliente.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbTituloTelaCliente.setForeground(new java.awt.Color(204, 204, 204));
        lbTituloTelaCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTituloTelaCliente.setText("Consultar Vendas");

        btnConsultarVendas.setText("Consultar");
        btnConsultarVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarVendasActionPerformed(evt);
            }
        });

        lstVendas.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lstVendasAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(lstVendas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(btnConsultarVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(lbTituloTelaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloTelaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConsultarVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarVendasActionPerformed
        Venda vendaSelecionada = (Venda) this.lstVendas.getSelectedValue();
        telaAuxiliarConsultaVenda.setVendaSelecionada(vendaSelecionada);
        getDesktopPane().add(telaAuxiliarConsultaVenda);
        this.telaAuxiliarConsultaVenda.setVisible(true);
        
    }//GEN-LAST:event_btnConsultarVendasActionPerformed

    private void lstVendasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lstVendasAncestorAdded
        System.out.println(gerenciaVenda.relatorio());
        ListUtils.carregarList(lstVendas, gerenciaVenda.relatorio());
        if (!gerenciaVenda.relatorio().isEmpty()) {
            btnConsultarVendas.setEnabled(true);
            lstVendas.setSelectedIndex(0);
        } else {
            btnConsultarVendas.setEnabled(false);
        }
    }//GEN-LAST:event_lstVendasAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarVendas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTituloTelaCliente;
    private javax.swing.JList<Venda> lstVendas;
    // End of variables declaration//GEN-END:variables
}
