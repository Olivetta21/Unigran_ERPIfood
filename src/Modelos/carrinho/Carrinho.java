package Modelos.carrinho;

import Modelos.carrinho.ingrediente.IngredienteEscolha;
import Modelos.carrinho.produto.Produto;
import java.util.List;

public class Carrinho {
    private Integer id;
    private Produto produto;
    private Integer quantidade;
    private List<IngredienteEscolha> ingredienteEscolha;

    public Carrinho() {
    }
    public Carrinho(Integer id, Produto produto, Integer quantidade, List<IngredienteEscolha> ingredienteEscolha) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.ingredienteEscolha = ingredienteEscolha;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public List<IngredienteEscolha> getIngredienteEscolha() {
        return ingredienteEscolha;
    }
    public void setIngredienteEscolha(List<IngredienteEscolha> ingredienteEscolha) {
        this.ingredienteEscolha = ingredienteEscolha;
    }
}
