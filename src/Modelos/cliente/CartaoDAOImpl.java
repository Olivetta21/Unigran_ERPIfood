package Modelos.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexao.Conexao;

public class CartaoDAOImpl implements CartaoDAO {
    @Override
    public void criar(Cartao cartao) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO cartao (numero, CVV, tipo) VALUES (?, ?, ?)"
        );
        stmt.setString(1, cartao.getNumero());
        stmt.setInt(2, cartao.getCVV());
        stmt.setBoolean(3, cartao.isTipo());
        stmt.executeUpdate();
        con.close();
    }

    @Override
    public Cartao ler(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, numero, CVV, tipo FROM cartao WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Cartao cartao = null;
        if (rs.next()) {
            cartao = new Cartao(
                rs.getInt("id"),
                rs.getString("numero"),
                rs.getInt("CVV"),
                rs.getBoolean("tipo")
            );
        }
        con.close();
        return cartao;
    }

    @Override
    public void atualizar(Cartao cartao) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "UPDATE cartao SET numero = ?, CVV = ?, tipo = ? WHERE id = ?"
        );
        stmt.setString(1, cartao.getNumero());
        stmt.setInt(2, cartao.getCVV());
        stmt.setBoolean(3, cartao.isTipo());
        stmt.setInt(4, cartao.getId());
        stmt.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "DELETE FROM cartao WHERE id = ?"
        );
        stmt.setInt(1, id);
        stmt.executeUpdate();
        con.close();
    }
}
