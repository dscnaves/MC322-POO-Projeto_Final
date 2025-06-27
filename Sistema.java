import java.util.ArrayList;

public class Sistema {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public Sistema(){
        // Acho que nao precisará desse construtor
    }

    public void cadastro(String nome, String userName, String senha, int caso) throws CadastroInvalidoException {

        if (senha.length() != 4) { // Senha invalida (defini senha de 4 caracteres)
            throw new CadastroInvalidoException("A senha deve possuir exatamente 4 caracteres.");
        }

        for(int i = 0; i < usuarios.size(); i++){ // UserName em uso
            if(usuarios.get(i).getUserName().equals(userName)){
                throw new CadastroInvalidoException("O userName '" + userName + "' já está em uso. Por favor insira outro userName.");
            }
        }

        if(caso == 1)
            usuarios.add(new Aluno(nome, userName, senha)); // Se user e senha validos cadastramos como Aluno (caso 1)
        else    
            usuarios.add(new Professor(nome, userName, senha)); // Se user e senha validos cadastramos como Professor (caso 2)

        System.out.println("Usuário '" + userName + "' cadastrado com sucesso!\n");
    }

    public Usuario login(String userName, String senha) throws CadastroInvalidoException {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getUserName().equals(userName)) {
                // User encontrado
                if (usuarios.get(i).getSenha().equals(senha)) { // Senha é valida
                    System.out.println("Login realizado com sucesso.\n");
                    return usuarios.get(i); // Retorno o usuario para conseguir usar ele na main
                } else { // Senha invalida
                    throw new CadastroInvalidoException("Senha incorreta para o usuário '" + userName + "' ");
                }
            }
        }
        // User não encontrado
        throw new CadastroInvalidoException("Usuário '" + userName + "' não encontrado.");
    }

    public void salvarDados(){

    }

    public void carregarDados(){

    }
}
