package Modelos.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexao.Conexao;

public class LoginDAOImpl implements LoginDAO {
    @Override
    public void criar(Login login) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement p = con.prepareStatement(
            "INSERT INTO login (senha) VALUES (?)"
        );
        p.setString(1, login.getSenha());
        p.executeUpdate();
        con.close();
    }

    @Override
    public Login ler(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement p = con.prepareStatement(
            "SELECT id, senha FROM login WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();

        Login login = null;
        if (r.next()) {
            login = new Login(
                r.getInt("id"),
                r.getString("senha")
            );
        }
        con.close();
        return login;
    }

    @Override
    public void atualizar(Login login) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement p = con.prepareStatement(
            "UPDATE login SET senha = ? WHERE id = ?"
        );
        p.setString(1, login.getSenha());
        p.setInt(2, login.getId());
        p.executeUpdate();
        con.close();
    }
    
    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement p = con.prepareStatement(
            "DELETE FROM login WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();
        con.close();
    }
}
