package Modelos.delivery.endereco;

import Modelos.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EnderecoDAOImpl implements EnderecoDAO {
    @Override
    public void criar(Endereco endereco) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "INSERT INTO endereco(rua, numero, cep, bairro_id, distancia) VALUES (?, ?, ?, ?, ?)"
        );
        p.setString(1, endereco.getRua());
        p.setString(2, endereco.getNumero());
        p.setString(3, endereco.getCep());
        p.setInt(4, endereco.getBairro().getId());
        p.setInt(5, endereco.getDistancia());
        p.executeUpdate();
        con.close();
    }

    @Override
    public Endereco ler(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "SELECT id, rua, numero, cep, bairro_id, distancia FROM endereco WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();

        Endereco endereco = null;
        if (r.next()) {
            endereco = new Endereco(
                r.getInt("id"),
                r.getString("numero"),
                r.getString("cep"),
                new BairroDAOImpl().ler(r.getInt("bairro_id")),
                r.getInt("distancia")
            );
            endereco.setRua(r.getString("rua"));
        }
        con.close();
        return endereco;
    }
    
    @Override
    public void atualizar(Endereco endereco) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "UPDATE endereco SET rua = ?, numero = ?, cep = ?, bairro_id = ?, distancia = ? WHERE id = ?"
        );
        p.setString(1, endereco.getRua());
        p.setString(2, endereco.getNumero());
        p.setString(3, endereco.getCep());
        p.setInt(4, endereco.getBairro().getId());
        p.setInt(5, endereco.getDistancia());
        p.setInt(6, endereco.getId());
        p.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "DELETE FROM endereco WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();
        con.close();
    }
}
