package DTOs.delivery.endereco;

import Modelos.delivery.endereco.Bairro;
import Modelos.delivery.endereco.Endereco;

public class EnderecoDTO {
    public Integer id;
    public String rua;
    public String numero;
    public String cep;
    public Bairro bairro;
    public String complemento;

    public Endereco builder() {
        return new Endereco(id, rua, numero, cep, bairro, complemento);
    }
    
}
