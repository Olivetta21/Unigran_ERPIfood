package DTOs.cliente;

import java.util.List;

import Modelos.cliente.Cartao;
import Modelos.cliente.Cliente;
import Modelos.contato.Telefone;

public class ClienteDTO {
    public Integer id;
    public String nome;
    public List<Cartao> cartoes;    
    public List<Telefone> telefones;

    public Cliente builder() {
        return new Cliente(id, nome, cartoes, telefones);
    }
}
