package br.com.iftm.pv.cinema.cine3m.dao;

import br.com.iftm.pv.cinema.cine3m.enums.Genero;
import br.com.iftm.pv.cinema.cine3m.model.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FilmeDAO {
    private Connection conn = null;

    public FilmeDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException ex) {
            Logger.getLogger(FilmeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean incluir(Filme filme) {
        String sql;
        PreparedStatement ps;

        sql = "INSERT INTO filme (tipo_genero, nome, descricao,diretor,duracao) VALUES (?, ?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(filme.getGenero()));            
            ps.setString(2, filme.getNome());
            ps.setString(3, filme.getDescricao());
            ps.setString(4, filme.getDiretor());
            ps.setTime(5, Time.valueOf(filme.getDuracao()));
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de inclusão do SGDB: " + e.getMessage());

            return false;
        }
    }

    public boolean alterar(Integer filmeID, Filme filmeAtualizado) {
        String sql;
        PreparedStatement ps;
        sql = "UPDATE filme SET nome = ?,tipo_genero = ?,descricao = ?, diretor = ?, duracao = ?  WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, filmeAtualizado.getNome());
            ps.setString(2, filmeAtualizado.getGenero().name());
            ps.setString(3, filmeAtualizado.getDescricao());
            ps.setString(4, filmeAtualizado.getDiretor());
            ps.setTime(5, Time.valueOf(filmeAtualizado.getDuracao()));
            ps.setInt(6, filmeID);

            ps.execute();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de alteração do SGDB: " + e.getMessage());

            return false;
        }
    }

    public boolean apagar(Integer filmeID) {
        String sql;
        PreparedStatement ps;

        sql = "UPDATE filme set del = true WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, filmeID);

            ps.execute();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de apagar do SGDB: " + e.getMessage());

            return false;
        }
    }

    public List<Filme> listar() {
        List<Filme> filmes = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM filme WHERE del = false";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            filmes = new ArrayList<>();

            while (rs.next()) {
                filmes.add(new Filme(Genero.valueOf(rs.getString("tipo_genero")), rs.getString("nome"), rs.getString("descricao"), rs.getString("diretor"), rs.getTime("duracao").toLocalTime(), rs.getInt("id"), rs.getBoolean("del")));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }

        return filmes;
    }
    public Filme consultarFilmeID(Integer filmeID) {
        PreparedStatement ps;
        ResultSet rs;
        Filme filmeRet = null;

        String sql = "SELECT * FROM filme WHERE id = ? and del = false";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, filmeID);
            rs = ps.executeQuery();

            if (rs.next()) {
                filmeRet = new Filme(Genero.valueOf(rs.getString("tipo_genero")), rs.getString("nome"), rs.getString("descricao"), rs.getString("diretor"), rs.getTime("duracao").toLocalTime(), rs.getInt("id"), rs.getBoolean("del"));
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return filmeRet;
    }

    public Filme consultarFilmeNome(Filme filme) {
        PreparedStatement ps;
        ResultSet rs;
        Filme filmeRet = null;

        String sql = "SELECT * FROM filme WHERE nome = ? and del = false";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, filme.getNome());
            rs = ps.executeQuery();

            if (rs.next()) {
                filmeRet = new Filme(Genero.valueOf(rs.getString("tipo_genero")), rs.getString("nome"), rs.getString("descricao"), rs.getString("diretor"), rs.getTime("duracao").toLocalTime(), rs.getInt("id"), rs.getBoolean("del"));
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return filmeRet;
    }
    
    public boolean consultarFilmeSessao(Integer filmeID) {
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM sessao WHERE fk_filme = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, filmeID);
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return false;
    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro no fechamento da conexão com o SGDB: " + e.getMessage());
        }
    }
    
}