package Modelos.carrinho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexao.Conexao;
import Modelos.carrinho.produto.ProdutoDAOImpl;

public class CarrinhoDAOImpl implements CarrinhoDAO {
    
    @Override
    public void criar(Carrinho carrinho) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO carrinho(produto_id, quantidade) VALUES (?, ?)"
        );
        stmt.setInt(1, carrinho.getProduto().getId());
        stmt.setInt(2, carrinho.getQuantidade());
        stmt.executeUpdate();

        con.close();
    }

    @Override
    public Carrinho ler(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, produto_id, quantidade FROM carrinho WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Carrinho carrinho = null;
        if (rs.next()) {
            carrinho = new Carrinho();
            carrinho.setId(rs.getInt("id"));
            carrinho.setQuantidade(rs.getInt("quantidade"));

            carrinho.setProduto(new ProdutoDAOImpl().ler(rs.getInt("produto_id")));
        }

        stmt.close();
        rs.close();
        con.close();

        return carrinho;
    }

    @Override
    public void atualizar(Carrinho carrinho) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "UPDATE carrinho SET produto_id = ?, quantidade = ? WHERE id = ?"
        );
        stmt.setInt(1, carrinho.getProduto().getId());
        stmt.setInt(2, carrinho.getQuantidade());
        stmt.setInt(3, carrinho.getId());
        stmt.executeUpdate();
        
        stmt.close();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();
        
        PreparedStatement stmt = con.prepareStatement(
            "DELETE FROM carrinho WHERE id = ?"
        );
        stmt.setInt(1, id);
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }
}
