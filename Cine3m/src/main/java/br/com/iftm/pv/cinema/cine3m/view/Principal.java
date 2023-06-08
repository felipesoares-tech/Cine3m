package br.com.iftm.pv.cinema.cine3m.view;

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import br.com.iftm.pv.cinema.cine3m.config.ParametrosSistema;
import br.com.iftm.pv.cinema.cine3m.controller.*;
import br.com.iftm.pv.cinema.cine3m.model.*;
import br.com.iftm.pv.cinema.cine3m.util.GerenciaArquivo;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.filme.*;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente.*;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.funcionario.*;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sala.*;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao.*;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.*;
import br.com.iftm.pv.cinema.cine3m.view.importacoes.*;
import br.com.iftm.pv.cinema.cine3m.view.util.ValidaTela;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    private final OperacoesSessao operacoesSessao;
    private final OperacoesCliente operacoesCliente;
    private final OperacoesFuncionario operacoesFuncionario;
    private final OperacoesFilme operacoesFilme;
    private final OperacoesSala operacoesSala;
    private final OperacoesVenda operacoesVenda;

    private final LoginFuncionario loginFuncionario;
    private final TelaImportacao telaImportacao;

    List<Filme> filmes = new ArrayList<>();
    List<Sessao> sessoes = new ArrayList<>();
    List<Venda> vendas = new ArrayList<>();
    List<Sala> salas = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();

    private final GerenciaArquivo gerenciaArquivo = new GerenciaArquivo();
    private final GerenciaCliente gerenciaCliente = new GerenciaCliente(clientes);
    private final GerenciaFilme gerenciaFilme = new GerenciaFilme(filmes);
    private final GerenciaFuncionario gerenciaFuncionario = new GerenciaFuncionario(
            gerenciaArquivo.obterFuncionarios());
    private final GerenciaSala gerenciaSala = new GerenciaSala(salas);
    private final GerenciaSessao gerenciaSessao = new GerenciaSessao(sessoes, gerenciaSala);
    private final GerenciaVenda gerenciaVenda = new GerenciaVenda(vendas, gerenciaCliente, gerenciaSessao);

    public Principal() {
        initComponents();
        this.operacoesSessao = new OperacoesSessao(gerenciaSessao, gerenciaSala, gerenciaFilme);
        this.operacoesCliente = new OperacoesCliente(gerenciaCliente);
        this.operacoesFuncionario = new OperacoesFuncionario(gerenciaFuncionario, gerenciaArquivo.getAdmin());
        this.operacoesFilme = new OperacoesFilme(gerenciaFilme);
        this.operacoesSala = new OperacoesSala(gerenciaSala);
        this.operacoesVenda = new OperacoesVenda(gerenciaVenda, gerenciaSessao, gerenciaCliente, operacoesSessao.getCadastroSessao(), operacoesCliente.getCadastroCliente());

        this.loginFuncionario = new LoginFuncionario(gerenciaArquivo, operacoesVenda.getCadastroVenda(), jMenuBar1);

        Color corFundoPadrao = ParametrosSistema.getInstance().getCorDeFundo();
        Color corPanelPadrao = ParametrosSistema.getInstance().getCorPanel();

        operacoesCliente.getCadastroCliente().getContentPane().setBackground(corFundoPadrao);
        operacoesCliente.getRelatorioCliente().getContentPane().setBackground(corFundoPadrao);
        operacoesCliente.getCadastroCliente().getjPanel8().setBackground(corPanelPadrao);
        operacoesCliente.getCadastroCliente().setBackground(corPanelPadrao);
        operacoesCliente.getLstClientes().setBackground(corPanelPadrao);

        operacoesFuncionario.getCadastroFuncionario().setBackground(corFundoPadrao);
        operacoesFuncionario.getRelatorioFuncionario().getContentPane().setBackground(corFundoPadrao);

        operacoesSessao.getCadastroSessao().getContentPane().setBackground(corFundoPadrao);
        operacoesSessao.getRelatorioSessao().getContentPane().setBackground(corFundoPadrao);

        operacoesSala.getCadastroSala().getContentPane().setBackground(corFundoPadrao);
        operacoesSala.getRelatorioSala().getContentPane().setBackground(corFundoPadrao);

        operacoesFilme.getCadastroFilme().getContentPane().setBackground(corFundoPadrao);
        operacoesFilme.getRelatorioFilme().getContentPane().setBackground(corFundoPadrao);

        operacoesVenda.getCadastroVenda().getContentPane().setBackground(corFundoPadrao);
        operacoesVenda.getRelatorioVenda().getContentPane().setBackground(corFundoPadrao);
        operacoesVenda.getCadastroVenda().getPanelBotoes().setBackground(corPanelPadrao);
        operacoesVenda.getCadastroVenda().getPanelDados().setBackground(corPanelPadrao);
        operacoesVenda.getLstVendas().setBackground(corPanelPadrao);

        getContentPane().setBackground(corFundoPadrao);

        loginFuncionario.getContentPane().setBackground(corFundoPadrao);
        telaImportacao = new TelaImportacao(gerenciaFilme);

        telaImportacao.getContentPane().setBackground(corFundoPadrao);

        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                loginFuncionario.setBounds((jDesktopPane1.getWidth() - 350) / 2,
                        (jDesktopPane1.getHeight() - 350) / 2, 350, 350);
                jDesktopPane1.add(loginFuncionario);
                loginFuncionario.setVisible(true);
                jMenuBar1.setVisible(false);
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (!gerenciaFuncionario.getFuncionarios().isEmpty()) {
                    try {
                        gerenciaArquivo.adicionaUsuarios(gerenciaFuncionario.getFuncionarios());
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/principal.png"));
        Image image = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        imCliente = new javax.swing.JMenuItem();
        imFuncionario = new javax.swing.JMenuItem();
        imFilme = new javax.swing.JMenuItem();
        imSala = new javax.swing.JMenuItem();
        imSessao = new javax.swing.JMenuItem();
        imVenda = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        imImportacaoFilmes = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 944, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        jMenu1.setText("Lançamentos");

        imCliente.setText("Clientes");
        imCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imClienteActionPerformed(evt);
            }
        });
        jMenu1.add(imCliente);

        imFuncionario.setText("Funcionários");
        imFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imFuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(imFuncionario);

        imFilme.setText("Filmes");
        imFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imFilmeActionPerformed(evt);
            }
        });
        jMenu1.add(imFilme);

        imSala.setText("Salas");
        imSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imSalaActionPerformed(evt);
            }
        });
        jMenu1.add(imSala);

        imSessao.setText("Sessões");
        imSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imSessaoActionPerformed(evt);
            }
        });
        jMenu1.add(imSessao);

        imVenda.setText("Vendas");
        imVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imVendaActionPerformed(evt);
            }
        });
        jMenu1.add(imVenda);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Importações");

        imImportacaoFilmes.setText("Filmes");
        imImportacaoFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imImportacaoFilmesActionPerformed(evt);
            }
        });
        jMenu2.add(imImportacaoFilmes);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Logout");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void imImportacaoFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imImportacaoFilmesActionPerformed
        jDesktopPane1.add(telaImportacao);
        telaImportacao.setVisible(true);
    }//GEN-LAST:event_imImportacaoFilmesActionPerformed

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        Integer resp = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja deslogar?",
                "Logout", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (resp.equals(JOptionPane.OK_OPTION)) {
            try {
                gerenciaArquivo.adicionaUsuarios(gerenciaFuncionario.getFuncionarios());
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            loginFuncionario.getTfUsuario().setText("");
            loginFuncionario.getJpfSenha().setText("");
            jDesktopPane1.add(loginFuncionario);
            loginFuncionario.setBounds((jDesktopPane1.getWidth() - 350) / 2,
                    (jDesktopPane1.getHeight() - 350) / 2, 350, 350);

            loginFuncionario.setVisible(true);
            jMenuBar1.setVisible(false);
        }
    }//GEN-LAST:event_jMenu3MousePressed

    private void imClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imClienteActionPerformed
