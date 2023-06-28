package br.com.iftm.pv.cinema.cine3m.dao;

import br.com.iftm.pv.cinema.cine3m.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        sql = "INSERT INTO cliente (nome,cpf) VALUES (?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());

            ps.execute();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de inclusão do SGDB: " + e.getMessage());

            return false;
        }
    }

    public boolean alterar(Cliente cliente, Cliente clienteAtualizado) {
        String sql;
        PreparedStatement ps;
        sql = "UPDATE cliente SET nome = ?,cpf = ?,filmes_assistidos = ? WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, clienteAtualizado.getNome());
            ps.setString(2, clienteAtualizado.getCpf());
            ps.setInt(3, clienteAtualizado.getQtdFilmesAssistidos());
            ps.setInt(4, cliente.getId());

            ps.execute();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de alteração do SGDB: " + e.getMessage());

            return false;
        }
    }

    public boolean apagar(Cliente cliente) {
        String sql;
        PreparedStatement ps;

        sql = "UPDATE cliente set del = true WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, cliente.getId());

            ps.execute();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de apagar do SGDB: " + e.getMessage());

            return false;
        }
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM cliente WHERE del = false";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            clientes = new ArrayList<>();

            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getBoolean("del"), rs.getInt("filmes_assistidos")));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }

        return clientes;
    }

    public Cliente consultarClienteID(Integer clienteID) {
        PreparedStatement ps;
        ResultSet rs;
        Cliente clienteRet = null;

        String sql = "SELECT * FROM cliente WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, clienteID);
            rs = ps.executeQuery();

            if (rs.next()) {
                clienteRet = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getBoolean("del"), rs.getInt("filmes_assistidos"));
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return clienteRet;
    }

    public Cliente consultarClienteCpf(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        Cliente clienteRet = null;

        String sql = "SELECT * FROM cliente WHERE cpf = ? and del = false";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getCpf());
            rs = ps.executeQuery();

            if (rs.next()) {
                clienteRet = new Cliente(rs.getString("nome"), rs.getString("cpf"));
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return clienteRet;
    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro no fechamento da conexão com o SGDB: " + e.getMessage());
        }
    }
}
