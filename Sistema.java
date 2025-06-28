import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Sistema {
    private static final String ARQUIVO_USUARIOS = "usuarios.dat"; // define o nome do arquivo que usaremos para serializar
    private static final ArrayList<Usuario> usuarios = new ArrayList<>();

    public Sistema(){
        carregarDados(); // Vamos pegar os dados que guardamos ao fazer a serializacao (estamos desserializando aqui)
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
        // 0 = Aluno, 1 = Professor
        if(caso == 0)
            usuarios.add(new Aluno(nome, userName, senha)); // Se user e senha validos cadastramos como Aluno (caso 1)
        else    
            usuarios.add(new Professor(nome, userName, senha)); // Se user e senha validos cadastramos como Professor (caso 2)

        salvarDados(); // Vamos salvar no aquivo.dat esse novo user
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
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_USUARIOS))) { // ObjectOutputStream out, nessa hora que o arquivo é realmente criado no disco. Porem se ele ja existir sobrescrevemos ele.
            out.writeObject(usuarios); // adicionamos o array usuarios atualizados (ou seja: todos os usuarios que ja estavam no arquivo.dat + o novo user)
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked") // serve para esconder um aviso do compilador, pois como vamos fazer um cast de um objeto genérico (Object) para um tipo genérico (ArrayList<Usuario>), o compilador pode alertar que isso é inseguro.
    public void carregarDados() {
        File arquivo = new File(ARQUIVO_USUARIOS); // Criamos o ponteiro para o arquivo (ainda nao criamos ele, pois para a primeira vez nao tera ainda o que ser carregado)
        if (!arquivo.exists()) return; // nada a carregar

        // Se o arquivo existe significa que ja temos um conteudo que foi salvo anteriormente e precisamos pega-lo
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) { // Abrimos o arquivo para leitura e ObjectInputStream interpreta os bytes lidos e "transforma" para objetos
            ArrayList<Usuario> lista = (ArrayList<Usuario>) in.readObject(); // Aqui fazemos um cast (forcamos in.readObject() "o que foi lido" ser do tipo (ArrayList<Usuario>))
            usuarios.clear(); // limpa o array usuarios para nao dar erros e nem duplicacoes por seguranca
            usuarios.addAll(lista); //adiciona a lista dos Usuarios serializados (que foram lidos do arquivo)
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
    }


    // cast: é forcar a conversão. Ex: vamos forcar a conversao de double para int.
    // double numero = 9.75;
    // int inteiro = (int) numero;  // cast de double para int
    // System.out.println(inteiro); // Saída: 9 (parte decimal é descartada)
}
