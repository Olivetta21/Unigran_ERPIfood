package Modelos.cliente;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexao.Conexao;

public class CartaoDAOImpl implements CartaoDAO {
    @Override
    public void criar(Cartao cartao) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO cartao (numero, cvv, isCredito, cliente_id) VALUES (?, ?, ?, ?)"
        );
        stmt.setString(1, cartao.getNumero());
        stmt.setInt(2, cartao.getCVV());
        stmt.setBoolean(3, cartao.isCredito());
        stmt.setInt(4, cartao.getCliente().getId());
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    @Override
    public Cartao ler(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, numero, cvv, isCredito, cliente_id, nome FROM cartao_completo WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Cartao cartao = null;
        if (rs.next()) {
            cartao = new Cartao(
                rs.getInt("id"),
                rs.getString("numero"),
                rs.getInt("cvv"),
                rs.getBoolean("isCredito"),
                new Cliente(
                    rs.getInt("cliente_id"),
                    rs.getString("nome"),
                    null
                )
            );
        }
        con.close();
        return cartao;
    }

    @Override
    public List<Cartao> listar() throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, numero, cvv, isCredito, cliente_id, nome FROM cartao_completo"
        );
        ResultSet rs = stmt.executeQuery();

        List<Cartao> cartoes = new ArrayList<>();
        while (rs.next()) {
            Cartao cartao = new Cartao(
                rs.getInt("id"),
                rs.getString("numero"),
                rs.getInt("cvv"),
                rs.getBoolean("isCredito"),
                new Cliente(
                    rs.getInt("cliente_id"),
                    rs.getString("nome"),
                    null
                )
            );
            cartoes.add(cartao);
        }
        con.close();
        return cartoes;
    }

    @Override
    public void atualizar(Cartao cartao) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "UPDATE cartao SET numero = ?, cvv = ?, isCredito = ?, cliente_id = ? WHERE id = ?"
        );
        stmt.setString(1, cartao.getNumero());
        stmt.setInt(2, cartao.getCVV());
        stmt.setBoolean(3, cartao.isCredito());
        stmt.setInt(4, cartao.getCliente().getId());
        stmt.setInt(5, cartao.getId());
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
