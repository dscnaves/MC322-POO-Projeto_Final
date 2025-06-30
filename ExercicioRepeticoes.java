public class ExercicioRepeticoes extends Exercicio {
    // São exercicios baseados em repetições (ex: agachamentos, abdominais)
    private int repeticoes;

    // Construtor
    public ExercicioRepeticoes(String nome, int series, Tempo intervalo, int repeticoes){
        super(nome, series, intervalo);
        this.repeticoes = repeticoes;
    }
    
    // Obtém o número de repetições
    public int getRepeticoes(){
        return repeticoes;
    }

    // Obtém uma string que indica todas as características do exercício
    @Override
    public String descreverExercicio() {
        return "Nome do exercício: " + getNome() +
               "\nNúmero de séries: " + getNumSeries() +
               "\nNúmero de repetições: " + repeticoes +
               "\nIntervalo: " + getIntervalo().getTempo() + " " + getIntervalo().getMedida();
    }
}
