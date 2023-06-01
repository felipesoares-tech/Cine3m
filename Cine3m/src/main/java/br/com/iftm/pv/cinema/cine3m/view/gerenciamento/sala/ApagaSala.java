package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sala;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSala;
import br.com.iftm.pv.cinema.cine3m.model.Sala;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ApagaSala extends javax.swing.JInternalFrame {

    private GerenciaSala gerenciaSala;
    private List<Sala> salas;

    public ApagaSala(GerenciaSala gerenciaSala) {
        initComponents();
        this.gerenciaSala = gerenciaSala;
        this.btnConfirmarApagaSala.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTituloTelaCliente = new javax.swing.JLabel();
        btnConfirmarApagaSala = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSala = new javax.swing.JList<>();

        setClosable(true);

        lbTituloTelaCliente.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbTituloTelaCliente.setForeground(new java.awt.Color(204, 204, 204));
        lbTituloTelaCliente.setText("Apagar Sala");

        btnConfirmarApagaSala.setText("APAGAR");
        btnConfirmarApagaSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarApagaSalaActionPerformed(evt);
            }
        });

        listSala.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listSala.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                listSalaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(listSala);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTituloTelaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(btnConfirmarApagaSala, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(lbTituloTelaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmarApagaSala, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JList<Sala> getListSala() {
        return listSala;
    }

    private void btnConfirmarApagaSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarApagaSalaActionPerformed
        Sala salaSelecionada = listSala.getSelectedValue();
             Integer resp = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja apagar ??",
                "Apagar Sala", WIDTH, JOptionPane.WARNING_MESSAGE);

        if (resp.equals(JOptionPane.OK_OPTION)) {
           gerenciaSala.remover(salaSelecionada);
            listSalaAncestorAdded(null);
            JOptionPane.showMessageDialog(this,"Sala removida!",
                    "Remover", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_btnConfirmarApagaSalaActionPerformed

    private void listSalaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listSalaAncestorAdded
        salas = gerenciaSala.relatorio();
        ListUtils.carregarList(listSala, salas);
         if(!salas.isEmpty()){
            btnConfirmarApagaSala.setEnabled(true);
            listSala.setSelectedIndex(0);
        }else{
            btnConfirmarApagaSala.setEnabled(false);
        }
    }//GEN-LAST:event_listSalaAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmarApagaSala;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTituloTelaCliente;
    private javax.swing.JList<Sala> listSala;
    // End of variables declaration//GEN-END:variables
}
