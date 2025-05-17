package Modelos;

import Modelos.cliente.Cliente;
import Modelos.delivery.Delivery;

public class Entrega {
    private Integer id;
    
    private Cliente cliente;
    private boolean isDelivery;
    
    private Delivery delivery;
    private Pedido pedido;    
    private StatusPedido status;

    public Entrega() {
    }
    public Entrega(Integer id, Cliente cliente, boolean isDelivery, Delivery delivery, Pedido pedido, StatusPedido status) {
        this.id = id;
        this.cliente = cliente;
        this.isDelivery = isDelivery;
        this.delivery = delivery;
        this.pedido = pedido;
        this.status = status;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public boolean isDelivery() {
        return isDelivery;
    }
    public void setDelivery(boolean isDelivery) {
        this.isDelivery = isDelivery;
    }
    public Delivery getDelivery() {
        return delivery;
    }
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public StatusPedido getStatus() {
        return status;
    }
    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
