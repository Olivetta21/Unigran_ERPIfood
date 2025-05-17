package Modelos.carrinho.produto;

public class Produto {
    private Integer id;
    private String nome;
    private Double vlr_uni;
    
    public Produto() {
    }
    public Produto(Integer id, String nome, Double vlr_uni) {
        this.id = id;
        this.nome = nome;
        this.vlr_uni = vlr_uni;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getVlr_uni() {
        return vlr_uni;
    }
    public void setVlr_uni(Double vlr_uni) {
        this.vlr_uni = vlr_uni;
    }
}
