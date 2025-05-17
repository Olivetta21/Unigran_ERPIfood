package Modelos.pagamento.metodo;

public interface CartaoDAO {
    void criar(Cartao cartao) throws Exception;
    Cartao ler(int id) throws Exception;
    void atualizar(Cartao cartao) throws Exception;
    void deletar(int id) throws Exception;
}
