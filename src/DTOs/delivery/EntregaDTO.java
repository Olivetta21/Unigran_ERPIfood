package DTOs.delivery;

import Modelos.delivery.endereco.Endereco;
import Modelos.delivery.Entrega;

public class EntregaDTO {
    public Integer id;
    public String chave;
    public Endereco endereco;
    
    public Entrega builder() {
        return new Entrega(id, chave, endereco);
    }
}
