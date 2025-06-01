package Modelos.delivery.endereco;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BairroDAOImpl implements BairroDAO {
    
    @Override
    public void criar(Bairro bairro) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement p = con.prepareStatement(
            "INSERT INTO bairro(nome) VALUES (?)"
        );
        p.setString(1, bairro.getNome());
        p.executeUpdate();
        con.close();
    }

    @Override
    public Bairro ler(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement p = con.prepareStatement(
            "SELECT id, nome FROM bairro WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();

        Bairro bairro = null;
        if (r.next()) {
            bairro = new Bairro();
            bairro.setId(r.getInt("id"));
            bairro.setNome(r.getString("nome"));
        }
        con.close();
        return bairro;
    }
    
    @Override
    public List<Bairro> listar() throws Exception {
        Connection con = Conexao.get();
        
        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, nome FROM bairro"
        );
        ResultSet rs = stmt.executeQuery();

        List<Bairro> bairros = new ArrayList<>();
        while (rs.next()) {
            Bairro bairro = new Bairro();
            bairro.setId(rs.getInt("id"));
            bairro.setNome(rs.getString("nome"));
            bairros.add(bairro);
        }
        
        rs.close();
        stmt.close();
        con.close();
        
        return bairros;
    }
    

    @Override
    public void atualizar(Bairro bairro) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement p = con.prepareStatement(
            "UPDATE bairro SET nome = ? WHERE id = ?"
        );
        p.setString(1, bairro.getNome());
        p.setInt(2, bairro.getId());
        p.executeUpdate();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement p = con.prepareStatement(
            "DELETE FROM bairro WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();
        con.close();
    }

}
