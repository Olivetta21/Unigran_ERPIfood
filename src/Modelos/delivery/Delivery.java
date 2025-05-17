package Modelos.delivery;

import Modelos.delivery.endereco.Endereco;

public class Delivery {
    private Integer id;
    private String chaveEntrega;
    private Integer numero;
    private String complemento;
    
    private Endereco endereco;

    public Delivery() {
    }
    public Delivery(Integer id, String chaveEntrega, Integer numero, String complemento, Endereco endereco) {
        this.id = id;
        this.chaveEntrega = chaveEntrega;
        this.numero = numero;
        this.complemento = complemento;
        this.endereco = endereco;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getChaveEntrega() {
        return chaveEntrega;
    }
    public void setChaveEntrega(String chaveEntrega) {
        this.chaveEntrega = chaveEntrega;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
