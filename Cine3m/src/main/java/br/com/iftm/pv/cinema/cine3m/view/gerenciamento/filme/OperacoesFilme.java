package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.filme;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaFilme;
import br.com.iftm.pv.cinema.cine3m.enums.EstadoAtual;
import br.com.iftm.pv.cinema.cine3m.model.Filme;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import br.com.iftm.pv.cinema.cine3m.view.util.PesquisaLike;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class OperacoesFilme extends javax.swing.JInternalFrame {

    private final CadastroFilme cadastroFilme;
    private final GerenciaFilme gerenciaFilme;
    private final RelatorioFilme relatorioFilme;
    private List<Filme> filmes;

    public OperacoesFilme(GerenciaFilme gerenciaFilme) {
        initComponents();
        this.gerenciaFilme = gerenciaFilme;
        initComponentsPersonalizado();
        this.cadastroFilme = new CadastroFilme(gerenciaFilme, this);
        relatorioFilme = new RelatorioFilme(gerenciaFilme);
        btnConsultar.setEnabled(false);

    }

    private void initComponentsPersonalizado() {
        PesquisaLike pesquisaLike = new PesquisaLike(gerenciaFilme);
        tfPesquisar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                pesquisaLike.filterList(tfPesquisar, lstFilmes);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                pesquisaLike.filterList(tfPesquisar, lstFilmes);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                pesquisaLike.filterList(tfPesquisar, lstFilmes);
            }
        });
    }

 
    public CadastroFilme getCadastroFilme() {
        return cadastroFilme;
    }

    public JList<Filme> getLstFilmes() {
        return lstFilmes;
    }

    public void setLstFilmes(JList<Filme> lstFilmes) {
        this.lstFilmes = lstFilmes;
    }


    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public void setBtnConsultar(JButton btnConsultar) {
        this.btnConsultar = btnConsultar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(JButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public void setBtnExcluir(JButton btnExcluir) {
        this.btnExcluir = btnExcluir;
    }

    public JButton getBtnNovo() {
        return btnNovo;
    }

    public void setBtnNovo(JButton btnNovo) {
        this.btnNovo = btnNovo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstFilmes = new javax.swing.JList<>();
        tfPesquisar = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRelatorio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);

        lstFilmes.setBackground(new java.awt.Color(102, 102, 102));
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

        tfPesquisar.setToolTipText("");

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel1.setText("Pesquisar:");

        btnRelatorio.setText("GERAR RELATORIO");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel2.setText("Filmes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 139, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                        .addComponent(tfPesquisar))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(171, 171, 171)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        cadastroFilme.getBtnConfirmar().setText("CADASTRAR");
        cadastroFilme.setEstadoAtual(EstadoAtual.CADASTRANDO);
        cadastroFilme.getLbTituloTelaFilme().setText("Cadastro de Filmes");
        cadastroFilme.getBtnConfirmar().setVisible(true);
        cadastroFilme.getTfNomeFilme().setEditable(true);
        cadastroFilme.getTfDiretor().setEditable(true);
        cadastroFilme.getTfaDescricao().setEditable(true);
        cadastroFilme.getTfNomeFilme().setText("");
        cadastroFilme.getTfDiretor().setText("");
        cadastroFilme.getTfaDescricao().setText("");
        cadastroFilme.getCbGenero().setEnabled(true);
        getDesktopPane().add(cadastroFilme);
        cadastroFilme.setModal(true);
        cadastroFilme.setVisible(true);

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        Filme filmeSelecionado = (Filme) lstFilmes.getSelectedValue();
        cadastroFilme.setFilmeSelecionado(filmeSelecionado);
        cadastroFilme.getTfNomeFilme().setText(filmeSelecionado.getNome());
        cadastroFilme.getTfDiretor().setText(filmeSelecionado.getDiretor());
        cadastroFilme.getTfaDescricao().setText(filmeSelecionado.getDescricao());
        cadastroFilme.getLbTituloTelaFilme().setText("Consulta de Filme");
        cadastroFilme.getBtnConfirmar().setVisible(false);
        cadastroFilme.getTfNomeFilme().setEditable(false);
        cadastroFilme.getTfDiretor().setEditable(false);
        cadastroFilme.getTfaDescricao().setEditable(false);
        cadastroFilme.getCbGenero().setSelectedItem(filmeSelecionado.getGenero());
        cadastroFilme.getCbGenero().setEnabled(false);
        
        getDesktopPane().add(cadastroFilme);
        cadastroFilme.setModal(true);
        cadastroFilme.setVisible(true);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Filme filmeSelecionado = lstFilmes.getSelectedValue();

        Integer resp = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja apagar ??",
                "Apagar Filme", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (resp.equals(JOptionPane.OK_OPTION)) {
            gerenciaFilme.remover(filmeSelecionado);
            lstFilmesAncestorAdded(null);
            JOptionPane.showMessageDialog(this, "Filme removido",
                    "Remover", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void lstFilmesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lstFilmesAncestorAdded
        filmes = gerenciaFilme.relatorio();
        ListUtils.carregarList(lstFilmes, filmes);

        if (!filmes.isEmpty()) {
            btnExcluir.setEnabled(true);
            btnConsultar.setEnabled(true);
            btnEditar.setEnabled(true);
            lstFilmes.setSelectedIndex(0);
        } else {
            btnExcluir.setEnabled(false);
            btnConsultar.setEnabled(false);
            btnEditar.setEnabled(false);
        }
    }//GEN-LAST:event_lstFilmesAncestorAdded

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Filme filmeSelecionado = (Filme) this.lstFilmes.getSelectedValue();
        cadastroFilme.getTfNomeFilme().setText(filmeSelecionado.getNome());
        cadastroFilme.setEstadoAtual(EstadoAtual.ATUALIZANDO);
        cadastroFilme.getTfDiretor().setText(filmeSelecionado.getDiretor());
        cadastroFilme.getCbGenero().setSelectedItem(filmeSelecionado.getGenero());
        cadastroFilme.getTfaDescricao().setText(filmeSelecionado.getDescricao());
        cadastroFilme.getLbTituloTelaFilme().setText("Atualização de Filme");
        cadastroFilme.getBtnConfirmar().setText("ATUALIZAR");
        cadastroFilme.getBtnConfirmar().setVisible(true);
        cadastroFilme.getTfNomeFilme().setEditable(true);
        cadastroFilme.getTfDiretor().setEditable(true);
        cadastroFilme.getCbGenero().setEnabled(true);
        cadastroFilme.getTfaDescricao().setEditable(true);
        cadastroFilme.setFilmeSelecionado(filmeSelecionado);
        getDesktopPane().add(cadastroFilme);
        cadastroFilme.setModal(true);
        cadastroFilme.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        getDesktopPane().add(relatorioFilme);
        relatorioFilme.setModal(true);
        relatorioFilme.setVisible(true);
    }//GEN-LAST:event_btnRelatorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Filme> lstFilmes;
    private javax.swing.JTextField tfPesquisar;
    // End of variables declaration//GEN-END:variables
}
