package Modelos.pagamento.cupom;

import Modelos.pagamento.Pagamento;

public class Cupom {
    private Integer id;
    private Double valor;
    private String codigo;
    private String validade;
    private Pagamento pagamento;

    public Cupom() {}
    public Cupom(Integer id, Double valor, String codigo, String validade, Pagamento pagamento) {
        this.id = id;
        this.valor = valor;
        this.codigo = codigo;
        this.validade = validade;
        this.pagamento = pagamento;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getValidade() {
        return validade;
    }
    public void setValidade(String validade) {
        this.validade = validade;
    }
    public Pagamento getPagamento() {
        return pagamento;
    }
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
