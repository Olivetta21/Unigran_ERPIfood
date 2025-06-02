package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import Modelos.cliente.Cliente;
import Modelos.delivery.Entrega;
import Modelos.delivery.endereco.Bairro;
import Modelos.delivery.endereco.Endereco;

public class PedidoDAOImpl implements PedidoDAO {
    @Override
    public void criar(Pedido pedido) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO pedido(cliente_id, status_pedido_id, entrega_id) VALUES (?, ?, ?)"
        );
        stmt.setInt(1, pedido.getCliente().getId());
        stmt.setInt(2, pedido.getStatus().getId());
        stmt.setInt(3, pedido.getEntrega().getId());
        stmt.executeUpdate();
        con.close();
    }

    @Override
    public Pedido ler(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, cliente_id, cliente_nome, data_pedido, status_id, status_progresso, entrega_id, chave, ender_id, cep, bairro_id, bairro_nome, " +
            "complemento, rua, numero, valor, reembolsado FROM pedido_completo WHERE id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Pedido pedido = null;
        if (rs.next()) {
            pedido = new Pedido();
            pedido.setId(rs.getInt("id"));
            pedido.setCliente(
                new Cliente(
                    rs.getInt("cliente_id"),
                    rs.getString("cliente_nome"),
                    null
                )
            );
            pedido.setData_pedido(rs.getString("data_pedido"));
            pedido.setStatus(new StatusPedido(
                rs.getInt("status_id"),
                rs.getString("status_progresso")
            ));
            pedido.setEntrega(new Entrega(
                rs.getInt("entrega_id"),
                rs.getString("chave"),
                new Endereco(
                    rs.getInt("ender_id"),
                    rs.getString("cep"),
                    new Bairro(
                        rs.getInt("bairro_id"),
                        rs.getString("bairro_nome")
                    ),
                    rs.getString("complemento"),
                    rs.getString("rua"),
                    rs.getString("numero")
                ),
                rs.getDouble("valor")
            ));
            pedido.setReembolso(rs.getString("reembolsado"));
        }

        con.close();
        return pedido;
    }

    @Override
    public List<Pedido> listar() throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, cliente_id, cliente_nome, data_pedido, status_id, status_progresso, entrega_id, chave, ender_id, cep, bairro_id, bairro_nome, " +
            "complemento, rua, numero, valor, reembolsado FROM pedido_completo"
        );
        ResultSet rs = stmt.executeQuery();

        List<Pedido> pedidos = new ArrayList<>();
        while (rs.next()) {
            Pedido pedido = new Pedido();
            pedido.setId(rs.getInt("id"));
            pedido.setCliente(
                new Cliente(
                    rs.getInt("cliente_id"),
                    rs.getString("cliente_nome"),
                    null
                )
            );
            pedido.setData_pedido(rs.getString("data_pedido"));
            pedido.setStatus(new StatusPedido(
                rs.getInt("status_id"),
                rs.getString("status_progresso")
            ));
            pedido.setEntrega(new Entrega(
                rs.getInt("entrega_id"),
                rs.getString("chave"),
                new Endereco(
                    rs.getInt("ender_id"),
                    rs.getString("cep"),
                    new Bairro(
                        rs.getInt("bairro_id"),
                        rs.getString("bairro_nome")
                    ),
                    rs.getString("complemento"),
                    rs.getString("rua"),
                    rs.getString("numero")
                ),
                rs.getDouble("valor")
            ));
            pedido.setReembolso(rs.getString("reembolsado"));

            pedidos.add(pedido);
        }

        con.close();
        return pedidos;
    }

    @Override
    public void atualizar(Pedido pedido) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "UPDATE pedido SET cliente_id = ?, status_pedido_id = ?, entrega_id = ?, reembolsado = ? WHERE id = ?"
        );
        stmt.setInt(1, pedido.getCliente().getId());
        stmt.setInt(2, pedido.getStatus().getId());
        stmt.setInt(3, pedido.getEntrega().getId());
        stmt.setString(4, pedido.getReembolso());
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
