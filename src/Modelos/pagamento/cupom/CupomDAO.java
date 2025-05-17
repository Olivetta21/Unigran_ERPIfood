package Modelos.pagamento.cupom;

public interface CupomDAO {
    void criar(Cupom cupom) throws Exception;
    Cupom ler(int id) throws Exception;
    void atualizar(Cupom cupom) throws Exception;
    void deletar(int id) throws Exception;
}
