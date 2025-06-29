import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

// Essa classe precisa ser serializavel para podermos guardar as informacoes dos alunos e professores
// Classes que herdam dessa não precisam implementar serializable pois ja herdam. Enum e Exceptions tambem nao precisam
    // Usuario é serializavel (Serialização é o processo de transformar um objeto Java em uma sequência de bytes,)

public abstract class Usuario implements Serializable{ 
    // O serialVersionUID é um identificador de versão da classe. Ele serve para garantir que, ao desserializar um objeto (ler do arquivo), a classe usada hoje ainda é compatível com a classe usada quando o objeto foi salvo.
    private static final long serialVersionUID = 1L; 
    private String nome;
    private String userName;
    private String senha;
    private ArrayList<Comentario> mensagens;

    // Construtor
    public Usuario(String nome,String userName, String senha){
        this.nome = nome;
        this.userName = userName;
        this.senha = senha;
        mensagens = new ArrayList<>();
    }

    // metodo que sobrescreve a desserialização padrão. Ele é chamado pelo metodo carregarDados da classe sistema.
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // desserializa os dados salvos, Ele atribui automaticamente aos campos serializáveis os valores salvos no arquivo 
        // Após a desserialização, se os campos vieram como null (pois podemos guardar eles vazios no arquivo), criamos um novo ArrayList<> para evitar NullPointerException no resto do código.
        if (mensagens == null) mensagens = new ArrayList<>();
        // Se nao estiverem vazios vms ter todas as informacoes anteriormente registradas
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
