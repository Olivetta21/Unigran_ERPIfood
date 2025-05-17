package Modelos.carrinho.ingrediente;

import Modelos.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IngredienteEscolhaDAOImpl implements IngredienteEscolhaDAO {
    @Override
    public void criar(IngredienteEscolha ingredienteEscolha) throws Exception {
        Connection con = Conexao.getConnection();
        
        PreparedStatement p = con.prepareStatement(
            "INSERT INTO ingrediente_escolha (id) VALUES (?)"
        );
        p.setInt(1, ingredienteEscolha.getId());
        p.executeUpdate();

        con.close();
    }

    @Override
    public IngredienteEscolha ler(int id) throws Exception {
        Connection con = Conexao.getConnection();

        IngredienteEscolha ingredienteEscolha = null;
        //kkkk nem faz sentido, mas é assim que tá no banco de dados
        PreparedStatement p = con.prepareStatement(
            "SELECT id FROM ingrediente_escolha WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            ingredienteEscolha = new IngredienteEscolha();
            ingredienteEscolha.setId(r.getInt("id"));
        }

        con.close();

        return ingredienteEscolha;
    }

    @Override
    public void atualizar(IngredienteEscolha ingredienteEscolha) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "UPDATE ingrediente_escolha SET id = ? WHERE id = ?"
        );
        p.setInt(1, ingredienteEscolha.getId());
        p.setInt(2, ingredienteEscolha.getId());
        p.executeUpdate();
        
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "DELETE FROM ingrediente_escolha WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();

        con.close();
    }    
}
