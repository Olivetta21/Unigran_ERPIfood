package Modelos.carrinho.produto;

import java.util.List;

public interface ProdutoDAO {
    void criar(Produto produto) throws Exception;
    Produto ler(int id) throws Exception;
    List<Produto> listar() throws Exception;
    void atualizar(Produto produto) throws Exception;
    void deletar(int id) throws Exception;
}
