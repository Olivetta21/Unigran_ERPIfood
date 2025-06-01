package DTOs.cliente;

import Interfaces.InterfaceDTO;
import Modelos.cliente.Cliente;
import Modelos.contato.Telefone;

public class ClienteDTO extends InterfaceDTO{
    public Integer id;
    public String nome;  
    public Telefone telefone;

    public ClienteDTO(Integer id, String nome, Telefone telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public ClienteDTO() {
    }
    
    public Cliente builder() {
        return new Cliente(id, nome, telefone);
    }
}
