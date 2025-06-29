import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

// Usuario é serializavel (Serialização é o processo de transformar um objeto Java em uma sequência de bytes,)
public class Professor extends Usuario implements Serializable {
    
    // O serialVersionUID é um identificador de versão da classe. Ele serve para garantir que, ao desserializar um objeto (ler do arquivo), a classe usada hoje ainda é compatível com a classe usada quando o objeto foi salvo.
    private static final long serialVersionUID = 1L; 

    // O Professor herda atributos e métodos da classe Usuario
    private final ArrayList<Aluno> alunos;
    private final ArrayList<Treino> treinosCriados;
    private int novosRecados;

    // Construtor
    public Professor(String nome,String userName, String senha){
        super(nome, userName, senha);
        alunos = new ArrayList<>();
        treinosCriados = new ArrayList<>();
        novosRecados = 0;
    }

    // Cria um novo treino e o adiciona à lista de treinos criados
    public void criarTreino(){

    }

    // Adiciona um novo exercício ao treino que está sendo criado
    public void adicionarExercicio(){
        
    }




    public int getNovosRecados(){
        return novosRecados;
    }

    public ArrayList<Treino> getTreinosCriados(){
        return treinosCriados;
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
