package Modelos.delivery;

import Modelos.Pedido;
import Modelos.StatusPedido;
import Modelos.cliente.Cliente;
import Modelos.delivery.endereco.Endereco;

public class Entrega {
    private Integer id;
    private String chave;
    private Endereco endereco;

    public Entrega() {
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
