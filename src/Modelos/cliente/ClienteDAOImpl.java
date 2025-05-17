package Modelos.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexao.Conexao;

public class ClienteDAOImpl implements ClienteDAO{ 

    @Override
    public void criar(Cliente cliente) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO cliente(nome) VALUES (?)"
        );
        stmt.setString(1, cliente.getNome());
        stmt.executeUpdate();

        con.close();
    }

    @Override
    public Cliente ler(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, nome FROM cliente WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Cliente cliente = null;
        if (rs.next()) {
            cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
        }

        con.close();
        return cliente;
    }

    @Override
    public void atualizar(Cliente cliente) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "UPDATE cliente SET nome = ? WHERE id = ?"
        );
        stmt.setString(1, cliente.getNome());
        stmt.setInt(2, cliente.getId());
        stmt.executeUpdate();

        con.close();
    }
    
    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "DELETE FROM cliente WHERE id = ?"
        );
        stmt.setInt(1, id);
        stmt.executeUpdate();

        con.close();
    }

}
