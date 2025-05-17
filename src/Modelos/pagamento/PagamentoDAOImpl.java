package Modelos.pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Modelos.Conexao;
import Modelos.pagamento.cupom.CupomDAOImpl;
import Modelos.pagamento.metodo.MetodoDAOImpl;


public class PagamentoDAOImpl implements PagamentoDAO {
    @Override
    public void criar(Pagamento pagamento) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "INSERT INTO pagamento (pedido_id, metodo_id, cupom_id) VALUES (?, ?, ?)"
        );
        p.setInt(1, pagamento.getPedido_id());
        p.setInt(2, pagamento.getMetodo().getId());
        p.setInt(3, pagamento.getCupom().getId());
        p.executeUpdate();
        con.close();
    }

    @Override
    public Pagamento ler(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "SELECT id, pedido_id, metodo_id, cupom_id FROM pagamento WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();

        Pagamento pagamento = null;
        if (r.next()) {
            pagamento = new Pagamento(
                r.getInt("id"),
                r.getInt("pedido_id"),
                new MetodoDAOImpl().ler(r.getInt("metodo_id")),
                new CupomDAOImpl().ler(r.getInt("cupom_id"))
            );
        }
        con.close();
        return pagamento;
    }

    @Override
    public void atualizar(Pagamento pagamento) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "UPDATE pagamento SET pedido_id = ?, metodo_id = ?, cupom_id = ? WHERE id = ?"
        );
        p.setInt(1, pagamento.getPedido_id());
        p.setInt(2, pagamento.getMetodo().getId());
        p.setInt(3, pagamento.getCupom().getId());
        p.setInt(4, pagamento.getId());
        p.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "DELETE FROM pagamento WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();
        con.close();
    }
    
}
