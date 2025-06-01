package Modelos.carrinho.ingrediente;

import java.util.List;

public interface IngredienteDAO {
    void criar(Ingrediente ingrediente) throws Exception;
    Ingrediente ler(int id) throws Exception;
    List<Ingrediente> listar() throws Exception;
    void atualizar(Ingrediente ingrediente) throws Exception;
    void deletar(int id) throws Exception;
}
