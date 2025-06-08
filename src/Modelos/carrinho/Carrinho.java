package Modelos.carrinho;

import Modelos.Pedido;
import Modelos.carrinho.produto.Produto;

public class Carrinho {
    private Integer id;
    private Produto produto;
    private Pedido pedido;
    private Integer quantidade;

    public Carrinho() {
    }
    public Carrinho(Integer id, Produto produto, Pedido pedido, Integer quantidade) {
        this.id = id;
        this.produto = produto;
        this.pedido = pedido;
        this.quantidade = quantidade;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}
