package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Modelos.cliente.Cliente;

public class PedidoDAOImpl implements PedidoDAO {
     @Override
    public void criar(Pedido p) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO pedido (datatime_pedido, npedido, cliente_id, reembolso, status_id) VALUES (?, ?, ?, ?, ?)"
        );
        ps.setInt(1, p.getDatatime_pedido());
        ps.setInt(2, p.getNPedido());
        ps.setInt(3, p.getCliente().getId());
        ps.setString(4, p.getReembolso());
        ps.setInt(5, p.getStatus().getId());
        ps.executeUpdate();
        con.close();
    }

    @Override
    public Pedido ler(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT id, datatime_pedido, npedido, cliente_id, reembolso, status_id FROM pedido WHERE id = ?"
        );
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Pedido p = null;
        if (rs.next()) {
            p = new Pedido();
            p.setId(rs.getInt("id"));
            p.setDatatime_pedido(rs.getInt("datatime_pedido"));
            p.setNPedido(rs.getInt("npedido"));

            Cliente c = new Cliente();
            c.setId(rs.getInt("cliente_id"));
            p.setCliente(c);

            p.setReembolso(rs.getString("reembolso"));

            StatusPedido status = new StatusPedido();
            status.setId(rs.getInt("status_id"));
            p.setStatus(status);
        }
        con.close();
        return p;
    }

    @Override
    public void atualizar(Pedido p) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE pedido SET datatime_pedido = ?, npedido = ?, cliente_id = ?, reembolso = ?, status_id = ? WHERE id = ?"
        );
        ps.setInt(1, p.getDatatime_pedido());
        ps.setInt(2, p.getNPedido());
        ps.setInt(3, p.getCliente().getId());
        ps.setString(4, p.getReembolso());
        ps.setInt(5, p.getStatus().getId());
        ps.setInt(6, p.getId());
        ps.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM pedido WHERE id = ?"
        );
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }

}
