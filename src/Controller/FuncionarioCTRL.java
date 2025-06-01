package Controller;

import java.util.List;

import DTOs.FuncionarioDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.Funcionario;
import Modelos.FuncionarioDAO;
import Modelos.FuncionarioDAOImpl;

public class FuncionarioCTRL extends ControllerInterface {

    @Override
    public void criar(InterfaceDTO funcionarioDTO) throws Exception {
        FuncionarioDTO dto = (FuncionarioDTO) funcionarioDTO;
        if (dto.id != null) {
            this.atualizar(funcionarioDTO);
            return;
        }
        new FuncionarioDAOImpl().criar(dto.builder());
    }

    @Override
    public InterfaceDTO ler(InterfaceDTO funcionarioDTO) throws Exception {
        Funcionario func = new FuncionarioDAOImpl().ler(((FuncionarioDTO) funcionarioDTO).id);
        return new FuncionarioDTO(func.getId(), func.getNome(), func.getTelefone(), func.getLogin(), func.getCpf(), func.getRg());
    }

    @Override
    public Object[][] listar() throws Exception {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAOImpl();
        List<Funcionario> funcionarios = funcionarioDAO.listar();

        Object[][] data = new Object[funcionarios.size()][7];

        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario func = funcionarios.get(i);
            data[i][0] = func.getId();
            data[i][1] = func.getNome();
            data[i][2] = func.getTelefone().getDdd() + " " + func.getTelefone().getNumero();
            data[i][3] = func.getLogin().getLogin();
            data[i][4] = func.getLogin().getSenha();
            data[i][5] = func.getCpf();
            data[i][6] = func.getRg();
        }

        return data;
    }

    @Override
    public String[] titulos() {
        return new String[]{"Id", "Nome", "Telefone", "Login", "Senha", "CPF", "RG"};
    }

    @Override
    public void atualizar(InterfaceDTO funcionarioDTO) throws Exception {
        new FuncionarioDAOImpl().atualizar(((FuncionarioDTO) funcionarioDTO).builder());
    }

    @Override
    public void deletar(InterfaceDTO funcionarioDTO) throws Exception {
        new FuncionarioDAOImpl().deletar(((FuncionarioDTO) funcionarioDTO).id);
    }
}
