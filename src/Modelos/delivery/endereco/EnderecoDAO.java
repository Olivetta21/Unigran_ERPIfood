package Modelos.delivery.endereco;

public interface EnderecoDAO {
    void criar(Endereco endereco) throws Exception;
    Endereco ler(int id) throws Exception;
    void atualizar(Endereco endereco) throws Exception;
    void deletar(int id) throws Exception;
}
