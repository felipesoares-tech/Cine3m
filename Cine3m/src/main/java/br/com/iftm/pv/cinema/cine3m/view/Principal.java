/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.com.iftm.pv.cinema.cine3m.view;

import br.com.iftm.pv.cinema.cine3m.config.ParametrosSistema;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao.CadastroSessao;
import java.util.ArrayList;
import java.util.List;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaCliente;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaFilme;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaFuncionario;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaIngresso;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSala;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSessao;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.model.Filme;
import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import br.com.iftm.pv.cinema.cine3m.model.Ingresso;
import br.com.iftm.pv.cinema.cine3m.model.Sala;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente.ApagaCliente;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente.AtualizaCliente;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente.CadastroCliente;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente.ConsultaCliente;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente.RelatorioCliente;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao.ApagaSessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao.AtualizaSessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao.ConsultaSessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao.RelatorioSessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sala.*;
import java.awt.Color;

/**
 *
 * @author elisabete
 */
public class Principal extends javax.swing.JDialog {

    //Telas a serem chamadas (CRUD SESSÃO)
    CadastroSessao cadastroSessao;
    ConsultaSessao consultaSessao;
    AtualizaSessao atualizaSessao;
    ApagaSessao apagaSessao;
    RelatorioSessao relatorioSessao;
    //Telas auxiliares (CRUD SESSÃO)
//    ImprimeRelatorio imprimeRelatorio;

    //Telas a serem chamadas (CRUD CLIENTES)
    CadastroCliente cadastroCliente;
    ConsultaCliente consultaCliente;
    AtualizaCliente atualizaCliente;
    ApagaCliente apagaCliente;
    RelatorioCliente relatorioCliente;
    //Telas auxiliares (CRUD SESSÃO)

    //Telas a serem chamadas (CRUD SALA)
    CadastroSala cadastroSala;
    ConsultaSala consultaSala;
    AtualizaSala atualizaSala;
    ApagaSala apagaSala;
    RelatorioSala relatorioSala;
    //Telas a serem chamadas (CRUD INGRESSO)
    //Telas a serem chamadas (CRUD FUNCIONARIO)
    List<Filme> filmes = new ArrayList<Filme>();
    List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    List<Sessao> sessoes = new ArrayList<Sessao>();
    List<Ingresso> ingressos = new ArrayList<Ingresso>();
    List<Sala> salas = new ArrayList<Sala>();
    List<Cliente> clientes = new ArrayList<Cliente>();

    private GerenciaCliente gerenciaCliente = new GerenciaCliente(clientes);
    private GerenciaFilme gerenciaFilme = new GerenciaFilme(filmes);
    private GerenciaFuncionario gerenciaFuncionario = new GerenciaFuncionario(funcionarios);
    private GerenciaSessao gerenciaSessao = new GerenciaSessao(sessoes);
    private GerenciaIngresso gerenciaIngresso = new GerenciaIngresso(ingressos);
    private GerenciaSala gerenciaSala = new GerenciaSala(salas);

    public Principal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        //Telas a serem chamadas (CRUD SESSÃO) Instanciação
        this.cadastroSessao = new CadastroSessao(null, rootPaneCheckingEnabled, gerenciaFilme, gerenciaSala, gerenciaSessao);
        this.consultaSessao = new ConsultaSessao(null, rootPaneCheckingEnabled, cadastroSessao);
        this.atualizaSessao = new AtualizaSessao(null, rootPaneCheckingEnabled, cadastroSessao);
        this.apagaSessao = new ApagaSessao(null, rootPaneCheckingEnabled);
//        this.imprimeRelatorio = new ImprimeRelatorio(null, rootPaneCheckingEnabled); //Tela auxiliar p/ relatório
        this.relatorioSessao = new RelatorioSessao(null, rootPaneCheckingEnabled);
        //Telas a serem chamadas (CRUD CLIENTES) Instanciação
        this.cadastroCliente = new CadastroCliente(null, rootPaneCheckingEnabled, gerenciaCliente);
        this.consultaCliente = new ConsultaCliente(null, rootPaneCheckingEnabled, cadastroCliente, gerenciaCliente);
        this.atualizaCliente = new AtualizaCliente(null, rootPaneCheckingEnabled, cadastroCliente, gerenciaCliente);
        this.apagaCliente = new ApagaCliente(null, rootPaneCheckingEnabled,gerenciaCliente);
        this.relatorioCliente = new RelatorioCliente(null, rootPaneCheckingEnabled,gerenciaCliente);

