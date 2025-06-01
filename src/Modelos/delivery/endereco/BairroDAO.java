package Modelos.delivery.endereco;

import java.util.List;

public interface BairroDAO {
    void criar(Bairro bairro) throws Exception;
    Bairro ler(int id) throws Exception;
    List<Bairro> listar() throws Exception;
    void atualizar(Bairro bairro) throws Exception;
    void deletar(int id) throws Exception;
}
