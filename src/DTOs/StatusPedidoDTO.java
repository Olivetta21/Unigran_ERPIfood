package DTOs;

import Modelos.StatusPedido;

public class StatusPedidoDTO {
    public Integer id;
    public String progresso;
    
    public StatusPedido builder() {
        return new StatusPedido(id, progresso);   
    }
}
