import java.util.Scanner;

public abstract class Usuario {
    private String nome;
    private String userName;
    private String senha;

    public Usuario(String nome,String userName, String senha){
        this.nome = nome;
        this.userName = userName;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }
    
    public String getUserName(){
        return userName;
    }

    public String getSenha(){
        return senha;
    }

    public abstract void mostrarMenuPrincipal(Scanner entrada); // Metodo abstrato que implementaremos na classe aluno e professor.
}
