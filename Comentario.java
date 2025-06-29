import java.io.Serializable;
import java.util.Date;

// Essa classe precisa ser serializavel para podermos guardar as informacoes dos alunos e professores
// Classes que herdam dessa não precisam implementar serializable pois ja herdam. Enum e Exceptions tambem nao precisam
/**
 * Representa um recado ou comentário enviado por um usuário.
 */
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Usuario autor;
    private final String texto;
    private final Date data;

    public Comentario(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
        this.data = new Date(); // Captura a data e hora do envio
    }

    public Usuario getAutor() {
        return autor;
    }

    public String getTexto() {
        return texto;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        return "De: " + autor.getNome() + " | Em: " + data.toString() + "\n  \"" + texto + "\"";
    }
}