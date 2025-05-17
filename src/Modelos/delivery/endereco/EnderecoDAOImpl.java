package Modelos.delivery.endereco;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EnderecoDAOImpl implements EnderecoDAO {
    @Override
    public void criar(Endereco endereco) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO endereco(rua, numero, cep, bairro_id, distancia) VALUES (?, ?, ?, ?, ?)"
        );
        stmt.setString(1, endereco.getRua());
        stmt.setString(2, endereco.getNumero());
        stmt.setString(3, endereco.getCep());
        stmt.setInt(4, endereco.getBairro().getId());
        stmt.executeUpdate();
        con.close();
    }

    @Override
    public Endereco ler(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, rua, numero, cep, bairro_id, distancia FROM endereco WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet r = stmt.executeQuery();

        Endereco endereco = null;
        if (r.next()) {
            endereco = new Endereco();
            endereco.setId(r.getInt("id"));
            endereco.setRua(r.getString("rua"));
            endereco.setNumero(r.getString("numero"));
            endereco.setCep(r.getString("cep"));

            BairroDAO bairroDAO = new BairroDAOImpl();
            Bairro bairro = bairroDAO.ler(r.getInt("bairro_id"));
            endereco.setBairro(bairro);
        }
        con.close();
        return endereco;
    }
    
    @Override
    public void atualizar(Endereco endereco) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "UPDATE endereco SET rua = ?, numero = ?, cep = ?, bairro_id = ?, distancia = ? WHERE id = ?"
        );
        stmt.setString(1, endereco.getRua());
        stmt.setString(2, endereco.getNumero());
        stmt.setString(3, endereco.getCep());
        stmt.setInt(4, endereco.getBairro().getId());
        stmt.setInt(6, endereco.getId());
        stmt.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "DELETE FROM endereco WHERE id = ?"
        );
        stmt.setInt(1, id);
        stmt.executeUpdate();
        con.close();
    }
}
