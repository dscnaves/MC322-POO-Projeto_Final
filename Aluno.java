// O Aluno herda atributos e metodos da classe Usuário

import java.util.ArrayList;
import java.util.Scanner;

// oie oie gente dsfafyufayuduydfys
public class Aluno extends Usuario {

    private ArrayList<Treino> treinosRecebidos = new ArrayList<>();
    private ArrayList<TreinoExecutavel> progresso;

    public Aluno(String nome,String userName, String senha){
        super(nome, userName, senha);
        treinosRecebidos = new ArrayList<>();
        progresso = new ArrayList<>();
    }


    public void registrarProgresso(TreinoExecutavel progresso){

    }

    public void comentarTreino(Treino treino, String comentario){

    }

    public void visualizarHistorico(){

    }

    public ArrayList<Treino> getTreinosRecebidos() {
        return treinosRecebidos;
    }

    public ArrayList<TreinoExecutavel> getProgresso() {
        return progresso;
    }

    @Override  // Essa será a implementacao do metodo abstrato. Aqui implementaremos a interface especifica do Aluno
    public void mostrarMenuPrincipal(Scanner entrada){
        System.out.println("Bem-vindo à interface do aluno!\n");
    }
}
