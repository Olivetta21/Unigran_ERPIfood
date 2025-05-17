package Modelos.pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexao.Conexao;
import Modelos.pagamento.cupom.CupomDAOImpl;

public class PagamentoDAOImpl implements PagamentoDAO {
    @Override
    public void criar(Pagamento pagamento) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO pagamento (pix, cartao, dinheiro, cupom_id) VALUES (?, ?, ?, ?)"
        );
        stmt.setDouble(1, pagamento.getPix());
        stmt.setDouble(2, pagamento.getCartao());
        stmt.setDouble(3, pagamento.getDinheiro());
        stmt.setInt(4, pagamento.getCupom().getId());
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    @Override
    public Pagamento ler(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, pix, cartao, dinheiro FROM pagamento WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Pagamento pagamento = null;
        if (rs.next()) {
            pagamento = new Pagamento(
                rs.getInt("id"),
                rs.getDouble("pix"),
                rs.getDouble("cartao"),
                rs.getDouble("dinheiro"),
                new CupomDAOImpl().ler(rs.getInt("cupom_id"))
            );
        }

        stmt.close();
        con.close();
        return pagamento;
    }

    @Override
    public void atualizar(Pagamento pagamento) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "UPDATE pagamento SET pix = ?, cartao = ?, dinheiro = ?, cupom_id = ? WHERE id = ?"
        );
        stmt.setDouble(1, pagamento.getPix());
        stmt.setDouble(2, pagamento.getCartao());
        stmt.setDouble(3, pagamento.getDinheiro());
        stmt.setInt(4, pagamento.getCupom().getId());
        stmt.setInt(5, pagamento.getId());
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "DELETE FROM pagamento WHERE id = ?"
        );
        stmt.setInt(1, id);
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }
    
}
