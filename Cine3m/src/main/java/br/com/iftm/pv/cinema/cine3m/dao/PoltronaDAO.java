package br.com.iftm.pv.cinema.cine3m.dao;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSala;
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
    private SalaDAO salaDAO;
    private GerenciaSala gerenciaSala;

    public PoltronaDAO() {
        salaDAO = new SalaDAO();
        
        try {
            conn = Conexao.getConexao();
        } catch (SQLException ex) {
            Logger.getLogger(PoltronaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public PoltronaDAO(GerenciaSala gerenciaSala) {
        salaDAO = new SalaDAO();
        this.gerenciaSala = gerenciaSala;
        
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
                poltronas.add(new Poltrona(rs.getInt("id"), rs.getString("identificador"), sala));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }

        return poltronas;
    }
    
    public Poltrona consultaPoltronaPorID(Integer poltronaID) {
        PreparedStatement ps;
        ResultSet rs;
        Poltrona poltronaRet = null;

        String sql = "SELECT * FROM poltrona WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, poltronaID);
            rs = ps.executeQuery();

            if (rs.next()) {
                Sala sala = salaDAO.consultarSalaID(rs.getInt("fk_sala"));
                poltronaRet = new Poltrona(rs.getInt("id"), rs.getString("identificador"), sala);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return poltronaRet;
    }
    

    public Poltrona consultaPoltronaIdentificador(Poltrona poltrona, Sala sala) {
        PreparedStatement ps;
        ResultSet rs;
        Poltrona poltronaRet = null;


        String sql = "SELECT * FROM poltrona WHERE identificador = ? and fk_sala = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, poltrona.getIdentificador());
            ps.setInt(2, sala.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                poltronaRet = new Poltrona(rs.getInt("id"), rs.getString("identificador"), sala);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return poltronaRet;
    }
   
}
