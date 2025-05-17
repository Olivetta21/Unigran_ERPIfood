package DTOs.pagamento.cupom;

import Modelos.pagamento.cupom.Cupom;

public class CupomDTO {
    public Integer id;
    public Double valor;
    public Integer codigo;
    public Integer validade;

    public Cupom builder() {
        return new Cupom(id, valor, codigo, validade);
    }
}
