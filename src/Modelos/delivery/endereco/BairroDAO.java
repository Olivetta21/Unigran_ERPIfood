package Modelos.delivery.endereco;

public interface BairroDAO {
    void criar(Bairro bairro) throws Exception;
    Bairro ler(int id) throws Exception;
    void atualizar(Bairro bairro) throws Exception;
    void deletar(int id) throws Exception;
}
