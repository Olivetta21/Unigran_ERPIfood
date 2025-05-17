package Modelos.pagamento.metodo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Modelos.Conexao;

public class MetodoDAOImpl implements MetodoDAO {

    @Override
    public void criar(Metodo metodo) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "INSERT INTO metodo(pix, cartao_id, dinheiro_id) VALUES (?, ?, ?)"
        );
        p.setDouble(1, metodo.getPix());
        p.setObject(2, metodo.getCartao() != null ? metodo.getCartao().getId() : null);
        p.setObject(3, metodo.getDinheiro() != null ? metodo.getDinheiro().getId() : null);
        p.executeUpdate();
        con.close();
    }

    @Override
    public Metodo ler(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "SELECT id, pix, cartao_id, dinheiro_id FROM metodo WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();

        Metodo metodo = null;
        if (r.next()) {
            metodo = new Metodo();
            metodo.setId(r.getInt("id"));
            metodo.setPix(r.getDouble("pix"));

            Cartao cartao = new Cartao();
            cartao.setId(r.getInt("cartao_id"));
            metodo.setCartao(cartao);

            Dinheiro dinheiro = new Dinheiro();
            dinheiro.setId(r.getInt("dinheiro_id"));
            metodo.setDinheiro(dinheiro);
        }
        con.close();
        return metodo;
    }

    @Override
    public void atualizar(Metodo metodo) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "UPDATE metodo SET pix = ?, cartao_id = ?, dinheiro_id = ? WHERE id = ?"
        );
        p.setDouble(1, metodo.getPix());
        p.setObject(2, metodo.getCartao() != null ? metodo.getCartao().getId() : null);
        p.setObject(3, metodo.getDinheiro() != null ? metodo.getDinheiro().getId() : null);
        p.setInt(4, metodo.getId());
        p.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement("DELETE FROM metodo WHERE id = ?");
        p.setInt(1, id);
        p.executeUpdate();
        con.close();
    }

}
