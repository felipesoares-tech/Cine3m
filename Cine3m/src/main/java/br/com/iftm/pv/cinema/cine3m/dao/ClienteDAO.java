package br.com.iftm.pv.cinema.cine3m.dao;

import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    private Connection conn = null;

    public ClienteDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean incluir(Cliente cliente) {
        String sql;
        PreparedStatement ps;

        sql = "INSERT INTO pessoa (nome, cpf) VALUES (?, ?)";

        try {
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {               
                String sqlCliente = "INSERT INTO cliente (fk_cliente, filmes_assistidos) VALUES (?, ?)";
                try (PreparedStatement ps2 = conn.prepareStatement(sqlCliente)) {
                    ps2.setInt(1, rs.getInt(1));
                    ps2.setInt(2, cliente.getQtdFilmesAssistidos());
                    ps2.execute();
                }                
            }
            ps.close();            
            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de inclusão do SGDB: " + e.getMessage());

            return false;
        }
    }

    public boolean alterar(Cliente cliente,Cliente clienteAtualizado) {
        String sql;
        PreparedStatement ps;
        sql = "UPDATE pessoa SET nome = ?,cpf = ? WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, clienteAtualizado.getNome());
            ps.setString(2, clienteAtualizado.getCpf());
            ps.setInt(3, cliente.getId());

            ps.execute();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de alteração do SGDB: " + e.getMessage());

            return false;
        }
    }
//
//    public boolean apagar(Cliente cliente) {
//        String sql;
//        PreparedStatement ps;
//
//        sql = "DELETE FROM cliente WHERE codigo = ?";
//
//        try {
//            ps = conn.prepareStatement(sql);
//
//            ps.setInt(1, cliente.getCodigo());
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
//
    public List<Cliente> lista() {
        List<Cliente> clientes = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM pessoa p JOIN cliente c ON p.id = c.fk_cliente";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            clientes = new ArrayList<>();

            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getInt("filmes_assistidos")));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }

        return clientes;
    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro no fechamento da conexão com o SGDB: " + e.getMessage());
        }
    }
}
