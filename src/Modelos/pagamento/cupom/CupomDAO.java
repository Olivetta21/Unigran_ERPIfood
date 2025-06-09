package Modelos.pagamento.cupom;

import java.util.List;

public interface CupomDAO {
    void criar(Cupom cupom) throws Exception;
    Cupom ler(int id) throws Exception;
    List<Cupom> listar() throws Exception;
    void atualizar(Cupom cupom) throws Exception;
    void deletar(int id) throws Exception;
}
