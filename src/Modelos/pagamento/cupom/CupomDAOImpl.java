package Modelos.pagamento.cupom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Modelos.Conexao;

public class CupomDAOImpl implements CupomDAO {
    
    @Override
    public void criar(Cupom cupom) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "INSERT INTO cupom(valor, codigo, validade) VALUES (?, ?, ?)"
        );
        p.setDouble(1, cupom.getValor());
        p.setInt(2, cupom.getCodigo());
        p.setInt(3, cupom.getValidade());
        p.executeUpdate();
        con.close();
    }

    @Override
    public Cupom ler(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "SELECT id, valor, codigo, validade FROM cupom WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();

        Cupom cupom = null;
        if (r.next()) {
            cupom = new Cupom(
                r.getInt("id"),
                r.getDouble("valor"),
                r.getInt("codigo"),
                r.getInt("validade")
            );
        }
        con.close();
        return cupom;
    }

    @Override
    public void atualizar(Cupom cupom) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "UPDATE cupom SET valor = ?, codigo = ?, validade = ? WHERE id = ?"
        );
        p.setDouble(1, cupom.getValor());
        p.setInt(2, cupom.getCodigo());
        p.setInt(3, cupom.getValidade());
        p.setInt(4, cupom.getId());
        p.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement("DELETE FROM cupom WHERE id = ?");
        p.setInt(1, id);
        p.executeUpdate();
        con.close();
    }
}
