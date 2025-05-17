package Modelos.carrinho.ingrediente;

public interface IngrRemDAO {
    void criar(IngrRem ingrRem) throws Exception;
    IngrRem ler(int id) throws Exception;
    void atualizar(IngrRem ingrRem) throws Exception;
    void deletar(int id) throws Exception;    
}
