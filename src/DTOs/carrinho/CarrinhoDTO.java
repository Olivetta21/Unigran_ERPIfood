package DTOs.carrinho;

import Modelos.carrinho.Carrinho;
import Modelos.carrinho.ingrediente.IngredienteEscolha;
import Modelos.carrinho.produto.Produto;

import java.util.List;

public class CarrinhoDTO {
    public Integer id;
    public Produto produto;
    public Integer quantidade;
    List<IngredienteEscolha> ingredienteEscolha;

    public Carrinho builder() {
        return new Carrinho(id, produto, quantidade, ingredienteEscolha);
    }
}
