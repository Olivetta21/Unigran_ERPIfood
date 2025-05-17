package Modelos.carrinho.produto;

public interface ProdutoDAO {
    void criar(Produto produto) throws Exception;
    Produto ler(int id) throws Exception;
    void atualizar(Produto produto) throws Exception;
    void deletar(int id) throws Exception;
}
