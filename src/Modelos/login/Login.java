package Modelos.login;

public class Login {
    private Integer id;
    private String login;
    private String senha;
    
    public Login() {}
    public Login(Integer id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
