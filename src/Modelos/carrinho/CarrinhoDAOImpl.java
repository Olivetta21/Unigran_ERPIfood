package Modelos.carrinho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Modelos.Conexao;
import Modelos.carrinho.produto.Produto;

public class CarrinhoDAOImpl implements CarrinhoDAO {
    
    @Override
    public void criar(Carrinho carrinho) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "INSERT INTO carrinho(produto_id, quantidade) VALUES (?, ?)"
        );
        p.setInt(1, carrinho.getProduto().getId());
        p.setInt(2, carrinho.getQuantidade());
        p.executeUpdate();

        con.close();
    }

    @Override
    public Carrinho ler(int id) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "SELECT id, produto_id, quantidade FROM carrinho WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();
        Carrinho carrinho = null;
        if (r.next()) {
            carrinho = new Carrinho();
            carrinho.setId(r.getInt("id"));
            carrinho.setQuantidade(r.getInt("quantidade"));

            Produto produto = new Produto();
            produto.setId(r.getInt("produto_id"));
            carrinho.setProduto(produto);
        }

        con.close();

        return carrinho;
    }

    @Override
    public void atualizar(Carrinho carrinho) throws Exception {
        Connection con = Conexao.getConnection();

        PreparedStatement p = con.prepareStatement(
            "UPDATE carrinho SET produto_id = ?, quantidade = ? WHERE id = ?"
        );
        p.setInt(1, carrinho.getProduto().getId());
        p.setInt(2, carrinho.getQuantidade());
        p.setInt(3, carrinho.getId());
        p.executeUpdate();
        
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.getConnection();
        PreparedStatement p = con.prepareStatement(
            "DELETE FROM carrinho WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();
        con.close();
    }
}
