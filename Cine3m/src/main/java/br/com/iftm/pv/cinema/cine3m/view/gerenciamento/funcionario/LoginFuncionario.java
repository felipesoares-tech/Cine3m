package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.funcionario;

import br.com.iftm.pv.cinema.cine3m.dao.FuncionarioDAO;
import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import br.com.iftm.pv.cinema.cine3m.util.ChecarCredenciais;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.CadastroVenda;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFuncionario extends javax.swing.JInternalFrame {

    private JMenuBar menuBar;
    private CadastroVenda cadastroVenda;
    private Funcionario funcionarioSelecionado;
    private ChecarCredenciais checarCredenciais;
    private FuncionarioDAO funcionarioDAO;

    public LoginFuncionario(CadastroVenda cadastroVenda, JMenuBar menuBar) {
        this.menuBar = menuBar;
        this.cadastroVenda = cadastroVenda;
        this.checarCredenciais = new ChecarCredenciais();
        this.funcionarioDAO = new FuncionarioDAO();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbUsuario = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        jpfSenha = new javax.swing.JPasswordField();
        btLogin = new javax.swing.JButton();

        lbUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbUsuario.setText("Login");

        lbSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbSenha.setText("Senha");

        tfUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jpfSenha.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        btLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btLogin.setMnemonic('L');
        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfUsuario)
                    .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lbUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btLogin)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        Boolean sucesso = checarCredenciais.checarCredenciais(tfUsuario.getText(), String.valueOf(jpfSenha.getPassword()));
        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Login bem sucedido!", null, JOptionPane.INFORMATION_MESSAGE);
            menuBar.setVisible(true);
            this.setVisible(false);
            getDesktopPane().remove(this);
            funcionarioSelecionado = funcionarioDAO.consultarFuncionarioLogin(tfUsuario.getText());
            cadastroVenda.setFuncionario(funcionarioSelecionado);

        } else
            JOptionPane.showMessageDialog(this, "Login ou senha incorretos!", null, JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btLoginActionPerformed

    public Funcionario getFuncionarioSelecionado() {
        return funcionarioSelecionado;
    }

    public JPasswordField getJpfSenha() {
        return jpfSenha;
    }

    public void setJpfSenha(JPasswordField jpfSenha) {
        this.jpfSenha = jpfSenha;
    }

    public JTextField getTfUsuario() {
        return tfUsuario;
    }

    public JLabel getLbSenha() {
        return lbSenha;
    }

    public JLabel getLbUsuario() {
        return lbUsuario;
    }

    public void setTfUsuario(JTextField tfUsuario) {
        this.tfUsuario = tfUsuario;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
