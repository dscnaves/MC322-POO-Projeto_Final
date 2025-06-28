import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Usuario implements Serializable{ // Usuario é serializavel (Serialização é o processo de transformar um objeto Java em uma sequência de bytes,)
    private static final long serialVersionUID = 1L; // O serialVersionUID é um identificador de versão da classe. Ele serve para garantir que, ao desserializar um objeto (ler do arquivo), a classe usada hoje ainda é compatível com a classe usada quando o objeto foi salvo.
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
