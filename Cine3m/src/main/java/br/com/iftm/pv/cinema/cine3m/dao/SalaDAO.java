package br.com.iftm.pv.cinema.cine3m.dao;

import br.com.iftm.pv.cinema.cine3m.model.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SalaDAO {
    private Connection conn = null;

    public SalaDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean incluir(Sala sala) {
        String sql;
        PreparedStatement ps;

        sql = "INSERT INTO sala (nome, capacidade) VALUES (?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, sala.getNome());            
            ps.setInt(2, sala.getCapacidade());
            
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de inclusão do SGDB: " + e.getMessage());

            return false;
        }
    }

//    public boolean alterar(Sala sala, Sala salaAtualizado) {
//        String sql;
//        PreparedStatement ps;
//        sql = "UPDATE sala SET nome = ?,tipo_genero = ?,descricao = ?, diretor = ?, duracao = ?  WHERE id = ?";
//
//        try {
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, salaAtualizado.getNome());
//            ps.setString(2, salaAtualizado.getGenero().name());
//            ps.setString(3, salaAtualizado.getDescricao());
//            ps.setString(4, salaAtualizado.getDiretor());
//            ps.setTime(5, Time.valueOf(salaAtualizado.getDuracao()));
//            ps.setInt(6, sala.getId());
//
//            ps.execute();
//            ps.close();
//
//            return true;
//        } catch (SQLException e) {
//            System.err.println("Erro na operação de alteração do SGDB: " + e.getMessage());
//
//            return false;
//        }
//    }

//    public boolean apagar(Sala sala) {
//        String sql;
//        PreparedStatement ps;
//
//        sql = "UPDATE sala set del = true WHERE id = ?";
//
//        try {
//            ps = conn.prepareStatement(sql);
//
//            ps.setInt(1, sala.getId());
//
//            ps.execute();
//            ps.close();
//
//            return true;
//        } catch (SQLException e) {
//            System.err.println("Erro na operação de apagar do SGDB: " + e.getMessage());
//
//            return false;
//        }
//    }

    public List<Sala> listar() {
        List<Sala> salas = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM sala WHERE del = false";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            salas = new ArrayList<>();

            while (rs.next()) {
                salas.add(new Sala(rs.getInt("id"), rs.getString("nome"), rs.getInt("capacidade")));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }

        return salas;
    }
    
    public Sala consultarSalaID(Integer salaID) {
        PreparedStatement ps;
        ResultSet rs;
        Sala salaRet = null;

        String sql = "SELECT * FROM sala WHERE id = ? and del = false";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, salaID);
            rs = ps.executeQuery();

            if (rs.next()) {
                salaRet = new Sala(rs.getInt("id"), rs.getString("nome"), rs.getInt("capacidade"));
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return salaRet;
    }

    public Sala consultarSalaNome(Sala sala) {
        PreparedStatement ps;
        ResultSet rs;
        Sala salaRet = null;

        String sql = "SELECT * FROM sala WHERE nome = ? and del = false";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, sala.getNome());
            rs = ps.executeQuery();

            if (rs.next()) {
                salaRet = new Sala(rs.getInt("id"), rs.getString("nome"), rs.getInt("capacidade"));
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return salaRet;
    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro no fechamento da conexão com o SGDB: " + e.getMessage());
        }
    }
    
}