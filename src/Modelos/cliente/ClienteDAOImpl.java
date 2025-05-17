package Modelos.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Modelos.Conexao;

public class ClienteDAOImpl implements ClienteDAO{ 

    @Override
    public void criar(Cliente cliente) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "INSERT INTO cliente(nome) VALUES (?)"
        );
        p.setString(1, cliente.getNome());
        p.executeUpdate();

        con.close();
    }

    @Override
    public Cliente ler(int id) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "SELECT id, nome FROM cliente WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();
        Cliente cliente = null;
        if (r.next()) {
            cliente = new Cliente();
            cliente.setId(r.getInt("id"));
            cliente.setNome(r.getString("nome"));
        }

        con.close();

        return cliente;
    }

    @Override
    public void atualizar(Cliente cliente) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "UPDATE cliente SET nome = ? WHERE id = ?"
        );
        p.setString(1, cliente.getNome());
        p.setInt(2, cliente.getId());
        p.executeUpdate();

        con.close();
    }
    
    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "DELETE FROM cliente WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();

        con.close();
    }

}
