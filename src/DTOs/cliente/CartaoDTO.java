package DTOs.cliente;

import Modelos.cliente.Cartao;

public class CartaoDTO {
    public Integer id;
    public String numero;
    public Integer CVV;
    public boolean tipo;

    public Cartao builder() {
        return new Cartao(id, numero, CVV, tipo);
    }
}
