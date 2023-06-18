package br.com.iftm.pv.cinema.cine3m.dao;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaFilme;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSala;
import br.com.iftm.pv.cinema.cine3m.model.Filme;
import br.com.iftm.pv.cinema.cine3m.model.Sala;
import br.com.iftm.pv.cinema.cine3m.model.Sessao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SessaoDAO {

    private Connection conn = null;
    private GerenciaFilme gerenciaFilme;
    private GerenciaSala gerenciaSala;

    public SessaoDAO(GerenciaFilme gerenciaFilme, GerenciaSala gerenciaSala) {
        this.gerenciaFilme = gerenciaFilme;
        this.gerenciaSala = gerenciaSala;
        try {
            conn = Conexao.getConexao();
        } catch (SQLException ex) {
            Logger.getLogger(SessaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean incluir(Sessao sessao) {
        String sql;
        PreparedStatement ps;

        sql = "INSERT INTO sessao (fk_filme, fk_sala, identificador, data, hora, valor,hora_final) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sessao.getFilme().getId());
            ps.setInt(2, sessao.getSala().getId());
            ps.setString(3, sessao.getIdentificador());
            ps.setDate(4, Date.valueOf(sessao.getData()));
            ps.setTime(5, Time.valueOf(sessao.getHora()));
            ps.setDouble(6, sessao.getValor());
            ps.setTime(7, Time.valueOf(sessao.getHoraFinal()));
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de inclusão do SGDB: " + e.getMessage());

            return false;
        }
    }

    public Sessao consultarSessaoID(Integer sessaoID) {
        PreparedStatement ps;
        ResultSet rs;
        Sessao sessaoRet = null;

        String sql = "SELECT * FROM sessao WHERE id = ? and del = false";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sessaoID);
            rs = ps.executeQuery();

            if (rs.next()) {
                Filme filme = gerenciaFilme.consultar(rs.getInt("fk_filme"));
                Sala sala = gerenciaSala.consultar(rs.getInt("fk_sala"));
                sessaoRet = new Sessao(rs.getInt("id"), filme, rs.getDate("data").toLocalDate(), rs.getTime("hora").toLocalTime(), sala, rs.getDouble("valor"), rs.getString("identificador"), rs.getTime("hora_final").toLocalTime());
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return sessaoRet;
    }

    public boolean apagar(Integer sessaoID) {
        String sql;
        PreparedStatement ps;

        sql = "UPDATE sessao set del = true WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, sessaoID);

            ps.execute();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de apagar do SGDB: " + e.getMessage());

            return false;
        }
    }

    public List<Sessao> listar() {
        List<Sessao> sessoes = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM sessao WHERE del = false";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            sessoes = new ArrayList<>();

            while (rs.next()) {
                Filme filme = gerenciaFilme.consultar(rs.getInt("fk_filme"));
                Sala sala = gerenciaSala.consultar(rs.getInt("fk_sala"));
                sessoes.add(new Sessao(rs.getInt("id"), filme, rs.getDate("data").toLocalDate(), rs.getTime("hora").toLocalTime(), sala, rs.getDouble("valor"), rs.getString("identificador"), rs.getTime("hora_final").toLocalTime()));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }

        return sessoes;
    }

    public Sessao consultarSessaoDataHoraSala(Sessao sessao) {
        PreparedStatement ps;
        ResultSet rs;
        Sessao sessaoRet = null;

        String sql = "SELECT * FROM sessao WHERE data = ? and hora = ? and fk_sala = ? and del = false";

        try {
            ps = conn.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(sessao.getData()));
            ps.setTime(2, Time.valueOf(sessao.getHora()));
            ps.setInt(3, sessao.getSala().getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                Filme filme = gerenciaFilme.consultar(rs.getInt("fk_filme"));
                Sala sala = gerenciaSala.consultar(rs.getInt("fk_sala"));
                sessaoRet = new Sessao(rs.getInt("id"), filme, rs.getDate("data").toLocalDate(), rs.getTime("hora").toLocalTime(), sala, rs.getDouble("valor"), rs.getString("identificador"), rs.getTime("hora_final").toLocalTime());
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return sessaoRet;
    }

}
