package Modelos;

import Modelos.carrinho.Carrinho;
import Modelos.cliente.Cliente;
import Modelos.delivery.Entrega;

import java.util.List;

public class Pedido {
    private Integer id;
    private Integer datatime_pedido;    
       
    private List<Carrinho> carrinho;
    private Cliente cliente;
    
    
    private String reembolso;
    private StatusPedido status;

    private Entrega entrega;
    
    public Pedido() {}
    public Pedido(Integer id, Integer datatime_pedido, List<Carrinho> carrinho, Cliente cliente, String reembolso, StatusPedido status, Entrega entrega) {
        this.id = id;
        this.datatime_pedido = datatime_pedido;
        this.carrinho = carrinho;
        this.cliente = cliente;
        this.reembolso = reembolso;
        this.status = status;
        this.entrega = entrega;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getDatatime_pedido() {
        return datatime_pedido;
    }
    public void setDatatime_pedido(Integer datatime_pedido) {
        this.datatime_pedido = datatime_pedido;
    }
    public List<Carrinho> getCarrinho() {
        return carrinho;
    }
    public void setCarrinho(List<Carrinho> carrinho) {
        this.carrinho = carrinho;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getReembolso() {
        return reembolso;
    }
    public void setReembolso(String reembolso) {
        this.reembolso = reembolso;
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
}
