package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.auxiliares;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaVenda;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSessao;
import br.com.iftm.pv.cinema.cine3m.enums.TipoIngresso;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import br.com.iftm.pv.cinema.cine3m.model.Venda;
import br.com.iftm.pv.cinema.cine3m.model.ItemVenda;
import br.com.iftm.pv.cinema.cine3m.model.Poltrona;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.CadastroVenda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class ConfirmaCompra extends javax.swing.JInternalFrame {

    private final Integer qtdMaxItensIngresso;
    private final SpinnerNumberModel spinnerModelInteira;
    private final SpinnerNumberModel spinnerModelMeia;
    private Double valorTotal;
    private final Double valorSessao;
    private final JList<ItemVenda> listItensIngresso;
    private final GerenciaSessao gerenciaSessao;
    private final Sessao sessaoSelecionada;
    private final VincularCliente vincularCliente;
    private final ConsultaPoltronas consultaPoltronas;
    private final CadastroVenda cadastroVenda;
    private final GerenciaVenda gerenciaVenda;
    private Integer qtdInteira;
    private Integer qtdMeia;

    public ConfirmaCompra(JList listItensIngresso, Sessao sessaoSelecionada, VincularCliente vincularCliente, GerenciaSessao gerenciaSessao, ConsultaPoltronas consultaPoltronas, CadastroVenda cadastroVenda, GerenciaVenda gerenciaVenda) {
        this.listItensIngresso = listItensIngresso;
        this.cadastroVenda = cadastroVenda;
        this.consultaPoltronas = consultaPoltronas;
        this.gerenciaVenda = gerenciaVenda;
        this.gerenciaSessao = gerenciaSessao;
        this.sessaoSelecionada = sessaoSelecionada;
        this.vincularCliente = vincularCliente;
        this.spinnerModelInteira = new SpinnerNumberModel(0, 0, listItensIngresso.getModel().getSize(), 1);
        this.spinnerModelMeia = new SpinnerNumberModel(0, 0, listItensIngresso.getModel().getSize(), 1);
        this.valorSessao = sessaoSelecionada.getValor();
        this.qtdMaxItensIngresso = listItensIngresso.getModel().getSize();
        initComponents();
        this.jsInteira.setModel(spinnerModelInteira);
        this.jsMeia.setModel(spinnerModelMeia);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfValorTotal = new javax.swing.JTextField();
        lbValorTotal = new javax.swing.JLabel();
        jsInteira = new javax.swing.JSpinner();
        jsMeia = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnFinalizarVenda = new javax.swing.JButton();

        setClosable(true);

        lbValorTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbValorTotal.setText("Valor Total :");

        jsInteira.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsInteiraStateChanged(evt);
            }
        });

        jsMeia.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsMeiaStateChanged(evt);
            }
        });

        jLabel1.setText("Quantidade:");

        jLabel2.setText("Inteira");

        jLabel3.setText("Meia");

        btnFinalizarVenda.setText("CONFIRMAR");
        btnFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnFinalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfValorTotal)
                    .addComponent(jsInteira, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jsMeia, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFinalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jsInteira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jsMeia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addComponent(lbValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jsInteiraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsInteiraStateChanged
        this.qtdInteira = (int) jsInteira.getValue();
        spinnerModelMeia.setMaximum(qtdMaxItensIngresso - qtdInteira);
        calcularValorTotal();
    }//GEN-LAST:event_jsInteiraStateChanged

    private void jsMeiaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsMeiaStateChanged
        this.qtdMeia = (int) jsMeia.getValue();
        spinnerModelInteira.setMaximum(qtdMaxItensIngresso - qtdMeia);
        calcularValorTotal();
    }//GEN-LAST:event_jsMeiaStateChanged

    private List<ItemVenda> preencheItensVenda(JList listItens, int qtdInteiras, int qtdMeia, Double valorSessao) {
        List<ItemVenda> itensVenda = new ArrayList<>();

        DefaultListModel<ItemVenda> model = (DefaultListModel<ItemVenda>) listItens.getModel();

        for (int i = 0; i < qtdMeia; i++) {
            ItemVenda item = model.getElementAt(i);
            item.setValor(valorSessao / 2.0);
            item.setTipoIngresso(TipoIngresso.MEIA);
            itensVenda.add(item);
        }

        for (int i = qtdMeia; i < qtdMeia + qtdInteiras; i++) {
            ItemVenda item = model.getElementAt(i);
            item.setValor(valorSessao);
            item.setTipoIngresso(TipoIngresso.INTEIRA);
            itensVenda.add(item);
        }

        return itensVenda;

    }

    private void btnFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVendaActionPerformed
        for (int i = 0; i < qtdMaxItensIngresso; i++) {
            ItemVenda item = (ItemVenda) listItensIngresso.getModel().getElementAt(i);
            Poltrona p = (Poltrona) item.getPoltrona();
            p.setLivre(false);
            gerenciaSessao.AtualizaPoltronaSessao(this.sessaoSelecionada, p);
        }
        Integer total = qtdMeia + qtdInteira;
        if (total.equals(qtdMaxItensIngresso)) {
            JOptionPane.showMessageDialog(this, "Cadastrado com sucesso", "venda", JOptionPane.PLAIN_MESSAGE);
            Venda venda;
            List<ItemVenda> itensVenda = preencheItensVenda(listItensIngresso, qtdInteira, qtdMeia, valorSessao);
            DefaultListModel<ItemVenda> model = (DefaultListModel<ItemVenda>) cadastroVenda.getListItensIngresso().getModel();
            Cliente clienteSelecionado = vincularCliente.getClienteSelecionado();
            Funcionario funcionarioSelecionado = cadastroVenda.getFuncionario();
            if (clienteSelecionado != null) {
                venda = new Venda(funcionarioSelecionado, sessaoSelecionada, clienteSelecionado, valorTotal, itensVenda);
            } else {
                venda = new Venda(funcionarioSelecionado, sessaoSelecionada, valorTotal, itensVenda);
            }
            Venda vendaRealizada = gerenciaVenda.cadastrar(venda);
            if (vendaRealizada != null) {
                cadastroVenda.getContentPane().remove(consultaPoltronas);
                cadastroVenda.setConsultaPoltronas(null);
                if (vendaRealizada.hasDesconto()) {
                    JOptionPane.showMessageDialog(this, "Cliente com promoção", "promoção", JOptionPane.INFORMATION_MESSAGE);
                }
                 this.setVisible(false);
            }
            model.removeAllElements();
            vincularCliente.setClienteSelecionado(null);
            cadastroVenda.getTfClienteSelecionado().setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione a quantidade certa de ingressos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        cadastroVenda.getBtnContinuarCompra().setEnabled(false);

    }//GEN-LAST:event_btnFinalizarVendaActionPerformed

    private void calcularValorTotal() {
        double valorIngressoInteira = (int) jsInteira.getValue() * valorSessao;
        double valorIngressoMeia = (int) jsMeia.getValue() * (valorSessao / 2.0);

        valorTotal = valorIngressoInteira + valorIngressoMeia;
        tfValorTotal.setText(String.valueOf(valorTotal));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner jsInteira;
    private javax.swing.JSpinner jsMeia;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JTextField tfValorTotal;
    // End of variables declaration//GEN-END:variables
}
