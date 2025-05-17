package DTOs.carrinho.ingrediente;

import Modelos.carrinho.ingrediente.Ingrediente;
import Modelos.carrinho.ingrediente.IngredienteEscolha;

public class IngredienteEscolhaDTO {
    public Integer id;
    public Boolean toExclude;
    public Ingrediente ingrediente;

    public IngredienteEscolha builder() {
        return new IngredienteEscolha(id, toExclude, ingrediente);
    }
}
