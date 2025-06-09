package Modelos.pagamento.cupom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import Modelos.pagamento.Pagamento;

public class CupomDAOImpl implements CupomDAO {
    
    @Override
    public void criar(Cupom cupom) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO cupom(valor, codigo, validade, pagamento_id) VALUES (?, ?, ?, ?)"
        );
        stmt.setDouble(1, cupom.getValor());
        stmt.setString(2, cupom.getCodigo());
        stmt.setDate(3, java.sql.Date.valueOf(cupom.getValidade()));
        stmt.setInt(4, cupom.getPagamento().getId());
        stmt.executeUpdate();
        con.close();
    }

    @Override
    public Cupom ler(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, valor, codigo, validade, pagamento_id FROM cupom WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet r = stmt.executeQuery();

        Cupom cupom = null;
        if (r.next()) {
            cupom = new Cupom();
            cupom.setId(r.getInt("id"));
            cupom.setValor(r.getDouble("valor"));
            cupom.setCodigo(r.getString("codigo"));
            cupom.setValidade(r.getString("validade"));
            cupom.setPagamento(new Pagamento(
                r.getInt("pagamento_id"), null, 0.0, 0.0, 0.0
            ));
        }
        con.close();
        return cupom;
    }

    @Override
    public List<Cupom> listar() throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement("SELECT id, valor, codigo, validade, pagamento_id FROM cupom");
        ResultSet rs = stmt.executeQuery();

        List<Cupom> cupons = new ArrayList<>();
        while (rs.next()) {
            Cupom cupom = new Cupom();
            cupom.setId(rs.getInt("id"));
            cupom.setValor(rs.getDouble("valor"));
            cupom.setCodigo(rs.getString("codigo"));
            cupom.setValidade(rs.getString("validade"));
            cupom.setPagamento(new Pagamento(
                rs.getInt("pagamento_id"), null, 0.0, 0.0, 0.0
            ));
            cupons.add(cupom);
        }
        con.close();
        return cupons;
    }

    @Override
    public void atualizar(Cupom cupom) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "UPDATE cupom SET valor = ?, codigo = ?, validade = ?, pagamento_id = ? WHERE id = ?"
        );
        stmt.setDouble(1, cupom.getValor());
        stmt.setString(2, cupom.getCodigo());
        stmt.setDate(3, java.sql.Date.valueOf(cupom.getValidade()));
        stmt.setInt(4, cupom.getPagamento().getId());
        stmt.setInt(5, cupom.getId());
        stmt.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement("DELETE FROM cupom WHERE id = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
        con.close();
    }
}
