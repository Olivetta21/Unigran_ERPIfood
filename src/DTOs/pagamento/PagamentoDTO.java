package DTOs.pagamento;

import Interfaces.InterfaceDTO;
import Modelos.Pedido;
import Modelos.pagamento.Pagamento;

public class PagamentoDTO extends InterfaceDTO {
    public Integer id;
    public Pedido pedido;
    public Double pix;
    public Double cartao;
    public Double dinheiro;

    public PagamentoDTO() {
    }
    public PagamentoDTO(Integer id, Pedido pedido, Double pix, Double cartao, Double dinheiro) {
        this.id = id;
        this.pedido = pedido;
        this.pix = pix;
        this.cartao = cartao;
        this.dinheiro = dinheiro;
    }

    public Pagamento builder() {
        return new Pagamento(id, pedido, pix, cartao, dinheiro);
    }
    
}
