package br.com.iftm.pv.cinema.cine3m.dao;

import br.com.iftm.pv.cinema.cine3m.model.Poltrona;
import br.com.iftm.pv.cinema.cine3m.model.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PoltronaDAO {

    private Connection conn = null;

    public PoltronaDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException ex) {
            Logger.getLogger(PoltronaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Poltrona> listarPoltronasSala(Sala sala) {
        List<Poltrona> poltronas = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM poltrona WHERE fk_sala = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sala.getId());
            rs = ps.executeQuery();
            poltronas = new ArrayList<>();

            while (rs.next()) {
               poltronas.add(new Poltrona(rs.getString("identificador"), sala, rs.getBoolean("livre")));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }

        return poltronas;
    }
    
    public boolean alterar(Poltrona poltrona, Poltrona poltronaAtualizada) {
        String sql;
        PreparedStatement ps;
        sql = "UPDATE poltrona SET livre = ?  WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, poltronaAtualizada.isLivre());
            ps.setInt(2, poltrona.getId());
            
            ps.execute();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de alteração do SGDB: " + e.getMessage());

            return false;
        }
    }

}
