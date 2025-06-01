package Modelos;

import Modelos.cliente.Cliente;
import Modelos.contato.Telefone;
import Modelos.login.Login;

public class Funcionario extends Cliente { 
    private Login login;
    private String cpf;
    private String rg;

    public Funcionario() {}

    public Funcionario(Integer id, String nome, Telefone telefone, Login login, String cpf, String rg) {
        super.setId(id);
        super.setNome(nome);
        super.setTelefone(telefone);
        this.login = login;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
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
}
