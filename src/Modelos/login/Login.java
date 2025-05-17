package Modelos.login;

public class Login {
    private Integer id;
    private String senha;
    
    public Login() {}
    public Login(Integer id, String senha) {
        this.id = id;
        this.senha = senha;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
