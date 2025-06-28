import java.util.ArrayList;

public class Treino {

    private final String nome;
    private final EnumDificuldade dificuldade;
    private final ArrayList<Exercicio> exercicios;

    // Construtor
    public Treino(String nome, EnumDificuldade dificuldade, Professor profResponsavel){
        this.nome = nome;
        this.dificuldade = dificuldade;
        exercicios = new ArrayList<>();
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
        return "Treino: " + nome +
               ",\n Dificuldade: " + dificuldade;
    }
}