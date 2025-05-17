package Modelos.carrinho.ingrediente;

import java.util.List;

public class IngredienteEscolha {
    private Integer id;
    private List<IngrRem> ingrRem;
    private List<IngrAdi> ingrAdi;

    public IngredienteEscolha() {
    }
    public IngredienteEscolha(Integer id, List<IngrRem> ingrRem, List<IngrAdi> ingrAdi) {
        this.id = id;
        this.ingrRem = ingrRem;
        this.ingrAdi = ingrAdi;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public List<IngrRem> getIngrRem() {
        return ingrRem;
    }
    public void setIngrRem(List<IngrRem> ingrRem) {
        this.ingrRem = ingrRem;
    }
    public List<IngrAdi> getIngrAdi() {
        return ingrAdi;
    }
    public void setIngrAdi(List<IngrAdi> ingrAdi) {
        this.ingrAdi = ingrAdi;
    }
}
