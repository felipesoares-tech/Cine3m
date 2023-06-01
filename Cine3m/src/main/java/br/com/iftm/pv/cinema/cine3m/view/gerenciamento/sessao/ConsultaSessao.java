package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSessao;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JList;

public class ConsultaSessao extends javax.swing.JInternalFrame {

    private final CadastroSessao cadastroSessao;
    private final GerenciaSessao gerenciaSessao;
    private List<Sessao> sessoes;

    public ConsultaSessao(CadastroSessao cadastroSessao, GerenciaSessao gerenciaSessao) {
        initComponents();
        this.cadastroSessao = cadastroSessao;
        this.gerenciaSessao = gerenciaSessao;
        this.btnConfirmar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConfirmar = new javax.swing.JButton();
        lbTituloTelaCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSessao = new javax.swing.JList<>();

        setClosable(true);

        btnConfirmar.setText("CONFIRMAR");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        lbTituloTelaCliente.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbTituloTelaCliente.setForeground(new java.awt.Color(204, 204, 204));
        lbTituloTelaCliente.setText("Consultar Sessão");

        listSessao.setForeground(new java.awt.Color(102, 102, 255));
        listSessao.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listSessao.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                listSessaoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        listSessao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listSessaoFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(listSessao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTituloTelaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(lbTituloTelaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JList<Sessao> getListSessao() {
        return listSessao;
    }

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        Sessao sessaoSelecionada = (Sessao) this.listSessao.getSelectedValue();
        this.cadastroSessao.setSessaoSelecionada(sessaoSelecionada);
        this.cadastroSessao.getBtnCadastrarSessao().setVisible(false);
        this.cadastroSessao.getCbFilmesSessao().setSelectedItem(sessaoSelecionada.getFilme());
        this.cadastroSessao.getCbSalasSessao().setSelectedItem(sessaoSelecionada.getSala());
        this.cadastroSessao.getTfDataSessao().setText(sessaoSelecionada.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.cadastroSessao.getTfHorarioSessao().setText(sessaoSelecionada.getHora().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        this.cadastroSessao.getTfValorSessao().setText(String.valueOf(sessaoSelecionada.getValor()));
        this.cadastroSessao.getCbFilmesSessao().setEnabled(false);
        this.cadastroSessao.getCbSalasSessao().setEnabled(false);
        this.cadastroSessao.getTfValorSessao().setEditable(false);
        this.cadastroSessao.getTfDataSessao().setEditable(false);
        this.cadastroSessao.getTfHorarioSessao().setEditable(false);
        this.cadastroSessao.getLbTituloTelaSessao().setText("Consulta de Sessão");
        
        getDesktopPane().add(cadastroSessao);
        this.cadastroSessao.setVisible(true);
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void listSessaoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listSessaoAncestorAdded
        sessoes = gerenciaSessao.relatorio();
        ListUtils.carregarList(listSessao, sessoes);
        if (!sessoes.isEmpty()) {
            btnConfirmar.setEnabled(true);
            listSessao.setSelectedIndex(0);
        } else {
            btnConfirmar.setEnabled(false);
        }
    }//GEN-LAST:event_listSessaoAncestorAdded

    private void listSessaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listSessaoFocusGained
        listSessaoAncestorAdded(null);
    }//GEN-LAST:event_listSessaoFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTituloTelaCliente;
    private javax.swing.JList<Sessao> listSessao;
    // End of variables declaration//GEN-END:variables
}
