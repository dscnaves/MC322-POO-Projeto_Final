import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

// Essa classe precisa ser serializavel para podermos guardar as informacoes dos alunos e professores
// Classes que herdam dessa não precisam implementar serializable pois ja herdam. Enum e Exceptions tambem nao precisam
public class Treino implements Serializable{
    // O serialVersionUID é um identificador de versão da classe. Ele serve para garantir que, ao desserializar um objeto (ler do arquivo), a classe usada hoje ainda é compatível com a classe usada quando o objeto foi salvo.
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private EnumDificuldade dificuldade;
    private ArrayList<Exercicio> exercicios;

    // Construtor
    public Treino(String nome, EnumDificuldade dificuldade, Professor profResponsavel){
        this.nome = nome;
        this.dificuldade = dificuldade;
        exercicios = new ArrayList<>();
    }

    // metodo que sobrescreve a desserialização padrão. Ele é chamado pelo metodo carregarDados da classe sistema.
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // desserializa os dados salvos, Ele atribui automaticamente aos campos serializáveis os valores salvos no arquivo 
        // Após a desserialização, se os campos vieram como null (pois podemos guardar eles vazios no arquivo), criamos um novo ArrayList<> para evitar NullPointerException no resto do código.
        if (exercicios == null) exercicios = new ArrayList<>();
        // Se nao estiverem vazios vms ter todas as informacoes anteriormente registradas
    }

    // Obtém o nome do treino
    public String getNome(){
        return nome;
    }

    // Obtém a dificuldade do treino
    public EnumDificuldade getDificuldade(){
        return dificuldade;
    }

    // Obtém os exercícios do treino
    public ArrayList<Exercicio> getArrayExercicios(){
        return exercicios;
    }
    
    // Adiciona um novo exercício ao treino
    public void adicionarExercicio(Exercicio exercicio){
        exercicios.add(exercicio);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do Treino: ").append(nome).append("\n");
        sb.append("Dificuldade: ").append(dificuldade).append("\n");
        sb.append("--------------------\n");
        sb.append("Exercícios:\n");

        if (exercicios.isEmpty()) {
            sb.append("  - Nenhum exercício adicionado.\n");
        } else {
            for (Exercicio exercicio : exercicios) {
                sb.append("  - ").append(exercicio.descreverExercicio()).append("\n");
                sb.append("--------------------\n"); // Adiciona uma linha de separação entre os exercícios
            }
        }
        return sb.toString();
    }
}