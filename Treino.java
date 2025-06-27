import java.util.ArrayList;

public class Treino {
    private String nome;
    private ArrayList<Exercicio> exercicios;
    private EnumDificuldade dificuldade;

    public Treino(){
        exercicios = new ArrayList<>();
    }
    
    public void adicionarExercicio(Exercicio exercicio){

    }

    @Override
    public String toString() {
        return "Treino: " + nome +
               ",\n Dificuldade: " + dificuldade;
    }
}