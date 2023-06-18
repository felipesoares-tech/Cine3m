package br.com.iftm.pv.cinema.cine3m.dao;

import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import br.com.iftm.pv.cinema.cine3m.model.Poltrona;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import br.com.iftm.pv.cinema.cine3m.model.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservaDAO {

    private Connection conn = null;
    private PoltronaDAO poltronaDAO;
    private SessaoDAO sessaoDAO;
    private ClienteDAO clienteDAO;

    public ReservaDAO() {
        poltronaDAO = new PoltronaDAO();
        sessaoDAO = new SessaoDAO();
        clienteDAO = new ClienteDAO();
        try {
            conn = Conexao.getConexao();
        } catch (SQLException ex) {
            Logger.getLogger(PoltronaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean incluir(Reserva reserva) {
        PreparedStatement ps;

        String sql = "INSERT INTO reserva (fk_poltrona, fk_sessao, fk_cliente, livre) VALUES (?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, reserva.getPoltrona().getId());
            ps.setInt(2, reserva.getSessao().getId());
            Cliente c = reserva.getCliente();
            ps.setObject(3, c != null ? c.getId() : null);            
            ps.setBoolean(4, false);

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de inclusão do SGDB: " + e.getMessage());

            return false;
        }
    }
    
    public List<Reserva> consultarReservaSessao(Integer sessaoID) {
        PreparedStatement ps;
        ResultSet rs;
        List<Reserva> reservas = new ArrayList<>();
        
        String sql = "SELECT * FROM reserva WHERE fk_sessao = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sessaoID);
            rs = ps.executeQuery();

            while (rs.next()) {
                Poltrona poltrona = poltronaDAO.consultaPoltronaPorID(rs.getInt("fk_poltrona"));
                Sessao sessao = sessaoDAO.consultarSessaoID(rs.getInt("fk_sessao"));
                Cliente cliente = clienteDAO.consultarClienteID(rs.getInt("fk_cliente"));
                reservas.add(new Reserva(rs.getInt("id"), rs.getBoolean("livre"),poltrona, sessao, cliente));                
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return reservas;
    }
    
    
    

    public Reserva consultarReservaID(Integer reservaID) {
        PreparedStatement ps;
        ResultSet rs;
        Reserva reservaRet = null;

        String sql = "SELECT * FROM reserva WHERE id = ? ";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, reservaID);
            rs = ps.executeQuery();

            if (rs.next()) {
                Poltrona poltrona = poltronaDAO.consultaPoltronaPorID(rs.getInt("fk_poltrona"));
                Sessao sessao = sessaoDAO.consultarSessaoID(rs.getInt("fk_sessao"));
                Cliente cliente = clienteDAO.consultarClienteID(rs.getInt("fk_cliente"));
                reservaRet = new Reserva(rs.getInt("id"), rs.getBoolean("livre"),poltrona, sessao, cliente);

            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return reservaRet;
    }

}
