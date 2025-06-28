public class CadastroInvalidoException extends Exception {

    // Excessão lançada quando ocorre algum problema em cadastrar o usuário (ex: senha fora dos padrões estabelecidos)
    public CadastroInvalidoException(String mensagem){
        super(mensagem);
    }
}
