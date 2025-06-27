public class Usuario {
    private String nome;
    private String userName;
    private String senha;

    public Usuario(String nome,String userName, String senha){
        this.nome = nome;
        this.userName = userName;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }
    
    public String getUserName(){
        return userName;
    }

    public String getSenha(){
        return senha;
    }

    public void mostrarMenuPrincipal(){
        // ainda nao sei como implementar, acho q poderia ser abstract e assim implemantarmos nas classes Aluno e Professor
    }    
}
