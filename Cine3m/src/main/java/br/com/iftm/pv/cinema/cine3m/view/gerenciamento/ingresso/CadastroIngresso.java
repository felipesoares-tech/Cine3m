/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.ingresso;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaIngresso;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSessao;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import br.com.iftm.pv.cinema.cine3m.model.Poltrona;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.ingresso.auxiliares.ConfirmaCompra;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.ingresso.auxiliares.ConsultaPoltronas;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao.CadastroSessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.util.ComboBoxUtils;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 * @author Felipe Soares
 */
public class CadastroIngresso extends javax.swing.JInternalFrame {

    private ConsultaPoltronas consultaPoltronas;
    private ConfirmaCompra confirmaCompra;
    private GerenciaIngresso gerenciaIngresso;
    private GerenciaSessao gerenciaSessao;
    private CadastroSessao cadastroSessao;
    private JDesktopPane jdp;

    public CadastroIngresso(GerenciaIngresso gerenciaIngresso, GerenciaSessao gerenciaSessao, CadastroSessao cadastroSessao, JDesktopPane jdp) {
        initComponents();
        this.gerenciaIngresso = gerenciaIngresso;
        this.gerenciaSessao = gerenciaSessao;
        this.consultaPoltronas = new ConsultaPoltronas(this, gerenciaSessao);
        this.cadastroSessao = cadastroSessao;
        this.jdp = jdp;
    }

    public ConsultaPoltronas getConsultaPoltronas() {
        return consultaPoltronas;
    }

    public void setConsultaPoltronas(ConsultaPoltronas consultaPoltronas) {
        this.consultaPoltronas = consultaPoltronas;
    }

    public ConfirmaCompra getConfirmaCompra() {
        return confirmaCompra;
    }

    public void setConfirmaCompra(ConfirmaCompra confirmaCompra) {
        this.confirmaCompra = confirmaCompra;
    }

    public CadastroSessao getCadastroSessao() {
        return cadastroSessao;
    }

    public void setCadastroSessao(CadastroSessao cadastroSessao) {
        this.cadastroSessao = cadastroSessao;
    }

    public JDesktopPane getJdp() {
        return jdp;
    }

    public void setJdp(JDesktopPane jdp) {
        this.jdp = jdp;
    }

    public JButton getBtnCadastrarSessao() {
        return btnCadastrarSessao;
    }

    public void setBtnCadastrarSessao(JButton btnCadastrarSessao) {
        this.btnCadastrarSessao = btnCadastrarSessao;
    }

    public JButton getBtnConsultarPoltrona() {
        return btnConsultarPoltrona;
    }

    public void setBtnConsultarPoltrona(JButton btnConsultarPoltrona) {
        this.btnConsultarPoltrona = btnConsultarPoltrona;
    }

    public JButton getBtnContinuarCompra() {
        return btnContinuarCompra;
    }

    public void setBtnContinuarCompra(JButton btnContinuarCompra) {
        this.btnContinuarCompra = btnContinuarCompra;
    }

    public JComboBox<Sessao> getCbSessaoVenda() {
        return cbSessaoVenda;
    }

    public void setCbSessaoVenda(JComboBox<Sessao> cbSessaoVenda) {
        this.cbSessaoVenda = cbSessaoVenda;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JList<Poltrona> getjList1() {
        return jList1;
    }

    public void setjList1(JList<Poltrona> jList1) {
        this.jList1 = jList1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbSessaoVenda = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnConsultarPoltrona = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btnCadastrarSessao = new javax.swing.JButton();
        btnContinuarCompra = new javax.swing.JButton();

        setClosable(true);

        cbSessaoVenda.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbSessaoVendaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cbSessaoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSessaoVendaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Sessão");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("Cadastrar Cliente");

        btnConsultarPoltrona.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnConsultarPoltrona.setText("Consultar Poltrona");
        btnConsultarPoltrona.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                btnConsultarPoltronaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btnConsultarPoltrona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarPoltronaActionPerformed(evt);
            }
        });

        jLabel3.setText("Ingresso :");

        jScrollPane1.setViewportView(jList1);

        btnCadastrarSessao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCadastrarSessao.setText("Cadastrar Sessão");
        btnCadastrarSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarSessaoActionPerformed(evt);
            }
        });

        btnContinuarCompra.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnContinuarCompra.setText("CONTINUAR");
        btnContinuarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnContinuarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbSessaoVenda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConsultarPoltrona, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(btnCadastrarSessao, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSessaoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrarSessao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConsultarPoltrona)
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(btnContinuarCompra))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 198, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSessaoVendaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbSessaoVendaAncestorAdded
        ComboBoxUtils.carregarComboBox(cbSessaoVenda, gerenciaSessao.relatorio());
    }//GEN-LAST:event_cbSessaoVendaAncestorAdded

    private void cbSessaoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSessaoVendaActionPerformed
        this.consultaPoltronas = new ConsultaPoltronas(this, gerenciaSessao);
        this.jList1.removeAll();
    }//GEN-LAST:event_cbSessaoVendaActionPerformed

    private void btnConsultarPoltronaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btnConsultarPoltronaAncestorAdded
        if (gerenciaSessao.relatorio().isEmpty()) {
            btnConsultarPoltrona.setEnabled(false);
        } else {
            btnConsultarPoltrona.setEnabled(true);
        }
    }//GEN-LAST:event_btnConsultarPoltronaAncestorAdded

    private void btnConsultarPoltronaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPoltronaActionPerformed
        this.jdp.add(consultaPoltronas);
        this.consultaPoltronas.setVisible(true);
    }//GEN-LAST:event_btnConsultarPoltronaActionPerformed

    private void btnCadastrarSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarSessaoActionPerformed
        this.jdp.add(cadastroSessao);
        cadastroSessao.setVisible(true);
    }//GEN-LAST:event_btnCadastrarSessaoActionPerformed

    private void btnContinuarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarCompraActionPerformed
        Sessao sessaoSelecionada = (Sessao) cbSessaoVenda.getSelectedItem();
        this.confirmaCompra = new ConfirmaCompra(jList1.getModel().getSize(), sessaoSelecionada.getValor());
        this.jdp.add(confirmaCompra);
        this.confirmaCompra.setVisible(true);
    }//GEN-LAST:event_btnContinuarCompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarSessao;
    private javax.swing.JButton btnConsultarPoltrona;
    private javax.swing.JButton btnContinuarCompra;
    private javax.swing.JComboBox<Sessao> cbSessaoVenda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<Poltrona> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
