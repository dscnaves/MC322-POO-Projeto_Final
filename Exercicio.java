import java.io.Serializable;

public abstract class Exercicio implements Serializable{

    private String nome;
    private int numSeries;
    private Tempo intervalo;

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

    // Obtém uma string que indica todas as características do exercício
    public abstract String descreverExercicio();
}