package Modelos.delivery;

import Modelos.Conexao;
import Modelos.delivery.endereco.EnderecoDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaxaDAOImpl implements TaxaDAO {
    @Override
    public void criar(Taxa taxa) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "INSERT INTO taxa(endereco_id, valor) VALUES (?, ?)"
        );
        p.setInt(1, taxa.getEndereco().getId());
        p.setDouble(2, taxa.getValor());
        p.executeUpdate();
        con.close();
    }

    @Override
    public Taxa ler(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "SELECT id, endereco_id, valor FROM taxa WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();

        Taxa taxa = null;
        if (r.next()) {
            taxa = new Taxa();
            taxa.setId(r.getInt("id"));
            taxa.setEndereco(new EnderecoDAOImpl().ler(r.getInt("endereco_id")));
            taxa.setValor(r.getDouble("valor"));
        }
        con.close();
        return taxa;
    }

    @Override
    public void atualizar(Taxa taxa) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "UPDATE taxa SET endereco_id = ?, valor = ? WHERE id = ?"
        );
        p.setInt(1, taxa.getEndereco().getId());
        p.setDouble(2, taxa.getValor());
        p.setInt(3, taxa.getId());
        p.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement("DELETE FROM taxa WHERE id = ?");
        p.setInt(1, id);
        p.executeUpdate();
        con.close();
    }
}