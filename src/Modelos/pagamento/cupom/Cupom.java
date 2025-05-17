package Modelos.pagamento.cupom;

public class Cupom {
    private Integer id;
    private Double valor;
    private Integer codigo;
    private Integer validade;
    public Cupom() {}
    public Cupom(Integer id, Double valor, Integer codigo, Integer validade) {
        this.id = id;
        this.valor = valor;
        this.codigo = codigo;
        this.validade = validade;
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
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Integer getValidade() {
        return validade;
    }
    public void setValidade(Integer validade) {
        this.validade = validade;
    }
}
