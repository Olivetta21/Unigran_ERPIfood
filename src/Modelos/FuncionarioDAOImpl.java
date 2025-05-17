package Modelos;

import Modelos.login.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Conexao.Conexao;

public class FuncionarioDAOImpl implements FuncionarioDAO{
    @Override
    public void criar(Funcionario f) throws Exception {
        Connection con = Conexao.get();

        // 1. Inserir na tabela cliente
        PreparedStatement pc = con.prepareStatement(
            "INSERT INTO cliente(nome) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
        pc.setString(1, f.getNome());
        pc.executeUpdate();

        ResultSet rs = pc.getGeneratedKeys();
        int idGerado = 0;
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }

        // 2. Inserir na tabela funcionario
        PreparedStatement pf = con.prepareStatement(
            "INSERT INTO funcionario(id, cpf, rg, login_id) VALUES (?, ?, ?, ?)");
        pf.setInt(1, idGerado);
        pf.setString(2, f.getCpf());
        pf.setString(3, f.getRg());
        pf.setObject(4, f.getLogin() != null ? f.getLogin().getId() : null);
        pf.executeUpdate();

        con.close();
    }

    @Override
    public Funcionario ler(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement p = con.prepareStatement(
            "SELECT c.nome, f.cpf, f.rg, f.login_id FROM cliente c JOIN funcionario f ON c.id = f.id WHERE c.id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();

        Funcionario f = null;
        if (r.next()) {
            f = new Funcionario();
            f.setId(id);
            f.setNome(r.getString("nome"));
            f.setCpf(r.getString("cpf"));
            f.setRg(r.getString("rg"));

            int loginId = r.getInt("login_id");
            if (!r.wasNull()) {
                Login login = new Login();                
                login.setId(loginId);
                f.setLogin(login);
            }
        }

        con.close();
        return f;
    }

    @Override
    public void atualizar(Funcionario f) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement pc = con.prepareStatement("UPDATE cliente SET nome = ? WHERE id = ?");
        pc.setString(1, f.getNome());
        pc.setInt(2, f.getId());
        pc.executeUpdate();

        PreparedStatement pf = con.prepareStatement(
            "UPDATE funcionario SET cpf = ?, rg = ?, login_id = ? WHERE id = ?");
        pf.setString(1, f.getCpf());
        pf.setString(2, f.getRg());
        pf.setObject(3, f.getLogin() != null ? f.getLogin().getId() : null);
        pf.setInt(4, f.getId());
        pf.executeUpdate();

        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();

        // Primeiro deleta da tabela funcionario, depois de cliente
        PreparedStatement pf = con.prepareStatement("DELETE FROM funcionario WHERE id = ?");
        pf.setInt(1, id);
        pf.executeUpdate();

        PreparedStatement pc = con.prepareStatement("DELETE FROM cliente WHERE id = ?");
        pc.setInt(1, id);
        pc.executeUpdate();

        con.close();
    }
}
