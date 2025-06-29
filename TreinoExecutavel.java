import java.io.Serializable;
import java.util.ArrayList;

// Essa classe precisa ser serializavel para podermos guardar as informacoes dos alunos e professores
// Classes que herdam dessa não precisam implementar serializable pois ja herdam. Enum e Exceptions tambem nao precisam
public class TreinoExecutavel implements Serializable{
    
    // Recebe um Treino por agregação e pode registrar o progresso e comentários dos alunos nesse treino, sem alterar o Treino original
    private final Treino treino;
    private final Professor profResponsavel;
    private double percentualConcluido;
    private boolean concluido;
    private final ArrayList<String> observacoes;

    // Construtor
    public TreinoExecutavel(Treino treino, Professor profResponsavel){
        this.treino = treino;
        this.profResponsavel = profResponsavel;
        percentualConcluido = 0;
        concluido = false;
        observacoes = new ArrayList<>();
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
}