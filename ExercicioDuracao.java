import java.io.Serializable;

public class ExercicioDuracao extends Exercicio{
    // São exercícios baseados em tempo de realização (ex: prancha, corrida)
    private Tempo duracao;

    // Construtor
    public ExercicioDuracao(String nome, int series, Tempo intervalo, Tempo duracao){
        super(nome, series, intervalo);
        this.duracao = duracao;
    }

    // Obtém o tempo de duração do exercício
    public Tempo getDuracao(){
        return duracao;
    }

    // Obtém uma string que indica todas as características do exercício
    @Override
    public String descreverExercicio() {
        return "Nome do exercício: " + getNome() +
               "\nNúmero de séries: " + getNumSeries() +
               "\nTempo em cada série: " + duracao.getTempo() + " " + duracao.getMedida() +
               "\nIntervalo: " + getIntervalo().getTempo() + " " + getIntervalo().getMedida();
    }
}