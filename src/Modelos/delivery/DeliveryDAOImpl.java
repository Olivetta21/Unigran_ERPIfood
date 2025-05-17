package Modelos.delivery;

import Modelos.Conexao;
import Modelos.delivery.endereco.EnderecoDAOImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeliveryDAOImpl implements DeliveryDAO {
    @Override
    public void criar(Delivery delivery) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "INSERT INTO delivery(chaveEntrega, numero, complemento, idEndereco) VALUES (?, ?, ?, ?)"
        );
        p.setString(1, delivery.getChaveEntrega());
        p.setInt(2, delivery.getNumero());
        p.setString(3, delivery.getComplemento());
        p.setInt(4, delivery.getEndereco().getId());
        p.executeUpdate();
        con.close();
    }

    @Override
    public Delivery ler(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "SELECT id, chaveEntrega, numero, complemento, idEndereco FROM delivery WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();

        Delivery delivery = null;
        if (r.next()) {
            delivery = new Delivery(
                r.getInt("id"),
                r.getString("chaveEntrega"),
                r.getInt("numero"),
                r.getString("complemento"),
                new EnderecoDAOImpl().ler(r.getInt("idEndereco"))
            );
        }
        con.close();
        return delivery;
    }

    @Override
    public void atualizar(Delivery delivery) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "UPDATE delivery SET chaveEntrega = ?, numero = ?, complemento = ?, idEndereco = ? WHERE id = ?"
        );
        p.setString(1, delivery.getChaveEntrega());
        p.setInt(2, delivery.getNumero());
        p.setString(3, delivery.getComplemento());
        p.setInt(4, delivery.getEndereco().getId());
        p.setInt(5, delivery.getId());
        p.executeUpdate();
        con.close();
    }
    
    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "DELETE FROM delivery WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();
        con.close();
    }

}
