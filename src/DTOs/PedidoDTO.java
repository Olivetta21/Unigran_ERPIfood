package DTOs;

import java.util.List;

import Modelos.Pedido;
import Modelos.StatusPedido;
import Modelos.carrinho.Carrinho;
import Modelos.cliente.Cliente;
import Modelos.delivery.Entrega;

public class PedidoDTO {
    public Integer id;
    public Integer datatime_pedido;    
    public List<Carrinho> carrinho;
    public Cliente cliente;
    public String reembolso;
    public StatusPedido status;
    public Entrega entrega;
    
    public Pedido builder() {
        return new Pedido(id, datatime_pedido, carrinho, cliente, reembolso, status, entrega);
    }
}
