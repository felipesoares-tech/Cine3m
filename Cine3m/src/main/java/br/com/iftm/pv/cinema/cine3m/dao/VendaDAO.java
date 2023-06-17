package br.com.iftm.pv.cinema.cine3m.dao;

import br.com.iftm.pv.cinema.cine3m.controller.GerenciaCliente;
import br.com.iftm.pv.cinema.cine3m.controller.GerenciaSessao;
import br.com.iftm.pv.cinema.cine3m.model.Funcionario;
import br.com.iftm.pv.cinema.cine3m.model.ItemVenda;
import br.com.iftm.pv.cinema.cine3m.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDAO {

    private Connection conn = null;
    private ItemVendaDAO itemVendaDAO;
    private GerenciaSessao gerenciaSessao;
    private GerenciaCliente gerenciaCliente;
//    private GerenciaFuncionario gerenciaFuncionario;

    public VendaDAO(GerenciaCliente gerenciaCliente, GerenciaSessao gerenciaSessao) {
        itemVendaDAO = new ItemVendaDAO();
        this.gerenciaCliente = gerenciaCliente;
        this.gerenciaSessao = gerenciaSessao;

        try {
            conn = Conexao.getConexao();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean incluir(Venda venda, List<ItemVenda> itens) {
        String sql;
        PreparedStatement ps;

        sql = "INSERT INTO venda (fk_sessao,fk_cliente,fk_funcionario,desconto,identificador,valor_total) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venda.getSessao().getId());
            Integer fk_cliente = venda.getCliente() != null ? venda.getCliente().getId() : 1;

            ps.setInt(2, fk_cliente);
            ps.setInt(3, 1);
            ps.setBoolean(4, venda.hasDesconto());
            ps.setString(5, venda.getIdentificador());
            ps.setDouble(6, venda.getValorFinal());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                Iterator<ItemVenda> it = itens.iterator();

                while (it.hasNext()) {
                    ItemVenda itemVenda = (ItemVenda) it.next();
                    venda.setId(rs.getInt(1));
                    itemVenda.setVenda(venda);
                    itemVendaDAO.incluir(itemVenda);

                }
            }
            ps.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro na operação de inclusão do SGDB: " + e.getMessage());

            return false;
        }
    }

    public List<Venda> listar() {
        List<Venda> vendas = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM venda WHERE del = false";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            vendas = new ArrayList<>();

            while (rs.next()) {
                vendas.add(new Venda(rs.getInt("id"), new Funcionario("teste", "", "sxx", "123"), gerenciaSessao.consultar(rs.getInt("fk_sessao")), gerenciaCliente.consultar(rs.getInt("fk_cliente")), rs.getDouble("valor_total"), rs.getString("identificador"), rs.getBoolean("cancelada"), rs.getBoolean("desconto"), rs.getBoolean("del")));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Erro ao buscar registros do SGDB: " + e.getMessage());
        }
        return vendas;
    }

}
