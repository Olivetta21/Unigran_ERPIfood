package Modelos.carrinho.ingrediente;

import Modelos.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IngrRemDAOImpl implements IngrRemDAO {
    @Override
    public void criar(IngrRem ingrRem) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "INSERT INTO ingr_rem (nome) VALUES (?)"
        );
        p.setString(1, ingrRem.getNome());
        p.executeUpdate();

        con.close();
    }

    @Override
    public IngrRem ler(int id) throws Exception {
        Connection con = Conexao.getConnection();

        IngrRem ingrRem = null;
        PreparedStatement p = con.prepareStatement(
            "SELECT id, nome FROM ingr_rem WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            ingrRem = new IngrRem();
            ingrRem.setId(r.getInt("id"));
            ingrRem.setNome(r.getString("nome"));
        }

        con.close();

        return ingrRem;
    }

    @Override
    public void atualizar(IngrRem ingrRem) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "UPDATE ingr_rem SET nome = ? WHERE id = ?"
        );
        p.setString(1, ingrRem.getNome());
        p.setInt(2, ingrRem.getId());
        p.executeUpdate();
        
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "DELETE FROM ingr_rem WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();
        
        con.close();
    }
    
}
