package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.auxiliares;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaVenda;
import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.enums.TipoVenda;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import br.com.iftm.pv.cinema.cine3m.model.Venda;
import br.com.iftm.pv.cinema.cine3m.model.ItemVenda;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.CadastroVenda;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.OperacoesVenda;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import br.com.iftm.pv.cinema.cine3m.view.util.ModalInternalFrame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

public class ConfirmaVenda extends ModalInternalFrame {

    private final Integer qtdMaxItensIngresso;
    private final SpinnerNumberModel spinnerModelInteira;
    private final SpinnerNumberModel spinnerModelMeia;
    private Double valorTotal;
    private final Double valorSessao;
    private final JList<ItemVenda> listItensIngresso;
    private final Sessao sessaoSelecionada;
    private final VincularCliente vincularCliente;
    private final CadastroVenda cadastroVenda;
    private final GerenciaVenda gerenciaVenda;
    //private final GerenciaSala gerenciaSala;
    private final OperacoesVenda operacoesVenda;
    private Integer qtdInteira;
    private Integer qtdMeia;

    public ConfirmaVenda(JList listItensIngresso, Sessao sessaoSelecionada, VincularCliente vincularCliente, ConsultaPoltronas consultaPoltronas, OperacoesVenda operacoesVenda) {
        this.listItensIngresso = listItensIngresso;
        this.operacoesVenda = operacoesVenda;
        this.cadastroVenda = operacoesVenda.getCadastroVenda();
        this.gerenciaVenda =  operacoesVenda.getGerenciaVenda();
        //this.gerenciaSala = operacoesVenda.getGerenciaSala();
        this.sessaoSelecionada = sessaoSelecionada;
        this.vincularCliente = vincularCliente;
        this.spinnerModelInteira = new SpinnerNumberModel(0, 0, listItensIngresso.getModel().getSize(), 1);
        this.spinnerModelMeia = new SpinnerNumberModel(0, 0, listItensIngresso.getModel().getSize(), 1);
        this.valorSessao = sessaoSelecionada.getValor();
        this.qtdMaxItensIngresso = listItensIngresso.getModel().getSize();
        initComponents();
        this.jsInteira.setModel(spinnerModelInteira);
        this.jsMeia.setModel(spinnerModelMeia);
        this.qtdInteira = (int) jsInteira.getValue();
        this.qtdMeia = (int) jsMeia.getValue();

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
            item.setTipoVenda(TipoVenda.MEIA);
            itensVenda.add(item);
        }

        for (int i = qtdMeia; i < qtdMeia + qtdInteiras; i++) {
            ItemVenda item = model.getElementAt(i);
            item.setValor(valorSessao);
            item.setTipoVenda(TipoVenda.INTEIRA);
            itensVenda.add(item);
        }

        return itensVenda;

    }

    private void btnFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVendaActionPerformed
        Cliente clienteSelecionado = vincularCliente.getClienteSelecionado();
        Funcionario funcionarioSelecionado = cadastroVenda.getFuncionario();
                
        Integer total = qtdMeia + qtdInteira;
        if (total.equals(qtdMaxItensIngresso)) {
            Venda venda;
            List<ItemVenda> itensVenda = preencheItensVenda(listItensIngresso, qtdInteira, qtdMeia, valorSessao);
            DefaultListModel<ItemVenda> model = (DefaultListModel<ItemVenda>) cadastroVenda.getListItensIngresso().getModel();
            if (clienteSelecionado != null) {
                venda = new Venda(funcionarioSelecionado, sessaoSelecionada, clienteSelecionado, valorTotal);
            } else {
                venda = new Venda(funcionarioSelecionado, sessaoSelecionada, valorTotal);
            }

            EnumValidacoes retorno = gerenciaVenda.cadastrar(venda,itensVenda);
            switch (retorno) {
                case VENDA_SUCESSO:
                    JOptionPane.showMessageDialog(this, "Venda realizada com sucesso ", "Cadastro Venda",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case VENDA_PROMOCAO:
                    JOptionPane.showMessageDialog(this, "Cliente com promoção", "promoção", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    throw new AssertionError();
            }
            setVisible(false);
            model.removeAllElements();
            vincularCliente.setClienteSelecionado(null);
            cadastroVenda.recarregaComboSessoes();
            cadastroVenda.getTfClienteSelecionado().setText("");
            ListUtils.carregarList(operacoesVenda.getLstVendas(), gerenciaVenda.relatorio());
            if (gerenciaVenda.relatorio().isEmpty()) {
                operacoesVenda.getBtnConsultar().setEnabled(false);
                operacoesVenda.getBtnCancelar().setEnabled(false);
            } else {
                operacoesVenda.getBtnConsultar().setEnabled(true);
                operacoesVenda.getBtnCancelar().setEnabled(true);
                operacoesVenda.getLstVendas().setSelectedIndex(0);
            }                       
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
