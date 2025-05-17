package Modelos.pagamento.metodo;

public class Metodo {
    private Integer id;
    private Double pix;
    
    private Cartao cartao;
    private Dinheiro dinheiro;

    public Metodo() {}
    public Metodo(Integer id, Double pix, Cartao cartao, Dinheiro dinheiro) {
        this.id = id;
        this.pix = pix;
        this.cartao = cartao;
        this.dinheiro = dinheiro;
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
    public Cartao getCartao() {
        return cartao;
    }
    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
    public Dinheiro getDinheiro() {
        return dinheiro;
    }
    public void setDinheiro(Dinheiro dinheiro) {
        this.dinheiro = dinheiro;
    }
}
