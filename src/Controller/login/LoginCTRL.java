package Controller.login;

import java.util.List;

import DTOs.login.LoginDTO;
import Interfaces.ControllerInterface;
import Interfaces.InterfaceDTO;
import Modelos.login.Login;
import Modelos.login.LoginDAO;
import Modelos.login.LoginDAOImpl;

public class LoginCTRL extends ControllerInterface {
    @Override
    public void criar(InterfaceDTO loginDTO) throws Exception {
        LoginDTO dto = (LoginDTO) loginDTO;
        if (dto.id != null) {
            this.atualizar(loginDTO);
            return;
        }
        new LoginDAOImpl().criar(dto.builder());
    }

    @Override
    public InterfaceDTO ler(InterfaceDTO loginDTO) throws Exception {
        Login login = new LoginDAOImpl().ler(((LoginDTO) loginDTO).id);
        return new LoginDTO(login.getId(), login.getLogin(), login.getSenha());
    }

    @Override
    public Object[][] listar() throws Exception {
        LoginDAO loginDAO = new LoginDAOImpl();
        List<Login> logins = loginDAO.listar();

        Object[][] data = new Object[logins.size()][3];

        for (int i = 0; i < logins.size(); i++) {
            Login login = logins.get(i);
            data[i][0] = login.getId();
            data[i][1] = login.getLogin();
            data[i][2] = login.getSenha();
        }

        return data;
    }

    @Override
    public String[] titulos() {
        return new String[]{"Id", "Login", "Senha"};
    }

    @Override
    public void atualizar(InterfaceDTO loginDTO) throws Exception {
        new LoginDAOImpl().atualizar(((LoginDTO) loginDTO).builder());
    }

    @Override
    public void deletar(InterfaceDTO loginDTO) throws Exception {
        new LoginDAOImpl().deletar(((LoginDTO) loginDTO).id);
    }
}
