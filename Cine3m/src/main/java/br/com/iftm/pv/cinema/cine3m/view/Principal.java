package br.com.iftm.pv.cinema.cine3m.view;

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import br.com.iftm.pv.cinema.cine3m.config.ParametrosSistema;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaCliente;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaFilme;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaFuncionario;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSala;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSessao;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaVenda;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.model.Filme;
import br.com.iftm.pv.cinema.cine3m.model.Sala;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import br.com.iftm.pv.cinema.cine3m.model.Venda;
import br.com.iftm.pv.cinema.cine3m.util.GerenciaArquivo;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente.OperacoesCliente;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.filme.OperacoesFilme;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.funcionario.LoginFuncionario;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.funcionario.OperacoesFuncionario;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sala.OperacoesSala;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao.OperacoesSessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.CadastroVenda;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.ConsultaVenda;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.RelatorioVenda;
import br.com.iftm.pv.cinema.cine3m.view.importacoes.TelaImportacao;
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
    
    private final LoginFuncionario loginFuncionario;

    private final CadastroVenda cadastroVenda;
    private final RelatorioVenda relatorioVenda;
    private final ConsultaVenda consultaVenda;


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
    private final GerenciaVenda gerenciaVenda = new GerenciaVenda(vendas, gerenciaCliente);
    private final GerenciaSala gerenciaSala = new GerenciaSala(salas);
    private final GerenciaSessao gerenciaSessao = new GerenciaSessao(sessoes, gerenciaSala);

    public Principal() {
        initComponents();
        this.operacoesSessao = new OperacoesSessao(gerenciaSessao, gerenciaSala, gerenciaFilme);
        this.operacoesCliente = new OperacoesCliente(gerenciaCliente);
        this.operacoesFuncionario = new OperacoesFuncionario(gerenciaFuncionario,gerenciaArquivo.getAdmin());
        this.operacoesFilme = new OperacoesFilme(gerenciaFilme);
        this.operacoesSala = new OperacoesSala(gerenciaSala);
        
        this.cadastroVenda = new CadastroVenda(gerenciaVenda, gerenciaSessao, gerenciaCliente, operacoesSessao.getCadastroSessao(), operacoesCliente.getCadastroCliente());
        this.relatorioVenda = new RelatorioVenda(gerenciaVenda);
        this.consultaVenda = new ConsultaVenda(gerenciaVenda);
        this.loginFuncionario = new LoginFuncionario(gerenciaArquivo, cadastroVenda,jMenuBar1);

        
        Color corFundoPadrao = ParametrosSistema.getInstance().getCorDeFundo();
        Color corPanelPadrao = ParametrosSistema.getInstance().getCorPanel();
        this.getContentPane().setBackground(corFundoPadrao);

        this.loginFuncionario.getContentPane().setBackground(corFundoPadrao);

        this.cadastroVenda.getContentPane().setBackground(corFundoPadrao);
        this.consultaVenda.getContentPane().setBackground(corFundoPadrao);
        this.relatorioVenda.getContentPane().setBackground(corFundoPadrao);
        this.cadastroVenda.getPanelCadastroVenda().setBackground(corPanelPadrao);

        this.cadastroVenda.getPanelBotoes().setBackground(corPanelPadrao);
        this.cadastroVenda.getPanelDados().setBackground(corPanelPadrao);
        this.consultaVenda.getLstVendas().setBackground(corPanelPadrao);

        this.telaImportacao = new TelaImportacao(gerenciaFilme);

        this.telaImportacao.getContentPane().setBackground(corFundoPadrao);

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
        mVenda = new javax.swing.JMenu();
        imCadastroVenda = new javax.swing.JMenuItem();
        imConsultaVenda = new javax.swing.JMenuItem();
        imRelatorioVenda = new javax.swing.JMenuItem();
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

        mVenda.setText("Vendas");

        imCadastroVenda.setText("Cadastrar");
        imCadastroVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imCadastroVendaActionPerformed(evt);
            }
        });
        mVenda.add(imCadastroVenda);

        imConsultaVenda.setText("Consultar");
        imConsultaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imConsultaVendaActionPerformed(evt);
            }
        });
        mVenda.add(imConsultaVenda);

        imRelatorioVenda.setText("Relatorio");
        imRelatorioVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imRelatorioVendaActionPerformed(evt);
            }
        });
        mVenda.add(imRelatorioVenda);

        jMenu1.add(mVenda);

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


    private void imCadastroVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCadastroVendaActionPerformed
        jDesktopPane1.add(cadastroVenda);
        cadastroVenda.setVisible(true);
    }//GEN-LAST:event_imCadastroVendaActionPerformed

    private void imConsultaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imConsultaVendaActionPerformed
        jDesktopPane1.add(consultaVenda);
        consultaVenda.setVisible(true);
    }//GEN-LAST:event_imConsultaVendaActionPerformed

    private void imRelatorioVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imRelatorioVendaActionPerformed
        jDesktopPane1.add(relatorioVenda);
        relatorioVenda.setVisible(true);
    }//GEN-LAST:event_imRelatorioVendaActionPerformed

    private void imImportacaoFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imImportacaoFilmesActionPerformed
        jDesktopPane1.add(telaImportacao);
        telaImportacao.setVisible(true);
    }//GEN-LAST:event_imImportacaoFilmesActionPerformed

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        Integer resp = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja deslogar?",
                "Logout", WIDTH, JOptionPane.WARNING_MESSAGE);
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
        jDesktopPane1.add(operacoesCliente);
        operacoesCliente.setVisible(true);
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
    private javax.swing.JMenuItem imCadastroVenda;
    private javax.swing.JMenuItem imCliente;
    private javax.swing.JMenuItem imConsultaVenda;
    private javax.swing.JMenuItem imFilme;
    private javax.swing.JMenuItem imFuncionario;
    private javax.swing.JMenuItem imImportacaoFilmes;
    private javax.swing.JMenuItem imRelatorioVenda;
    private javax.swing.JMenuItem imSala;
    private javax.swing.JMenuItem imSessao;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mVenda;
    // End of variables declaration//GEN-END:variables
}
