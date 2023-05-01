package br.com.iftm.pv.cinema.sistemacinema;

import br.com.iftm.pv.cinema.sistemacinema.enums.Genero;
import br.com.iftm.pv.cinema.sistemacinema.gerenciamento.GerenciaCliente;
import br.com.iftm.pv.cinema.sistemacinema.gerenciamento.GerenciaFilme;
import br.com.iftm.pv.cinema.sistemacinema.gerenciamento.GerenciaFuncionario;
import br.com.iftm.pv.cinema.sistemacinema.gerenciamento.GerenciaIngresso;
import br.com.iftm.pv.cinema.sistemacinema.gerenciamento.GerenciaSala;
import br.com.iftm.pv.cinema.sistemacinema.gerenciamento.GerenciaSessao;
import br.com.iftm.pv.cinema.sistemacinema.model.Cliente;
import br.com.iftm.pv.cinema.sistemacinema.model.Conta;
import br.com.iftm.pv.cinema.sistemacinema.model.Filme;
import br.com.iftm.pv.cinema.sistemacinema.model.Funcionario;
import br.com.iftm.pv.cinema.sistemacinema.model.Ingresso;
import br.com.iftm.pv.cinema.sistemacinema.model.Sala;
import br.com.iftm.pv.cinema.sistemacinema.model.Sessao;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cine3m {

    public static int menu(int operacaoGeral) {
        String[] tipos = {"Cliente", "Filme", "Funcionario", "Sala", "Sessao", "Ingresso"};
        Scanner entrada = new Scanner(System.in);

        System.out.println("===" + tipos[operacaoGeral - 1].toUpperCase() + "===");
        System.out.println("1 - Cadastrar " + tipos[operacaoGeral - 1]);
        System.out.println("2 - Alterar " + tipos[operacaoGeral - 1]);
        System.out.println("3 - Excluir " + tipos[operacaoGeral - 1]);
        System.out.println("4 - Consultar " + tipos[operacaoGeral - 1]);
        System.out.println("5 - Relatório " + tipos[operacaoGeral - 1]);
        System.out.println("0 - Voltar ao menu principal");
        System.out.println("Opção: ");

        return entrada.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<Filme> filmes = new ArrayList<Filme>();
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        List<Sessao> sessoes = new ArrayList<Sessao>();
        List<Ingresso> ingressos = new ArrayList<Ingresso>();
        List<Sala> salas = new ArrayList<Sala>();
        List<Cliente> clientes = new ArrayList<Cliente>();
        
        GerenciaCliente gerenciaCliente = new GerenciaCliente(clientes);
        GerenciaFilme gerenciaFilme = new GerenciaFilme(filmes);
        GerenciaFuncionario gerenciaFuncionario = new GerenciaFuncionario(funcionarios);
        GerenciaSessao gerenciaSessao = new GerenciaSessao(sessoes);
        GerenciaIngresso gerenciaIngresso = new GerenciaIngresso(ingressos);
        GerenciaSala gerenciaSala = new GerenciaSala(salas);

        gerenciaFilme.cadastrar(new Filme(Genero.TERROR, "filme a", "desc a", "diretor a"));
        gerenciaCliente.cadastrar(new Cliente("Felipe Soares", "02187354644"));
        gerenciaSala.cadastrar(new Sala("sala a", 30));
        gerenciaFuncionario.cadastrar(new Funcionario("Pedro", "15732145567", new Conta("admin", "123")));
        gerenciaSessao.cadastrar(new Sessao(gerenciaFilme.getFilmes().get(0), LocalDateTime.now(), gerenciaSala.getSalas().get(0)));
        
        int opcao;

        do {
            System.out.println(" === SISTEMA-CINEMA=== ");
            System.out.println("1 - Cliente ");
            System.out.println("2 - Filme ");
            System.out.println("3 - Funcionario ");
            System.out.println("4 - Sala ");
            System.out.println("5 - Sessao");
            System.out.println("6 - Ingresso ");
            System.out.println("0 - Sair ");
            opcao = sc.nextInt();
            sc.skip("\n");

            int operacao;
            switch (opcao) {

                case 1: {
                    do {
                        operacao = menu(opcao);
                        switch (operacao) {
                            case 1: {
                                //gerenciaCliente.cadastrar(new Cliente(nome, cpf));
                            }
                            case 2: {
                                //gerenciaCliente.atualizar(new Cliente(nome, cpf));
                            }
                            case 3: {

                                //gerenciaCliente.remover(new Cliente(nome, cpf));
                            }
                            case 4: {
                                //gerenciaCliente.consultar(new Cliente(nome, cpf));
                            }
                            case 5: {
                                //gerenciaCliente.relatorio();
                            }
                            default: {
                                if (operacao != 0) {
                                    System.out.println("Opcao invalida");
                                }
                            }
                        }
                    } while (operacao != 0);
                }
                case 2: {
                    do {
                        operacao = menu(opcao);
                        switch (operacao) {
                            case 1: {
                                //gerenciaFilme.cadastrar(new Filme(Genero.TERROR, nome, descricao, diretor));
                            }

                            case 2: {
                                //gerenciaFilme.alterar();
                            }

                            case 3: {
                                //gerenciaFilme.excluir();
                            }

                            case 4: {
                                //gerenciaFilme.consultar();
                            }

                            case 5: {
                                //gerenciaFilme.relatorio();
                            }

                            default: {
                                if (operacao != 0) {
                                    System.out.println("Opcao invalida");
                                }
                            }
                        }
                    } while (operacao != 0);
                }
                case 3: {
                    do {
                        operacao = menu(opcao);
                        switch (operacao) {
                            case 1: {
                                //gerenciaFuncionario.cadastrar();
                            }

                            case 2: {
                                //gerenciaFuncionario.alterar();
                            }

                            case 3: {
                                //gerenciaFuncionario.excluir();
                            }

                            case 4: {
                                //gerenciaFuncionario.consultar();
                            }

                            case 5: {
                                //gerenciaFuncionario.relatorio();
                            }

                            default: {
                                if (operacao != 0) {
                                    System.out.println("Opcao invalida");
                                }
                            }
                        }
                    } while (operacao != 0);
                }
                case 4: {
                    do {
                        operacao = menu(opcao);
                        switch (operacao) {
                            case 1: {
                                //gerenciaSala.cadastrar(new Sala(nome, capacidade));
                            }
                            case 2: {
                                //gerenciaSala.excluir();
                            }
                            case 3: {
                                //gerenciaSala.consultar();
                            }
                            case 4: {
                                //gerenciaSala.relatorio();
                            }
                            default: {
                                if (operacao != 0) {
                                    System.out.println("Opcao invalida");
                                }
                            }
                        }
                    } while (operacao != 0);
                }
                case 5: {
                    do {
                        operacao = menu(opcao);
                        switch (operacao) {
                            case 1: {
                                //gerenciaSessao.cadastrar(new Sessao(filme, LocalDateTime.now(), sala));
                            }

                            case 2: {
                                //gerenciaSessao.alterar();
                            }

                            case 3: {
                                //gerenciaSessao.excluir();
                            }

                            case 4: {
                                //gerenciaSessao.consultar();
                            }

                            case 5: {
                                //gerenciaSessao.relatorio();
                            }

                            default: {
                                if (operacao != 0) {
                                    System.out.println("Opcao invalida");
                                }
                            }
                        }
                    } while (operacao != 0);
                }
                case 6: {
                    do {
                        operacao = menu(opcao);
                        switch (operacao) {
                            case 1: {
                                System.out.println("Sessões disponíveis: ");
                                System.out.println(gerenciaSessao.getSessoes());
                                System.out.println("Escolha: ");
                                Integer escolha = sc.nextInt();

                                System.out.println("Poltronas disponíveis: ");
                                System.out.println(gerenciaSessao.getSessoes().get(escolha).getSala().getPoltronas());

                            }

                            case 2: {
                                //gerenciaIngresso.alterar();
                            }

                            case 3: {
                                //gerenciaIngresso.excluir();
                            }

                            case 4: {
                                //gerenciaIngresso.consultar();
                            }

                            case 5: {
                                //gerenciaIngresso.relatorio();
                            }

                            default: {
                                if (operacao != 0) {
                                    System.out.println("Opcao invalida");
                                }
                            }
                        }
                    } while (operacao != 0);
                }

                default: {
                    if (opcao != 0) {
                        System.out.println("Opção inválida.");
                    }
                }
            }

        } while (opcao != 0);

    }
}
