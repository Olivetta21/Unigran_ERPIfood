package Modelos.delivery;

public interface TaxaDAO {
    void criar(Taxa taxa) throws Exception;
    Taxa ler(int id) throws Exception;
    void atualizar(Taxa taxa) throws Exception;
    void deletar(int id) throws Exception;
}
