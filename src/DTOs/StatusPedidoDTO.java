package DTOs;

import Interfaces.InterfaceDTO;
import Modelos.StatusPedido;

public class StatusPedidoDTO extends InterfaceDTO {
    public Integer id;
    public String progresso;

    public StatusPedidoDTO() {
    }

    public StatusPedidoDTO(Integer id, String progresso) {
        this.id = id;
        this.progresso = progresso;
    }
    
    public StatusPedido builder() {
        return new StatusPedido(id, progresso);   
    }
}
