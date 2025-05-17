package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexao.Conexao;
import Modelos.cliente.Cliente;
import Modelos.cliente.ClienteDAOImpl;

public class PedidoDAOImpl implements PedidoDAO {
    @Override
    public void criar(Pedido pedido) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO pedido(cliente_id, datatime_pedido, reembolso, status) VALUES (?, ?, ?, ?)"
        );
        stmt.setInt(1, pedido.getCliente().getId());
        stmt.setInt(2, pedido.getDatatime_pedido());
        stmt.setString(3, pedido.getReembolso());
        stmt.setString(4, pedido.getStatus().toString());
        stmt.executeUpdate();
        con.close();
    }

    @Override
    public Pedido ler(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, cliente_id, datatime_pedido, reembolso, status_id FROM pedido WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet r = stmt.executeQuery();

        Pedido pedido = null;
        if (r.next()) {
            pedido = new Pedido();
            pedido.setId(r.getInt("id"));
            pedido.setDatatime_pedido(r.getInt("datatime_pedido"));
            pedido.setReembolso(r.getString("reembolso"));
            pedido.setStatus(new StatusPedidoDAOImpl().ler(r.getInt("status_id")));
            
            ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
            Cliente cliente = clienteDAO.ler(r.getInt("cliente_id"));
            pedido.setCliente(cliente);
        }
        con.close();
        return pedido;
    }

    @Override
    public void atualizar(Pedido pedido) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "UPDATE pedido SET cliente_id = ?, datatime_pedido = ?, reembolso = ?, status = ? WHERE id = ?"
        );
        stmt.setInt(1, pedido.getCliente().getId());
        stmt.setInt(2, pedido.getDatatime_pedido());
        stmt.setString(3, pedido.getReembolso());
        stmt.setString(4, pedido.getStatus().toString());
        stmt.setInt(5, pedido.getId());
        stmt.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "DELETE FROM pedido WHERE id = ?"
        );
        stmt.setInt(1, id);
        stmt.executeUpdate();
        
        stmt.close();
        con.close();
    }
}
