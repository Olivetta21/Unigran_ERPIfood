package Modelos.contato;

public interface TelefoneDAO {
    void criar(Telefone telefone) throws Exception;
    Telefone ler(int id) throws Exception;
    void atualizar(Telefone telefone) throws Exception;
    void deletar(int id) throws Exception;
}
