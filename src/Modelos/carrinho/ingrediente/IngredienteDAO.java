package Modelos.carrinho.ingrediente;

public interface IngredienteDAO {
    void criar(Ingrediente ingrediente) throws Exception;
    Ingrediente ler(int id) throws Exception;
    void atualizar(Ingrediente ingrediente) throws Exception;
    void deletar(int id) throws Exception;
}
