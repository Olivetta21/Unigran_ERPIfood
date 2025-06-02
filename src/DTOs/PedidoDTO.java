package DTOs;

import Interfaces.InterfaceDTO;
import Modelos.Pedido;
import Modelos.StatusPedido;
import Modelos.cliente.Cliente;
import Modelos.delivery.Entrega;

public class PedidoDTO extends InterfaceDTO {
    public Integer id;
    public Cliente cliente;
    public String data_pedido; 
    public StatusPedido status;
    public Entrega entrega;
    public String reembolso;

    public PedidoDTO(Integer id, Cliente cliente, String data_pedido, StatusPedido status, Entrega entrega, String reembolso) {
        this.id = id;
        this.cliente = cliente;
        this.data_pedido = data_pedido;
        this.status = status;
        this.entrega = entrega;
        this.reembolso = reembolso;
    }

    public PedidoDTO() {
    }
    
    public Pedido builder() {
        return new Pedido(id, cliente, data_pedido, status, entrega, reembolso);
    }
}
