package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaCliente;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.model.Pessoa;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import br.com.iftm.pv.cinema.cine3m.view.util.ValidaTela;
import javax.swing.JList;

public class ConsultaCliente extends javax.swing.JInternalFrame {

    private CadastroCliente cadastroCliente;
    private GerenciaCliente gerenciaCliente;

    public ConsultaCliente(CadastroCliente cadastroCliente, GerenciaCliente gerenciaCliente) {
        initComponents();
        this.cadastroCliente = cadastroCliente;
        this.gerenciaCliente = gerenciaCliente;
        this.btnConfirmarConsulta.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstClientes = new javax.swing.JList<>();
        btnConfirmarConsulta = new javax.swing.JButton();
        lbCliente2 = new javax.swing.JLabel();

        setClosable(true);

        lstClientes.setBackground(new java.awt.Color(102, 102, 102));
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

        btnConfirmarConsulta.setText("CONFIRMAR");
        btnConfirmarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarConsultaActionPerformed(evt);
            }
        });

        lbCliente2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbCliente2.setForeground(new java.awt.Color(204, 204, 204));
        lbCliente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCliente2.setText("Consultar Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCliente2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(btnConfirmarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(lbCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarConsultaActionPerformed
        Cliente clienteSelecionado = (Cliente) this.lstClientes.getSelectedValue();

       cadastroCliente.getTfNomeCliente().setText(clienteSelecionado.getNome());
       cadastroCliente.getTfCpfCliente().setText(clienteSelecionado.getCpf());
       cadastroCliente.getLbTituloTelaCliente().setText("Consulta de Cliente");

       cadastroCliente.getBtnCadastrarCliente().setVisible(false);
       cadastroCliente.getTfNomeCliente().setEditable(false);
       cadastroCliente.getTfCpfCliente().setEditable(false);
//        getDesktopPane().add(cadastroCliente);
//       cadastroCliente.setVisible(true);
        ValidaTela.abrirTela(cadastroCliente, getDesktopPane());
    }//GEN-LAST:event_btnConfirmarConsultaActionPerformed

    private void lstClientesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lstClientesAncestorAdded
        ValidaTela.fecharTela(cadastroCliente, getDesktopPane());
        ListUtils.carregarList(lstClientes, gerenciaCliente.relatorio());
        if (!gerenciaCliente.relatorio().isEmpty()) {
            btnConfirmarConsulta.setEnabled(true);
            lstClientes.setSelectedIndex(0);
        } else {
            btnConfirmarConsulta.setEnabled(false);
        }
    }//GEN-LAST:event_lstClientesAncestorAdded

    public JList<Pessoa> getLstClientes() {
        return lstClientes;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmarConsulta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCliente2;
    private javax.swing.JList<Pessoa> lstClientes;
    // End of variables declaration//GEN-END:variables
}
