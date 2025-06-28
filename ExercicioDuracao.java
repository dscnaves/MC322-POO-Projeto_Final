public class ExercicioDuracao extends Exercicio {
    
    // São exercícios baseados em tempo de realização (ex: prancha, corrida)
    private final Tempo duracao;

    // Construtor
    public ExercicioDuracao(String nome, int series, Tempo intervalo, Tempo duracao){
        super(nome, series, intervalo);
        this.duracao = duracao;
    }

    // Obtém o tempo de duração do exercício
    public Tempo getDuracao(){
        return duracao;
    }
}
