package DTOs.pagamento.cupom;

import Interfaces.InterfaceDTO;
import Modelos.pagamento.Pagamento;
import Modelos.pagamento.cupom.Cupom;

public class CupomDTO extends InterfaceDTO {
    public Integer id;
    public Double valor;
    public String codigo;
    public String validade;
    public Pagamento pagamento;

    public CupomDTO() {
    }
    public CupomDTO(Integer id, Double valor, String codigo, String validade, Pagamento pagamento) {
        this.id = id;
        this.valor = valor;
        this.codigo = codigo;
        this.validade = validade;
        this.pagamento = pagamento;
    }

    public Cupom builder() {
        return new Cupom(id, valor, codigo, validade, pagamento);
    }
}
