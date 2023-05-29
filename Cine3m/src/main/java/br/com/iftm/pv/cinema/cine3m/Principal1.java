/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.iftm.pv.cinema.cine3m;

import br.com.iftm.pv.cinema.cine3m.config.ParametrosSistema;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaCliente;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaFilme;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaFuncionario;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSala;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSessao;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaVenda;
import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.model.Filme;
import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import br.com.iftm.pv.cinema.cine3m.model.Sala;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import br.com.iftm.pv.cinema.cine3m.model.Venda;
import br.com.iftm.pv.cinema.cine3m.util.GerenciaArquivo;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente.ApagarCliente;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente.AtualizaCliente;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente.CadastroCliente;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente.ConsultaCliente;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.cliente.RelatorioCliente;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.filme.ApagaFilme;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.filme.AtualizaFilme;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.filme.CadastroFilme;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.filme.ConsultaFilme;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.filme.RelatorioFilme;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.funcionario.ApagaFuncionario;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.funcionario.AtualizaFuncionario;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.funcionario.CadastroFuncionario;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.funcionario.ConsultaFuncionario;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.funcionario.LoginFuncionario;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.funcionario.RelatorioFuncionario;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sala.ApagaSala;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sala.AtualizaSala;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sala.CadastroSala;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sala.ConsultaSala;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sala.RelatorioSala;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao.ApagaSessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao.AtualizaSessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao.CadastroSessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao.ConsultaSessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.sessao.RelatorioSessao;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.CadastroVenda;
import br.com.iftm.pv.cinema.cine3m.view.importacoes.TelaImportacao;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elisabete
 */
public class Principal1 extends javax.swing.JFrame {

//Telas a serem chamadas (CRUD SESSAO)
    private CadastroSessao cadastroSessao;
    private ConsultaSessao consultaSessao;
    private AtualizaSessao atualizaSessao;
    private ApagaSessao apagaSessao;
    private RelatorioSessao relatorioSessao;

//Telas a serem chamadas (CRUD CLIENTES)
    private CadastroCliente cadastroCliente;
    private ConsultaCliente consultaCliente;
    private AtualizaCliente atualizaCliente;
    private ApagarCliente apagaCliente;
    private RelatorioCliente relatorioCliente;

//Telas a serem chamadas (CRUD FUNCIONARIOS)
    private CadastroFuncionario cadastroFuncionario;
    private ConsultaFuncionario consultaFuncionario;
    private AtualizaFuncionario atualizaFuncionario;
    private ApagaFuncionario apagaFuncionario;
    private RelatorioFuncionario relatorioFuncionario;
    private LoginFuncionario loginFuncionario;

//Telas a serem chamadas (CRUD SALA)
    private CadastroSala cadastroSala;
    private ConsultaSala consultaSala;
    private AtualizaSala atualizaSala;
    private ApagaSala apagaSala;
    private RelatorioSala relatorioSala;

//Telas a serem chamadas (CRUD VENDAS)
    private CadastroVenda cadastroVenda;

//Telas a serem chamadas (CRUD FILMES)
    private CadastroFilme cadastroFilme;
    private ConsultaFilme consultaFilme;
    private AtualizaFilme atualizaFilme;
    private ApagaFilme apagaFilme;
    private RelatorioFilme relatorioFilme;

    private TelaImportacao telaImportacao;

    List<Filme> filmes = new ArrayList<Filme>();
    List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    List<Sessao> sessoes = new ArrayList<Sessao>();
    List<Venda> vendas = new ArrayList<Venda>();
    List<Sala> salas = new ArrayList<Sala>();
    List<Cliente> clientes = new ArrayList<Cliente>();

    private final GerenciaArquivo gerenciaArquivo = new GerenciaArquivo();
    private final GerenciaCliente gerenciaCliente = new GerenciaCliente(clientes);
    private final GerenciaFilme gerenciaFilme = new GerenciaFilme(filmes);
    private final GerenciaFuncionario gerenciaFuncionario = new GerenciaFuncionario(funcionarios);
    private final GerenciaVenda gerenciaVenda = new GerenciaVenda(vendas);
    private final GerenciaSala gerenciaSala = new GerenciaSala(salas);
    private final GerenciaSessao gerenciaSessao = new GerenciaSessao(sessoes, gerenciaSala);

