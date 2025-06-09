package Modelos.pagamento;

import java.util.List;

public interface PagamentoDAO {
    void criar(Pagamento pagamento) throws Exception;
    Pagamento ler(int id) throws Exception;
    List<Pagamento> listar() throws Exception;
    void atualizar(Pagamento pagamento) throws Exception;
    void deletar(int id) throws Exception;
}
