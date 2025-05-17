package Modelos.delivery;

import Modelos.delivery.endereco.Endereco;

public class Taxa {
    private Integer id;
    private Endereco endereco;
    private Double valor;

    public Taxa () {}
    public Taxa(Integer id, Endereco endereco, Double valor) {
        this.id = id;
        this.endereco = endereco;
        this.valor = valor;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
