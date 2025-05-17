package Modelos.pagamento.metodo;

public class Cartao {
    private Integer id;
    private String numero;
    private Integer CVV;
    private boolean tipo;

    public Cartao() {
    }
    public Cartao(Integer id, String numero, Integer CVV, boolean tipo) {
        this.id = id;
        this.numero = numero;
        this.CVV = CVV;
        this.tipo = tipo;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Integer getCVV() {
        return CVV;
    }
    public void setCVV(Integer CVV) {
        this.CVV = CVV;
    }
    public boolean isTipo() {
        return tipo;
    }
    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
}
