package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.filme;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaFilme;
import br.com.iftm.pv.cinema.cine3m.model.Filme;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ApagaFilme extends javax.swing.JInternalFrame {

    private GerenciaFilme gerenciaFilme;
    private List<Filme> filmes;

    public ApagaFilme(GerenciaFilme gerenciaFilme) {
        this.gerenciaFilme = gerenciaFilme;
        initComponents();
       this.btnConfirmarApagaFilme.setEnabled(false);
    }

    public JList<Filme> getLstFilmes() {
        return lstFilmes;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstFilmes = new javax.swing.JList<>();
        btnConfirmarApagaFilme = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstFilmes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstFilmes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lstFilmesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(lstFilmes);

        btnConfirmarApagaFilme.setText("APAGAR");
        btnConfirmarApagaFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarApagaFilmeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Apagar Filme");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(btnConfirmarApagaFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfirmarApagaFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstFilmesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lstFilmesAncestorAdded
        filmes = gerenciaFilme.relatorio();
        ListUtils.carregarList(lstFilmes, filmes);
         if(!filmes.isEmpty()){
            btnConfirmarApagaFilme.setEnabled(true);
            lstFilmes.setSelectedIndex(0);
        }else{
            btnConfirmarApagaFilme.setEnabled(false);
        }
    }//GEN-LAST:event_lstFilmesAncestorAdded

    private void btnConfirmarApagaFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarApagaFilmeActionPerformed
        Filme filmeSelecionado = lstFilmes.getSelectedValue();

        Integer resp = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja apagar ??",
                "Apagar Filme", WIDTH, JOptionPane.WARNING_MESSAGE);

        if (resp.equals(JOptionPane.OK_OPTION)) {
            gerenciaFilme.remover(filmeSelecionado);
            lstFilmesAncestorAdded(null);
            JOptionPane.showMessageDialog(this, "Filme removido",
                    "Remover", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnConfirmarApagaFilmeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmarApagaFilme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Filme> lstFilmes;
    // End of variables declaration//GEN-END:variables
}
