package Modelos.pagamento.metodo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Modelos.Conexao;

public class DinheiroDAOImpl implements DinheiroDAO {
    
    @Override
    public void criar(Dinheiro dinheiro) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "INSERT INTO dinheiro (valor) VALUES (?)"
        );
        p.setDouble(1, dinheiro.getValorEntregado());
        p.executeUpdate();
        con.close();
    }

    @Override
    public Dinheiro ler(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "SELECT id, valor FROM dinheiro WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();

        Dinheiro dinheiro = null;
        if (r.next()) {
            dinheiro = new Dinheiro(
                r.getInt("id"),
                r.getDouble("valor")
            );
        }
        con.close();
        return dinheiro;
    }

    @Override
    public void atualizar(Dinheiro dinheiro) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "UPDATE dinheiro SET valor = ? WHERE id = ?"
        );
        p.setDouble(1, dinheiro.getValorEntregado());
        p.setInt(2, dinheiro.getId());
        p.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "DELETE FROM dinheiro WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();
        con.close();
    }

}
