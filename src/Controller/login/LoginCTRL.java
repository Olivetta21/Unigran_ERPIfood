package Controller.login;

import DTOs.login.LoginDTO;
import Modelos.login.Login;
import Modelos.login.LoginDAO;
import Modelos.login.LoginDAOImpl;

public class LoginCTRL {
    public void criar(LoginDTO loginDTO) throws Exception {
        LoginDAO dao = new LoginDAOImpl();
        dao.criar(loginDTO.builder());
    }

    public Login ler(int id) throws Exception {
        LoginDAO dao = new LoginDAOImpl();
        return dao.ler(id);
    }

    public void atualizar(LoginDTO loginDTO) throws Exception {
        LoginDAO dao = new LoginDAOImpl();
        dao.atualizar(loginDTO.builder());
    }

    public void deletar(int id) throws Exception {
        LoginDAO dao = new LoginDAOImpl();
        dao.deletar(id);
    }
}
