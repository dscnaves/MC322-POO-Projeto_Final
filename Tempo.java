// Essa classe precisa ser serializavel para podermos guardar as informacoes dos alunos e professores
// Classes que herdam dessa não precisam implementar serializable pois ja herdam. Enum e Exceptions tambem nao precisam

import java.io.Serializable;

public class Tempo implements Serializable{
    
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
