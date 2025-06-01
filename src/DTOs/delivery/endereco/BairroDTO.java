package DTOs.delivery.endereco;

import Interfaces.InterfaceDTO;
import Modelos.delivery.endereco.Bairro;

public class BairroDTO extends InterfaceDTO {
    public Integer id;
    public String nome;

    public BairroDTO() {
    }

    public BairroDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Bairro builder() {
        return new Bairro(id, nome);
    }
}
