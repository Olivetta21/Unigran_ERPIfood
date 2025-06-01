package Modelos.cliente;

import java.util.List;

public interface ClienteDAO {
    void criar(Cliente cliente) throws Exception;
    Cliente ler(int id) throws Exception;
    List<Cliente> listar() throws Exception;
    void atualizar(Cliente cliente) throws Exception;
    void deletar(int id) throws Exception;
}
