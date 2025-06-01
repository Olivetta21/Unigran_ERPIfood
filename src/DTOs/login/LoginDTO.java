package DTOs.login;

import Interfaces.InterfaceDTO;
import Modelos.login.Login;

public class LoginDTO extends InterfaceDTO {
    public Integer id;
    public String login;
    public String senha;

    public LoginDTO() {
    }

    public LoginDTO(Integer id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    public Login builder() {
        return new Login(id, login, senha);
    }
}
