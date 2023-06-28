package br.com.iftm.pv.cinema.cine3m.view.gerenciamento.filme;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaFilme;
import br.com.iftm.pv.cinema.cine3m.enums.EnumHoras;
import br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes;
import static br.com.iftm.pv.cinema.cine3m.enums.EnumValidacoes.FILME_JA_CADASTRADO;
import br.com.iftm.pv.cinema.cine3m.enums.EstadoAtual;
import br.com.iftm.pv.cinema.cine3m.enums.Genero;
import br.com.iftm.pv.cinema.cine3m.model.Filme;
import br.com.iftm.pv.cinema.cine3m.view.util.ComboBoxUtils;
import br.com.iftm.pv.cinema.cine3m.view.util.ListUtils;
import br.com.iftm.pv.cinema.cine3m.view.util.ModalInternalFrame;
import br.com.iftm.pv.cinema.cine3m.view.util.ValidaCampo;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CadastroFilme extends ModalInternalFrame {

    private final GerenciaFilme gerenciaFilme;
    private Filme filmeSelecionado;
    private final OperacoesFilme operacoesFilme;
    private EstadoAtual estadoAtual;
    private EnumHoras enumHoras;

    public CadastroFilme(GerenciaFilme gerenciaFilme, OperacoesFilme operacoesFilme) {
        initComponents();
        this.gerenciaFilme = gerenciaFilme;
        this.operacoesFilme = operacoesFilme;

    }

    public Filme getFilmeSelecionado() {
        return filmeSelecionado;
    }

    public EstadoAtual getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(EstadoAtual estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public void setFilmeSelecionado(Filme filmeSelecionado) {
        this.filmeSelecionado = filmeSelecionado;
    }

    public JButton getBtnConfirmar() {
        return btnCadastrarFilme;
    }

    public void setBtnConfirmar(JButton btnConfirmar) {
        this.btnCadastrarFilme = btnConfirmar;
    }

    public JComboBox<Genero> getCbGenero() {
        return cbGenero;
    }

    public void setCbGenero(JComboBox<Genero> cbGenero) {
        this.cbGenero = cbGenero;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLbDescricao() {
        return lbDescricao;
    }

    public void setLbDescricao(JLabel lbDescricao) {
        this.lbDescricao = lbDescricao;
    }

    public JLabel getLbDiretor() {
        return lbDiretor;
    }

    public void setLbDiretor(JLabel lbDiretor) {
        this.lbDiretor = lbDiretor;
    }

    public JLabel getLbGenero() {
        return lbGenero;
    }

    public void setLbGenero(JLabel lbGenero) {
        this.lbGenero = lbGenero;
    }

    public JLabel getLbNome() {
        return lbNome;
    }

    public void setLbNome(JLabel lbNome) {
        this.lbNome = lbNome;
    }

    public JLabel getLbTituloTelaFilme() {
        return lbTituloTelaFilme;
    }

    public void setLbTituloTelaFilme(JLabel lbTituloTelaFilme) {
        this.lbTituloTelaFilme = lbTituloTelaFilme;
    }

    public JTextField getTfDiretor() {
        return tfDiretor;
    }

    public void setTfDiretor(JTextField tfDiretor) {
        this.tfDiretor = tfDiretor;
    }

    public JTextField getTfNomeFilme() {
        return tfNomeFilme;
    }

    public void setTfNomeFilme(JTextField tfNomeFilme) {
        this.tfNomeFilme = tfNomeFilme;
    }

    public JTextArea getTfaDescricao() {
        return tfaDescricao;
    }

    public void setTfaDescricao(JTextArea tfaDescricao) {
        this.tfaDescricao = tfaDescricao;
    }

    public JFormattedTextField getTfDuracaoFilme() {
        return tfDuracaoFilme;
    }

    public void setTfDuracaoFilme(JFormattedTextField tfDuracaoFilme) {
        this.tfDuracaoFilme = tfDuracaoFilme;
    }

    private void limpaCampos() {
        tfNomeFilme.setText("");
        tfDiretor.setText("");
        tfaDescricao.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfaDescricao = new javax.swing.JTextArea();
        lbGenero = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
        lbDescricao = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        tfNomeFilme = new javax.swing.JTextField();
        tfDiretor = new javax.swing.JTextField();
        lbDiretor = new javax.swing.JLabel();
        btnCadastrarFilme = new javax.swing.JButton();
        lbDuracao = new javax.swing.JLabel();
        tfDuracaoFilme = new javax.swing.JFormattedTextField();
        lbTituloTelaFilme = new javax.swing.JLabel();

        setClosable(true);

        tfaDescricao.setColumns(20);
        tfaDescricao.setRows(5);
        jScrollPane1.setViewportView(tfaDescricao);

        lbGenero.setForeground(new java.awt.Color(51, 51, 51));
        lbGenero.setText("Genero");

        cbGenero.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbGeneroAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lbDescricao.setForeground(new java.awt.Color(51, 51, 51));
        lbDescricao.setText("Descrição");

        lbNome.setForeground(new java.awt.Color(51, 51, 51));
        lbNome.setText("Nome");

        lbDiretor.setForeground(new java.awt.Color(51, 51, 51));
        lbDiretor.setText("Diretor");

        btnCadastrarFilme.setText("CADASTRAR");
        btnCadastrarFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFilmeActionPerformed(evt);
            }
        });

        lbDuracao.setText("Duracao");

        try {
            tfDuracaoFilme.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfNomeFilme)
            .addComponent(lbNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbDiretor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tfDiretor)
            .addComponent(cbGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbGenero)
                .addGap(0, 422, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(btnCadastrarFilme))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbDuracao)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(tfDuracaoFilme)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfNomeFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDiretor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbGenero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDuracao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDuracaoFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lbDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrarFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbTituloTelaFilme.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbTituloTelaFilme.setForeground(new java.awt.Color(204, 204, 204));
        lbTituloTelaFilme.setText("Cadastro de filmes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTituloTelaFilme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbTituloTelaFilme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbGeneroAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbGeneroAncestorAdded
        List<Genero> listaGeneros = Arrays.asList(Genero.values());
        ComboBoxUtils.carregarComboBox(cbGenero, listaGeneros);
        if (filmeSelecionado != null) {
            cbGenero.setSelectedItem(filmeSelecionado.getGenero());
        }
    }//GEN-LAST:event_cbGeneroAncestorAdded
    private void exibeMensagemValidacao(EnumValidacoes tipoRetorno) {
        String titulo = estadoAtual.equals(EstadoAtual.CADASTRANDO) ? "Cadastro Filme" : "Atualização Filme";
        String mensagemSucesso = estadoAtual.equals(EstadoAtual.CADASTRANDO) ? "Filme cadastrado com sucesso" : "Filme atualizado com sucesso";
        switch (tipoRetorno) {
            case FILME_SUCESSO:
                JOptionPane.showMessageDialog(this, mensagemSucesso, titulo,
                        JOptionPane.INFORMATION_MESSAGE);
                limpaCampos();
                break;
            case FILME_VINCULADO_SESSAO:
                JOptionPane.showMessageDialog(this, "Não foi possível atualizar, filme já vinculado a uma sessão!",
                        "Remover", JOptionPane.ERROR_MESSAGE);
            case FILME_JA_CADASTRADO:
                JOptionPane.showMessageDialog(this, "Filme já cadastrado ", titulo,
                        JOptionPane.ERROR_MESSAGE);
                break;
            default:
                throw new AssertionError();
        }
    }
    private void btnCadastrarFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFilmeActionPerformed
        String nome = tfNomeFilme.getText();
        String diretor = tfDiretor.getText();
        String descricao = tfaDescricao.getText();
        Genero genero = (Genero) cbGenero.getSelectedItem();
        String duracaoSessao = tfDuracaoFilme.getText();
        
        if(Integer.parseInt(duracaoSessao.replaceAll("[:]", "")) <= 5){
                    if (ValidaCampo.validar(nome, lbNome, this)
                && ValidaCampo.validar(diretor, lbDiretor, this)
                && ValidaCampo.validar(descricao, lbDescricao, this)
                && ValidaCampo.validar(duracaoSessao.replaceAll("[:]", "").trim(), lbDuracao, this)) {

            LocalTime duracao;

            try {
                duracao = LocalTime.parse(duracaoSessao, DateTimeFormatter.ofPattern("HH:mm"));
            } catch (DateTimeException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Filme filme = new Filme(genero, nome, descricao, diretor, duracao);

            if (estadoAtual.equals(EstadoAtual.CADASTRANDO)) {
                exibeMensagemValidacao(gerenciaFilme.cadastrar(filme));
            } else {
                EnumValidacoes retornoValidacao = gerenciaFilme.atualizar(filmeSelecionado, filme);
                exibeMensagemValidacao(retornoValidacao);
                if (retornoValidacao.equals(EnumValidacoes.FILME_SUCESSO)) {
                    limpaCampos();
                    setVisible(false);
                    getDesktopPane().remove(this);

                }
            }
            ListUtils.carregarList(operacoesFilme.getLstFilmes(), gerenciaFilme.relatorio());
            if (gerenciaFilme.relatorio().isEmpty()) {
                operacoesFilme.getBtnConsultar().setEnabled(false);
                operacoesFilme.getBtnExcluir().setEnabled(false);
                operacoesFilme.getBtnEditar().setEnabled(false);
            } else {
                operacoesFilme.getBtnConsultar().setEnabled(true);
                operacoesFilme.getBtnExcluir().setEnabled(true);
                operacoesFilme.getBtnEditar().setEnabled(true);
                operacoesFilme.getLstFilmes().setSelectedIndex(0);
            }
        }
        } else
            JOptionPane.showMessageDialog(this, "Filme não pode ultrapassar 5 horas.", "Erro", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnCadastrarFilmeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarFilme;
    private javax.swing.JComboBox<Genero> cbGenero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbDiretor;
    private javax.swing.JLabel lbDuracao;
    private javax.swing.JLabel lbGenero;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbTituloTelaFilme;
    private javax.swing.JTextField tfDiretor;
    private javax.swing.JFormattedTextField tfDuracaoFilme;
    private javax.swing.JTextField tfNomeFilme;
    private javax.swing.JTextArea tfaDescricao;
    // End of variables declaration//GEN-END:variables
}
