package Modelos.carrinho.ingrediente;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAOImpl implements IngredienteDAO {
    @Override
    public void criar(Ingrediente ingrediente) throws Exception {
        Connection con = Conexao.get();

        String sql = "INSERT INTO ingrediente (nome, valor) VALUES (?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, ingrediente.getNome());
        stmt.setDouble(2, ingrediente.getValor());
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    @Override
    public Ingrediente ler(int id) throws Exception {
        Connection con = Conexao.get();

        String sql = "SELECT * FROM ingrediente WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Ingrediente ingrediente = null;
        if (rs.next()) {
            ingrediente = new Ingrediente();
            ingrediente.setId(rs.getInt("id"));
            ingrediente.setNome(rs.getString("nome"));
            ingrediente.setValor(rs.getDouble("valor"));
        }

        rs.close();
        stmt.close();
        con.close();

        return ingrediente;
    }
    
    @Override
    public List<Ingrediente> listar() throws Exception {
        Connection con = Conexao.get();
        String sql = "select id, nome, valor from ingrediente";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        List<Ingrediente> ingredientes = new ArrayList<>();
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setId(rs.getInt("id"));
            ingrediente.setNome(rs.getString("nome"));
            ingrediente.setValor(rs.getDouble("valor"));
            ingredientes.add(ingrediente);
        }
        
        rs.close();
        stmt.close();
        con.close();
        
        return ingredientes;
    }

    @Override
    public void atualizar(Ingrediente ingrediente) throws Exception {
        Connection con = Conexao.get();

        String sql = "UPDATE ingrediente SET nome = ?, valor = ? WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, ingrediente.getNome());
        stmt.setDouble(2, ingrediente.getValor());
        stmt.setInt(3, ingrediente.getId());
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();

        String sql = "DELETE FROM ingrediente WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }
    
}
