package Modelos;

import Modelos.cliente.Cliente;
import Modelos.delivery.Delivery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class EntregaDAOImpl implements EntregaDAO{
    
    @Override
    public void criar(Entrega entrega) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "INSERT INTO entrega(cliente_id, is_delivery, delivery_id, pedido_id, status_id) VALUES (?, ?, ?, ?, ?)"
        );
        p.setInt(1, entrega.getCliente().getId());
        p.setBoolean(2, entrega.isDelivery());
        p.setObject(3, entrega.getDelivery() != null ? entrega.getDelivery().getId() : null);
        p.setObject(4, entrega.getPedido() != null ? entrega.getPedido().getId() : null);
        p.setObject(5, entrega.getStatus() != null ? entrega.getStatus().getId() : null);
        p.executeUpdate();
        con.close();
    }

    @Override
    public Entrega ler(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "SELECT * FROM entrega WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();

        Entrega entrega = null;
        if (r.next()) {
            entrega = new Entrega();
            entrega.setId(r.getInt("id"));
            entrega.setDelivery(r.getInt("delivery_id") != 0 ? new Delivery() {{ setId(r.getInt("delivery_id")); }} : null);
            
            entrega.setCliente(new Cliente() {{ setId(r.getInt("cliente_id")); }});
            entrega.setPedido(new Pedido() {{ setId(r.getInt("pedido_id")); }});
            entrega.setStatus(new StatusPedido() {{ setId(r.getInt("status_id")); }});
            entrega.setDelivery(r.getBoolean("is_delivery"));
        }
        con.close();
        return entrega;
    }

    @Override
    public void atualizar(Entrega entrega) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "UPDATE entrega SET cliente_id = ?, is_delivery = ?, delivery_id = ?, pedido_id = ?, status_id = ? WHERE id = ?"
        );
        p.setInt(1, entrega.getCliente().getId());
        p.setBoolean(2, entrega.isDelivery());
        p.setObject(3, entrega.getDelivery() != null ? entrega.getDelivery().getId() : null);
        p.setObject(4, entrega.getPedido() != null ? entrega.getPedido().getId() : null);
        p.setObject(5, entrega.getStatus() != null ? entrega.getStatus().getId() : null);
        p.setInt(6, entrega.getId());
        p.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement("DELETE FROM entrega WHERE id = ?");
        p.setInt(1, id);
        p.executeUpdate();
        con.close();
    }
}
