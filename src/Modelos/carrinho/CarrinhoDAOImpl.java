package Modelos.carrinho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import Modelos.Pedido;
import Modelos.carrinho.produto.Produto;

public class CarrinhoDAOImpl implements CarrinhoDAO {
    
    @Override
    public void criar(Carrinho carrinho) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO carrinho(pedido_id, produto_id, quantidade) VALUES (?, ?, ?)"
        );
        stmt.setInt(1, carrinho.getPedido().getId());
        stmt.setInt(2, carrinho.getProduto().getId());
        stmt.setInt(3, carrinho.getQuantidade());
        stmt.executeUpdate();

        con.close();
    }

    @Override
    public Carrinho ler(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, pedido_id, produto_id, produto_nome, produto_valor, quantidade FROM carrinho_completo WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Carrinho carrinho = null;
        if (rs.next()) {
            carrinho = new Carrinho();
            carrinho.setId(rs.getInt("id"));
            carrinho.setQuantidade(rs.getInt("quantidade"));
            carrinho.setPedido(new Pedido(
                rs.getInt("pedido_id"), null, null, null, null, null
            ));
            carrinho.setProduto(new Produto(
                rs.getInt("produto_id"),
                rs.getString("produto_nome"),
                rs.getDouble("produto_valor"))
            );
        }

        stmt.close();
        rs.close();
        con.close();

        return carrinho;
    }

    @Override
    public List<Carrinho> listar() throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, pedido_id, produto_id, produto_nome, produto_valor, quantidade FROM carrinho_completo"
        );
        ResultSet rs = stmt.executeQuery();
        
        List<Carrinho> carrinhos = new ArrayList<>();
        while (rs.next()) {
            Carrinho carrinho = new Carrinho();
            carrinho.setId(rs.getInt("id"));
            carrinho.setQuantidade(rs.getInt("quantidade"));
            carrinho.setPedido(new Pedido(
                rs.getInt("pedido_id"), null, null, null, null, null
            ));
            carrinho.setProduto(new Produto(
                rs.getInt("produto_id"),
                rs.getString("produto_nome"),
                rs.getDouble("produto_valor"))
            );
            carrinhos.add(carrinho);
        }

        stmt.close();
        rs.close();
        con.close();

        return carrinhos;
    }

    @Override
    public void atualizar(Carrinho carrinho) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "UPDATE carrinho SET pedido_id = ?, produto_id = ?, quantidade = ? WHERE id = ?"
        );
        stmt.setInt(1, carrinho.getPedido().getId());
        stmt.setInt(2, carrinho.getProduto().getId());
        stmt.setInt(3, carrinho.getQuantidade());
        stmt.setInt(4, carrinho.getId());
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
