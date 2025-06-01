package Modelos.delivery;

import Modelos.delivery.endereco.Endereco;

public class Entrega {
    private Integer id;
    private String chave;
    private Endereco endereco;
    private Double valor;

    public Entrega() {}
    public Entrega(Integer id, String chave, Endereco endereco, Double valor) {
        this.id = id;
        this.chave = chave;
        this.endereco = endereco;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    
}
