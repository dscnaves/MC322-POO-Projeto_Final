public class ExercicioRepeticoes extends Exercicio {

    // São exercicios baseados em repetições (ex: agachamentos, abdominais)
    private final int repeticoes;

    // Construtor
    public ExercicioRepeticoes(String nome, int series, Tempo intervalo, int repeticoes){
        super(nome, series, intervalo);
        this.repeticoes = repeticoes;
    }
    
    // Obtém o número de repetições
    public int getRepeticoes(){
        return repeticoes;
    }
}
