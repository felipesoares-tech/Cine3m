/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
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
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.ConsultaVenda;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.RelatorioVenda;
import br.com.iftm.pv.cinema.cine3m.view.gerenciamento.venda.auxiliares.TelaAuxiliarConsultaVenda;
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

/**
 *
 * @author elisabete
 */
public class Principal extends javax.swing.JFrame {

//Telas a serem chamadas (CRUD SESSAO)
    private final CadastroSessao cadastroSessao;
    private final ConsultaSessao consultaSessao;
    private final AtualizaSessao atualizaSessao;
    private final ApagaSessao apagaSessao;
    private final RelatorioSessao relatorioSessao;

//Telas a serem chamadas (CRUD CLIENTES)
    private final CadastroCliente cadastroCliente;
    private final ConsultaCliente consultaCliente;
    private final AtualizaCliente atualizaCliente;
    private final ApagarCliente apagaCliente;
    private final RelatorioCliente relatorioCliente;

//Telas a serem chamadas (CRUD FUNCIONARIOS)
    private final CadastroFuncionario cadastroFuncionario;
    private final ConsultaFuncionario consultaFuncionario;
    private final AtualizaFuncionario atualizaFuncionario;
    private final ApagaFuncionario apagaFuncionario;
    private final RelatorioFuncionario relatorioFuncionario;
    private final LoginFuncionario loginFuncionario;

//Telas a serem chamadas (CRUD SALA)
    private final CadastroSala cadastroSala;
    private final ConsultaSala consultaSala;
    private final AtualizaSala atualizaSala;
    private final ApagaSala apagaSala;
    private final RelatorioSala relatorioSala;

//Telas a serem chamadas (CRUD VENDAS)
    private final CadastroVenda cadastroVenda;
    private final RelatorioVenda relatorioVenda;
    private final ConsultaVenda consultaVenda;

//Telas a serem chamadas (CRUD FILMES)
    private final CadastroFilme cadastroFilme;
    private final ConsultaFilme consultaFilme;
    private final AtualizaFilme atualizaFilme;
    private final ApagaFilme apagaFilme;
    private final RelatorioFilme relatorioFilme;

    private final TelaImportacao telaImportacao;

    List<Filme> filmes = new ArrayList<>();
    List<Funcionario> funcionarios = new ArrayList<>();
    List<Sessao> sessoes = new ArrayList<>();
    List<Venda> vendas = new ArrayList<>();
    List<Sala> salas = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();

    private final GerenciaArquivo gerenciaArquivo = new GerenciaArquivo();
    private final GerenciaCliente gerenciaCliente = new GerenciaCliente(clientes);
    private final GerenciaFilme gerenciaFilme = new GerenciaFilme(filmes);
    private final GerenciaFuncionario gerenciaFuncionario = new GerenciaFuncionario(funcionarios);
    private final GerenciaVenda gerenciaVenda = new GerenciaVenda(vendas, gerenciaCliente);
    private final GerenciaSala gerenciaSala = new GerenciaSala(salas);
    private final GerenciaSessao gerenciaSessao = new GerenciaSessao(sessoes, gerenciaSala);

