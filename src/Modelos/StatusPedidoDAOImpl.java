package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexao.Conexao;

public class StatusPedidoDAOImpl implements StatusPedidoDAO {
    @Override
    public void criar(StatusPedido s) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement p = con.prepareStatement(
            "INSERT INTO status_pedido (progresso) VALUES (?)"
        );
        p.setString(1, s.getProgresso());
        p.executeUpdate();
        con.close();
    }

    @Override
    public StatusPedido ler(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement p = con.prepareStatement(
            "SELECT id, progresso FROM status_pedido WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet rs = p.executeQuery();
        StatusPedido s = null;
        if (rs.next()) {
            s = new StatusPedido();
            s.setId(rs.getInt("id"));
            s.setProgresso(rs.getString("progresso"));
        }
        con.close();
        return s;
    }

    @Override
    public void atualizar(StatusPedido s) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement p = con.prepareStatement(
            "UPDATE status_pedido SET progresso = ? WHERE id = ?"
        );
        p.setString(1, s.getProgresso());
        p.setInt(2, s.getId());
        p.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement p = con.prepareStatement(
            "DELETE FROM status_pedido WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();
        con.close();
    }
}
