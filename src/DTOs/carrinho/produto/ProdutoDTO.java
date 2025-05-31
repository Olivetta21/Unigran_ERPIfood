package DTOs.carrinho.produto;

import Interfaces.InterfaceDTO;
import Modelos.carrinho.produto.Produto;

public class ProdutoDTO extends InterfaceDTO{
    public Integer id;
    public String nome;
    public Double valor;

    public Produto builder() {
        return new Produto(id, nome, valor);
    }
}
