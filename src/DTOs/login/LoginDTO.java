package DTOs.login;

import Modelos.login.Login;

public class LoginDTO {
    public Integer id;
    public String senha;

    public Login builder() {
        return new Login(id, senha);
    }
}
