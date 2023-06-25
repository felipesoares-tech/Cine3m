package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaCliente;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSala;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSessao;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaVenda;
import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.model.Venda;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente.CadastroCliente;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao.CadastroSessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.auxiliares.ConsultaVenda;
import br.com.iftm.pv.cinema.cine3m.view.util.CelulasPersonalizadasList;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import java.awt.Frame;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class OperacoesVenda extends javax.swing.JInternalFrame {

    private final GerenciaVenda gerenciaVenda;
    private final GerenciaSessao gerenciaSessao;
    private final GerenciaCliente gerenciaCliente;
    private final CadastroVenda cadastroVenda;
    private final RelatorioVenda relatorioVenda;
    private final GerenciaSala gerenciaSala;
    private final ConsultaVenda telaAuxiliarConsultaVenda;
    private JDialog relVenda;
    private List<Venda> vendas;

    public OperacoesVenda(GerenciaVenda gerenciaVenda,GerenciaSessao gerenciaSessao, GerenciaCliente gerenciaCliente, GerenciaSala gerenciaSala,CadastroSessao cadastroSessao, CadastroCliente cadastroCliente) {
        initComponents();
        this.gerenciaVenda = gerenciaVenda;
        this.gerenciaSala = gerenciaSala;
        this.gerenciaSessao = gerenciaSessao;
        this.gerenciaCliente = gerenciaCliente;
        this.relatorioVenda = new RelatorioVenda(gerenciaVenda);
        this.cadastroVenda = new CadastroVenda(gerenciaVenda, cadastroSessao, cadastroCliente, this);
        this.telaAuxiliarConsultaVenda = new ConsultaVenda(gerenciaVenda);
        initComponentsPersonalizado();
        btnConsultar.setEnabled(false);

    }

    public GerenciaSala getGerenciaSala() {
        return gerenciaSala;
    }
    
    public GerenciaVenda getGerenciaVenda() {
        return gerenciaVenda;
    }

    public GerenciaCliente getGerenciaCliente() {
        return gerenciaCliente;
    }

    public CadastroVenda getCadastroVenda() {
        return cadastroVenda;
    }

    private void initComponentsPersonalizado() {
//        PesquisaLike pesquisaLike = new PesquisaLike(gerenciaVenda);
//        tfPesquisar.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                pesquisaLike.filterList(tfPesquisar, lstVendas);
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                pesquisaLike.filterList(tfPesquisar, lstVendas);
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                pesquisaLike.filterList(tfPesquisar, lstVendas);
//            }
//        });

        lstVendas.setCellRenderer(new CelulasPersonalizadasList());
    }

    public JList<Venda> getLstVendas() {
        return lstVendas;
    }

    public void setLstVendas(JList<Venda> lstVendas) {
        this.lstVendas = lstVendas;
    }

    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public void setBtnConsultar(JButton btnConsultar) {
        this.btnConsultar = btnConsultar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnNovo() {
        return btnNovo;
    }

    public RelatorioVenda getRelatorioVenda() {
        return relatorioVenda;
    }

    public JLabel getLbPesquisar() {
        return lbPesquisar;
    }

    public JLabel getLbTitulo() {
        return lbTitulo;
    }

    public GerenciaSessao getGerenciaSessao() {
        return gerenciaSessao;
    }

    public JPanel getPanelBotoesVenda() {
        return panelBotoesVenda;
    }

    public void setBtnNovo(JButton btnNovo) {
        this.btnNovo = btnNovo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstVendas = new javax.swing.JList<>();
        tfPesquisar = new javax.swing.JTextField();
        panelBotoesVenda = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        lbPesquisar = new javax.swing.JLabel();
        btnRelatorio = new javax.swing.JButton();
        lbTitulo = new javax.swing.JLabel();

        setClosable(true);

        lstVendas.setBackground(new java.awt.Color(102, 102, 102));
        lstVendas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstVendas.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lstVendasAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(lstVendas);

        tfPesquisar.setToolTipText("");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
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

        javax.swing.GroupLayout panelBotoesVendaLayout = new javax.swing.GroupLayout(panelBotoesVenda);
        panelBotoesVenda.setLayout(panelBotoesVendaLayout);
        panelBotoesVendaLayout.setHorizontalGroup(
            panelBotoesVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesVendaLayout.createSequentialGroup()
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBotoesVendaLayout.setVerticalGroup(
            panelBotoesVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesVendaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelBotoesVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        lbTitulo.setText("Vendas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitulo)
                .addGap(135, 135, 135)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                                .addComponent(tfPesquisar))
                            .addComponent(lbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(panelBotoesVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(panelBotoesVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        getDesktopPane().add(cadastroVenda);
        cadastroVenda.setModal(true);
        cadastroVenda.setVisible(true);

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        getDesktopPane().add(telaAuxiliarConsultaVenda);
        telaAuxiliarConsultaVenda.setVendaSelecionada((Venda) lstVendas.getSelectedValue());
        telaAuxiliarConsultaVenda.setModal(true);
        telaAuxiliarConsultaVenda.setVisible(true);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Venda vendaSelecionada = lstVendas.getSelectedValue();

        Integer resp = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja cancelar ??",
                "Cancelar Venda", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (resp.equals(JOptionPane.OK_OPTION)) {
            if (gerenciaVenda.cancelar(vendaSelecionada).equals(EnumValidacoes.VENDA_CANCELADA)) {
                JOptionPane.showMessageDialog(this, "Venda cancelada",
                        "Cancelar", JOptionPane.INFORMATION_MESSAGE);
                lstVendasAncestorAdded(null);
            } else {
                JOptionPane.showMessageDialog(this, "Venda já cancelada!!",
                        "Cancelar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void lstVendasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lstVendasAncestorAdded
        vendas = gerenciaVenda.relatorio();
        ListUtils.carregarList(lstVendas, vendas);

        if (!vendas.isEmpty()) {
            btnCancelar.setEnabled(true);
            btnConsultar.setEnabled(true);
            lstVendas.setSelectedIndex(0);
        } else {
            btnCancelar.setEnabled(false);
            btnConsultar.setEnabled(false);
        }
    }//GEN-LAST:event_lstVendasAncestorAdded

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        try {
            // Compilando o JasperReport
            JasperReport relatorioCompilado = JasperCompileManager.compileReport("src/main/java/br/com/iftm/pv/cinema/cine3m/report/venda.jrxml");

            // Preenchendo o relatório com uma lista de usuários usando JRBeanCollectionDataSource
            JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, null, new JRBeanCollectionDataSource(gerenciaVenda.relatorio()));

            // Criando um diálogo para exibir o relatório
            relVenda = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Relatório de Usuários", true);
            relVenda.setSize(1000, 500);

            // Criando um componente Swing para exibir o relatório
            JRViewer painelRelatorio = new JRViewer(relatorioPreenchido);

            // Adicionando o painel do relatório ao diálogo criado
            relVenda.getContentPane().add(painelRelatorio);

            // Tornando o diálogo visível com o relatório
            relVenda.setVisible(true);
        } catch (JRException ex) {
//            Logger.getLogger(TelaAdminstrador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Erro ao gerar o relatório." + ex.getCause());
        }
    }//GEN-LAST:event_btnRelatorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbPesquisar;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JList<Venda> lstVendas;
    private javax.swing.JPanel panelBotoesVenda;
    private javax.swing.JTextField tfPesquisar;
    // End of variables declaration//GEN-END:variables
}
