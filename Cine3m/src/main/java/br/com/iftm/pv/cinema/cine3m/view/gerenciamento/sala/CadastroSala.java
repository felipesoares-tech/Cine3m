package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sala;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSala;
import br.com.iftm.pv.cinema.cine3m.model.Sala;
import br.com.iftm.pv.cinema.cine3m.view.util.ValidaCampo;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CadastroSala extends javax.swing.JInternalFrame {

    private GerenciaSala gerenciaSala;
    private Sala salaSelecionada;
    private int maxValor;

    public CadastroSala(GerenciaSala gerenciaSala) {
        initComponents();
        this.gerenciaSala = gerenciaSala;
        this.maxValor = 100;

        this.jsCapacidade.setModel(new SpinnerNumberModel(0, 0, maxValor, 10));
        this.jsCapacidade.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = (int) jsCapacidade.getValue();
                if (valor >= maxValor) {
                    jsCapacidade.setValue(maxValor);
                } else if (valor % 10 != 0) {
                    valor = Math.round(valor / 10) * 10;
                    jsCapacidade.setValue(valor);
                }
            }
        });
    }

    public JSpinner getJsCapacidade() {
        return jsCapacidade;
    }

    public void setJsCapacidade(JSpinner jsCapacidade) {
        this.jsCapacidade = jsCapacidade;
    }

    public Sala getSalaSelecionada() {
        return salaSelecionada;
    }

    public void setSalaSelecionada(Sala salaSelecionada) {
        this.salaSelecionada = salaSelecionada;
    }

    public JButton getBtnCadastrarSala() {
        return btnCadastrarSala;
    }

    public void setBtnCadastrarSala(JButton btnCadastrarSala) {
        this.btnCadastrarSala = btnCadastrarSala;
    }

    public JLabel getLbSalaCapacidade() {
        return lbSalaCapacidade;
    }

    public void setLbSalaCapacidade(JLabel lbSalaCapacidade) {
        this.lbSalaCapacidade = lbSalaCapacidade;
    }

    public JLabel getLbSalaNome() {
        return lbSalaNome;
    }

    public void setLbSalaNome(JLabel lbSalaNome) {
        this.lbSalaNome = lbSalaNome;
    }

    public JLabel getLbTituloTelaSala() {
        return lbTituloTelaSala;
    }

    public void setLbTituloTelaSala(JLabel lbTituloTelaSala) {
        this.lbTituloTelaSala = lbTituloTelaSala;
    }

    public JTextField getTfNomeSala() {
        return tfNomeSala;
    }

    public void setTfNomeSala(JTextField tfNomeSala) {
        this.tfNomeSala = tfNomeSala;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTituloTelaSala = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbSalaCapacidade = new javax.swing.JLabel();
        jsCapacidade = new javax.swing.JSpinner();
        lbSalaNome = new javax.swing.JLabel();
        tfNomeSala = new javax.swing.JTextField();
        btnCadastrarSala = new javax.swing.JButton();

        setClosable(true);

        lbTituloTelaSala.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbTituloTelaSala.setForeground(new java.awt.Color(204, 204, 204));
        lbTituloTelaSala.setText("Cadastro de salas");

        lbSalaCapacidade.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbSalaCapacidade.setForeground(new java.awt.Color(51, 51, 51));
        lbSalaCapacidade.setText("Capacidade (max =100):");

        lbSalaNome.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbSalaNome.setForeground(new java.awt.Color(51, 51, 51));
        lbSalaNome.setText("Nome");

        btnCadastrarSala.setText("CADASTRAR");
        btnCadastrarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarSalaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSalaCapacidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSalaNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jsCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNomeSala, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 76, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(btnCadastrarSala, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbSalaCapacidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbSalaNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfNomeSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnCadastrarSala, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTituloTelaSala, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(lbTituloTelaSala)
                .addGap(55, 55, 55)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarSalaActionPerformed

        Integer capacidade = (int) jsCapacidade.getValue();
        String nome = tfNomeSala.getText();
        Sala sala = new Sala(nome, capacidade);
        if (ValidaCampo.validar(nome, lbSalaNome, this)&& ValidaCampo.validar(capacidade, lbSalaCapacidade, this)) {
            if (btnCadastrarSala.getText().equals("CADASTRAR")) {
                Boolean sucesso = gerenciaSala.cadastrar(sala);
                JOptionPane.showMessageDialog(this, sucesso ? "Sala cadastrada com sucesso !" : "Sala já cadastrada!",
                        "Cadastro Sala", sucesso ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);

            } else {
                gerenciaSala.atualizar(salaSelecionada, sala);
                JOptionPane.showMessageDialog(this, "Sala atualizada com sucesso!", "Atualizar", JOptionPane.PLAIN_MESSAGE);
                this.setVisible(false);
                getDesktopPane().remove(this);
            }
            tfNomeSala.setText("");
        }

    }//GEN-LAST:event_btnCadastrarSalaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarSala;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jsCapacidade;
    private javax.swing.JLabel lbSalaCapacidade;
    private javax.swing.JLabel lbSalaNome;
    private javax.swing.JLabel lbTituloTelaSala;
    private javax.swing.JTextField tfNomeSala;
    // End of variables declaration//GEN-END:variables
}
