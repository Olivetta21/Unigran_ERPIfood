package Modelos.cliente;

import Modelos.contato.Telefone;

public class Cliente {
    private Integer id;
    private String nome;    
    private Telefone telefone;
    
    public Cliente() {}
    public Cliente(Integer id, String nome, Telefone telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
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
    public Telefone getTelefone() {
        return telefone;
    }
    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}
