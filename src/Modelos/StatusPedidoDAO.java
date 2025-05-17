package Modelos;

public interface StatusPedidoDAO {
    void criar(StatusPedido s) throws Exception;
    StatusPedido ler(int id) throws Exception;
    void atualizar(StatusPedido s) throws Exception;
    void deletar(int id) throws Exception;
}
