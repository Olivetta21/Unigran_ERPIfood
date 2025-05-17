package Modelos.login;

public interface LoginDAO {
    void criar(Login login) throws Exception;
    Login ler(int id) throws Exception;
    void atualizar(Login login) throws Exception;
    void deletar(int id) throws Exception;
}