        //Telas a serem chamadas (CRUD SALA)
         this.cadastroSala = new CadastroSala(null, rootPaneCheckingEnabled, gerenciaSala);
        this.consultaSala = new ConsultaSala(null, rootPaneCheckingEnabled, cadastroSala);
        this.atualizaSala = new AtualizaSala(null, rootPaneCheckingEnabled, cadastroSala);
        this.apagaSala = new ApagaSala(null, rootPaneCheckingEnabled);
//        this.imprimeRelatorio = new ImprimeRelatorio(null, rootPaneCheckingEnabled);
        this.relatorioSala = new RelatorioSala(null, rootPaneCheckingEnabled);

        //Telas a serem chamadas (CRUD INGRESSO)
        //Telas a serem chamadas (CRUD FUNCIONARIO)
        //Configurações para as telas;
        Color corFundoPadrao = ParametrosSistema.getInstance().getCorDeFundo();
        this.getContentPane().setBackground(corFundoPadrao);
        
        //CORES PARA TELAS CLIENTE
        this.cadastroCliente.getContentPane().setBackground(corFundoPadrao);
        this.consultaCliente.getContentPane().setBackground(corFundoPadrao);
        this.atualizaCliente.getContentPane().setBackground(corFundoPadrao);
        this.apagaCliente.getContentPane().setBackground(corFundoPadrao);
        this.relatorioCliente.getContentPane().setBackground(corFundoPadrao);
        
