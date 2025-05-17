package Modelos.cliente;

import Modelos.contato.Telefone;
import java.util.List;

public class Cliente {
    private Integer id;
    private String nome;
    private List<Cartao> cartoes;
    
    private List<Telefone> telefones;
    
    public Cliente() {}
    public Cliente(Integer id, String nome, List<Cartao> cartoes, List<Telefone> telefones) {
        this.id = id;
        this.nome = nome;
        this.cartoes = cartoes;
        this.telefones = telefones;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Cartao> getCartoes() {
        return cartoes;
    }
    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }
    public List<Telefone> getTelefones() {
        return telefones;
    }
    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
