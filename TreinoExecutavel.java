import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

// Essa classe precisa ser serializavel para podermos guardar as informacoes dos alunos e professores
// Classes que herdam dessa não precisam implementar serializable pois ja herdam. Enum e Exceptions tambem nao precisam
public class TreinoExecutavel implements Serializable{
    // O serialVersionUID é um identificador de versão da classe. Ele serve para garantir que, ao desserializar um objeto (ler do arquivo), a classe usada hoje ainda é compatível com a classe usada quando o objeto foi salvo.
    private static final long serialVersionUID = 1L;
    
    // Recebe um Treino por agregação e pode registrar o progresso e comentários dos alunos nesse treino, sem alterar o Treino original
    private Treino treino;
    private Professor profResponsavel;
    private double percentualConcluido;
    private boolean concluido;
    private ArrayList<String> observacoes;

    // Construtor
    public TreinoExecutavel(Treino treino, Professor profResponsavel){
        this.treino = treino;
        this.profResponsavel = profResponsavel;
        percentualConcluido = 0;
        concluido = false;
        observacoes = new ArrayList<>();
    }

    // metodo que sobrescreve a desserialização padrão. Ele é chamado pelo metodo carregarDados da classe sistema.
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // desserializa os dados salvos, Ele atribui automaticamente aos campos serializáveis os valores salvos no arquivo 
        // Após a desserialização, se os campos vieram como null (pois podemos guardar eles vazios no arquivo), criamos um novo ArrayList<> para evitar NullPointerException no resto do código.
        if (observacoes == null) observacoes = new ArrayList<>();
        // Se nao estiverem vazios vms ter todas as informacoes anteriormente registradas
    }

    // Obtém o Treino 
    public Treino getTreino(){
        return treino;
    }

    // Obtém o professor criador do treino
    public Professor getProfResponsavel(){
        return profResponsavel;
    }

    // Obtém o percentual concluido do Treino
    public double getPercentual(){
        return  percentualConcluido;
    }

    //
    public void setPercentual(double percentual){
        percentualConcluido += percentual;
    }

    public void setConcluido(){
        concluido = !concluido;
    }

    // Se vc usar um JComboBox vc precisa sobrescerver o metodo toString para nao aparecer algo assim como o nome do campo TreinoExecutavel@2f4d3709 
    @Override
    public String toString() {
        return treino.getNome() + " (" + percentualConcluido + "%)";
    }
}