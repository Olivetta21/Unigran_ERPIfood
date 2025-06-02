package Modelos;

import java.util.List;

public interface PedidoDAO {
    void criar(Pedido p) throws Exception;
    Pedido ler(int id) throws Exception;
    List<Pedido> listar() throws Exception;
    void atualizar(Pedido p) throws Exception;
    void deletar(int id) throws Exception;
}