    public Principal() {
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
        this.loginFuncionario = new LoginFuncionario(gerenciaArquivo, jMenuBar1);

        //Telas a serem chamadas (CRUD SALA)
        this.cadastroSala = new CadastroSala(gerenciaSala);
        this.consultaSala = new ConsultaSala(cadastroSala, gerenciaSala);
        this.atualizaSala = new AtualizaSala(cadastroSala, gerenciaSala);
        this.apagaSala = new ApagaSala(gerenciaSala);
        this.relatorioSala = new RelatorioSala(gerenciaSala);

        //Telas a serem chamadas (CRUD VENDAS)
        this.cadastroVenda = new CadastroVenda(gerenciaVenda, gerenciaSessao, gerenciaCliente, cadastroSessao, cadastroCliente);
        this.relatorioVenda = new RelatorioVenda(gerenciaVenda);
        this.consultaVenda = new ConsultaVenda(gerenciaVenda);

        //Telas a serem chamadas (CRUD FILMES)
        this.cadastroFilme = new CadastroFilme(gerenciaFilme);
        this.consultaFilme = new ConsultaFilme(cadastroFilme, gerenciaFilme);
        this.atualizaFilme = new AtualizaFilme(cadastroFilme, gerenciaFilme);
        this.apagaFilme = new ApagaFilme(gerenciaFilme);
        this.relatorioFilme = new RelatorioFilme(gerenciaFilme);

        //Configurações para as telas;
        Color corFundoPadrao = ParametrosSistema.getInstance().getCorDeFundo();
        Color corPanelPadrao = ParametrosSistema.getInstance().getCorPanel();
        this.getContentPane().setBackground(corFundoPadrao);

        //CORES PARA TELAS CLIENTE
        this.cadastroCliente.getContentPane().setBackground(corFundoPadrao);
        this.consultaCliente.getContentPane().setBackground(corFundoPadrao);
        this.atualizaCliente.getContentPane().setBackground(corFundoPadrao);
        this.apagaCliente.getContentPane().setBackground(corFundoPadrao);
        this.relatorioCliente.getContentPane().setBackground(corFundoPadrao);

        // PANEL/LIST CLIENTES
        this.cadastroCliente.getjPanel8().setBackground(corPanelPadrao);
        this.consultaCliente.getLstClientes().setBackground(corPanelPadrao);
        this.atualizaCliente.getLstClientes().setBackground(corPanelPadrao);
        this.apagaCliente.getLstClientes().setBackground(corPanelPadrao);

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

        //CORES PARA A TELA IMPORTACAO
        this.telaImportacao.getContentPane().setBackground(corFundoPadrao);

//        addWindowListener(new WindowAdapter() {
//            public void windowOpened(WindowEvent e) {
//                loginFuncionario.setBounds((jDesktopPane1.getWidth() - 350) / 2,
//                        (jDesktopPane1.getHeight() - 350) / 2, 350, 350);
//                jDesktopPane1.add(loginFuncionario);
//                loginFuncionario.setVisible(true);
//                jMenuBar1.setVisible(false);
//            }
//        });
        //TELA LOGIN
        loginFuncionario.setBounds((jDesktopPane1.getWidth() - 350) / 2,
                (jDesktopPane1.getHeight() - 350) / 2, 350, 350);
        jDesktopPane1.add(loginFuncionario);
        loginFuncionario.setVisible(true);
        jMenuBar1.setVisible(false);

        //EVENTO QUANDO PRINCIPAL FOR FECHADO
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (!gerenciaFuncionario.getFuncionarios().isEmpty()) {
                    try {
                        gerenciaArquivo.adicionaUsuarios(gerenciaFuncionario);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        mFuncionario.setText("Funcionario");

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


    private void imCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCadastroClienteActionPerformed
        this.cadastroCliente.getBtnCadastrarCliente().setVisible(true);
        this.cadastroCliente.getLbTituloTelaCliente().setText("Cadastro de Cliente");
        this.cadastroCliente.getBtnCadastrarCliente().setText("CADASTRAR");
        this.cadastroCliente.getTfNomeCliente().setEditable(true);
        this.cadastroCliente.getTfCpfCliente().setEditable(true);
         this.cadastroCliente.getTfNomeCliente().setText("");
        this.cadastroCliente.getTfCpfCliente().setText("");
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
        cadastroFuncionario.getBtnCadastrarFuncionario().setVisible(true);
        cadastroFuncionario.getBtnCadastrarFuncionario().setText("Cadastrar");
        cadastroFuncionario.getTfNomeFuncionario().setEditable(true);
        cadastroFuncionario.getTfCpfFuncionario().setEditable(true);
        cadastroFuncionario.getTfLoginFuncionario().setEditable(true);
        cadastroFuncionario.getTfSenhaFuncionario().setEditable(true);
        
        cadastroFuncionario.getTfNomeFuncionario().setText("");
        cadastroFuncionario.getTfCpfFuncionario().setText("");
        cadastroFuncionario.getTfLoginFuncionario().setText("");
        cadastroFuncionario.getTfSenhaFuncionario().setText("");
        cadastroFuncionario.getLbTituloTelaFuncionario().setText("Cadastrar Funcionário");
        
        
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
        this.cadastroSessao.getBtnCadastrarSessao().setVisible(true);
        this.cadastroSessao.getLbTituloTelaSessao().setText("Cadastro de Sessão");
        this.cadastroSessao.getBtnCadastrarSessao().setText("Cadastrar");

        //Habilita campos
        this.cadastroSessao.getTfDataSessao().setEditable(true);
        this.cadastroSessao.getTfHorarioSessao().setEditable(true);
        this.cadastroSessao.getTfValorSessao().setEditable(true);
        this.cadastroSessao.getCbFilmesSessao().setEnabled(true);
        this.cadastroSessao.getCbSalasSessao().setEnabled(true);
        //Limpa campos
        this.cadastroSessao.getTfDataSessao().setValue(null);
        this.cadastroSessao.getTfHorarioSessao().setValue(null);
        this.cadastroSessao.getTfValorSessao().setValue(null);
        jDesktopPane1.add(cadastroSessao);
        this.cadastroSessao.setVisible(true);
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
            if (!gerenciaFuncionario.getFuncionarios().isEmpty()) {
                try {
                    gerenciaArquivo.adicionaUsuarios(gerenciaFuncionario);
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
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
    private javax.swing.JMenuItem imImportacaoFilmes;
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
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mCliente;
    private javax.swing.JMenu mFilme;
    private javax.swing.JMenu mFuncionario;
    private javax.swing.JMenu mSala;
    private javax.swing.JMenu mSessao;
    private javax.swing.JMenu mVenda;
    // End of variables declaration//GEN-END:variables
}
