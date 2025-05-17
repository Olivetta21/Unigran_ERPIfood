package Modelos.delivery.endereco;

public class Endereco {
    private Integer id;
    
    private String rua;
    private String numero;
    private String cep;
    private Bairro bairro;
    
    private Integer distancia;

    public Endereco() {
    }
    public Endereco(Integer id, String numero, String cep, Bairro bairro, Integer distancia) {
        this.id = id;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.distancia = distancia;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public Bairro getBairro() {
        return bairro;
    }
    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }
    public Integer getDistancia() {
        return distancia;
    }
    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }
}
