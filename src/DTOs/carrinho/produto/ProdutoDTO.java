package DTOs.carrinho.produto;

import Modelos.carrinho.produto.Produto;

public class ProdutoDTO {
    public Integer id;
    public String nome;
    public Double valor;

    public Produto builder() {
        return new Produto(id, nome, valor);
    }
}
