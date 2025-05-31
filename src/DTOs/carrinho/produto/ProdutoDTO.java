package DTOs.carrinho.produto;

import Interfaces.InterfaceDTO;
import Modelos.carrinho.produto.Produto;

public class ProdutoDTO extends InterfaceDTO{
    public Integer id;
    public String nome;
    public Double valor;

    public ProdutoDTO() {
    }
    public ProdutoDTO(Integer id, String nome, Double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public Produto builder() {
        return new Produto(id, nome, valor);
    }
}
