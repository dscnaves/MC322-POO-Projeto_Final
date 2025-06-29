import java.io.Serializable;
import java.sql.Date;

// Essa classe precisa ser serializavel para podermos guardar as informacoes dos alunos e professores
// Classes que herdam dessa não precisam implementar serializable pois ja herdam. Enum e Exceptions tambem nao precisam
public class Comentario implements Serializable{
    private Usuario autor;
    private String texto;
    private Date data;
}
