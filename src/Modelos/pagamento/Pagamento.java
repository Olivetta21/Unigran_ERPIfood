package Modelos.pagamento;

import Modelos.Pedido;

public class Pagamento {
    private Integer id;
    private Pedido pedido;
    private Double pix;
    private Double dinheiro;
    private Double cartao;

    public Pagamento() {}
    public Pagamento(Integer id, Pedido pedido, Double pix, Double dinheiro, Double cartao) {
        this.id = id;
        this.pedido = pedido;
        this.pix = pix;
        this.dinheiro = dinheiro;
        this.cartao = cartao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Double getPix() {
        return pix;
    }

    public void setPix(Double pix) {
        this.pix = pix;
    }

    public Double getCartao() {
        return cartao;
    }

    public void setCartao(Double cartao) {
        this.cartao = cartao;
    }

    public Double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Double dinheiro) {
        this.dinheiro = dinheiro;
    }
}
