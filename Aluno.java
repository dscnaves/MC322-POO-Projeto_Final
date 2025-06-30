// O Aluno herda atributos e metodos da classe Usuário
import java.io.IOException;
import java.util.ArrayList;

// Usuario ja implementa serializavel, logo ja herdamos
public class Aluno extends Usuario {
    private static final long serialVersionUID = 1L; 
    // O Aluno herda atributos e métodos da classe Usuario
    private ArrayList<Professor> professores; // Professores que o Aluno adicionou
    private ArrayList<Treino> treinosRecebidos;
    private ArrayList<TreinoExecutavel> progresso;
    private int novosRecados;

    // Construtor
    public Aluno(String nome,String userName, String senha){
        super(nome, userName, senha);
        treinosRecebidos = new ArrayList<>();
        progresso = new ArrayList<>();
        professores = new ArrayList<>();
        novosRecados = 0; // Inicializamos a contagem de novos recados
    }

    // metodo que sobrescreve a desserialização padrão. Ele é chamado pelo metodo carregarDados da classe sistema.
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // desserializa os dados salvos, Ele atribui automaticamente aos campos serializáveis os valores salvos no arquivo
        // Após a desserialização, se os campos vieram como null (pois podemos guardar eles vazios no arquivo), criamos um novo ArrayList<> para evitar NullPointerException no resto do código.
        if (professores == null) professores = new ArrayList<>();
        if (treinosRecebidos == null) treinosRecebidos = new ArrayList<>();
        if (progresso == null) progresso = new ArrayList<>();
        // Se nao estiverem vazios vms ter todas as informacoes anteriormente registradas
    }

    public ArrayList<TreinoExecutavel> getTreinosExecutaveis(){
        return progresso;
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

    public void addProf(Professor prof){
        professores.add(prof);
    }

    public ArrayList<Professor> getProfessores(){
        return professores;
    }
    
    public ArrayList<Treino> getTreinosRecebidos() {
        return treinosRecebidos;
    }

    public void addTreinoRecebido(Treino treino){
        treinosRecebidos.add(treino);

    }

    public ArrayList<TreinoExecutavel> getProgresso() {
        return progresso;
    }

    public void addTreinoExe(TreinoExecutavel treinoExe){
        progresso.add(treinoExe);

    }

}