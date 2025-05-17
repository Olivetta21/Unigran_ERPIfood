package Modelos.delivery;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexao.Conexao;
import Modelos.delivery.endereco.EnderecoDAOImpl;


public class EntregaDAOImpl implements EntregaDAO{
    @Override
    public void criar(Entrega entrega) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO entrega(chave, endereco_id) VALUES (?, ?)"
        );
        stmt.setString(1, entrega.getChave());
        stmt.setInt(2, entrega.getEndereco().getId());
        stmt.executeUpdate();

        con.close();
    }

    @Override
    public Entrega ler(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, chave, endereco_id FROM entrega WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Entrega entrega = null;
        if (rs.next()) {
            entrega = new Entrega();
            entrega.setId(rs.getInt("id"));
            entrega.setChave(rs.getString("chave"));
            entrega.setEndereco(new EnderecoDAOImpl().ler(rs.getInt("endereco_id")));
        }

        con.close();
        return entrega;
    }

    @Override
    public void atualizar(Entrega entrega) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "UPDATE entrega SET chave = ?, endereco_id = ? WHERE id = ?"
        );
        stmt.setString(1, entrega.getChave());
        stmt.setInt(2, entrega.getEndereco().getId());
        stmt.setInt(3, entrega.getId());
        stmt.executeUpdate();

        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "DELETE FROM entrega WHERE id = ?"
        );
        stmt.setInt(1, id);
        stmt.executeUpdate();

        con.close();
    }
}
