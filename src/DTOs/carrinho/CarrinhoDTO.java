package DTOs.carrinho;

import Interfaces.InterfaceDTO;
import Modelos.Pedido;
import Modelos.carrinho.Carrinho;
import Modelos.carrinho.produto.Produto;

public class CarrinhoDTO extends InterfaceDTO {
    public Integer id;
    public Produto produto;
    public Integer quantidade;
    public Pedido pedido;

    public CarrinhoDTO() {
    }
    public CarrinhoDTO(Integer id, Produto produto, Pedido pedido, Integer quantidade) {
        this.id = id;
        this.produto = produto;
        this.pedido = pedido;
        this.quantidade = quantidade;
    }

    public Carrinho builder() {
        return new Carrinho(id, produto, pedido, quantidade);
    }
}
