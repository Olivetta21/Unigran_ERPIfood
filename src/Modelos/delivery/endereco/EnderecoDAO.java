package Modelos.delivery.endereco;

import java.util.List;

public interface EnderecoDAO {
    void criar(Endereco endereco) throws Exception;
    Endereco ler(int id) throws Exception;
    List<Endereco> listar() throws Exception;
    void atualizar(Endereco endereco) throws Exception;
    void deletar(int id) throws Exception;
}
