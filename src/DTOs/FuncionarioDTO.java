package DTOs;

import Interfaces.InterfaceDTO;
import Modelos.Funcionario;
import Modelos.contato.Telefone;
import Modelos.login.Login;

public class FuncionarioDTO extends InterfaceDTO{
    public Integer id;
    public String nome;
    public Telefone telefone;
    public Login login;
    public String cpf;
    public String rg;

    public FuncionarioDTO(Integer id, String nome, Telefone telefone, Login login, String cpf, String rg) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.login = login;
        this.cpf = cpf;
        this.rg = rg;
    }

    public FuncionarioDTO() {
    }
    
    public Funcionario builder() {
        return new Funcionario(id, nome, telefone, login, cpf, rg);
    }
}
