import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Instânciamento do sistema (usado para cadastro e login de usuários)
        Sistema sistema = new Sistema();

        // Variáveis de funcionamento do sistema.
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;

        // Loop de funcionamento do sistema:
        while(continuar){
            System.out.println("Selecione alguma das opções abaixo:\n" +
            "[1] - Cadastre-se no sistema\n" +
            "[2] - Fazer Login no sistema\n" +
            "[0] - Sair do sistema\n");
    
            int opcao = entrada.nextInt();
            entrada.nextLine(); // limpa o buffer

            String nome, userName, senha;
            switch (opcao){
                case 1:
                    while (true) {
                        try {
                            System.out.println("Qual o seu nome:");
                            nome = entrada.nextLine();

                            System.out.println("Crie um userName:");
                            userName = entrada.nextLine();

                            System.out.println("Crie uma senha:");
                            senha = entrada.nextLine();

                            sistema.cadastro(nome, userName, senha);
                            break;

                        } 
                        catch (CadastroInvalidoException e){
                            System.err.println("Erro: " + e.getMessage());
                            System.out.println("Tente novamente \n");
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        try {
                            System.out.println("Digite seu userName:");
                            userName = entrada.nextLine();

                            System.out.println("Digite sua senha:");
                            senha = entrada.nextLine();

                            sistema.login(userName, senha);
                            break;

                        } 
                        catch (CadastroInvalidoException e){
                            System.err.println("Erro: " + e.getMessage());
                            System.out.println("Tente novamente \n");
                        }
                    }
                    break;
                case 0:
                System.out.println("Saindo...");
                continuar = false;
                    break;  

                default:
                System.out.println("Valor inválido, digite novamente\n");
                    break;
            }
        }
        entrada.close();
    }
}