    public Principal1() {
        initComponents();
        //Telas a serem chamadas (CRUD SESSÃO) Instanciação
        this.cadastroSessao = new CadastroSessao(gerenciaSessao, gerenciaSala, gerenciaFilme);
        this.consultaSessao = new ConsultaSessao(cadastroSessao, gerenciaSessao);
        this.atualizaSessao = new AtualizaSessao(cadastroSessao, gerenciaSessao);
        this.apagaSessao = new ApagaSessao(gerenciaSessao);
        this.relatorioSessao = new RelatorioSessao(gerenciaSessao);

        //Telas a serem chamadas (CRUD CLIENTES) Instanciação
        this.cadastroCliente = new CadastroCliente(gerenciaCliente);
        this.consultaCliente = new ConsultaCliente(cadastroCliente, gerenciaCliente);
        this.atualizaCliente = new AtualizaCliente(cadastroCliente, gerenciaCliente);
        this.apagaCliente = new ApagarCliente(gerenciaCliente);
        this.relatorioCliente = new RelatorioCliente(gerenciaCliente);

        //Telas a serem chamadas (CRUD FUNCIONARIOS) Instanciação
        this.cadastroFuncionario = new CadastroFuncionario(gerenciaFuncionario);
        this.consultaFuncionario = new ConsultaFuncionario(cadastroFuncionario, gerenciaFuncionario);
        this.atualizaFuncionario = new AtualizaFuncionario(cadastroFuncionario, gerenciaFuncionario);
        this.apagaFuncionario = new ApagaFuncionario(gerenciaFuncionario);
        this.relatorioFuncionario = new RelatorioFuncionario(gerenciaFuncionario);
        this.loginFuncionario = new LoginFuncionario(gerenciaArquivo);

        //Telas a serem chamadas (CRUD SALA)
        this.cadastroSala = new CadastroSala(gerenciaSala);
        this.consultaSala = new ConsultaSala(cadastroSala, gerenciaSala);
        this.atualizaSala = new AtualizaSala(cadastroSala, gerenciaSala);
        this.apagaSala = new ApagaSala(gerenciaSala);
        this.relatorioSala = new RelatorioSala(gerenciaSala);

        //Telas a serem chamadas (CRUD VENDAS)
        this.cadastroVenda = new CadastroVenda(gerenciaVenda, gerenciaSessao, cadastroSessao);

        //Telas a serem chamadas (CRUD FILMES)
        this.cadastroFilme = new CadastroFilme(gerenciaFilme);
        this.consultaFilme = new ConsultaFilme(cadastroFilme, gerenciaFilme);
        this.atualizaFilme = new AtualizaFilme(cadastroFilme, gerenciaFilme);
        this.apagaFilme = new ApagaFilme(gerenciaFilme);
        this.relatorioFilme = new RelatorioFilme(gerenciaFilme);

        //Configurações para as telas;
        Color corFundoPadrao = ParametrosSistema.getInstance().getCorDeFundo();
        this.getContentPane().setBackground(corFundoPadrao);

        //CORES PARA TELAS CLIENTE
        this.cadastroCliente.getContentPane().setBackground(corFundoPadrao);
        this.consultaCliente.getContentPane().setBackground(corFundoPadrao);
        this.atualizaCliente.getContentPane().setBackground(corFundoPadrao);
        this.apagaCliente.getContentPane().setBackground(corFundoPadrao);
        this.relatorioCliente.getContentPane().setBackground(corFundoPadrao);

        //CORES PARA TELAS FUNCIONARIO
        this.cadastroFuncionario.getContentPane().setBackground(corFundoPadrao);
        this.consultaFuncionario.getContentPane().setBackground(corFundoPadrao);
        this.apagaFuncionario.getContentPane().setBackground(corFundoPadrao);
        this.atualizaFuncionario.getContentPane().setBackground(corFundoPadrao);
        this.relatorioFuncionario.getContentPane().setBackground(corFundoPadrao);
        this.loginFuncionario.getContentPane().setBackground(corFundoPadrao);

        //CORES PARA TELAS SESSAO
        this.cadastroSessao.getContentPane().setBackground(corFundoPadrao);
        this.consultaSessao.getContentPane().setBackground(corFundoPadrao);
        this.atualizaSessao.getContentPane().setBackground(corFundoPadrao);
        this.apagaSessao.getContentPane().setBackground(corFundoPadrao);
        this.relatorioSessao.getContentPane().setBackground(corFundoPadrao);

        //CORES PARA TELAS SALA
        this.cadastroSala.getContentPane().setBackground(corFundoPadrao);
        this.consultaSala.getContentPane().setBackground(corFundoPadrao);
        this.atualizaSala.getContentPane().setBackground(corFundoPadrao);
        this.apagaSala.getContentPane().setBackground(corFundoPadrao);
        this.relatorioSala.getContentPane().setBackground(corFundoPadrao);

        //CORES PARA TELAS FILME
        this.cadastroFilme.getContentPane().setBackground(corFundoPadrao);
        this.consultaFilme.getContentPane().setBackground(corFundoPadrao);
        this.atualizaFilme.getContentPane().setBackground(corFundoPadrao);
        this.apagaFilme.getContentPane().setBackground(corFundoPadrao);
        this.relatorioFilme.getContentPane().setBackground(corFundoPadrao);

        this.telaImportacao = new TelaImportacao(gerenciaFilme);

        //TELA LOGIN
        loginFuncionario.setBounds((jDesktopPane1.getWidth() - 350) / 2,
                (jDesktopPane1.getHeight() - 350) / 2, 350, 350);
        jDesktopPane1.add(loginFuncionario);
        loginFuncionario.setVisible(true);
        jMenuBar1.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mCliente = new javax.swing.JMenu();
        imCadastroCliente = new javax.swing.JMenuItem();
        imConsultaCliente = new javax.swing.JMenuItem();
        imAtualizaCliente = new javax.swing.JMenuItem();
        imApagaCliente = new javax.swing.JMenuItem();
        imRelatorioCliente = new javax.swing.JMenuItem();
        mFuncionario = new javax.swing.JMenu();
        imCadastroFuncionario = new javax.swing.JMenuItem();
        imConsultaFuncionario = new javax.swing.JMenuItem();
        imAtualizaFuncionario = new javax.swing.JMenuItem();
        imApagaFuncionario = new javax.swing.JMenuItem();
        imRelatorioFuncionario = new javax.swing.JMenuItem();
        mFilme = new javax.swing.JMenu();
        imCadastroFilme = new javax.swing.JMenuItem();
        imConsultaFilme = new javax.swing.JMenuItem();
        imAtualizaFilme = new javax.swing.JMenuItem();
        imApagarFilme = new javax.swing.JMenuItem();
        imRelatorioFilme = new javax.swing.JMenuItem();
        mSala = new javax.swing.JMenu();
        imCadastroSala = new javax.swing.JMenuItem();
        imConsultaSala = new javax.swing.JMenuItem();
        imAtualizaSala = new javax.swing.JMenuItem();
        imApagaSala = new javax.swing.JMenuItem();
        imRelatorioSala = new javax.swing.JMenuItem();
        mSessao = new javax.swing.JMenu();
        imCadastroSessao = new javax.swing.JMenuItem();
        imConsultaSessao = new javax.swing.JMenuItem();
        imatualizaSessao = new javax.swing.JMenuItem();
        imApagaSessao = new javax.swing.JMenuItem();
        imRelatorioSessao = new javax.swing.JMenuItem();
        mVenda = new javax.swing.JMenu();
        imCadastroVenda = new javax.swing.JMenuItem();
        imConsultaVenda = new javax.swing.JMenuItem();
        imRelatorioVenda = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

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

        mCliente.setText("Cliente");

        imCadastroCliente.setText("Cadastrar");
        imCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imCadastroClienteActionPerformed(evt);
            }
        });
        mCliente.add(imCadastroCliente);

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

        imRelatorioCliente.setText("Relatorio");
        imRelatorioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imRelatorioClienteActionPerformed(evt);
            }
        });
        mCliente.add(imRelatorioCliente);

        jMenu1.add(mCliente);

        mFuncionario.setText("Funcionrio");

        imCadastroFuncionario.setText("Cadastrar");
        imCadastroFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imCadastroFuncionarioActionPerformed(evt);
            }
        });
        mFuncionario.add(imCadastroFuncionario);

        imConsultaFuncionario.setText("Consultar");
        imConsultaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imConsultaFuncionarioActionPerformed(evt);
            }
        });
        mFuncionario.add(imConsultaFuncionario);

        imAtualizaFuncionario.setText("Atualizar");
        imAtualizaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imAtualizaFuncionarioActionPerformed(evt);
            }
        });
        mFuncionario.add(imAtualizaFuncionario);

        imApagaFuncionario.setText("Apagar");
        imApagaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imApagaFuncionarioActionPerformed(evt);
            }
        });
        mFuncionario.add(imApagaFuncionario);

        imRelatorioFuncionario.setText("Relatorio");
        imRelatorioFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imRelatorioFuncionarioActionPerformed(evt);
            }
        });
        mFuncionario.add(imRelatorioFuncionario);

        jMenu1.add(mFuncionario);

        mFilme.setText("Filme");

        imCadastroFilme.setText("Cadastrar");
        imCadastroFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imCadastroFilmeActionPerformed(evt);
            }
        });
        mFilme.add(imCadastroFilme);

        imConsultaFilme.setText("Consultar");
        imConsultaFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imConsultaFilmeActionPerformed(evt);
            }
        });
        mFilme.add(imConsultaFilme);

        imAtualizaFilme.setText("Atualizar");
        imAtualizaFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imAtualizaFilmeActionPerformed(evt);
            }
        });
        mFilme.add(imAtualizaFilme);

        imApagarFilme.setText("Apagar");
        imApagarFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imApagarFilmeActionPerformed(evt);
            }
        });
        mFilme.add(imApagarFilme);

        imRelatorioFilme.setText("Relatorio");
        imRelatorioFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imRelatorioFilmeActionPerformed(evt);
            }
        });
        mFilme.add(imRelatorioFilme);

        jMenu1.add(mFilme);

        mSala.setText("Sala");

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

        imRelatorioSala.setText("Relatorio");
        imRelatorioSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imRelatorioSalaActionPerformed(evt);
            }
        });
        mSala.add(imRelatorioSala);

        jMenu1.add(mSala);

        mSessao.setText("Sessao");

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

        imatualizaSessao.setText("Atualizar");
        imatualizaSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imatualizaSessaoActionPerformed(evt);
            }
        });
        mSessao.add(imatualizaSessao);

        imApagaSessao.setText("Apagar");
        imApagaSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imApagaSessaoActionPerformed(evt);
            }
        });
        mSessao.add(imApagaSessao);

        imRelatorioSessao.setText("Relatorio");
        imRelatorioSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imRelatorioSessaoActionPerformed(evt);
            }
        });
        mSessao.add(imRelatorioSessao);

        jMenu1.add(mSessao);

        mVenda.setText("Venda");

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

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void imCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCadastroClienteActionPerformed
        this.cadastroCliente.getBtnCadastrarCliente().setVisible(true);
        this.cadastroCliente.getLbTituloTelaCliente().setText("Cadastro de Cliente");
        this.cadastroCliente.getBtnCadastrarCliente().setText("Cadastrar");
        this.cadastroCliente.getTfNomeCliente().setEditable(true);
        this.cadastroCliente.getTfCpfCliente().setEditable(true);
        jDesktopPane1.add(cadastroCliente);
        cadastroCliente.setVisible(true);
    }//GEN-LAST:event_imCadastroClienteActionPerformed

    private void imConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imConsultaClienteActionPerformed
        jDesktopPane1.add(consultaCliente);
        consultaCliente.setVisible(true);
    }//GEN-LAST:event_imConsultaClienteActionPerformed

    private void imAtualizaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imAtualizaClienteActionPerformed
        jDesktopPane1.add(atualizaCliente);
        atualizaCliente.setVisible(true);
    }//GEN-LAST:event_imAtualizaClienteActionPerformed

    private void imApagaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imApagaClienteActionPerformed
        jDesktopPane1.add(apagaCliente);
        apagaCliente.setVisible(true);
    }//GEN-LAST:event_imApagaClienteActionPerformed

    private void imRelatorioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imRelatorioClienteActionPerformed
        jDesktopPane1.add(relatorioCliente);
        relatorioCliente.setVisible(true);
    }//GEN-LAST:event_imRelatorioClienteActionPerformed

    private void imCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCadastroFuncionarioActionPerformed
        this.cadastroFuncionario.getBtnCadastrarFuncionario().setVisible(true);
        this.cadastroFuncionario.getBtnCadastrarFuncionario().setText("Cadastrar");
        this.cadastroFuncionario.getTfNomeFuncionario().setEditable(true);
        this.cadastroFuncionario.getTfCpfFuncionario().setEditable(true);
        this.cadastroFuncionario.getTfLoginFuncionario().setEditable(true);
        this.cadastroFuncionario.getTfSenhaFuncionario().setEditable(true);
        jDesktopPane1.add(cadastroFuncionario);
        this.cadastroFuncionario.setVisible(true);
    }//GEN-LAST:event_imCadastroFuncionarioActionPerformed

    private void imConsultaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imConsultaFuncionarioActionPerformed
        jDesktopPane1.add(consultaFuncionario);
        consultaFuncionario.setVisible(true);
    }//GEN-LAST:event_imConsultaFuncionarioActionPerformed

    private void imAtualizaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imAtualizaFuncionarioActionPerformed
        jDesktopPane1.add(atualizaFuncionario);
        atualizaFuncionario.setVisible(true);
    }//GEN-LAST:event_imAtualizaFuncionarioActionPerformed

    private void imApagaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imApagaFuncionarioActionPerformed
        jDesktopPane1.add(apagaFuncionario);
        apagaFuncionario.setVisible(true);
    }//GEN-LAST:event_imApagaFuncionarioActionPerformed

    private void imRelatorioFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imRelatorioFuncionarioActionPerformed
        jDesktopPane1.add(relatorioFuncionario);
        relatorioFuncionario.setVisible(true);
    }//GEN-LAST:event_imRelatorioFuncionarioActionPerformed

    private void imCadastroFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCadastroFilmeActionPerformed
        this.cadastroFilme.getBtnConfirmar().setText("Cadastrar");
        this.cadastroFilme.getBtnConfirmar().setVisible(true);
        this.cadastroFilme.getTfNomeFilme().setEditable(true);
        this.cadastroFilme.getTfDiretor().setEditable(true);
        this.cadastroFilme.getTfaDescricao().setEditable(true);
        this.cadastroFilme.getTfNomeFilme().setText("");
        this.cadastroFilme.getTfDiretor().setText("");
        this.cadastroFilme.getTfaDescricao().setText("");
        this.cadastroFilme.getCbGenero().setEnabled(true);
        jDesktopPane1.add(cadastroFilme);
        this.cadastroFilme.setVisible(true);
    }//GEN-LAST:event_imCadastroFilmeActionPerformed

    private void imConsultaFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imConsultaFilmeActionPerformed
        jDesktopPane1.add(consultaFilme);
        consultaFilme.setVisible(true);
    }//GEN-LAST:event_imConsultaFilmeActionPerformed

    private void imAtualizaFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imAtualizaFilmeActionPerformed
        jDesktopPane1.add(atualizaFilme);
        atualizaFilme.setVisible(true);
    }//GEN-LAST:event_imAtualizaFilmeActionPerformed

    private void imApagarFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imApagarFilmeActionPerformed
        jDesktopPane1.add(apagaFilme);
        apagaFilme.setVisible(true);
    }//GEN-LAST:event_imApagarFilmeActionPerformed

    private void imRelatorioFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imRelatorioFilmeActionPerformed
        jDesktopPane1.add(relatorioFilme);
        relatorioFilme.setVisible(true);
    }//GEN-LAST:event_imRelatorioFilmeActionPerformed

    private void imCadastroSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCadastroSalaActionPerformed
        this.cadastroSala.getJsCapacidade().setEnabled(true);
        this.cadastroSala.getBtnCadastrarSala().setVisible(true);
        this.cadastroSala.getBtnCadastrarSala().setText("Cadastrar");
        this.cadastroSala.getTfNomeSala().setText("");
        this.cadastroSala.getTfNomeSala().setEditable(true);
        jDesktopPane1.add(cadastroSala);
        this.cadastroSala.setVisible(true);
    }//GEN-LAST:event_imCadastroSalaActionPerformed

    private void imConsultaSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imConsultaSalaActionPerformed
        jDesktopPane1.add(consultaSala);
        consultaSala.setVisible(true);
    }//GEN-LAST:event_imConsultaSalaActionPerformed

    private void imAtualizaSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imAtualizaSalaActionPerformed
        jDesktopPane1.add(atualizaSala);
        atualizaSala.setVisible(true);
    }//GEN-LAST:event_imAtualizaSalaActionPerformed

    private void imApagaSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imApagaSalaActionPerformed
        jDesktopPane1.add(apagaSala);
        apagaSala.setVisible(true);
    }//GEN-LAST:event_imApagaSalaActionPerformed

    private void imRelatorioSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imRelatorioSalaActionPerformed
        jDesktopPane1.add(relatorioSala);
        relatorioSala.setVisible(true);
    }//GEN-LAST:event_imRelatorioSalaActionPerformed

    private void imCadastroSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCadastroSessaoActionPerformed
        jDesktopPane1.add(cadastroSessao);
        cadastroSessao.setVisible(true);
    }//GEN-LAST:event_imCadastroSessaoActionPerformed

    private void imConsultaSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imConsultaSessaoActionPerformed
        jDesktopPane1.add(consultaSessao);
        consultaSessao.setVisible(true);
    }//GEN-LAST:event_imConsultaSessaoActionPerformed

    private void imatualizaSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imatualizaSessaoActionPerformed
        jDesktopPane1.add(atualizaSessao);
        atualizaSessao.setVisible(true);
    }//GEN-LAST:event_imatualizaSessaoActionPerformed

    private void imApagaSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imApagaSessaoActionPerformed
        jDesktopPane1.add(apagaSessao);
        apagaSessao.setVisible(true);
    }//GEN-LAST:event_imApagaSessaoActionPerformed

    private void imRelatorioSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imRelatorioSessaoActionPerformed
        jDesktopPane1.add(relatorioSessao);
        relatorioSessao.setVisible(true);
    }//GEN-LAST:event_imRelatorioSessaoActionPerformed

    private void imCadastroVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCadastroVendaActionPerformed
        jDesktopPane1.add(cadastroVenda);
        cadastroVenda.setVisible(true);
    }//GEN-LAST:event_imCadastroVendaActionPerformed

    private void imConsultaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imConsultaVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imConsultaVendaActionPerformed

    private void imRelatorioVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imRelatorioVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imRelatorioVendaActionPerformed

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
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem imApagaCliente;
    private javax.swing.JMenuItem imApagaFuncionario;
    private javax.swing.JMenuItem imApagaSala;
    private javax.swing.JMenuItem imApagaSessao;
    private javax.swing.JMenuItem imApagarFilme;
    private javax.swing.JMenuItem imAtualizaCliente;
    private javax.swing.JMenuItem imAtualizaFilme;
    private javax.swing.JMenuItem imAtualizaFuncionario;
    private javax.swing.JMenuItem imAtualizaSala;
    private javax.swing.JMenuItem imCadastroCliente;
    private javax.swing.JMenuItem imCadastroFilme;
    private javax.swing.JMenuItem imCadastroFuncionario;
    private javax.swing.JMenuItem imCadastroSala;
    private javax.swing.JMenuItem imCadastroSessao;
    private javax.swing.JMenuItem imCadastroVenda;
    private javax.swing.JMenuItem imConsultaCliente;
    private javax.swing.JMenuItem imConsultaFilme;
    private javax.swing.JMenuItem imConsultaFuncionario;
    private javax.swing.JMenuItem imConsultaSala;
    private javax.swing.JMenuItem imConsultaSessao;
    private javax.swing.JMenuItem imConsultaVenda;
    private javax.swing.JMenuItem imRelatorioCliente;
    private javax.swing.JMenuItem imRelatorioFilme;
    private javax.swing.JMenuItem imRelatorioFuncionario;
    private javax.swing.JMenuItem imRelatorioSala;
    private javax.swing.JMenuItem imRelatorioSessao;
    private javax.swing.JMenuItem imRelatorioVenda;
    private javax.swing.JMenuItem imatualizaSessao;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mCliente;
    private javax.swing.JMenu mFilme;
    private javax.swing.JMenu mFuncionario;
    private javax.swing.JMenu mSala;
    private javax.swing.JMenu mSessao;
    private javax.swing.JMenu mVenda;
    // End of variables declaration//GEN-END:variables
}
