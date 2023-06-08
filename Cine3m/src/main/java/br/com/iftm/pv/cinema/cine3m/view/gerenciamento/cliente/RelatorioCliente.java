package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaCliente;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.view.util.ModalInternalFrame;
import br.com.iftm.pv.cinema.cine3m.view.util.TableModelGenerico;
import javax.swing.JTable;

public class RelatorioCliente extends ModalInternalFrame {

    private final GerenciaCliente gerenciaCliente;
    private final TableModelGenerico modelo;

    public RelatorioCliente(GerenciaCliente gerenciaCliente) {
        this.gerenciaCliente = gerenciaCliente;
        this.modelo = new TableModelGenerico(Cliente.class);
        initComponents();
        tbRelClientes.setModel(modelo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbRelClientes = new javax.swing.JTable();
        lbCliente2 = new javax.swing.JLabel();

        setClosable(true);

        tbRelClientes.setModel(modelo);
        tbRelClientes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbRelClientesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tbRelClientes);

        lbCliente2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbCliente2.setForeground(new java.awt.Color(204, 204, 204));
        lbCliente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCliente2.setText("Relatório de Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lbCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbRelClientesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbRelClientesAncestorAdded
        modelo.setData(gerenciaCliente.relatorio());
    }//GEN-LAST:event_tbRelClientesAncestorAdded

    public JTable getTbRelClientes() {
        return tbRelClientes;
    }

    public void setTbRelClientes(JTable tbRelClientes) {
        this.tbRelClientes = tbRelClientes;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCliente2;
    private javax.swing.JTable tbRelClientes;
    // End of variables declaration//GEN-END:variables
}
