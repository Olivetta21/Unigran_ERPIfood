package Modelos.login;

import java.util.List;

public interface LoginDAO {
    void criar(Login login) throws Exception;
    Login ler(int id) throws Exception;
    List<Login> listar() throws Exception;
    void atualizar(Login login) throws Exception;
    void deletar(int id) throws Exception;
}
