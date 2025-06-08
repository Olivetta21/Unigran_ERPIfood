package Modelos.carrinho.ingrediente;

import Conexao.Conexao;
import Modelos.carrinho.Carrinho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IngredienteEscolhaDAOImpl implements IngredienteEscolhaDAO {
    @Override
    public void criar(IngredienteEscolha ingredienteEscolha) throws Exception {
        Connection con = Conexao.get();

        String sql = "INSERT INTO ingrediente_escolha (ingrediente_id, carrinho_id, toExclude) VALUES (?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);        
        stmt.setInt(1, ingredienteEscolha.getIngrediente().getId());
        stmt.setInt(2, ingredienteEscolha.getCarrinho().getId());
        stmt.setBoolean(3, ingredienteEscolha.getToExclude());
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    @Override
    public IngredienteEscolha ler(int id) throws Exception {
        Connection con = Conexao.get();

        String sql = "SELECT id, ingrediente_id, ingrediente_nome, ingrediente_valor, carrinho_id, toExclude FROM ingrediente_escolha_completo WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        IngredienteEscolha ingredienteEscolha = null;
        if (rs.next()) {
            ingredienteEscolha = new IngredienteEscolha();
            ingredienteEscolha.setId(rs.getInt("id"));
            ingredienteEscolha.setIngrediente(
                new Ingrediente(
                    rs.getInt("ingrediente_id"),
                    rs.getString("ingrediente_nome"),
                    rs.getDouble("ingrediente_valor")
                )
            );
            ingredienteEscolha.setToExclude(rs.getBoolean("toExclude"));
            ingredienteEscolha.setCarrinho(
                new Carrinho(
                    rs.getInt("carrinho_id"), null, null, null
                )
            );
        }

        rs.close();
        stmt.close();
        con.close();

        return ingredienteEscolha;
    }

    @Override
    public List<IngredienteEscolha> listar() throws Exception {
        Connection con = Conexao.get();

        String sql = "SELECT id, ingrediente_id, ingrediente_nome, ingrediente_valor, carrinho_id, toExclude FROM ingrediente_escolha_completo";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<IngredienteEscolha> lista = new ArrayList<>();
        while (rs.next()) {
            IngredienteEscolha ingredienteEscolha = new IngredienteEscolha();
            ingredienteEscolha.setId(rs.getInt("id"));
            ingredienteEscolha.setIngrediente(
                new Ingrediente(
                    rs.getInt("ingrediente_id"),
                    rs.getString("ingrediente_nome"),
                    rs.getDouble("ingrediente_valor")
                )
            );
            ingredienteEscolha.setToExclude(rs.getBoolean("toExclude"));
            ingredienteEscolha.setCarrinho(
                new Carrinho(
                    rs.getInt("carrinho_id"), null, null, null
                )
            );
            lista.add(ingredienteEscolha);
        }

        rs.close();
        stmt.close();
        con.close();

        return lista;
    }

    @Override
    public void atualizar(IngredienteEscolha ingredienteEscolha) throws Exception {
        Connection con = Conexao.get();

        String sql = "UPDATE ingrediente_escolha SET ingrediente_id = ?, carrinho_id = ?, toExclude = ? WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, ingredienteEscolha.getIngrediente().getId());
        stmt.setInt(2, ingredienteEscolha.getCarrinho().getId());
        stmt.setBoolean(3, ingredienteEscolha.getToExclude());
        stmt.setInt(4, ingredienteEscolha.getId());
        
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
