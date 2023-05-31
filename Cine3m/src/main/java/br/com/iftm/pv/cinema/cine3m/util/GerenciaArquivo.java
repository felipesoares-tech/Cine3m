package br.com.iftm.pv.cinema.cine3m.util;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaFuncionario;
import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciaArquivo {

    private Map<String, Funcionario> usuarioSenhas;
    private String pathArquivo;
    private CriptografarSenha criptografarSenha;

    public GerenciaArquivo() {
        this.usuarioSenhas = new HashMap<>();
        this.pathArquivo = "dados_login";
        this.criptografarSenha = new CriptografarSenha();
        criarArquivo();
    }

    private void guardarSenhas() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(pathArquivo); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(usuarioSenhas);
        }
    }

    private void criarArquivo() {
        try {
            File arquivo = new File(pathArquivo);
            if (!arquivo.exists()) {
                arquivo.createNewFile();
                try {
                    Funcionario admin = new Funcionario("EDWAR", "000.000.000-00", "admin", criptografarSenha.criptografarSenha("admin"));
                    usuarioSenhas.put("admin", admin);
                    guardarSenhas();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checarCredenciais(String usuarioNome, String senha) {
        try (FileInputStream fis = new FileInputStream(pathArquivo); ObjectInputStream ois = new ObjectInputStream(fis)) {
            HashMap<String, Funcionario> funcionarioDados = (HashMap<String, Funcionario>) ois.readObject();

            if (funcionarioDados.containsKey(usuarioNome)) {
                Funcionario funcionario = funcionarioDados.get(usuarioNome);
                String senhaGuardada = funcionario.getSenha();
                // Aqui você pode comparar a senha fornecida com a senha guardada do Funcionario
                System.out.println(senhaGuardada + "senha guardada");
                System.out.println(criptografarSenha.criptografarSenha(senha) + "senha tentada");
                return criptografarSenha.criptografarSenha(senha).equals(senhaGuardada);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void adicionaUsuarios(GerenciaFuncionario gerenciaFuncionario) throws IOException {
        List<Funcionario> funcionarios = gerenciaFuncionario.getFuncionarios();
        limparArquivo();
        System.out.println(funcionarios + "Lista de funcionarios");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario + " funcionario no for de adicionaUsuarios");
            String login = funcionario.getLogin();
            String senha = funcionario.getSenha();
            if(!funcionario.getSenha().startsWith("CRYPT:"))
                funcionario.setSenha(criptografarSenha.criptografarSenha(senha));
            else
                funcionario.setSenha(senha);
            System.out.println(funcionario.getLogin());
            System.out.println(funcionario.getSenha());
            usuarioSenhas.put(login, funcionario);
        }
        guardarSenhas();
    }

    public void limparArquivo() {
        try {
            usuarioSenhas.clear();
            guardarSenhas();
            System.out.println("Arquivo limpo com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Funcionario> obterFuncionarios() {;;
        List<Funcionario> funcionarios = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(pathArquivo); ObjectInputStream ois = new ObjectInputStream(fis)) {
            HashMap<String, Funcionario> funcionarioDados = (HashMap<String, Funcionario>) ois.readObject();
            funcionarios.addAll(funcionarioDados.values());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }
}
