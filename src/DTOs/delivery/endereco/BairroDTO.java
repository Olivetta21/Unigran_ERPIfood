package DTOs.delivery.endereco;

import Modelos.delivery.endereco.Bairro;

public class BairroDTO {
    public Integer id;
    public String nome;

    public Bairro builder() {
        return new Bairro(id, nome);
    }
}
