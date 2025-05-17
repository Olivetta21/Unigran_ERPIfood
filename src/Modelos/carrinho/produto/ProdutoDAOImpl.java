package Modelos.carrinho.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Modelos.Conexao;

public class ProdutoDAOImpl implements ProdutoDAO {
    
    @Override
    public void criar(Produto produto) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "INSERT INTO produto(nome, vlr_uni) VALUES(?, ?)"
        );
        p.setString(1, produto.getNome());
        p.setDouble(2, produto.getVlr_uni());
        p.executeUpdate();

        con.close();
    }

    @Override
    public Produto ler(int id) throws Exception {
        Connection con = Conexao.getConnection();

        Produto produto = null;
        PreparedStatement p = con.prepareStatement(
            "SELECT id, nome, vlr_uni FROM produto WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            produto = new Produto();
            produto.setId(r.getInt("id"));
            produto.setNome(r.getString("nome"));
            produto.setVlr_uni(r.getDouble("vlr_uni"));
        }

        con.close();

        return produto;
    }

    @Override
    public void atualizar(Produto produto) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "UPDATE produto SET nome = ?, vlr_uni = ? WHERE id = ?"
        );
        p.setString(1, produto.getNome());
        p.setDouble(2, produto.getVlr_uni());
        p.setInt(3, produto.getId());
        p.executeUpdate();
        
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "DELETE FROM produto WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();
        
        con.close();
    }
    
}
