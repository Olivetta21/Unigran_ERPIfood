package Modelos;

import Modelos.cliente.Cliente;
import Modelos.login.Login;

public class Funcionario extends Cliente { 
    private String cpf;
    private String rg;
    private Login login;

    public Funcionario() {}

    public Funcionario(Integer id, String nome, String cpf, String rg, Login login) {
        super.setId(id);
        super.setNome(nome);
        this.cpf = cpf;
        this.rg = rg;
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
