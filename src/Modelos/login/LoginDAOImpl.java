package Modelos.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;

public class LoginDAOImpl implements LoginDAO {
    @Override
    public void criar(Login login) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO login (login, senha) VALUES (?, ?)"
        );
        stmt.setString(1, login.getLogin());
        stmt.setString(2, login.getSenha());
        stmt.executeUpdate();
        con.close();
    }

    @Override
    public Login ler(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, login, 'secret' as senha FROM login WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Login login = null;
        if (rs.next()) {
            login = new Login(
                rs.getInt("id"),
                rs.getString("login"),
                rs.getString("senha")
            );
        }
        con.close();
        return login;
    }

    @Override
    public List<Login> listar() throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, login, 'secret' as senha FROM login"
        );
        ResultSet rs = stmt.executeQuery();

        List<Login> logins = new ArrayList<>();
        while (rs.next()) {
            Login login = new Login(
                rs.getInt("id"),
                rs.getString("login"),
                rs.getString("senha")
            );
            logins.add(login);
        }
        
        rs.close();
        stmt.close();
        con.close();

        return logins;
    }

    @Override
    public void atualizar(Login login) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "UPDATE login SET senha = ? WHERE id = ?"
        );
        stmt.setString(1, login.getSenha());
        stmt.setInt(2, login.getId());
        stmt.executeUpdate();
        con.close();
    }
    
    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "DELETE FROM login WHERE id = ?"
        );
        stmt.setInt(1, id);
        stmt.executeUpdate();
        con.close();
    }
}
