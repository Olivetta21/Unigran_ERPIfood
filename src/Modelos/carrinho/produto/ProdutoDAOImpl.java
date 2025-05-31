package Modelos.carrinho.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexao.Conexao;
import javax.swing.JOptionPane;

public class ProdutoDAOImpl implements ProdutoDAO {
    
    @Override
    public void criar(Produto produto) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO produto(nome, valor) VALUES(?, ?)"
        );
        
        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getValor());
        stmt.executeUpdate();

        stmt.close();
        con.close();

        
        StringBuilder strb = new StringBuilder();
        strb.append("Produto " + produto.getId() + ":");
        strb.append(produto.getNome());
        strb.append(" com valor: ");
        strb.append(produto.getValor());
        strb.append(" cadastrado com sucesso!"); 
        JOptionPane.showMessageDialog(null, strb.toString(), "Cadastro de Produto", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public Produto ler(int id) throws Exception {
        Connection con = Conexao.get();

        Produto produto = null;
        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, nome, valor FROM produto WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            produto = new Produto();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setValor(rs.getDouble("valor"));
        }

        stmt.close();
        rs.close();
        con.close();

        return produto;
    }

    @Override
    public void atualizar(Produto produto) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "UPDATE produto SET nome = ?, valor = ? WHERE id = ?"
        );
        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getValor());
        stmt.setInt(3, produto.getId());
        stmt.executeUpdate();
        
        stmt.close();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "DELETE FROM produto WHERE id = ?"
        );
        stmt.setInt(1, id);
        stmt.executeUpdate();
        
        stmt.close();
        con.close();
    }
    
}
