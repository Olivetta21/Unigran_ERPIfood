package DTOs.delivery.endereco;

import Interfaces.InterfaceDTO;
import Modelos.delivery.endereco.Bairro;
import Modelos.delivery.endereco.Endereco;

public class EnderecoDTO extends InterfaceDTO{
    public Integer id;
    public String cep;
    public Bairro bairro;
    public String complemento;
    public String rua;
    public String numero;

    public EnderecoDTO() {
    }
    public EnderecoDTO(Integer id, String cep, Bairro bairro, String complemento, String rua, String numero) {
        this.id = id;
        this.cep = cep;
        this.bairro = bairro;
        this.complemento = complemento;
        this.rua = rua;
        this.numero = numero;
    }

    public Endereco builder() {
        return new Endereco(id, cep, bairro, complemento, rua, numero);
    }
    
}
