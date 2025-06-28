import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Professor extends Usuario implements Serializable { // Usuario é serializavel (Serialização é o processo de transformar um objeto Java em uma sequência de bytes,)
    private static final long serialVersionUID = 1L; // O serialVersionUID é um identificador de versão da classe. Ele serve para garantir que, ao desserializar um objeto (ler do arquivo), a classe usada hoje ainda é compatível com a classe usada quando o objeto foi salvo.
    // O Professor herda atributos e metodos da classe Usuario
    private final ArrayList<Aluno> alunos;
    private final ArrayList<Treino> treinosCriados;
    private int novosRecados;

    public Professor(String nome,String userName, String senha){
        super(nome, userName, senha);
        alunos = new ArrayList<>();
        treinosCriados = new ArrayList<>();
        novosRecados = 0;
    }

    public int getNovosRecados(){
        return novosRecados;
    }

    public void criarTreino(){

    }

    public void atribuirTreino(Aluno aluno, Treino treino) {

    }

    public void verComentarios(){

    }

    public void responderComentario(){

    }

    @Override // Essa será a implementacao do metodo abstrato. Aqui implementaremos a interface especifica do Professor
    public void mostrarMenuPrincipal(Scanner entrada){
        System.out.println("Bem-vindo à interface do professor!\n");
    }   
}
