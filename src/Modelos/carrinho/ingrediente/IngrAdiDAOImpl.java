package Modelos.carrinho.ingrediente;

import Modelos.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IngrAdiDAOImpl implements IngrAdiDAO {
    @Override
    public void criar(IngrAdi ingrAdi) throws Exception {
        Connection con = Conexao.getConnection();
        
        PreparedStatement p = con.prepareStatement(
            "INSERT INTO ingr_adi (nome) VALUES (?)"
        );
        p.setString(1, ingrAdi.getNome());
        p.executeUpdate();

        con.close();
    }

    @Override
    public IngrAdi ler(int id) throws Exception {
        Connection con = Conexao.getConnection();

        IngrAdi ingrAdi = null;
        PreparedStatement p = con.prepareStatement(
            "SELECT id, nome FROM ingr_adi WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            ingrAdi = new IngrAdi();
            ingrAdi.setId(r.getInt("id"));
            ingrAdi.setNome(r.getString("nome"));
        }

        con.close();

        return ingrAdi;
    }

    @Override
    public void atualizar(IngrAdi ingrAdi) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "UPDATE ingr_adi SET nome = ? WHERE id = ?"
        );
        p.setString(1, ingrAdi.getNome());
        p.setInt(2, ingrAdi.getId());
        p.executeUpdate();
        
        con.close();
    }
    
    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "DELETE FROM ingr_adi WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();
        
        con.close();
    }
}
