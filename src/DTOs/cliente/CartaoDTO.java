package DTOs.cliente;

import Interfaces.InterfaceDTO;
import Modelos.cliente.Cartao;
import Modelos.cliente.Cliente;

public class CartaoDTO extends InterfaceDTO{
    public Integer id;
    public String numero;
    public Integer CVV;
    public boolean isCredito;
    public Cliente cliente;

    public CartaoDTO(Integer id, String numero, Integer CVV, boolean isCredito, Cliente cliente) {
        this.id = id;
        this.numero = numero;
        this.CVV = CVV;
        this.isCredito = isCredito;
        this.cliente = cliente;
    }

    public CartaoDTO() {
    }
    
    public Cartao builder() {
        return new Cartao(id, numero, CVV, isCredito, cliente);
    }
}
