package DTOs.carrinho.ingrediente;

import Interfaces.InterfaceDTO;
import Modelos.carrinho.ingrediente.Ingrediente;

public class IngredienteDTO extends InterfaceDTO{
    public Integer id;
    public String nome;
    public Double valor;

    public IngredienteDTO(Integer id, String nome, Double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public IngredienteDTO() {
    }    
    
    public Ingrediente builder() {
        return new Ingrediente(id, nome, valor);
    }
}
