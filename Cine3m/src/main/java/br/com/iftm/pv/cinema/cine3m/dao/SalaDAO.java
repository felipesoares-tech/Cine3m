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

    public boolean alterar(Integer salaID, Sala salaAtualizada) {
        String sql;
        PreparedStatement ps;
        sql = "UPDATE sala SET nome = ?,capacidade = ? WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, salaAtualizada.getNome());
            ps.setInt(2, salaAtualizada.getCapacidade());
            ps.setInt(3, salaID);

            ps.execute();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de alteração do SGDB: " + e.getMessage());

            return false;
        }
    }
    
    
    public boolean apagar(Integer salaID) {
        String sql;
        PreparedStatement ps;

        sql = "UPDATE sala set del = true WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, salaID);

            ps.execute();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de apagar do SGDB: " + e.getMessage());

            return false;
        }
    }

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

    public boolean consultarSalaSessao(Integer salaID) {
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM sessao WHERE fk_sala = ? and del = false";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, salaID);
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
