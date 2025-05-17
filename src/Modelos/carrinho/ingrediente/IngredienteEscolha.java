package Modelos.carrinho.ingrediente;


public class IngredienteEscolha {
    private Integer id;
    private Boolean toExclude;
    private Ingrediente ingrediente;

    public IngredienteEscolha() {
    }
    public IngredienteEscolha(Integer id, Boolean toExclude, Ingrediente ingrediente) {
        this.id = id;
        this.toExclude = toExclude;
        this.ingrediente = ingrediente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getToExclude() {
        return toExclude;
    }

    public void setToExclude(Boolean toExclude) {
        this.toExclude = toExclude;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
    
    
}
