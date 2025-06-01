package Modelos.cliente;
import java.util.List;

public interface CartaoDAO {
    void criar(Cartao cartao) throws Exception;
    Cartao ler(int id) throws Exception;
    List<Cartao> listar() throws Exception;
    void atualizar(Cartao cartao) throws Exception;
    void deletar(int id) throws Exception;
}
