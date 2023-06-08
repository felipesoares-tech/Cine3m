package br.com.iftm.pv.cinema.cine3m.util;

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
    private Funcionario admin;

    public GerenciaArquivo() {
        this.usuarioSenhas = new HashMap<>();
        this.pathArquivo = "dados_login.bin";
        this.criptografarSenha = new CriptografarSenha();
        this.admin = new Funcionario("ADMIN", "000.000.000-00", "admin", criptografarSenha.criptografarSenha("admin"));
        criarArquivo();
        carregarDadosArquivo(pathArquivo);  
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
                    Funcionario funcionario = admin;
                    usuarioSenhas.put("admin", funcionario);
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
                return criptografarSenha.criptografarSenha(senha).equals(senhaGuardada);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void adicionaUsuarios(List<Funcionario> funcionarios) throws IOException {
        List<Funcionario> usuarios = funcionarios;
        limparArquivo();
        for (Funcionario funcionario : usuarios) {
            String login = funcionario.getLogin();
            usuarioSenhas.put(login, funcionario);
        }
        guardarSenhas();
    }

    public void limparArquivo() {
        try {
            usuarioSenhas.clear();
            guardarSenhas();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Funcionario> obterFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(pathArquivo); ObjectInputStream ois = new ObjectInputStream(fis)) {
            HashMap<String, Funcionario> funcionarioDados = (HashMap<String, Funcionario>) ois.readObject();
            funcionarios.addAll(funcionarioDados.values());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

    public void carregarDadosArquivo(String pathArquivo) {
        try (FileInputStream fis = new FileInputStream(pathArquivo); ObjectInputStream ois = new ObjectInputStream(fis)) {
            usuarioSenhas = (HashMap<String, Funcionario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Funcionario obterFuncionario(String chave) {
        if (usuarioSenhas.containsKey(chave)) {
            return usuarioSenhas.get(chave);
        }
        return null;
    }

    public Funcionario getAdmin() {
        return admin;
    }

}
