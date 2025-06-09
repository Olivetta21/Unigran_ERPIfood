package Modelos.pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import Modelos.Pedido;
import Modelos.pagamento.cupom.CupomDAOImpl;

public class PagamentoDAOImpl implements PagamentoDAO {
    @Override
    public void criar(Pagamento pagamento) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO pagamento (pedido_id, pix, dinheiro, cartao) VALUES (?, ?, ?, ?)"
        );
        stmt.setInt(1, pagamento.getPedido().getId());
        stmt.setDouble(2, pagamento.getPix());
        stmt.setDouble(3, pagamento.getDinheiro());
        stmt.setDouble(4, pagamento.getCartao());
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    @Override
    public Pagamento ler(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, pedido_id, pix, dinheiro, cartao FROM pagamento WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Pagamento pagamento = null;
        if (rs.next()) {
            pagamento = new Pagamento(
                rs.getInt("id"),
                new Pedido(rs.getInt("pedido_id"), null, null, null, null, null),
                rs.getDouble("pix"),
                rs.getDouble("dinheiro"),
                rs.getDouble("cartao")
            );
        }

        stmt.close();
        con.close();
        return pagamento;
    }

    @Override
    public List<Pagamento> listar() throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, pedido_id, pix, dinheiro, cartao FROM pagamento"
        );
        ResultSet rs = stmt.executeQuery();

        List<Pagamento> pagamentos = new ArrayList<>();
        while (rs.next()) {
            Pagamento pagamento = new Pagamento(
                rs.getInt("id"),
                new Pedido(rs.getInt("pedido_id"), null, null, null, null, null),
                rs.getDouble("pix"),
                rs.getDouble("dinheiro"),
                rs.getDouble("cartao")
            );
            pagamentos.add(pagamento);
        }

        stmt.close();
        con.close();
        return pagamentos;
    }

    @Override
    public void atualizar(Pagamento pagamento) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "UPDATE pagamento SET pedido_id = ?, pix = ?, dinheiro = ?, cartao = ? WHERE id = ?"
        );
        stmt.setInt(1, pagamento.getPedido().getId());
        stmt.setDouble(2, pagamento.getPix());
        stmt.setDouble(3, pagamento.getDinheiro());
        stmt.setDouble(4, pagamento.getCartao());
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
