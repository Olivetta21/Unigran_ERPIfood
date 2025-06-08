package Modelos.carrinho.ingrediente;

import java.util.List;

public interface IngredienteEscolhaDAO {
    void criar(IngredienteEscolha ingredienteEscolha) throws Exception;
    IngredienteEscolha ler(int id) throws Exception;
    List<IngredienteEscolha> listar() throws Exception;
    void atualizar(IngredienteEscolha ingredienteEscolha) throws Exception;
    void deletar(int id) throws Exception;
}
