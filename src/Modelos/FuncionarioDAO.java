package Modelos;

import java.util.List;

public interface FuncionarioDAO {
    void criar(Funcionario f) throws Exception;
    Funcionario ler(int id) throws Exception;
    List<Funcionario> listar() throws Exception;
    void atualizar(Funcionario f) throws Exception;
    void deletar(int id) throws Exception;
}
