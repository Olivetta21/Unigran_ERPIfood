package Modelos.delivery;

import java.util.List;

public interface EntregaDAO {
    void criar(Entrega entrega) throws Exception;
    Entrega ler(int id) throws Exception;
    List<Entrega> listar() throws Exception;
    void atualizar(Entrega entrega) throws Exception;
    void deletar(int id) throws Exception;
}
