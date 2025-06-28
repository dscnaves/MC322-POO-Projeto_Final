import java.util.ArrayList;
import java.util.Scanner;

public abstract class Usuario {

    private final String nome;
    private final String userName;
    private final String senha;
    private final ArrayList<Comentario> mensagens;

    // Construtor
    public Usuario(String nome,String userName, String senha){
        this.nome = nome;
        this.userName = userName;
        this.senha = senha;
        mensagens = new ArrayList<>();
    }

    // Obtém o nome do usuário
    public String getNome() {
        return nome;
    }
    
    // Obtém o username
    public String getUserName(){
        return userName;
    }

    // Obtém a senha 
    public String getSenha(){
        return senha;
    }

    // Adiciona nova mensagem

    // Método abstrato que implementaremos na classe aluno e professor
    public abstract void mostrarMenuPrincipal(Scanner entrada);
}
