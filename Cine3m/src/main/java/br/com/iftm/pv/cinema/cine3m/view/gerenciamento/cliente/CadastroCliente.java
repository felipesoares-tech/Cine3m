package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaCliente;
import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import static br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes.CLIENTE_CPF_INVALIDO;
import static br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes.CLIENTE_CPF_JA_CADASTRADO;
import static br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes.CLIENTE_SUCESSO;
import br.com.iftm.pv.cinema.cine3m.enums.EstadoAtual;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import br.com.iftm.pv.cinema.cine3m.view.util.ModalInternalFrame;
import br.com.iftm.pv.cinema.cine3m.view.util.ValidaCampo;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroCliente extends ModalInternalFrame {

    private GerenciaCliente gerenciaCliente;
    private Cliente clienteSelecionado;
    private OperacoesCliente operacoesCliente;
    private EstadoAtual estadoAtual;

    public CadastroCliente(GerenciaCliente gerenciaCliente, OperacoesCliente operacoesCliente) {
        this.gerenciaCliente = gerenciaCliente;
        this.operacoesCliente = operacoesCliente;
        initComponents();
        ImageIcon icon = new ImageIcon("src/main/java/imagens/new-client.png");

        icon.setImage(icon.getImage().getScaledInstance(59, 66, 1));
        lbImg.setIcon(icon);
    }

    public EstadoAtual getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(EstadoAtual estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public CadastroCliente(GerenciaCliente gerenciaCliente) {
        this.gerenciaCliente = gerenciaCliente;
        initComponents();
        ImageIcon icon = new ImageIcon("src/main/java/imagens/new-client.png");

        icon.setImage(icon.getImage().getScaledInstance(59, 66, 1));
        lbImg.setIcon(icon);
    }

    private void exibeMensagemValidacao(EnumValidacoes tipoRetorno) {
        String titulo = estadoAtual.equals(EstadoAtual.CADASTRANDO) ? "Cadastro Cliente" : "Atualização Cliente";
        String mensagemSucesso = estadoAtual.equals(EstadoAtual.CADASTRANDO) ? "Cliente cadastrado com sucesso" : "Cliente atualizado com sucesso";
        switch (tipoRetorno) {
            case CLIENTE_SUCESSO:
                JOptionPane.showMessageDialog(this, mensagemSucesso, titulo,
                        JOptionPane.INFORMATION_MESSAGE);
                limpaCampos();
                break;
            case CLIENTE_CPF_INVALIDO:
                JOptionPane.showMessageDialog(this, "CPF Inválido ", titulo,
                        JOptionPane.ERROR_MESSAGE);
                break;
            case CLIENTE_CPF_JA_CADASTRADO:
                JOptionPane.showMessageDialog(this, "CPF já cadastrado ", titulo,
                        JOptionPane.ERROR_MESSAGE);

                break;
            default:
                throw new AssertionError();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        lbNomeCliente = new javax.swing.JLabel();
        lbCpfCliente = new javax.swing.JLabel();
        tfCpfCliente = new javax.swing.JFormattedTextField();
        tfNomeCliente = new javax.swing.JTextField();
        btnCadastrarCliente = new javax.swing.JButton();
        lbImg = new javax.swing.JLabel();
        lbTituloTelaCliente = new javax.swing.JLabel();

        setClosable(true);

        jPanel8.setBackground(java.awt.Color.gray);

        lbNomeCliente.setBackground(new java.awt.Color(255, 255, 255));
        lbNomeCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbNomeCliente.setForeground(new java.awt.Color(51, 51, 51));
        lbNomeCliente.setText("Nome:");

        lbCpfCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbCpfCliente.setForeground(new java.awt.Color(51, 51, 51));
        lbCpfCliente.setText("Cpf:");

        try {
            tfCpfCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnCadastrarCliente.setForeground(new java.awt.Color(51, 51, 51));
        btnCadastrarCliente.setText("CADASTRAR");
        btnCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbCpfCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tfNomeCliente)
            .addComponent(tfCpfCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbNomeCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCpfCliente)
                .addGap(10, 10, 10)
                .addComponent(tfCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        lbTituloTelaCliente.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbTituloTelaCliente.setForeground(new java.awt.Color(102, 102, 102));
        lbTituloTelaCliente.setText("Cadastro de clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbTituloTelaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lbTituloTelaCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarClienteActionPerformed
        String nome = tfNomeCliente.getText().toUpperCase();
        String cpf = tfCpfCliente.getText().replaceAll("[-.]", "");

        if (ValidaCampo.validar(nome, lbNomeCliente, this)
                && ValidaCampo.validar(cpf, lbCpfCliente, this)) {
            
            Cliente cliente = new Cliente(nome, cpf);
            
            if (estadoAtual.equals(EstadoAtual.CADASTRANDO)) {
                exibeMensagemValidacao(gerenciaCliente.cadastrar(cliente));
            } else {
                EnumValidacoes retornoValidacao = gerenciaCliente.atualizar(clienteSelecionado, cliente);
                exibeMensagemValidacao(retornoValidacao);
                if (retornoValidacao.equals(EnumValidacoes.CLIENTE_SUCESSO)) {
                    limpaCampos();
                    setVisible(false);
                    getDesktopPane().remove(this);

                }
            }

            ListUtils.carregarList(operacoesCliente.getLstClientes(), gerenciaCliente.relatorio());
            if (gerenciaCliente.relatorio().isEmpty()) {
                operacoesCliente.getBtnConsultar().setEnabled(false);
                operacoesCliente.getBtnExcluir().setEnabled(false);
                operacoesCliente.getBtnEditar().setEnabled(false);
            } else {
                operacoesCliente.getBtnConsultar().setEnabled(true);
                operacoesCliente.getBtnExcluir().setEnabled(true);
                operacoesCliente.getBtnEditar().setEnabled(true);
                operacoesCliente.getLstClientes().setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_btnCadastrarClienteActionPerformed

    public void limpaCampos() {
        tfNomeCliente.setText("");
        tfCpfCliente.setValue(null);
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public JButton getBtnCadastrarCliente() {
        return btnCadastrarCliente;
    }

    public void setBtnCadastrarCliente(JButton btnCadastrarCliente) {
        this.btnCadastrarCliente = btnCadastrarCliente;
    }

    public JPanel getjPanel8() {
        return jPanel8;
    }

    public void setjPanel8(JPanel jPanel8) {
        this.jPanel8 = jPanel8;
    }

    public JLabel getLbCpfCliente() {
        return lbCpfCliente;
    }

    public void setLbCpfCliente(JLabel lbCpfCliente) {
        this.lbCpfCliente = lbCpfCliente;
    }

    public JLabel getLbNomeCliente() {
        return lbNomeCliente;
    }

    public void setLbNomeCliente(JLabel lbNomeCliente) {
        this.lbNomeCliente = lbNomeCliente;
    }

    public JLabel getLbTituloTelaCliente() {
        return lbTituloTelaCliente;
    }

    public void setLbTituloTelaCliente(JLabel lbTituloTelaCliente) {
        this.lbTituloTelaCliente = lbTituloTelaCliente;
    }

    public JFormattedTextField getTfCpfCliente() {
        return tfCpfCliente;
    }

    public void setTfCpfCliente(JFormattedTextField tfCpfCliente) {
        this.tfCpfCliente = tfCpfCliente;
    }

    public JTextField getTfNomeCliente() {
        return tfNomeCliente;
    }

    public void setTfNomeCliente(JTextField tfNomeCliente) {
        this.tfNomeCliente = tfNomeCliente;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarCliente;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbCpfCliente;
    private javax.swing.JLabel lbImg;
    private javax.swing.JLabel lbNomeCliente;
    private javax.swing.JLabel lbTituloTelaCliente;
    private javax.swing.JFormattedTextField tfCpfCliente;
    private javax.swing.JTextField tfNomeCliente;
    // End of variables declaration//GEN-END:variables
}
