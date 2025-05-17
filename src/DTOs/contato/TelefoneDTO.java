package DTOs.contato;

import Modelos.contato.Telefone;

public class TelefoneDTO {
    public Integer id;
    public String ddd;
    public String numero;

    public Telefone builder() {
        return new Telefone(id, ddd, numero);
    }
}
