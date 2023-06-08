package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.funcionario;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaFuncionario;
import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import br.com.iftm.pv.cinema.cine3m.model.Pessoa;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import br.com.iftm.pv.cinema.cine3m.view.util.PesquisaLike;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class OperacoesFuncionario extends javax.swing.JInternalFrame {

    private final CadastroFuncionario cadastroFuncionario;
    private final GerenciaFuncionario gerenciaFuncionario;
    private final RelatorioFuncionario relatorioFuncionario;
    private List<Funcionario> funcionarios;
    private Funcionario admin;
    private Funcionario funcionarioLogado;

    public OperacoesFuncionario(GerenciaFuncionario gerenciaFuncionario, Funcionario admin) {
        initComponents();
        this.gerenciaFuncionario = gerenciaFuncionario;
        initComponentsPersonalizado();
        this.admin = admin;
        cadastroFuncionario = new CadastroFuncionario(gerenciaFuncionario, this);
        relatorioFuncionario = new RelatorioFuncionario(gerenciaFuncionario);
        btnConsultar.setEnabled(false);

    }

    private void initComponentsPersonalizado() {
        //PesquisaLike pesquisaLike = new PesquisaLike(gerenciaFuncionario);
//        tfPesquisar.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                pesquisaLike.filterList(tfPesquisar, lstFuncionarios);
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                pesquisaLike.filterList(tfPesquisar, lstFuncionarios);
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                pesquisaLike.filterList(tfPesquisar, lstFuncionarios);
//            }
//        });
    }

    public JList<Pessoa> getLstFuncionarios() {
        return lstFuncionarios;
    }

    public void setLstFuncionarios(JList<Pessoa> lstFuncionarios) {
        this.lstFuncionarios = lstFuncionarios;
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

    public void setFuncionarioLogado(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
    }

    public void setBtnNovo(JButton btnNovo) {
        this.btnNovo = btnNovo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstFuncionarios = new javax.swing.JList<>();
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

        lstFuncionarios.setBackground(new java.awt.Color(102, 102, 102));
        lstFuncionarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstFuncionarios.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lstFuncionariosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(lstFuncionarios);

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
        jLabel2.setText("Funcionários");

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
                .addGap(104, 104, 104)
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
        cadastroFuncionario.getBtnCadastrarFuncionario().setVisible(true);
        cadastroFuncionario.getBtnCadastrarFuncionario().setText("CADASTRAR");
        cadastroFuncionario.getTfNomeFuncionario().setEditable(true);
        cadastroFuncionario.getTfCpfFuncionario().setEditable(true);
        cadastroFuncionario.getTfLoginFuncionario().setEditable(true);
        cadastroFuncionario.getTfSenhaFuncionario().setEditable(true);

        cadastroFuncionario.getTfNomeFuncionario().setText("");
        cadastroFuncionario.getTfCpfFuncionario().setValue(null);
        cadastroFuncionario.getTfLoginFuncionario().setText("");
        cadastroFuncionario.getTfSenhaFuncionario().setText("");
        cadastroFuncionario.getLbTituloTelaFuncionario().setText("Cadastro de Funcionários");

        getDesktopPane().add(cadastroFuncionario);
        cadastroFuncionario.setModal(true);
        cadastroFuncionario.setVisible(true);

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        Funcionario funcionarioSelecionado = (Funcionario) this.lstFuncionarios.getSelectedValue();
        cadastroFuncionario.getTfNomeFuncionario().setText(funcionarioSelecionado.getNome());
        cadastroFuncionario.getTfCpfFuncionario().setText(funcionarioSelecionado.getCpf());
        cadastroFuncionario.getTfLoginFuncionario().setText(funcionarioSelecionado.getLogin());
        cadastroFuncionario.getTfSenhaFuncionario().setText(funcionarioSelecionado.getSenha());

        cadastroFuncionario.getBtnCadastrarFuncionario().setVisible(false);
        cadastroFuncionario.getTfNomeFuncionario().setEditable(false);
        cadastroFuncionario.getTfCpfFuncionario().setEditable(false);
        cadastroFuncionario.getTfLoginFuncionario().setEditable(false);
        cadastroFuncionario.getTfSenhaFuncionario().setEditable(false);
        cadastroFuncionario.getLbTituloTelaFuncionario().setText("Consulta de Funcionário");

        getDesktopPane().add(cadastroFuncionario);
        cadastroFuncionario.setModal(true);
        cadastroFuncionario.setVisible(true);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Funcionario funcionarioSelecionado = (Funcionario) lstFuncionarios.getSelectedValue();
        if (funcionarioSelecionado.equals(admin)) {
            JOptionPane.showMessageDialog(this, "Não é possível remover admin! ",
                    "Admin", JOptionPane.ERROR_MESSAGE);
        } else if (funcionarioSelecionado.equals(funcionarioLogado)) {
            JOptionPane.showMessageDialog(this, "Não é possível remover o usuário logado! ",
                    "Usuário", JOptionPane.ERROR_MESSAGE);
        } else {
            Integer resp = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja apagar ??",
                    "Apagar Funcionário", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (resp.equals(JOptionPane.OK_OPTION)) {
                gerenciaFuncionario.remover(funcionarioSelecionado);
                lstFuncionariosAncestorAdded(null);
                JOptionPane.showMessageDialog(this, "Funcionário removido", "Remover", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void lstFuncionariosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lstFuncionariosAncestorAdded
        funcionarios = gerenciaFuncionario.relatorio();
        ListUtils.carregarList(lstFuncionarios, funcionarios);

        if (!funcionarios.isEmpty()) {
            btnExcluir.setEnabled(true);
            btnConsultar.setEnabled(true);
            btnEditar.setEnabled(true);
            lstFuncionarios.setSelectedIndex(0);
        } else {
            btnExcluir.setEnabled(false);
            btnConsultar.setEnabled(false);
            btnEditar.setEnabled(false);
        }
    }//GEN-LAST:event_lstFuncionariosAncestorAdded

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Funcionario funcionarioSelecionado = (Funcionario) this.lstFuncionarios.getSelectedValue();
        this.cadastroFuncionario.getTfNomeFuncionario().setText(funcionarioSelecionado.getNome());
        this.cadastroFuncionario.getTfCpfFuncionario().setText(funcionarioSelecionado.getCpf());
        this.cadastroFuncionario.getLbTituloTelaFuncionario().setText("Atualização de Funcionario");
        this.cadastroFuncionario.getBtnCadastrarFuncionario().setText("Atualizar");
        this.cadastroFuncionario.getBtnCadastrarFuncionario().setVisible(true);
        this.cadastroFuncionario.getTfNomeFuncionario().setEditable(true);
        this.cadastroFuncionario.getTfCpfFuncionario().setEditable(true);
        this.cadastroFuncionario.setFuncionarioSelecionado(funcionarioSelecionado);
        getDesktopPane().add(cadastroFuncionario);
        cadastroFuncionario.setModal(true);
        cadastroFuncionario.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        getDesktopPane().add(relatorioFuncionario);
        relatorioFuncionario.setModal(true);
        relatorioFuncionario.setVisible(true);
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
    private javax.swing.JList<Pessoa> lstFuncionarios;
    private javax.swing.JTextField tfPesquisar;
    // End of variables declaration//GEN-END:variables
}
