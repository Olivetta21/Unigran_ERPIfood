package Modelos.pagamento;

import Modelos.pagamento.cupom.Cupom;
import Modelos.pagamento.metodo.Metodo;

public class Pagamento {
    private Integer id;
    private Integer pedido_id;
    private Metodo metodo;
    private Cupom cupom;

    public Pagamento() {}
    public Pagamento(Integer id, Integer pedido_id, Metodo metodo, Cupom cupom) {
        this.id = id;
        this.pedido_id = pedido_id;
        this.metodo = metodo;
        this.cupom = cupom;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPedido_id() {
        return pedido_id;
    }
    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
    }
    public Metodo getMetodo() {
        return metodo;
    }
    public void setMetodo(Metodo metodo) {
        this.metodo = metodo;
    }
    public Cupom getCupom() {
        return cupom;
    }
    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }
}