        //CORES PARA TELAS SESSAO
        this.cadastroSessao.getContentPane().setBackground(corFundoPadrao);
        this.consultaSessao.getContentPane().setBackground(corFundoPadrao);
        this.atualizaSessao.getContentPane().setBackground(corFundoPadrao);
        this.apagaSessao.getContentPane().setBackground(corFundoPadrao);
        this.relatorioSessao.getContentPane().setBackground(corFundoPadrao);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mSessao = new javax.swing.JMenu();
        imCadastroSessao = new javax.swing.JMenuItem();
        imConsultaSessao = new javax.swing.JMenuItem();
        imAtualizaSessao = new javax.swing.JMenuItem();
        imApagaSessao = new javax.swing.JMenuItem();
        imRelatorioSessao = new javax.swing.JMenuItem();
        mIngresso = new javax.swing.JMenu();
        imCadastroIngresso = new javax.swing.JMenuItem();
        imConsultaIngresso = new javax.swing.JMenuItem();
        imAtualizaIngresso = new javax.swing.JMenuItem();
        imApagaIngresso = new javax.swing.JMenuItem();
        imRelatorioIngresso = new javax.swing.JMenuItem();
        mFilme = new javax.swing.JMenu();
        imCadastroFilme = new javax.swing.JMenuItem();
        imConsultaFilme = new javax.swing.JMenuItem();
        imAtualizaFilme = new javax.swing.JMenuItem();
        imApagaFilme = new javax.swing.JMenuItem();
        imRelatorioFilme = new javax.swing.JMenuItem();
        mSala = new javax.swing.JMenu();
        imCadastroSala = new javax.swing.JMenuItem();
        imConsultaSala = new javax.swing.JMenuItem();
        imAtualizaSala = new javax.swing.JMenuItem();
        imApagaSala = new javax.swing.JMenuItem();
        imRelatorioSala = new javax.swing.JMenuItem();
        mFuncionario = new javax.swing.JMenu();
        imCadastroFuncionario = new javax.swing.JMenuItem();
        imConsultaFuncionario = new javax.swing.JMenuItem();
        imAtualizaFuncionario = new javax.swing.JMenuItem();
        imApagaFuncionario = new javax.swing.JMenuItem();
        imRelatorioFuncionario = new javax.swing.JMenuItem();
        mCliente = new javax.swing.JMenu();
        imCadastraCliente = new javax.swing.JMenuItem();
        imConsultaCliente = new javax.swing.JMenuItem();
        imAtualizaCliente = new javax.swing.JMenuItem();
        imApagaCliente = new javax.swing.JMenuItem();
        imRelatorioCliente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("P052", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cine 3M");

        jMenu1.setMnemonic('L');
        jMenu1.setText("Lançamentos");

        mSessao.setMnemonic('S');
        mSessao.setText("Sessão");

        imCadastroSessao.setText("Cadastrar");
        imCadastroSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imCadastroSessaoActionPerformed(evt);
            }
        });
        mSessao.add(imCadastroSessao);

        imConsultaSessao.setText("Consultar");
        imConsultaSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imConsultaSessaoActionPerformed(evt);
            }
        });
        mSessao.add(imConsultaSessao);

        imAtualizaSessao.setText("Atualizar");
        imAtualizaSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imAtualizaSessaoActionPerformed(evt);
            }
        });
        mSessao.add(imAtualizaSessao);

        imApagaSessao.setText("Apagar");
        imApagaSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imApagaSessaoActionPerformed(evt);
            }
        });
        mSessao.add(imApagaSessao);

        imRelatorioSessao.setText("Relatório");
        imRelatorioSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imRelatorioSessaoActionPerformed(evt);
            }
        });
        mSessao.add(imRelatorioSessao);

        jMenu1.add(mSessao);

        mIngresso.setMnemonic('I');
        mIngresso.setText("Ingresso");

        imCadastroIngresso.setText("Cadastrar");
        mIngresso.add(imCadastroIngresso);

        imConsultaIngresso.setText("Consultar");
        mIngresso.add(imConsultaIngresso);

        imAtualizaIngresso.setText("Atualizar");
        mIngresso.add(imAtualizaIngresso);

        imApagaIngresso.setText("Apagar");
        mIngresso.add(imApagaIngresso);

        imRelatorioIngresso.setText("Relatório");
        mIngresso.add(imRelatorioIngresso);

        jMenu1.add(mIngresso);

        mFilme.setMnemonic('F');
        mFilme.setText("Filme");

        imCadastroFilme.setText("Cadastrar");
        mFilme.add(imCadastroFilme);

        imConsultaFilme.setText("Consultar");
        mFilme.add(imConsultaFilme);

        imAtualizaFilme.setText("Atualizar");
        mFilme.add(imAtualizaFilme);

        imApagaFilme.setText("Apagar");
        mFilme.add(imApagaFilme);

        imRelatorioFilme.setText("Relatório");
        mFilme.add(imRelatorioFilme);

        jMenu1.add(mFilme);

        mSala.setMnemonic('a');
        mSala.setText("Sala");
        mSala.setToolTipText("");

        imCadastroSala.setText("Cadastrar");
        imCadastroSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imCadastroSalaActionPerformed(evt);
            }
        });
        mSala.add(imCadastroSala);

        imConsultaSala.setText("Consultar");
        imConsultaSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imConsultaSalaActionPerformed(evt);
            }
        });
        mSala.add(imConsultaSala);

        imAtualizaSala.setText("Atualizar");
        imAtualizaSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imAtualizaSalaActionPerformed(evt);
            }
        });
        mSala.add(imAtualizaSala);

        imApagaSala.setText("Apagar");
        imApagaSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imApagaSalaActionPerformed(evt);
            }
        });
        mSala.add(imApagaSala);

        imRelatorioSala.setText("Relatório");
        imRelatorioSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imRelatorioSalaActionPerformed(evt);
            }
        });
        mSala.add(imRelatorioSala);

        jMenu1.add(mSala);

        mFuncionario.setMnemonic('F');
        mFuncionario.setText("Funcionario");

        imCadastroFuncionario.setText("Cadastrar");
        mFuncionario.add(imCadastroFuncionario);

        imConsultaFuncionario.setText("Consultar");
        mFuncionario.add(imConsultaFuncionario);

        imAtualizaFuncionario.setText("Atualizar");
        mFuncionario.add(imAtualizaFuncionario);

        imApagaFuncionario.setText("Apagar");
        mFuncionario.add(imApagaFuncionario);

        imRelatorioFuncionario.setText("Relatório");
        mFuncionario.add(imRelatorioFuncionario);

        jMenu1.add(mFuncionario);

        mCliente.setMnemonic('C');
        mCliente.setText("Cliente");

        imCadastraCliente.setText("Cadastrar");
        imCadastraCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imCadastraClienteActionPerformed(evt);
            }
        });
        mCliente.add(imCadastraCliente);

        imConsultaCliente.setText("Consultar");
        imConsultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imConsultaClienteActionPerformed(evt);
            }
        });
        mCliente.add(imConsultaCliente);

        imAtualizaCliente.setText("Atualizar");
        imAtualizaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imAtualizaClienteActionPerformed(evt);
            }
        });
        mCliente.add(imAtualizaCliente);

        imApagaCliente.setText("Apagar");
        imApagaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imApagaClienteActionPerformed(evt);
            }
        });
        mCliente.add(imApagaCliente);

        imRelatorioCliente.setText("Relatório");
        imRelatorioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imRelatorioClienteActionPerformed(evt);
            }
        });
        mCliente.add(imRelatorioCliente);

        jMenu1.add(mCliente);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(373, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(284, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imCadastroSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCadastroSessaoActionPerformed
        this.cadastroSessao.setVisible(true);
    }//GEN-LAST:event_imCadastroSessaoActionPerformed

    private void imConsultaSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imConsultaSessaoActionPerformed
        this.consultaSessao.setVisible(true);
    }//GEN-LAST:event_imConsultaSessaoActionPerformed

    private void imAtualizaSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imAtualizaSessaoActionPerformed
        this.atualizaSessao.setVisible(true);
    }//GEN-LAST:event_imAtualizaSessaoActionPerformed

    private void imApagaSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imApagaSessaoActionPerformed
        this.apagaSessao.setVisible(true);
    }//GEN-LAST:event_imApagaSessaoActionPerformed

    private void imRelatorioSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imRelatorioSessaoActionPerformed
        this.relatorioSessao.setVisible(true);
    }//GEN-LAST:event_imRelatorioSessaoActionPerformed

    private void imCadastraClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCadastraClienteActionPerformed
        this.cadastroCliente.getBtnCadastrarCliente().setVisible(true);
        this.cadastroCliente.getBtnCadastrarCliente().setText("Cadastrar");
        this.cadastroCliente.getTfNomeCliente().setEditable(true);
        this.cadastroCliente.getTfCpfCliente().setEditable(true);
        this.cadastroCliente.setVisible(true);
    }//GEN-LAST:event_imCadastraClienteActionPerformed

    private void imConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imConsultaClienteActionPerformed
        this.consultaCliente.setVisible(true);
    }//GEN-LAST:event_imConsultaClienteActionPerformed

    private void imAtualizaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imAtualizaClienteActionPerformed
        this.atualizaCliente.setVisible(true);
    }//GEN-LAST:event_imAtualizaClienteActionPerformed

    private void imApagaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imApagaClienteActionPerformed
        this.apagaCliente.setVisible(true);
    }//GEN-LAST:event_imApagaClienteActionPerformed

    private void imRelatorioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imRelatorioClienteActionPerformed
        this.relatorioCliente.setVisible(true);
    }//GEN-LAST:event_imRelatorioClienteActionPerformed

    private void imCadastroSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCadastroSalaActionPerformed
        this.cadastroSala.setVisible(true);
    }//GEN-LAST:event_imCadastroSalaActionPerformed

    private void imConsultaSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imConsultaSalaActionPerformed
        this.consultaSala.setVisible(true);
    }//GEN-LAST:event_imConsultaSalaActionPerformed

    private void imAtualizaSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imAtualizaSalaActionPerformed
       this.atualizaSala.setVisible(true);
    }//GEN-LAST:event_imAtualizaSalaActionPerformed

    private void imApagaSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imApagaSalaActionPerformed
    this.apagaSala.setVisible(true);
    }//GEN-LAST:event_imApagaSalaActionPerformed

    private void imRelatorioSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imRelatorioSalaActionPerformed
    this.relatorioSala.setVisible(true);
    }//GEN-LAST:event_imRelatorioSalaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal dialog = new Principal(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem imApagaCliente;
    private javax.swing.JMenuItem imApagaFilme;
    private javax.swing.JMenuItem imApagaFuncionario;
    private javax.swing.JMenuItem imApagaIngresso;
    private javax.swing.JMenuItem imApagaSala;
    private javax.swing.JMenuItem imApagaSessao;
    private javax.swing.JMenuItem imAtualizaCliente;
    private javax.swing.JMenuItem imAtualizaFilme;
    private javax.swing.JMenuItem imAtualizaFuncionario;
    private javax.swing.JMenuItem imAtualizaIngresso;
    private javax.swing.JMenuItem imAtualizaSala;
    private javax.swing.JMenuItem imAtualizaSessao;
    private javax.swing.JMenuItem imCadastraCliente;
    private javax.swing.JMenuItem imCadastroFilme;
    private javax.swing.JMenuItem imCadastroFuncionario;
    private javax.swing.JMenuItem imCadastroIngresso;
    private javax.swing.JMenuItem imCadastroSala;
    private javax.swing.JMenuItem imCadastroSessao;
    private javax.swing.JMenuItem imConsultaCliente;
    private javax.swing.JMenuItem imConsultaFilme;
    private javax.swing.JMenuItem imConsultaFuncionario;
    private javax.swing.JMenuItem imConsultaIngresso;
    private javax.swing.JMenuItem imConsultaSala;
    private javax.swing.JMenuItem imConsultaSessao;
    private javax.swing.JMenuItem imRelatorioCliente;
    private javax.swing.JMenuItem imRelatorioFilme;
    private javax.swing.JMenuItem imRelatorioFuncionario;
    private javax.swing.JMenuItem imRelatorioIngresso;
    private javax.swing.JMenuItem imRelatorioSala;
    private javax.swing.JMenuItem imRelatorioSessao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mCliente;
    private javax.swing.JMenu mFilme;
    private javax.swing.JMenu mFuncionario;
    private javax.swing.JMenu mIngresso;
    private javax.swing.JMenu mSala;
    private javax.swing.JMenu mSessao;
    // End of variables declaration//GEN-END:variables
}
