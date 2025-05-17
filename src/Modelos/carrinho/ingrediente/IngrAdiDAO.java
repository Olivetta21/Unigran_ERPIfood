package Modelos.carrinho.ingrediente;

public interface IngrAdiDAO {
    void criar(IngrAdi ingrAdi) throws Exception;
    IngrAdi ler(int id) throws Exception;
    void atualizar(IngrAdi ingrAdi) throws Exception;
    void deletar(int id) throws Exception;
}
