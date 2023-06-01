package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaCliente;
import br.com.iftm.pv.cinema.cine3m.model.Pessoa;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import javax.swing.JList;

public class AtualizaCliente extends javax.swing.JInternalFrame {

    CadastroCliente cadastroCliente;
    GerenciaCliente gerenciaCliente;

    public AtualizaCliente(CadastroCliente cadastroCliente, GerenciaCliente gerenciaCliente) {
        initComponents();
        this.cadastroCliente = cadastroCliente;
        this.gerenciaCliente = gerenciaCliente;
        this.btnAtualizarCliente.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbCliente2 = new javax.swing.JLabel();
        btnAtualizarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstClientes = new javax.swing.JList<>();

        setClosable(true);

        lbCliente2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbCliente2.setForeground(new java.awt.Color(255, 255, 255));
        lbCliente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCliente2.setText("Atualizar Clientes");

        btnAtualizarCliente.setText("CONFIRMAR");
        btnAtualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarClienteActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(btnAtualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCliente2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lbCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAtualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstClientesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lstClientesAncestorAdded
        ListUtils.carregarList(lstClientes, gerenciaCliente.relatorio());

        if (!gerenciaCliente.relatorio().isEmpty()) {
            btnAtualizarCliente.setEnabled(true);
            lstClientes.setSelectedIndex(0);
        } else {
            btnAtualizarCliente.setEnabled(false);
        }
    }//GEN-LAST:event_lstClientesAncestorAdded

    private void btnAtualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarClienteActionPerformed
        Cliente clienteSelecionado = (Cliente) this.lstClientes.getSelectedValue();
        this.cadastroCliente.getTfNomeCliente().setText(clienteSelecionado.getNome());
        this.cadastroCliente.getTfCpfCliente().setText(clienteSelecionado.getCpf());
        this.cadastroCliente.getLbTituloTelaCliente().setText("Atualização de Cliente");
        this.cadastroCliente.getBtnCadastrarCliente().setText("Atualizar");
        this.cadastroCliente.getBtnCadastrarCliente().setVisible(true);
        this.cadastroCliente.getTfNomeCliente().setEditable(true);
        this.cadastroCliente.getTfCpfCliente().setEditable(true);
        this.cadastroCliente.setClienteSelecionado(clienteSelecionado);
        getDesktopPane().add(cadastroCliente);
        this.cadastroCliente.setVisible(true);
    }//GEN-LAST:event_btnAtualizarClienteActionPerformed

    public JList<Pessoa> getLstClientes() {
        return lstClientes;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCliente2;
    private javax.swing.JList<Pessoa> lstClientes;
    // End of variables declaration//GEN-END:variables
}
