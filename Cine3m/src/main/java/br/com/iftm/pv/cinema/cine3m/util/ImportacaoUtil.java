package br.com.iftm.pv.cinema.cine3m.util;

import br.com.iftm.pv.cinema.cine3m.enums.Genero;
import br.com.iftm.pv.cinema.cine3m.model.Filme;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportacaoUtil {

    public static List<Filme> lerArquivo(String caminho) throws Exception {
        List<Filme> filmes = new ArrayList<>();
        Filme filme = null;
        Scanner sc = new Scanner(new File(caminho));

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha.contains("<filme>")) {
                filme = new Filme();
            } else if (linha.contains("<nome>")) {
                filme.setNome(getConteudo(linha, "nome"));
            } else if (linha.contains("<genero>")) {
                filme.setGenero(Genero.valueOf(getConteudo(linha, "genero")));
            } else if (linha.contains("<descricao>")) {
                filme.setDescricao(getConteudo(linha, "descricao"));
            } else if (linha.contains("<diretor>")) {
                filme.setDiretor(getConteudo(linha, "diretor"));
            } else if (linha.contains("</filme>")) {
                filmes.add(filme);
            }
        }
        return filmes;
    }

    public static String getConteudo(String linha, String tag) {
        return linha.substring(linha.indexOf("<" + tag + ">")
                + tag.length() + 2, linha.indexOf("</" + tag + ">"));
    }

}
