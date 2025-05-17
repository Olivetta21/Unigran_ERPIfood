package DTOs.carrinho.ingrediente;

import Modelos.carrinho.ingrediente.Ingrediente;

public class IngredienteDTO {
    public Integer id;
    public String nome;
    public Double valor;

    public Ingrediente builder() {
        return new Ingrediente(id, nome, valor);
    }
}
