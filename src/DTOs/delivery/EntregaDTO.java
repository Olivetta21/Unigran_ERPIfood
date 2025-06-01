package DTOs.delivery;

import Modelos.delivery.endereco.Endereco;
import Interfaces.InterfaceDTO;
import Modelos.delivery.Entrega;

public class EntregaDTO extends InterfaceDTO{
    public Integer id;
    public String chave;
    public Endereco endereco;
    public Double valor;

    public EntregaDTO(Integer id, String chave, Endereco endereco, Double valor) {
        this.id = id;
        this.chave = chave;
        this.endereco = endereco;
        this.valor = valor;
    }

    public EntregaDTO() {
    }
    
    public Entrega builder() {
        return new Entrega(id, chave, endereco, valor);
    }
}
