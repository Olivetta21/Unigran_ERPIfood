package Modelos.carrinho.ingrediente;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IngredienteEscolhaDAOImpl implements IngredienteEscolhaDAO {
    @Override
    public void criar(IngredienteEscolha ingredienteEscolha) throws Exception {
        Connection con = Conexao.get();

        String sql = "INSERT INTO ingrediente_escolha (toExclude, ingrediente_id) VALUES (?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setBoolean(1, ingredienteEscolha.getToExclude());
        stmt.setInt(2, ingredienteEscolha.getIngrediente().getId());
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    @Override
    public IngredienteEscolha ler(int id) throws Exception {
        Connection con = Conexao.get();

        String sql = "SELECT * FROM ingrediente_escolha WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        IngredienteEscolha ingredienteEscolha = null;
        if (rs.next()) {
            ingredienteEscolha = new IngredienteEscolha();
            ingredienteEscolha.setId(rs.getInt("id"));
            ingredienteEscolha.setToExclude(rs.getBoolean("toExclude"));
            IngredienteDAOImpl ingredienteDAO = new IngredienteDAOImpl();
            Ingrediente ingrediente = ingredienteDAO.ler(rs.getInt("ingrediente_id"));
            ingredienteEscolha.setIngrediente(ingrediente);
        }

        rs.close();
        stmt.close();
        con.close();

        return ingredienteEscolha;
    }

    @Override
    public void atualizar(IngredienteEscolha ingredienteEscolha) throws Exception {
        Connection con = Conexao.get();

        String sql = "UPDATE ingrediente_escolha SET toExclude = ?, ingrediente_id = ? WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setBoolean(1, ingredienteEscolha.getToExclude());
        stmt.setInt(2, ingredienteEscolha.getIngrediente().getId());
        stmt.setInt(3, ingredienteEscolha.getId());
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();
        
        String sql = "DELETE from ingrediente_escolha where id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        
        stmt.close();
        con.close();
    }
    
}
