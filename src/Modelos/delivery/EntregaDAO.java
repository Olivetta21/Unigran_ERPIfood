package Modelos.delivery;

public interface EntregaDAO {
    void criar(Entrega entrega) throws Exception;
    Entrega ler(int id) throws Exception;
    void atualizar(Entrega entrega) throws Exception;
    void deletar(int id) throws Exception;
}
