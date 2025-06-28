// O Aluno herda atributos e metodos da classe Usuário

import java.util.ArrayList;
import java.util.Scanner;

//OIE OIE GENTE 
public class Aluno extends Usuario {

    private final ArrayList<Treino> treinosRecebidos;
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

    @Override  // Essa será a implementacao do metodo abstrato. Aqui implementaremos a interface especifica do Aluno
    public void mostrarMenuPrincipal(Scanner entrada){
        System.out.println("Bem-vindo à interface do aluno!\n");
    }
}
