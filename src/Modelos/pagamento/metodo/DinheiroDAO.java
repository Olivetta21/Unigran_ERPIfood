package Modelos.pagamento.metodo;


public interface DinheiroDAO {
    void criar(Dinheiro dinheiro) throws Exception;
    Dinheiro ler(int id) throws Exception;
    void atualizar(Dinheiro dinheiro) throws Exception;
    void deletar(int id) throws Exception;
    
}
