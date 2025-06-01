package Modelos;

import Modelos.contato.Telefone;
import Modelos.login.Login;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Conexao.Conexao;

public class FuncionarioDAOImpl implements FuncionarioDAO{
    @Override
    public void criar(Funcionario f) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "insert into funcionario (nome, telefone_id, login_id, cpf, rg) values (?, ?, ?, ?, ?)"
        );
        stmt.setString(1, f.getNome());
        stmt.setInt(2, f.getTelefone().getId());
        stmt.setInt(3, f.getLogin().getId());
        stmt.setString(4, f.getCpf());
        stmt.setString(5, f.getRg());
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    @Override
    public Funcionario ler(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, nome, telefone_id, ddd, numero, login_id, login, senha, cpf, rg from funcionario_completo WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        Funcionario func = null;
        if (rs.next()) {
            func = new Funcionario();
            func.setId(rs.getInt("id"));
            func.setNome(rs.getString("nome"));
            func.setTelefone(new Telefone(
                rs.getInt("telefone_id"),
                rs.getString("ddd"),
                rs.getString("numero")
            ));
            func.setLogin(new Login(
                rs.getInt("login_id"),
                rs.getString("login"),
                rs.getString("senha")
            ));
            func.setCpf(rs.getString("cpf"));
            func.setRg(rs.getString("rg"));
        }

        rs.close();
        stmt.close();   
        con.close();

        return func;
    }

    @Override
    public List<Funcionario> listar() throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, nome, telefone_id, ddd, numero, login_id, login, senha, cpf, rg FROM funcionario_completo"
        );
        ResultSet rs = stmt.executeQuery();

        List<Funcionario> funcionarios = new ArrayList<>();
        while (rs.next()) {
            Funcionario func = new Funcionario();
            func.setId(rs.getInt("id"));
            func.setNome(rs.getString("nome"));
            func.setTelefone(new Telefone(
                rs.getInt("telefone_id"),
                rs.getString("ddd"),
                rs.getString("numero")
            ));
            func.setLogin(new Login(
                rs.getInt("login_id"),
                rs.getString("login"),
                rs.getString("senha")
            ));
            func.setCpf(rs.getString("cpf"));
            func.setRg(rs.getString("rg"));
            funcionarios.add(func);
        }

        rs.close();
        stmt.close();
        con.close();

        return funcionarios;
    }

    @Override
    public void atualizar(Funcionario f) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "UPDATE funcionario SET nome = ?, telefone_id = ?, login_id = ?, cpf = ?, rg = ? WHERE id = ?"
        );
        stmt.setString(1, f.getNome());
        stmt.setInt(2, f.getTelefone().getId());
        stmt.setInt(3, f.getLogin().getId());
        stmt.setString(4, f.getCpf());
        stmt.setString(5, f.getRg());
        stmt.setInt(6, f.getId());
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement pf = con.prepareStatement("DELETE FROM funcionario WHERE id = ?");
        pf.setInt(1, id);
        pf.executeUpdate();

        con.close();
    }
}
