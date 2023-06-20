package br.com.iftm.pv.cinema.cine3m.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
    private static Connection conn = null;
    
    // Design Pattern - Singleton
    public static Connection getConexao() throws SQLException{
        if((conn == null) || (conn.isClosed())){
            conn = fabricaDeConexoes();
        }
        
        return conn;
    }
    
    // Design Pattern - Fábrica de Conexões
    public static Connection fabricaDeConexoes(){
        try{
            Class.forName("org.postgresql.Driver");
            
            Properties prop = new Properties();
            prop.put("user", "postgres");
            prop.put("password", "Hb180400*");
            prop.put("charset", "UTF-8");
            prop.put("lc_ctype", "ISO8859_1");
            
            return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/cine3m", prop);
        }
        catch(ClassNotFoundException | SQLException e){
            System.err.print("Erro na conexão com o banco: " + e.getMessage());
        }
        
        return null;
    }
}
