public class ProgressoTreino {
    private Treino treino;
    private boolean concluido;
    private double percentualConcluido;
    private String observacoes;

    public ProgressoTreino(Treino treino){

    }

    public Treino getTreino(){
        return treino;
    }

    public void setPercentual(double percentual){
        percentualConcluido += percentual;
    }

    public void setConcluido(){
        if(concluido == true)
            concluido = false;
        else
            concluido = true;
    }
}