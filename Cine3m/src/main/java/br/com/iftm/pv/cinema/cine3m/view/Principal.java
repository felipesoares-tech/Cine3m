package br.com.iftm.pv.cinema.cine3m.view;

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import br.com.iftm.pv.cinema.cine3m.config.ParametrosSistema;
import br.com.iftm.pv.cinema.cine3m.controller.*;
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

    private final GerenciaCliente gerenciaCliente = new GerenciaCliente();    
    private final GerenciaFuncionario gerenciaFuncionario = new GerenciaFuncionario();
    private final GerenciaSala gerenciaSala = new GerenciaSala();
    private final GerenciaFilme gerenciaFilme = new GerenciaFilme();
    private final GerenciaSessao gerenciaSessao = new GerenciaSessao(gerenciaSala,gerenciaFilme);        
    private final GerenciaVenda gerenciaVenda = new GerenciaVenda(gerenciaCliente, gerenciaSessao,gerenciaSala);

    public Principal() {
        initComponents();
        operacoesSessao = new OperacoesSessao(gerenciaSessao, gerenciaSala, gerenciaFilme);
        operacoesCliente = new OperacoesCliente(gerenciaCliente);
        operacoesFuncionario = new OperacoesFuncionario(gerenciaFuncionario);
        operacoesFilme = new OperacoesFilme(gerenciaFilme);
        operacoesSala = new OperacoesSala(gerenciaSala);
        operacoesVenda = new OperacoesVenda(gerenciaVenda,gerenciaSessao, gerenciaCliente, gerenciaSala,operacoesSessao.getCadastroSessao(), operacoesCliente.getCadastroCliente());

        this.loginFuncionario = new LoginFuncionario(operacoesVenda.getCadastroVenda(), jMenuBar1);

        Color corFundo = ParametrosSistema.getInstance().getCorDeFundo();
        Color corPanel = ParametrosSistema.getInstance().getCorPanel();
        Color transparent = ParametrosSistema.getInstance().getTransparent();
        Color corLabel = ParametrosSistema.getInstance().getCorLabel();

        operacoesCliente.getCadastroCliente().getContentPane().setBackground(corFundo);
        operacoesCliente.getCadastroCliente().getLbTitulo().setForeground(corLabel);
        operacoesCliente.getCadastroCliente().getLbNomeCliente().setForeground(corLabel);
        operacoesCliente.getCadastroCliente().getLbCpfCliente().setForeground(corLabel);
        operacoesCliente.getCadastroCliente().getjPanel8().setBackground(corPanel);
        operacoesCliente.getCadastroCliente().getContentPane().setBackground(corFundo);
        operacoesCliente.getRelatorioCliente().getContentPane().setBackground(corFundo);

        operacoesCliente.getLstClientes().setBackground(corFundo);
        operacoesCliente.getContentPane().setBackground(corFundo);
        operacoesCliente.getLstClientes().setBackground(corPanel);
        operacoesCliente.getPanelBotoes().setBackground(transparent);
        operacoesCliente.getLbTitulo().setForeground(corLabel);
        operacoesCliente.getLbPesquisar().setForeground(corLabel);

        operacoesFuncionario.getCadastroFuncionario().setBackground(corFundo);
        operacoesFuncionario.getRelatorioFuncionario().getContentPane().setBackground(corFundo);

        operacoesFuncionario.getLstFuncionarios().setBackground(corFundo);
        operacoesFuncionario.getContentPane().setBackground(corFundo);
        operacoesFuncionario.getLstFuncionarios().setBackground(corPanel);
        operacoesFuncionario.getPanelBotoes().setBackground(transparent);
        operacoesFuncionario.getLbTitulo().setForeground(corLabel);
        operacoesFuncionario.getLbPesquisar().setForeground(corLabel);

        operacoesSessao.getCadastroSessao().getContentPane().setBackground(corFundo);
        operacoesSessao.getRelatorioSessao().getContentPane().setBackground(corFundo);

        operacoesSessao.getLstSessoes().setBackground(corFundo);
        operacoesSessao.getContentPane().setBackground(corFundo);
        operacoesSessao.getLstSessoes().setBackground(corPanel);
        operacoesSessao.getPanelBotoes().setBackground(transparent);
        operacoesSessao.getLbTitulo().setForeground(corLabel);
        operacoesSessao.getLbPesquisar().setForeground(corLabel);

        operacoesSala.getCadastroSala().getContentPane().setBackground(corFundo);
        operacoesSala.getRelatorioSala().getContentPane().setBackground(corFundo);

        operacoesSala.getLstSalas().setBackground(corFundo);
        operacoesSala.getContentPane().setBackground(corFundo);
        operacoesSala.getLstSalas().setBackground(corPanel);
        operacoesSala.getPanelBotoes().setBackground(transparent);
        operacoesSala.getLbTitulo().setForeground(corLabel);
        operacoesSala.getLbPesquisar().setForeground(corLabel);

        operacoesFilme.getCadastroFilme().getContentPane().setBackground(corFundo);
        operacoesFilme.getRelatorioFilme().getContentPane().setBackground(corFundo);

        operacoesFilme.getLstFilmes().setBackground(corFundo);
        operacoesFilme.getContentPane().setBackground(corFundo);
        operacoesFilme.getLstFilmes().setBackground(corPanel);
        operacoesFilme.getPanelBotoes().setBackground(transparent);
        operacoesFilme.getLbTitulo().setForeground(corLabel);
        operacoesFilme.getLbPesquisar().setForeground(corLabel);

        operacoesVenda.getCadastroVenda().getContentPane().setBackground(corFundo);
        operacoesVenda.getRelatorioVenda().getContentPane().setBackground(corFundo);

        operacoesVenda.getCadastroVenda().getPanelBotoes().setBackground(corPanel);
        operacoesVenda.getCadastroVenda().getPanelDados().setBackground(corPanel);
        operacoesVenda.getContentPane().setBackground(corFundo);
        operacoesVenda.getPanelBotoesVenda().setBackground(transparent);
        operacoesVenda.getLbPesquisar().setForeground(corLabel);
        operacoesVenda.getLbTitulo().setForeground(corLabel);
        operacoesVenda.getLstVendas().setBackground(corPanel);

        loginFuncionario.getLbUsuario().setForeground(corLabel);
        loginFuncionario.getLbSenha().setForeground(corLabel);

        getContentPane().setBackground(corFundo);

        loginFuncionario.getContentPane().setBackground(corFundo);
        telaImportacao = new TelaImportacao(gerenciaFilme);

        telaImportacao.getContentPane().setBackground(corFundo);

        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                loginFuncionario.setBounds((jDesktopPane1.getWidth() - 350) / 2,
                        (jDesktopPane1.getHeight() - 350) / 2, 350, 350);
                jDesktopPane1.add(loginFuncionario);
                loginFuncionario.setVisible(true);
                jMenuBar1.setVisible(false);
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
