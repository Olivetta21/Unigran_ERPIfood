package DTOs.pagamento;

import Modelos.pagamento.Pagamento;
import Modelos.pagamento.cupom.Cupom;

public class PagamentoDTO {
    public Integer id;
    public Double pix;
    public Double cartao;
    public Double dinheiro;
    public Cupom cupom;

    public Pagamento builder() {
        return new Pagamento(id, pix, cartao, dinheiro, cupom);
    }
    
}
