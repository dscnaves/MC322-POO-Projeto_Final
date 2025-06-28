public class Tempo {
    
    // Guarda um intervalo de tempo medido em segundos ou minutos
    private final int duracao;
    private final EnumTempo medida;

    // Construtor
    public Tempo(int duracao, EnumTempo medida){
        this.duracao = duracao;
        this.medida = medida;
    }

    // Obtém o intervalo de tempo
    public int getTempo(){
        return duracao;
    }

    // Obtém a medida do intervalo (minutos ou segundos)
    public EnumTempo getMedida(){
        return medida;
    }
}
