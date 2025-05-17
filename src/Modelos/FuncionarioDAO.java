package Modelos;

public interface FuncionarioDAO {
    void criar(Funcionario f) throws Exception;
    Funcionario ler(int id) throws Exception;
    void atualizar(Funcionario f) throws Exception;
    void deletar(int id) throws Exception;
}
