package Modelos.carrinho;

public interface CarrinhoDAO {
    void criar(Carrinho carrinho) throws Exception;
    Carrinho ler(int id) throws Exception;
    void atualizar(Carrinho carrinho) throws Exception;
    void deletar(int id) throws Exception;
}
