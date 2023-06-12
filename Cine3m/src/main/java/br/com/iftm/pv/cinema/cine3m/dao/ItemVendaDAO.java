package br.com.iftm.pv.cinema.cine3m.dao;

import br.com.iftm.pv.cinema.cine3m.enums.TipoVenda;
import br.com.iftm.pv.cinema.cine3m.model.ItemVenda;
import br.com.iftm.pv.cinema.cine3m.model.Poltrona;
import br.com.iftm.pv.cinema.cine3m.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ItemVendaDAO {
     private Connection conn = null;

    public ItemVendaDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean incluir(ItemVenda itemVenda) {
        String sql;
        PreparedStatement ps;

        sql = "INSERT INTO item_venda (fk_poltrona, fk_venda,tipo_venda,valor) VALUES (?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, itemVenda.getPoltrona().getId());            
            ps.setInt(2, itemVenda.getVenda().getId());
            ps.setString(3, itemVenda.getTipoVenda().name());
            ps.setDouble(4, itemVenda.getValor());
            
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de inclusão do SGDB: " + e.getMessage());

            return false;
        }
    }
    
    public List<ItemVenda> listar(Venda venda) {
        List<ItemVenda> itensVenda = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM item_venda WHERE fk_venda = ?";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            itensVenda = new ArrayList<>();

            while (rs.next()) {
               // Poltrona poltrona =  
               // itensVenda.add(new ItemVenda(rs.getInt("id"), poltrona, TipoVenda.INTEIRA, venda, Double.NaN) );
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }

        return null;
    }
    
}
