package Modelos.contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexao.Conexao;

public class TelefoneDAOImpl implements TelefoneDAO{ 

    @Override
    public void criar(Telefone telefone) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement p = con.prepareStatement(
            "INSERT INTO telefone(numero) VALUES (?)"
        );
        p.setString(1, telefone.getNumero());
        p.executeUpdate();

        con.close();
    }

    @Override
    public Telefone ler(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement p = con.prepareStatement(
            "SELECT id, numero, cliente_id FROM telefone WHERE id = ?"
        );
        p.setInt(1, id);
        ResultSet r = p.executeQuery();
        Telefone telefone = null;
        if (r.next()) {
            telefone = new Telefone();
            telefone.setId(r.getInt("id"));
            telefone.setNumero(r.getString("numero"));
        }

        con.close();

        return telefone;
    }

    @Override
    public void atualizar(Telefone telefone) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement p = con.prepareStatement(
            "UPDATE telefone SET numero = ? WHERE id = ?"
        );
        p.setString(1, telefone.getNumero());
        p.setInt(2, telefone.getId());
        p.executeUpdate();

        con.close();
    }
    
    @Override
    public void deletar(int id) throws Exception {
        Connection con = Conexao.get();

        PreparedStatement p = con.prepareStatement(
            "DELETE FROM telefone WHERE id = ?"
        );
        p.setInt(1, id);
        p.executeUpdate();

        con.close();
    }
    
}
