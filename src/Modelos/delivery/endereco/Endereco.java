package Modelos.delivery.endereco;

public class Endereco {
    private Integer id;    
    private String cep;
    private Bairro bairro;    
    private String complemento;
    private String rua;
    private String numero;

    public Endereco() {}

    public Endereco(Integer id, String cep, Bairro bairro, String complemento, String rua, String numero) {
        this.id = id;
        this.cep = cep;
        this.bairro = bairro;
        this.complemento = complemento;
        this.rua = rua;
        this.numero = numero;
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
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
