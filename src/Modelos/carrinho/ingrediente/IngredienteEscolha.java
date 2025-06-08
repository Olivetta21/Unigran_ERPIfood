package Modelos.carrinho.ingrediente;

import Modelos.carrinho.Carrinho;

public class IngredienteEscolha {
    private Integer id;
    private Ingrediente ingrediente;
    private Carrinho carrinho;
    private Boolean toExclude;

    public IngredienteEscolha() {
    }
    public IngredienteEscolha(Integer id, Ingrediente ingrediente, Carrinho carrinho, Boolean toExclude) {
        this.id = id;
        this.ingrediente = ingrediente;
        this.carrinho = carrinho;
        this.toExclude = toExclude;
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

    public Carrinho getCarrinho() {
        return carrinho;
    }
    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
    
    
}
