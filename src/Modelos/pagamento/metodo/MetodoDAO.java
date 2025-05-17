package Modelos.pagamento.metodo;

public interface MetodoDAO {
    void criar(Metodo metodo) throws Exception;
    Metodo ler(int id) throws Exception;
    void atualizar(Metodo metodo) throws Exception;
    void deletar(int id) throws Exception;
}
