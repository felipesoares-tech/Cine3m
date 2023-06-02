
package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaCliente;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.model.Pessoa;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;


public class ApagarCliente extends javax.swing.JInternalFrame {

    private GerenciaCliente gerenciaCliente;
    private List<Cliente> clientes;

    public ApagarCliente(GerenciaCliente gerenciaCliente) {
        initComponents();
        this.gerenciaCliente = gerenciaCliente;
        this.btnConfirmarApagaCliente.setEnabled(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstClientes = new javax.swing.JList<>();
        btnConfirmarApagaCliente = new javax.swing.JButton();
        lbCliente2 = new javax.swing.JLabel();

        setClosable(true);

        lstClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstClientes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lstClientesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(lstClientes);

        btnConfirmarApagaCliente.setText("APAGAR");
        btnConfirmarApagaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarApagaClienteActionPerformed(evt);
            }
        });

        lbCliente2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbCliente2.setForeground(new java.awt.Color(255, 255, 255));
        lbCliente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCliente2.setText("Remover Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(btnConfirmarApagaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCliente2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnConfirmarApagaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstClientesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lstClientesAncestorAdded
        clientes = gerenciaCliente.relatorio();
        ListUtils.carregarList(lstClientes, clientes);
        
        if(!clientes.isEmpty()){
            btnConfirmarApagaCliente.setEnabled(true);
            lstClientes.setSelectedIndex(0);
        }else{
            btnConfirmarApagaCliente.setEnabled(false);
        }
    }//GEN-LAST:event_lstClientesAncestorAdded

    private void btnConfirmarApagaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarApagaClienteActionPerformed
        Pessoa clienteSelecionado = lstClientes.getSelectedValue();
        Integer resp = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja apagar ??",
                "Apagar Cliente", WIDTH, JOptionPane.WARNING_MESSAGE);

        if (resp.equals(JOptionPane.OK_OPTION)) {
            gerenciaCliente.remover((Cliente)clienteSelecionado);
            
            lstClientesAncestorAdded(null);
            JOptionPane.showMessageDialog(this, "Cliente removido", "Remover", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnConfirmarApagaClienteActionPerformed

    public JList<Pessoa> getLstClientes() {
        return lstClientes;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmarApagaCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCliente2;
    private javax.swing.JList<Pessoa> lstClientes;
    // End of variables declaration//GEN-END:variables
}
