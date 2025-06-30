import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

// Usuario ja implementa serializavel, logo ja herdamos
public class Professor extends Usuario {
    private static final long serialVersionUID = 1L;  
    // O Professor herda atributos e métodos da classe Usuario
    private ArrayList<Aluno> alunos; // Alunos que sao deste professor pois o aluno escolheu-o
    private ArrayList<Treino> treinosCriados;
    private int novosRecados;

    // Construtor
    public Professor(String nome,String userName, String senha){
        super(nome, userName, senha);
        alunos = new ArrayList<>();
        treinosCriados = new ArrayList<>();
        novosRecados = 0; // Inicializamos a contagem de novos recados
    }

    // metodo que sobrescreve a desserialização padrão. Ele é chamado pelo metodo carregarDados da classe sistema.
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // desserializa os dados salvos, Ele atribui automaticamente aos campos serializáveis os valores salvos no arquivo
        // Após a desserialização, se os campos vieram como null (pois podemos guardar eles vazios no arquivo), criamos um novo ArrayList<> para evitar NullPointerException no resto do código.
        if (alunos == null) alunos = new ArrayList<>();
        if (treinosCriados == null) treinosCriados = new ArrayList<>();
        // Se nao estiverem vazios vms ter todas as informacoes anteriormente registradas
    }

    public void addAluno(Aluno aluno){ // Quando um aluno selecionar esse professor ja colocamos ele no array de alunos deste prof
        alunos.add(aluno);
    }

    // Adiciona um novo treino aos treinos criados
    public void adicionarTreino(Treino treino){
        treinosCriados.add(treino);
    }

    public ArrayList<Aluno> getAlunos(){
        return alunos;
    }

    @Override
    public int getNovosRecados(){
        return novosRecados;
    }
    
    @Override
    public void incrementarNovosRecados() {
        this.novosRecados++;
    }

    @Override
    public void zerarNovosRecados() {
        this.novosRecados = 0;
    }

    public ArrayList<Treino> getTreinosCriados(){
        return treinosCriados;
    }

}