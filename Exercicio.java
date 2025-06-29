import java.io.Serializable;

// Essa classe precisa ser serializavel para podermos guardar as informacoes dos alunos e professores
// Classes que herdam dessa não precisam implementar serializable pois ja herdam. Enum e Exceptions tambem nao precisam
public class Exercicio implements Serializable {

    private final String nome;
    private final int numSeries;
    private final Tempo intervalo;

    // Construtor
    public Exercicio(String nome, int numSeries, Tempo intervalo) {
        this.nome = nome;
        this.numSeries = numSeries;
        this.intervalo = intervalo;
    }

    // Obtém o nome do exercício
    public String getNome(){
        return nome;
    }

    // Obtém o número de séries
    public int getNumSeries(){
        return  numSeries;
    }

    // Obtém o tempo de intervalo entre cada série
    public Tempo getIntervalo(){
        return intervalo;
    }
}