package Modelos.carrinho.ingrediente;

public class IngrRem {
    private Integer id;
    private String Nome;

    public IngrRem() {
    }
    public IngrRem(Integer id, String Nome) {
        this.id = id;
        this.Nome = Nome;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String Nome) {
        this.Nome = Nome;
    }
}
