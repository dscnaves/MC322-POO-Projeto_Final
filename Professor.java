import java.util.ArrayList;
import java.util.Scanner;

// O Professor herda atributos e metodos da classe Usuario
public class Professor extends Usuario {

    private ArrayList<Aluno> alunos;
    private ArrayList<Treino> treinosCriados;

    public Professor(String nome,String userName, String senha){
        super(nome, userName, senha);
        alunos = new ArrayList<>();
        treinosCriados = new ArrayList<>();
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
