package Modelos;

import Modelos.cliente.Cliente;
import Modelos.delivery.Entrega;

public class Pedido {
    private Integer id;
    private Cliente cliente;
    private String data_pedido; 
    private StatusPedido status;
    private Entrega entrega;
    private String reembolso;
    
    public Pedido() {}

    public Pedido(Integer id, Cliente cliente, String data_pedido, StatusPedido status, Entrega entrega, String reembolso) {
        this.id = id;
        this.cliente = cliente;
        this.data_pedido = data_pedido;
        this.status = status;
        this.entrega = entrega;
        this.reembolso = reembolso;
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

    public String getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(String data_pedido) {
        this.data_pedido = data_pedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public String getReembolso() {
        return reembolso;
    }

    public void setReembolso(String reembolso) {
        this.reembolso = reembolso;
    }
    
    
    
}
