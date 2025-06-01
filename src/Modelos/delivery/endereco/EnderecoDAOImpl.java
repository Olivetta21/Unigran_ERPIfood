package Modelos.delivery.endereco;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAOImpl implements EnderecoDAO {
    @Override
    public void criar(Endereco endereco) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO endereco(cep, bairro_id, complemento, rua, numero) VALUES (?, ?, ?, ?, ?)"
        );
        stmt.setString(1, endereco.getCep());
        stmt.setInt(2, endereco.getBairro().getId());
        stmt.setString(3, endereco.getComplemento());
        stmt.setString(4, endereco.getRua());
        stmt.setString(5, endereco.getNumero());
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    @Override
    public Endereco ler(int id) throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, cep, bairro_id, bairro_nome, complemento, rua, numero FROM endereco_completo WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Endereco endereco = null;
        if (rs.next()) {
            endereco = new Endereco();
            endereco.setId(rs.getInt("id"));
            endereco.setCep(rs.getString("cep"));
            endereco.setBairro(new Bairro(rs.getInt("bairro_id"), rs.getString("bairro_nome")));
            endereco.setComplemento(rs.getString("complemento"));
            endereco.setRua(rs.getString("rua"));
            endereco.setNumero(rs.getString("numero"));
        }

        rs.close();
        stmt.close();
        con.close();

        return endereco;
    }

    @Override
    public List<Endereco> listar() throws Exception {
        Connection con = Conexao.get();
        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, cep, bairro_id, bairro_nome, complemento, rua, numero FROM endereco_completo"
        );
        ResultSet rs = stmt.executeQuery();

        List<Endereco> enderecos = new ArrayList<>();
        while (rs.next()) {
            Endereco endereco = new Endereco();
            endereco.setId(rs.getInt("id"));
            endereco.setCep(rs.getString("cep"));
            endereco.setBairro(new Bairro(rs.getInt("bairro_id"), rs.getString("bairro_nome")));
            endereco.setComplemento(rs.getString("complemento"));
            endereco.setRua(rs.getString("rua"));
            endereco.setNumero(rs.getString("numero"));
            enderecos.add(endereco);
        }

        rs.close();
        stmt.close();
        con.close();

        return enderecos;
    }
    
    @Override
    public void atualizar(Endereco endereco) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "UPDATE endereco SET rua = ?, numero = ?, cep = ?, bairro_id = ?, complemento = ? WHERE id = ?"
        );
        stmt.setString(1, endereco.getRua());
        stmt.setString(2, endereco.getNumero());
        stmt.setString(3, endereco.getCep());
        stmt.setInt(4, endereco.getBairro().getId());
        stmt.setString(5, endereco.getComplemento());
        stmt.setInt(6, endereco.getId());
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "DELETE FROM endereco WHERE id = ?"
        );
        stmt.setInt(1, id);
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }
}
