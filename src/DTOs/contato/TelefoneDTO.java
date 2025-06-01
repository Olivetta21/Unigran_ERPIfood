package DTOs.contato;

import Interfaces.InterfaceDTO;
import Modelos.contato.Telefone;

public class TelefoneDTO extends InterfaceDTO {
    public Integer id;
    public String ddd;
    public String numero;

    public TelefoneDTO() {
    }

    public TelefoneDTO(Integer id, String ddd, String numero) {
        this.id = id;
        this.ddd = ddd;
        this.numero = numero;
    }
    
    public Telefone builder() {
        return new Telefone(id, ddd, numero);
    }
}
