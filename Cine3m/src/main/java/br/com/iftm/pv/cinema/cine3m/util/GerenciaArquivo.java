package br.com.iftm.pv.cinema.cine3m.util;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaFuncionario;
import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciaArquivo {

    private Map<String, String> usuarioSenhas;
    private String pathArquivo;
    private CriptografarSenha criptografarSenha;

    public GerenciaArquivo() {
        this.usuarioSenhas = new HashMap<>();
        this.pathArquivo = "dados_login";
        this.criptografarSenha = new CriptografarSenha();
        criarArquivo();
        guardarSenha("admin", criptografarSenha.criptografarSenha("admin"));
    }

    public void guardarSenha(String login, String senha) {
        try {
            usuarioSenhas.put(login, senha);
            guardarSenhas();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public boolean checarCredenciais(String usuarioNome, String senha) {
//        if (usuarioSenhas.containsKey(usuarioNome)) {
//            String senhaGuardada = usuarioSenhas.get(usuarioNome);
//            return criptografarSenha.criptografarSenha(senha).equals(senhaGuardada);
//        }
//        return false;
//    }

    public boolean checarCredenciais(String usuarioNome, String senha) {
        try (FileInputStream fis = new FileInputStream(pathArquivo); 
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            HashMap<String, String> usuarioSenhas = (HashMap<String, String>) ois.readObject();

            if (usuarioSenhas.containsKey(usuarioNome)) {
                String senhaGuardada = usuarioSenhas.get(usuarioNome);
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
        for (Funcionario funcionario : funcionarios) {
            String login = funcionario.getLogin();
            String senha = funcionario.getSenha();
            usuarioSenhas.put(login, senha);
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

}
