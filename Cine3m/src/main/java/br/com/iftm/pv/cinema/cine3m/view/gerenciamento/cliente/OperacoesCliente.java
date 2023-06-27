package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaCliente;
import br.com.iftm.pv.cinema.cine3m.enums.EstadoAtual;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.model.Pessoa;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import br.com.iftm.pv.cinema.cine3m.view.util.PesquisaLike;
import java.awt.Frame;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class OperacoesCliente extends javax.swing.JInternalFrame {

    private final CadastroCliente cadastroCliente;
    private final GerenciaCliente gerenciaCliente;
    private JDialog relCliente;
    private List<Cliente> clientes;

    public OperacoesCliente(GerenciaCliente gerenciaCliente) {
        initComponents();
        this.gerenciaCliente = gerenciaCliente;
        initComponentsPersonalizado();
        this.cadastroCliente = new CadastroCliente(gerenciaCliente, this);
        btnConsultar.setEnabled(false);

    }

    private void initComponentsPersonalizado() {
        PesquisaLike pesquisaLike = new PesquisaLike(gerenciaCliente);
        tfPesquisar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                pesquisaLike.filterList(tfPesquisar, lstClientes);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                pesquisaLike.filterList(tfPesquisar, lstClientes);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                pesquisaLike.filterList(tfPesquisar, lstClientes);
            }
        });
    }

    public JList<Pessoa> getLstClientes() {
        return lstClientes;
    }

    public CadastroCliente getCadastroCliente() {
        return cadastroCliente;
    }

    public void setLstClientes(JList<Pessoa> lstClientes) {
        this.lstClientes = lstClientes;
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

    public JLabel getLbPesquisar() {
        return lbPesquisar;
    }

    public JLabel getLbTitulo() {
        return lbTitulo;
    }

    public JPanel getPanelBotoes() {
        return panelBotoes;
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
        lstClientes = new javax.swing.JList<>();
        tfPesquisar = new javax.swing.JTextField();
        panelBotoes = new javax.swing.JPanel();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        lbPesquisar = new javax.swing.JLabel();
        btnRelatorio = new javax.swing.JButton();
        lbTitulo = new javax.swing.JLabel();

        setClosable(true);

        lstClientes.setBackground(new java.awt.Color(102, 102, 102));
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

        javax.swing.GroupLayout panelBotoesLayout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(panelBotoesLayout);
        panelBotoesLayout.setHorizontalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        lbPesquisar.setText("Pesquisar:");

        btnRelatorio.setText("GERAR RELATORIO");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        lbTitulo.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbTitulo.setText("Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 139, Short.MAX_VALUE)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                        .addComponent(tfPesquisar))
                    .addComponent(lbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitulo)
                .addGap(171, 171, 171)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitulo)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lbPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        cadastroCliente.getBtnCadastrarCliente().setVisible(true);
        cadastroCliente.setEstadoAtual(EstadoAtual.CADASTRANDO);
        cadastroCliente.getLbTitulo().setText("Cadastro de Clientes");
        cadastroCliente.getBtnCadastrarCliente().setText("CADASTRAR");
        cadastroCliente.getTfNomeCliente().setEditable(true);
        cadastroCliente.getTfCpfCliente().setEditable(true);
        cadastroCliente.getTfNomeCliente().setText("");
        cadastroCliente.getTfCpfCliente().setValue(null);
        getDesktopPane().add(cadastroCliente);
        cadastroCliente.setModal(true);
        cadastroCliente.setVisible(true);

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        Cliente clienteSelecionado = (Cliente) this.lstClientes.getSelectedValue();

        cadastroCliente.getTfNomeCliente().setText(clienteSelecionado.getNome());
        cadastroCliente.getTfCpfCliente().setText(clienteSelecionado.getCpf());
        cadastroCliente.getLbTitulo().setText("Consulta de Cliente");
        cadastroCliente.getBtnCadastrarCliente().setVisible(false);
        cadastroCliente.getTfNomeCliente().setEditable(false);
        cadastroCliente.getTfCpfCliente().setEditable(false);
        getDesktopPane().add(cadastroCliente);
        cadastroCliente.setModal(true);
        cadastroCliente.setVisible(true);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Pessoa clienteSelecionado = lstClientes.getSelectedValue();
        Integer resp = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja apagar ??",
                "Apagar Cliente", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (resp.equals(JOptionPane.YES_OPTION)) {
            gerenciaCliente.remover((Cliente) clienteSelecionado);

            lstClientesAncestorAdded(null);
            JOptionPane.showMessageDialog(this, "Cliente removido",
                    "Remover", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void lstClientesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lstClientesAncestorAdded
        clientes = gerenciaCliente.relatorio();
        ListUtils.carregarList(lstClientes, clientes);

        if (!clientes.isEmpty()) {
            btnExcluir.setEnabled(true);
            btnConsultar.setEnabled(true);
            btnEditar.setEnabled(true);
            lstClientes.setSelectedIndex(0);
        } else {
            btnExcluir.setEnabled(false);
            btnConsultar.setEnabled(false);
            btnEditar.setEnabled(false);
        }
    }//GEN-LAST:event_lstClientesAncestorAdded

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Cliente clienteSelecionado = (Cliente) this.lstClientes.getSelectedValue();
        cadastroCliente.getTfNomeCliente().setText(clienteSelecionado.getNome());
        cadastroCliente.getTfCpfCliente().setText(clienteSelecionado.getCpf());
        cadastroCliente.setEstadoAtual(EstadoAtual.ATUALIZANDO);
        cadastroCliente.getLbTitulo().setText("Atualização de Cliente");
        cadastroCliente.getBtnCadastrarCliente().setText("Atualizar");
        cadastroCliente.getBtnCadastrarCliente().setVisible(true);
        cadastroCliente.getTfNomeCliente().setEditable(true);
        cadastroCliente.getTfCpfCliente().setEditable(true);
        cadastroCliente.setClienteSelecionado(clienteSelecionado);
        getDesktopPane().add(cadastroCliente);
        cadastroCliente.setModal(true);
        cadastroCliente.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        try {
            JasperReport relatorioCompilado = JasperCompileManager.compileReport("src/main/java/br/com/iftm/pv/cinema/cine3m/report/cliente.jrxml");
            JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, null, new JRBeanCollectionDataSource(gerenciaCliente.relatorio()));
            relCliente = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Relatório de Clientes", true);
            relCliente.setSize(1000, 500);
            JRViewer painelRelatorio = new JRViewer(relatorioPreenchido);
            relCliente.getContentPane().add(painelRelatorio);
            relCliente.setVisible(true);
        } catch (JRException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Erro ao gerar o relatório." + ex);
        }
    }//GEN-LAST:event_btnRelatorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbPesquisar;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JList<Pessoa> lstClientes;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JTextField tfPesquisar;
    // End of variables declaration//GEN-END:variables
}
