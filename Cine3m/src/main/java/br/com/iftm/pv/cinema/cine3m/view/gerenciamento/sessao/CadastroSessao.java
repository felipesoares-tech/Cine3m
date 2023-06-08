package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaFilme;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSala;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSessao;
import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import br.com.iftm.pv.cinema.cine3m.enums.EstadoAtual;
import br.com.iftm.pv.cinema.cine3m.model.Filme;
import br.com.iftm.pv.cinema.cine3m.model.Sala;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import br.com.iftm.pv.cinema.cine3m.view.util.ComboBoxUtils;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import br.com.iftm.pv.cinema.cine3m.view.util.ModalInternalFrame;
import br.com.iftm.pv.cinema.cine3m.view.util.ValidaCampo;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CadastroSessao extends ModalInternalFrame {

    private final GerenciaSessao gerenciaSessao;
    private final GerenciaSala gerenciaSala;
    private final GerenciaFilme gerenciaFilme;
    private final OperacoesSessao operacoesSessao;
    private Sessao sessaoSelecionada;
    private EstadoAtual estadoAtual;

    public CadastroSessao(GerenciaSessao gerenciaSessao, GerenciaSala gerenciaSala, GerenciaFilme gerenciaFilme, OperacoesSessao operacoesSessao) {
        initComponents();
        this.gerenciaFilme = gerenciaFilme;
        this.gerenciaSala = gerenciaSala;
        this.gerenciaSessao = gerenciaSessao;
        this.operacoesSessao = operacoesSessao;
        this.btnCadastrarSessao.setEnabled(false);
    }

    public JButton getBtnCadastrarSessao() {
        return btnCadastrarSessao;
    }

    public void setBtnCadastrarSessao(JButton btnCadastrarSessao) {
        this.btnCadastrarSessao = btnCadastrarSessao;
    }

    public JComboBox<Filme> getCbFilmesSessao() {
        return cbFilmesSessao;
    }

    public void setCbFilmesSessao(JComboBox<Filme> cbFilmesSessao) {
        this.cbFilmesSessao = cbFilmesSessao;
    }

    public JComboBox<Sala> getCbSalasSessao() {
        return cbSalasSessao;
    }

    public void setCbSalasSessao(JComboBox<Sala> cbSalasSessao) {
        this.cbSalasSessao = cbSalasSessao;
    }

    public JLabel getLbDataHora() {
        return lbData;
    }

    public EstadoAtual getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(EstadoAtual estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public void setLbDataHora(JLabel lbDataHora) {
        this.lbData = lbDataHora;
    }

    public JLabel getLbDataHora1() {
        return lbHora;
    }

    public void setLbDataHora1(JLabel lbDataHora1) {
        this.lbHora = lbDataHora1;
    }

    public JLabel getLbFilmes() {
        return lbFilmes;
    }

    public void setLbFilmes(JLabel lbFilmes) {
        this.lbFilmes = lbFilmes;
    }

    public JLabel getLbSalas() {
        return lbSalas;
    }

    public void setLbSalas(JLabel lbSalas) {
        this.lbSalas = lbSalas;
    }

    public JLabel getLbTituloTelaSessao() {
        return lbTituloTelaSessao;
    }

    public void setLbTituloTelaSessao(JLabel lbTituloTelaSessao) {
        this.lbTituloTelaSessao = lbTituloTelaSessao;
    }

    public Sessao getSessaoSelecionada() {
        return sessaoSelecionada;
    }

    public void setSessaoSelecionada(Sessao sessaoSelecionada) {
        this.sessaoSelecionada = sessaoSelecionada;
    }

    public JLabel getLbValor() {
        return lbValor;
    }

    public void setLbValor(JLabel lbValor) {
        this.lbValor = lbValor;
    }

    public JFormattedTextField getTfDataSessao() {
        return tfDataSessao;
    }

    public void setTfDataSessao(JFormattedTextField tfDataSessao) {
        this.tfDataSessao = tfDataSessao;
    }

    public JFormattedTextField getTfHorarioSessao() {
        return tfHorarioSessao;
    }

    public void setTfHorarioSessao(JFormattedTextField tfHorarioSessao) {
        this.tfHorarioSessao = tfHorarioSessao;
    }

    public JFormattedTextField getTfValorSessao() {
        return tfValorSessao;
    }

    public void setTfValorSessao(JFormattedTextField tfValorSessao) {
        this.tfValorSessao = tfValorSessao;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTituloTelaSessao = new javax.swing.JLabel();
        btnCadastrarSessao = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbFilmes = new javax.swing.JLabel();
        cbFilmesSessao = new javax.swing.JComboBox<>();
        lbSalas = new javax.swing.JLabel();
        cbSalasSessao = new javax.swing.JComboBox<>();
        lbValor = new javax.swing.JLabel();
        tfValorSessao = new javax.swing.JFormattedTextField();
        lbData = new javax.swing.JLabel();
        tfDataSessao = new javax.swing.JFormattedTextField();
        lbHora = new javax.swing.JLabel();
        tfHorarioSessao = new javax.swing.JFormattedTextField();

        setClosable(true);
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lbTituloTelaSessao.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbTituloTelaSessao.setForeground(new java.awt.Color(204, 204, 204));
        lbTituloTelaSessao.setText("Cadastro de Sessão");

        btnCadastrarSessao.setText("CADASTRAR");
        btnCadastrarSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarSessaoActionPerformed(evt);
            }
        });

        lbFilmes.setForeground(new java.awt.Color(51, 51, 51));
        lbFilmes.setText("FIlmes");

        lbSalas.setForeground(new java.awt.Color(51, 51, 51));
        lbSalas.setText("Salas");

        lbValor.setForeground(new java.awt.Color(51, 51, 51));
        lbValor.setText("Valor");

        tfValorSessao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        lbData.setForeground(new java.awt.Color(51, 51, 51));
        lbData.setText("Data:");

        try {
            tfDataSessao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbHora.setForeground(new java.awt.Color(51, 51, 51));
        lbHora.setText("Hora");

        try {
            tfHorarioSessao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFilmes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSalas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDataSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfHorarioSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSalasSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFilmesSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfValorSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbFilmes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbFilmesSessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSalas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbSalasSessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfValorSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDataSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfHorarioSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btnCadastrarSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(lbTituloTelaSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbTituloTelaSessao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnCadastrarSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarSessaoActionPerformed
        Filme filmeSelecionado = (Filme) cbFilmesSessao.getSelectedItem();
        Sala salaSelecionada = (Sala) cbSalasSessao.getSelectedItem();

        String dataSessao = tfDataSessao.getText();
        String horaSessao = tfHorarioSessao.getText();
        String valorSessao = tfValorSessao.getText();
        LocalDate validarData = LocalDate.parse(dataSessao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (ValidaCampo.validar(dataSessao.replaceAll("[/]", "").trim(), lbData, this)
                && ValidaCampo.validar(horaSessao.replaceAll("[:]", "").trim(), lbHora, this)
                && ValidaCampo.validar(valorSessao, lbValor, this) && ValidaCampo.validar(validarData, lbData, this)) {

            LocalDate data;
            LocalTime hora;

            try {
                data = LocalDate.parse(dataSessao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                hora = LocalTime.parse(horaSessao, DateTimeFormatter.ofPattern("HH:mm"));
            } catch (DateTimeException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Double valor = Double.valueOf(tfValorSessao.getText());

            Sessao sessao = new Sessao(filmeSelecionado, data, hora, salaSelecionada, valor);

            if (estadoAtual.equals(EstadoAtual.CADASTRANDO)) {
                EnumValidacoes retorno = gerenciaSessao.cadastrar(sessao);
                switch (retorno) {
                    case SESSAO_SUCESSO:
                        JOptionPane.showMessageDialog(this, "Sessão cadastrada com sucesso ", "Cadastro Sessão",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case SESSAO_JA_CADASTRADA:
                        JOptionPane.showMessageDialog(this, "Sessão já cadastrado ", "Cadastro Sessão",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        throw new AssertionError();
                }
            } else {
                gerenciaSessao.atualizar(sessaoSelecionada, sessao);
                JOptionPane.showMessageDialog(this, "Sessão atualizada com sucesso ",
                        "Atualizar", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                getDesktopPane().remove(this);
            }
            ListUtils.carregarList(operacoesSessao.getLstSessoes(), gerenciaSessao.relatorio());
            if (gerenciaSessao.relatorio().isEmpty()) {
                operacoesSessao.getBtnConsultar().setEnabled(false);
                operacoesSessao.getBtnExcluir().setEnabled(false);
                operacoesSessao.getBtnEditar().setEnabled(false);
            } else {
                operacoesSessao.getBtnConsultar().setEnabled(true);
                operacoesSessao.getBtnExcluir().setEnabled(true);
                operacoesSessao.getBtnEditar().setEnabled(true);
                operacoesSessao.getLstSessoes().setSelectedIndex(0);
            }

            tfValorSessao.setValue(null);
            tfDataSessao.setValue(null);
            tfHorarioSessao.setValue(null);
        }
    }//GEN-LAST:event_btnCadastrarSessaoActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        ComboBoxUtils.carregarComboBox(cbSalasSessao, gerenciaSala.relatorio());
        if (this.sessaoSelecionada != null) {
            cbSalasSessao.setSelectedItem(sessaoSelecionada.getSala());
        }

        ComboBoxUtils.carregarComboBox(cbFilmesSessao, gerenciaFilme.relatorio());
        if (this.sessaoSelecionada != null) {
            cbFilmesSessao.setSelectedItem(sessaoSelecionada.getFilme());
        }

        if (cbFilmesSessao.getModel().getSize() > 0
                && cbSalasSessao.getModel().getSize() > 0) {
            btnCadastrarSessao.setEnabled(true);
        }
    }//GEN-LAST:event_formAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarSessao;
    private javax.swing.JComboBox<Filme> cbFilmesSessao;
    private javax.swing.JComboBox<Sala> cbSalasSessao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbFilmes;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbSalas;
    private javax.swing.JLabel lbTituloTelaSessao;
    private javax.swing.JLabel lbValor;
    private javax.swing.JFormattedTextField tfDataSessao;
    private javax.swing.JFormattedTextField tfHorarioSessao;
    private javax.swing.JFormattedTextField tfValorSessao;
    // End of variables declaration//GEN-END:variables
}
