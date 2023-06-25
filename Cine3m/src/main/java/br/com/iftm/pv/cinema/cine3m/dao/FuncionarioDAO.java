package br.com.iftm.pv.cinema.cine3m.dao;

import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO {

    private Connection conn = null;

    public FuncionarioDAO() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean incluir(Funcionario funcionario) {
        String sql;
        PreparedStatement ps;
        sql = "INSERT INTO funcionario (nome, cpf, login, senha) VALUES (?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getLogin());
            ps.setString(4, funcionario.getSenha());

            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de inclusão do SGDB: " + e.getMessage());

            return false;
        }
    }

    public boolean alterar(Funcionario funcionario, Funcionario funcionarioAtualizado) {
        String sql;
        PreparedStatement ps;
        sql = "UPDATE funcionario SET nome = ?,cpf = ?, login = ?, senha = ? WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, funcionarioAtualizado.getNome());
            ps.setString(2, funcionarioAtualizado.getCpf());
            ps.setString(3, funcionarioAtualizado.getLogin());
            ps.setString(4, funcionarioAtualizado.getSenha());
            ps.setInt(5, funcionario.getId());

            ps.execute();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de alteração do SGDB: " + e.getMessage());

            return false;
        }
    }

    public boolean apagar(Funcionario funcionario) {
        String sql;
        PreparedStatement ps;

        sql = "UPDATE funcionario set del = true WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, funcionario.getId());

            ps.execute();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de apagar do SGDB: " + e.getMessage());

            return false;
        }
    }

    public List<Funcionario> listar() {
        List<Funcionario> funcionarios = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM funcionario WHERE del = false";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            funcionarios = new ArrayList<>();

            while (rs.next()) {
                funcionarios.add(new Funcionario(rs.getInt("id"), rs.getString("nome"),
                        rs.getString("cpf"), rs.getString("login"),
                        rs.getString("senha"), rs.getBoolean("del")));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return funcionarios;
    }

    public Funcionario consultarFuncionarioID(Integer funcionarioID) {
        PreparedStatement ps;
        ResultSet rs;
        Funcionario funcionarioRet = null;

        String sql = "SELECT * FROM funcionario WHERE id = ? and del = false";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, funcionarioID);
            rs = ps.executeQuery();

            if (rs.next()) {
                funcionarioRet = new Funcionario(rs.getInt("id"), rs.getString("nome"),
                        rs.getString("cpf"), rs.getString("login"),
                        rs.getString("senha"), rs.getBoolean("del"));
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return funcionarioRet;
    }

    public Funcionario consultarFuncionarioCpf(Funcionario funcionario) {
        PreparedStatement ps;
        ResultSet rs;
        Funcionario funcionarioRet = null;

        String sql = "SELECT * FROM funcionario WHERE cpf = ? and del = false";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.getCpf());
            rs = ps.executeQuery();

            if (rs.next()) {
                funcionarioRet = new Funcionario(rs.getString("nome"), rs.getString("cpf"),
                        rs.getString("login"), rs.getString("senha"));
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return funcionarioRet;
    }

    public Funcionario consultarFuncionarioLogin(String login) {
        PreparedStatement ps;
        ResultSet rs;
        Funcionario funcionarioRet = null;

        String sql = "SELECT * FROM funcionario WHERE login = ? and del = false";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            rs = ps.executeQuery();

            if (rs.next()) {
                funcionarioRet = new Funcionario(rs.getInt("id"), rs.getString("nome"),
                        rs.getString("cpf"), rs.getString("login"),
                        rs.getString("senha"), rs.getBoolean("del"));
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return funcionarioRet;
    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro no fechamento da conexão com o SGDB: " + e.getMessage());
        }
    }
}