//        jDesktopPane1.add(operacoesCliente);
        //   operacoesCliente.setVisible(true);
        ValidaTela.abrirTela(operacoesCliente, jDesktopPane1);
    }//GEN-LAST:event_imClienteActionPerformed

    private void imFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imFuncionarioActionPerformed
        jDesktopPane1.add(operacoesFuncionario);
        operacoesFuncionario.setFuncionarioLogado(loginFuncionario.getFuncionarioSelecionado());
        operacoesFuncionario.setVisible(true);
    }//GEN-LAST:event_imFuncionarioActionPerformed

    private void imSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imSessaoActionPerformed
        jDesktopPane1.add(operacoesSessao);
        operacoesSessao.setVisible(true);
    }//GEN-LAST:event_imSessaoActionPerformed

    private void imFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imFilmeActionPerformed
        jDesktopPane1.add(operacoesFilme);
        operacoesFilme.setVisible(true);
    }//GEN-LAST:event_imFilmeActionPerformed

    private void imSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imSalaActionPerformed
        jDesktopPane1.add(operacoesSala);
        operacoesSala.setVisible(true);
    }//GEN-LAST:event_imSalaActionPerformed

    private void imVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imVendaActionPerformed
        jDesktopPane1.add(operacoesVenda);
        operacoesVenda.setVisible(true);
    }//GEN-LAST:event_imVendaActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem imCliente;
    private javax.swing.JMenuItem imFilme;
    private javax.swing.JMenuItem imFuncionario;
    private javax.swing.JMenuItem imImportacaoFilmes;
    private javax.swing.JMenuItem imSala;
    private javax.swing.JMenuItem imSessao;
    private javax.swing.JMenuItem imVenda;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
