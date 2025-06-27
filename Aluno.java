
// O Aluno herda atributos e metodos da classe Usuario

import java.util.ArrayList;

public class Aluno extends Usuario{
    private ArrayList<Treino> treinosRecebidos;
    private ArrayList<ProgressoTreino> progresso;

    public Aluno(String nome,String userName, String senha){
        super(nome, userName, senha);
        treinosRecebidos = new ArrayList<>();
        progresso = new ArrayList<>();
    }


    public void registrarProgresso(ProgressoTreino progresso){

    }

    public void comentarTreino(Treino treino, String comentario){

    }

    public void visualizarHistorico(){

    }

    public void mostrarMenuPrincipal(){
        // Nao sei ainda como implementar
    }
}
