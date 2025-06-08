package DTOs.carrinho.ingrediente;

import Interfaces.InterfaceDTO;
import Modelos.carrinho.Carrinho;
import Modelos.carrinho.ingrediente.Ingrediente;
import Modelos.carrinho.ingrediente.IngredienteEscolha;

public class IngredienteEscolhaDTO extends InterfaceDTO{
    public Integer id;
    public Ingrediente ingrediente;
    public Carrinho carrinho;
    public Boolean toExclude;

    public IngredienteEscolhaDTO() {
    }
    public IngredienteEscolhaDTO(Integer id, Ingrediente ingrediente, Carrinho carrinho, Boolean toExclude) {
        this.id = id;
        this.ingrediente = ingrediente;
        this.carrinho = carrinho;
        this.toExclude = toExclude;
    }

    public IngredienteEscolha builder() {
        return new IngredienteEscolha(id, ingrediente, carrinho, toExclude);
    }
}
