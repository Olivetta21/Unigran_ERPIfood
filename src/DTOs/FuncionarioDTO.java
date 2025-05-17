package DTOs;

import Modelos.Funcionario;
import Modelos.login.Login;

public class FuncionarioDTO {
    public Integer id;
    public String nome;
    public String cpf;
    public String rg;
    public Login login;

    public Funcionario builder() {
        return new Funcionario(id, nome, cpf, rg, login);
    }
}
