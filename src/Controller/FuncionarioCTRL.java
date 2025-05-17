package Controller;

import DTOs.FuncionarioDTO;
import Modelos.Funcionario;
import Modelos.FuncionarioDAO;
import Modelos.FuncionarioDAOImpl;

public class FuncionarioCTRL {
    public void criar(FuncionarioDTO funcionarioDTO) throws Exception {
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        dao.criar(funcionarioDTO.builder());
    }

    public Funcionario ler(int id) throws Exception {
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        return dao.ler(id);
    }

    public void atualizar(FuncionarioDTO funcionarioDTO) throws Exception {
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        dao.atualizar(funcionarioDTO.builder());
    }

    public void deletar(int id) throws Exception {
        FuncionarioDAO dao = new FuncionarioDAOImpl();
        dao.deletar(id);
    }
}
