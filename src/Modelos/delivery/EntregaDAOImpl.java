package Modelos.delivery;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexao.Conexao;
import Modelos.delivery.endereco.Bairro;
import Modelos.delivery.endereco.Endereco;

import java.util.ArrayList;
import java.util.List;


public class EntregaDAOImpl implements EntregaDAO{
    @Override
    public void criar(Entrega entrega) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO entrega(chave, endereco_id, valor) VALUES (?, ?, ?)"
        );
        stmt.setString(1, entrega.getChave());
        stmt.setInt(2, entrega.getEndereco().getId());
        stmt.setDouble(3, entrega.getValor());
        stmt.executeUpdate();

        con.close();
    }

    @Override
    public Entrega ler(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, chave, ender_id, cep, bairro_id, bairro_nome, complemento, rua, numero, valor FROM entrega_completa WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Entrega entrega = null;
        if (rs.next()) {
            entrega = new Entrega();
            entrega.setId(rs.getInt("id"));
            entrega.setChave(rs.getString("chave"));
            entrega.setValor(rs.getDouble("valor"));
            
            entrega.setEndereco(
                new Endereco(
                    rs.getInt("ender_id"),
                    rs.getString("cep"),
                    new Bairro(
                        rs.getInt("bairro_id"),
                        rs.getString("bairro_nome")
                    ),
                    rs.getString("complemento"),
                    rs.getString("rua"),
                    rs.getString("numero")
                )
            );
        }

        con.close();
        return entrega;
    }

    @Override
    public List<Entrega> listar() throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, chave, ender_id, cep, bairro_id, bairro_nome, complemento, rua, numero, valor FROM entrega_completa"
        );
        ResultSet rs = stmt.executeQuery();

        List<Entrega> entregas = new ArrayList<>();
        while (rs.next()) {
            Entrega entrega = new Entrega();
            entrega.setId(rs.getInt("id"));
            entrega.setChave(rs.getString("chave"));
            entrega.setValor(rs.getDouble("valor"));
            
            entrega.setEndereco(
                new Endereco(
                    rs.getInt("ender_id"),
                    rs.getString("cep"),
                    new Bairro(
                        rs.getInt("bairro_id"),
                        rs.getString("bairro_nome")
                    ),
                    rs.getString("complemento"),
                    rs.getString("rua"),
                    rs.getString("numero")
                )
            );
            entregas.add(entrega);
        }

        rs.close();
        stmt.close();
        con.close();

        return entregas;
    }

    @Override
    public void atualizar(Entrega entrega) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "UPDATE entrega SET chave = ?, endereco_id = ?, valor = ? WHERE id = ?"
        );
        stmt.setString(1, entrega.getChave());
        stmt.setInt(2, entrega.getEndereco().getId());
        stmt.setDouble(3, entrega.getValor());
        stmt.setInt(4, entrega.getId());
        stmt.executeUpdate();

        con.close();
    }

    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "DELETE FROM entrega WHERE id = ?"
        );
        stmt.setInt(1, id);
        stmt.executeUpdate();

        con.close();
    }
}
