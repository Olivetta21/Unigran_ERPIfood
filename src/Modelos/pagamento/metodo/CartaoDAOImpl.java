package Modelos.pagamento.metodo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Modelos.Conexao;

public class CartaoDAOImpl implements CartaoDAO {
    @Override
    public void criar(Cartao cartao) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "INSERT INTO cartao (numero, CVV, tipo) VALUES (?, ?, ?)"
        );
        p.setString(1, cartao.getNumero());
        p.setInt(2, cartao.getCVV());
        p.setBoolean(3, cartao.isTipo());
        p.executeUpdate();
        con.close();
    }

    @Override
    public Cartao ler(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "SELECT id, numero, CVV, tipo FROM cartao WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();

        Cartao cartao = null;
        if (r.next()) {
            cartao = new Cartao(
                r.getInt("id"),
                r.getString("numero"),
                r.getInt("CVV"),
                r.getBoolean("tipo")
            );
        }
        con.close();
        return cartao;
    }

    @Override
    public void atualizar(Cartao cartao) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "UPDATE cartao SET numero = ?, CVV = ?, tipo = ? WHERE id = ?"
        );
        p.setString(1, cartao.getNumero());
        p.setInt(2, cartao.getCVV());
        p.setBoolean(3, cartao.isTipo());
        p.setInt(4, cartao.getId());
        p.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "DELETE FROM cartao WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();
        con.close();
    }
}
