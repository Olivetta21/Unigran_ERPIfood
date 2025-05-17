package Modelos.pagamento;

import Modelos.pagamento.cupom.Cupom;

public class Pagamento {
    private Integer id;
    private Double pix;
    private Double cartao;
    private Double dinheiro;
    private Cupom cupom;

    public Pagamento() {}
    public Pagamento(Integer id, Double pix, Double cartao, Double dinheiro, Cupom cupom) {
        this.id = id;
        this.pix = pix;
        this.cartao = cartao;
        this.dinheiro = dinheiro;
        this.cupom = cupom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }
    
    
    
}
