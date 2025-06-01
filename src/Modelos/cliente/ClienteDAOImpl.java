package Modelos.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import Modelos.contato.Telefone;

public class ClienteDAOImpl implements ClienteDAO{ 

    @Override
    public void criar(Cliente cliente) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO cliente(nome, telefone_id) VALUES (?, ?)"
        );
        stmt.setString(1, cliente.getNome());
        stmt.setInt(2, cliente.getTelefone().getId());
        stmt.executeUpdate();

        con.close();
    }

    @Override
    public Cliente ler(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, nome, telefone_id, ddd, numero FROM cliente_completo WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Cliente cliente = null;
        if (rs.next()) {
            cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(
                new Telefone(
                    rs.getInt("telefone_id"),
                    rs.getString("ddd"),
                    rs.getString("numero")
                )
            );
        }

        con.close();
        return cliente;
    }

    @Override
    public List<Cliente> listar() throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, nome, telefone_id, ddd, numero FROM cliente_completo"
        );
        ResultSet rs = stmt.executeQuery();

        List<Cliente> clientes = new ArrayList<>();
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(
                new Telefone(
                    rs.getInt("telefone_id"),
                    rs.getString("ddd"),
                    rs.getString("numero")
                )
            );
            clientes.add(cliente);
        }

        rs.close();
        stmt.close();
        con.close();

        return clientes;
    }

    @Override
    public void atualizar(Cliente cliente) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "UPDATE cliente SET nome = ?, telefone_id = ? WHERE id = ?"
        );
        stmt.setString(1, cliente.getNome());
        stmt.setInt(2, cliente.getTelefone().getId());
        stmt.setInt(3, cliente.getId());
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
