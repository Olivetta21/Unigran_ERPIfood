package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection con = null;
    String URL = "jdbc:postgresql://localhost:5432/gercarro";
    String USER = "postgres";
    String PASSWORD = "1234";

    private Conexao() {
        try {
            getConnection();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public static Connection get(){
        if (con == null) {
            new Conexao();
        }
        return con;
    }

    private Connection getConnection() throws SQLException {
        return con = (con == null ? DriverManager.getConnection(URL, USER, PASSWORD) : con);
    }

}
