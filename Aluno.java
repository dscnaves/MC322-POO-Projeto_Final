// O Aluno herda atributos e metodos da classe Usuário

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

// Usuario ja implementa serializavel, logo ja herdamos
public class Aluno extends Usuario { // Usuario é serializavel (Serialização é o processo de transformar um objeto Java em uma sequência de bytes,)
    
    // O serialVersionUID é um identificador de versão da classe. Ele serve para garantir que, ao desserializar um objeto (ler do arquivo), a classe usada hoje ainda é compatível com a classe usada quando o objeto foi salvo.
    private static final long serialVersionUID = 1L; 
    // O Aluno herda atributos e métodos da classe Usuario
    private ArrayList<Professor> professores; // Professores que o Aluno adicionou

    private ArrayList<Treino> treinosRecebidos = new ArrayList<>();
    private ArrayList<TreinoExecutavel> progresso;
    private int novosRecados;

    // Construtor
    public Aluno(String nome,String userName, String senha){
        super(nome, userName, senha);
        treinosRecebidos = new ArrayList<>();
        progresso = new ArrayList<>();
        professores = new ArrayList<>();

        novosRecados = 0;
    }
    // ←⛳️ AQUI está o método que você deve adicionar
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // desserializa os dados salvos
        if (professores == null) professores = new ArrayList<>();
        if (treinosRecebidos == null) treinosRecebidos = new ArrayList<>();
        if (progresso == null) progresso = new ArrayList<>();
    }

    public void registrarProgresso(TreinoExecutavel progresso){

    }

    public void comentarTreino(Treino treino, String comentario){

    }

    public void visualizarHistorico(){

    }

    public int getNovosRecados(){
        return novosRecados;
    }

    public void addProf(Professor prof){
        professores.add(prof);
    }

    public ArrayList<Professor> getProfessores(){
        return professores;
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
