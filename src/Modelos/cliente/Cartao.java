package Modelos.cliente;


public class Cartao {
    private Integer id;
    private String numero;
    private Integer CVV;
    private boolean isCredito;
    private Cliente cliente;

    public Cartao() {
    }
    public Cartao(Integer id, String numero, Integer CVV, boolean isCredito, Cliente cliente) {
        this.id = id;
        this.numero = numero;
        this.CVV = CVV;
        this.isCredito = isCredito;
        this.cliente = cliente;
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
    public boolean isCredito() {
        return isCredito;
    }
    public void setIsCredito(boolean tipo) {
        this.isCredito = tipo;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
