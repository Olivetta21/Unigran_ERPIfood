package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
    private static Connection con = null;
    String URL = "jdbc:postgresql://localhost:5432/trabdesktopjava";
    String USER = "postgres";
    String PASSWORD = "1234";

    private Conexao() {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public static Connection get(){
        try {
            if (con == null || con.isClosed()) new Conexao();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao testar conexão: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
}
