package Modelos.cliente;

public interface ClienteDAO {
    void criar(Cliente cliente) throws Exception;
    Cliente ler(int id) throws Exception;
    void atualizar(Cliente cliente) throws Exception;
    void deletar(int id) throws Exception;
}
