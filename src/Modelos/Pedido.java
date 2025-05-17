package Modelos;

import Modelos.carrinho.Carrinho;
import Modelos.cliente.Cliente;
import java.util.List;

public class Pedido {
    private Integer id;
    private Integer datatime_pedido;
    private Integer nPedido;
    
       
    private List<Carrinho> carrinho;
    private Cliente cliente;
    
    
    private String reembolso;
    private StatusPedido status;
    
    public Pedido() {
    }
    public Pedido(Integer id, Integer datatime_pedido, Integer nPedido, List<Carrinho> carrinho, Cliente cliente, String reembolso, StatusPedido status) {
        this.id = id;
        this.datatime_pedido = datatime_pedido;
        this.nPedido = nPedido;
        this.carrinho = carrinho;
        this.cliente = cliente;
        this.reembolso = reembolso;
        this.status = status;
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
    public Integer getNPedido() {
        return nPedido;
    }
    public void setNPedido(Integer nPedido) {
        this.nPedido = nPedido;
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
}
