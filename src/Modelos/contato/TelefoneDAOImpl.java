package Modelos.contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;

public class TelefoneDAOImpl implements TelefoneDAO{ 

    @Override
    public void criar(Telefone telefone) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO telefone(ddd, numero) VALUES (?, ?)"
        );
        stmt.setString(1, telefone.getDdd());
        stmt.setString(2, telefone.getNumero());
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }

    @Override
    public Telefone ler(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, ddd, numero FROM telefone WHERE id = ?"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Telefone telefone = null;
        if (rs.next()) {
            telefone = new Telefone();
            telefone.setId(rs.getInt("id"));
            telefone.setNumero(rs.getString("numero"));
        }

        stmt.close();
        rs.close();
        con.close();

        return telefone;
    }

    @Override
    public List<Telefone> listar() throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "SELECT id, ddd, numero FROM telefone"
        );
        ResultSet rs = stmt.executeQuery();

        List<Telefone> telefones = new ArrayList<>();
        while (rs.next()) {
            Telefone telefone = new Telefone();
            telefone.setId(rs.getInt("id"));
            telefone.setDdd(rs.getString("ddd"));
            telefone.setNumero(rs.getString("numero"));
            telefones.add(telefone);
        }

        stmt.close();
        rs.close();
        con.close();

        return telefones;
    }

    @Override
    public void atualizar(Telefone telefone) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "UPDATE telefone SET ddd = ?, numero = ? WHERE id = ?"
        );
        stmt.setString(1, telefone.getDdd());
        stmt.setString(2, telefone.getNumero());
        stmt.setInt(3, telefone.getId());
        stmt.executeUpdate();
        
        stmt.close();
        con.close();
    }
    
    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement stmt = con.prepareStatement(
            "DELETE FROM telefone WHERE id = ?"
        );
        stmt.setInt(1, id);
        stmt.executeUpdate();

        con.close();
    }
    
}
