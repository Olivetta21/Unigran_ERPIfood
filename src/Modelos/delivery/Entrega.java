package Modelos.delivery;

import Modelos.delivery.endereco.Endereco;

public class Entrega {
    private Integer id;
    private String chave;
    private Endereco endereco;

    public Entrega() {}
    public Entrega(Integer id, String chave, Endereco endereco) {
        this.id = id;
        this.chave = chave;
        this.endereco = endereco;
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
    
    
}
