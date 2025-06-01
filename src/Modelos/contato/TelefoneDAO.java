package Modelos.contato;

import java.util.List;

public interface TelefoneDAO {
    void criar(Telefone telefone) throws Exception;
    Telefone ler(int id) throws Exception;
    List<Telefone> listar() throws Exception;
    void atualizar(Telefone telefone) throws Exception;
    void deletar(int id) throws Exception;
}
