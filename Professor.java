import java.util.ArrayList;

// O Professor herda atributos e metodos da classe Usuario
public class Professor extends Usuario {

    private ArrayList<Aluno> alunos;
    private ArrayList<Treino> treinosCriados;

    public Professor(String nome,String userName, String senha, ArrayList<Aluno> alunos, ArrayList<Treino> treinosCriados){
        super(nome, userName, senha);
        alunos = new ArrayList<>();
        treinosCriados = new ArrayList<>();
        this.alunos = alunos; 
        this.treinosCriados = treinosCriados;
    }

    public void criarTreino(){

    }

    public void atribuirTreino(Aluno aluno, Treino treino) {

    }

    public void verComentarios(){

    }

    public void responderComentario(){

    }

    public void mostrarMenuPrincipal(){
        // Nao sei ainda como implementar
    }   
}
