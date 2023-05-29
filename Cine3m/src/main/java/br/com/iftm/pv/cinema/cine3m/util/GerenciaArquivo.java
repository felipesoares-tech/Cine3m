package br.com.iftm.pv.cinema.cine3m.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
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
        lerSenhas();
        guardarSenha("admin", "admin");
    }

    public void guardarSenha(String login, String senha) {
        try {
            usuarioSenhas.put(login, criptografarSenha.criptografarSenha(senha));
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
            if (arquivo.exists()) {
                arquivo.delete();
            }
            boolean criado = arquivo.createNewFile();
            if (criado) {
                System.out.println("Arquivo criado em: " + arquivo.getAbsolutePath());
            } else {
                System.out.println("Arquivo já existe em: " + arquivo.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, String> lerSenhas() {
        try (FileInputStream fis = new FileInputStream("dados_login")) {
            if (fis.available() > 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                return (HashMap<String, String>) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new HashMap<>();
    }

    public void mudarNomeUsuarioESenha(String login, String novoLogin, String novaSenha) {
        try {
            File arquivo = new File("dados_login");
            if (arquivo.exists() && arquivo.length() > 0) {
                FileInputStream fis = new FileInputStream("dados_login");
                ObjectInputStream ois = new ObjectInputStream(fis);
                usuarioSenhas = (HashMap<String, String>) ois.readObject();
                ois.close();
            } else {
                usuarioSenhas = new HashMap<>();
            }

            if (usuarioSenhas.containsKey(login)) {
                usuarioSenhas.remove(login);

                guardarSenha(novoLogin, novaSenha);

                FileOutputStream fos = new FileOutputStream("dados_login");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(usuarioSenhas);
                oos.close();

                System.out.println("Nome de usuário e senha alterados com sucesso!");
            } else {
                System.out.println("Nome de usuário não encontrado no arquivo.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removerUsuario(String usuarioNome) {
        if (usuarioSenhas.containsKey(usuarioNome)) {
            usuarioSenhas.remove(usuarioNome);
            try {
                guardarSenhas();
                System.out.println("Usuário removido com sucesso!");
            } catch (IOException e) {
                System.out.println("Erro ao remover usuário: " + e.getMessage());
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public boolean checarCredenciais(String usuarioNome, String senha) {
        if (usuarioSenhas.containsKey(usuarioNome)) {
            String senhaGuardada = usuarioSenhas.get(usuarioNome);
            return criptografarSenha.criptografarSenha(senha).equals(senhaGuardada);
        }
        return false;
    }
}
