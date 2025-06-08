package Modelos.carrinho;

import java.util.List;

public interface CarrinhoDAO {
    void criar(Carrinho carrinho) throws Exception;
    Carrinho ler(int id) throws Exception;
    List<Carrinho> listar() throws Exception;
    void atualizar(Carrinho carrinho) throws Exception;
    void deletar(int id) throws Exception;
}
