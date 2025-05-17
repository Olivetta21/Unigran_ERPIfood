package Modelos;

public interface PedidoDAO {
    void criar(Pedido p) throws Exception;
    Pedido ler(int id) throws Exception;
    void atualizar(Pedido p) throws Exception;
    void deletar(int id) throws Exception;
}
