package Modelos.delivery.endereco;

import Modelos.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BairroDAOImpl implements BairroDAO {
    
    @Override
    public void criar(Bairro bairro) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "INSERT INTO bairro(nome) VALUES (?)"
        );
        p.setString(1, bairro.getNome());
        p.executeUpdate();
        con.close();
    }

    @Override
    public Bairro ler(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "SELECT id, nome FROM bairro WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();

        Bairro bairro = null;
        if (r.next()) {
            bairro = new Bairro();
            bairro.setId(r.getInt("id"));
            bairro.setNome(r.getString("nome"));
        }
        con.close();
        return bairro;
    }

    @Override
    public void atualizar(Bairro bairro) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "UPDATE bairro SET nome = ? WHERE id = ?"
        );
        p.setString(1, bairro.getNome());
        p.setInt(2, bairro.getId());
        p.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "DELETE FROM bairro WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();
        con.close();
    }

}
