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

    public boolean checarCredenciais(String usuarioNome, String senha) {
        if (usuarioSenhas.containsKey(usuarioNome)) {
            String senhaGuardada = usuarioSenhas.get(usuarioNome);
            return criptografarSenha.criptografarSenha(senha).equals(senhaGuardada);
        }
        return false;
    }
}
