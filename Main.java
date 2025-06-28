import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

// oi main aaaaaaaaa
public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sistema");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 800);//teste

            // Instânciamento do sistema (usado para cadastro e login de usuários)
            Sistema sistema = new Sistema();

            TelaLogin telaLogin = new TelaLogin(frame, sistema);
            frame.setContentPane(telaLogin); // inicia com tela de login
            frame.setVisible(true);
        });

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
            int caso; // Usada para determinar se será um Aluno ou Professor
            switch (opcao){
                case 1:
                    while (true) {
                        try {
                            System.out.println("Selecione alguma das opções abaixo:\n" +
                            "[1] - Para se cadastrar como Aluno\n" + 
                            "[2] - Para se cadastrar como Professor  \n");

                            caso = entrada.nextInt();
                            entrada.nextLine(); // limpa o buffer

                            System.out.println("Qual o seu nome:");
                            nome = entrada.nextLine();

                            System.out.println("Crie um userName:");
                            userName = entrada.nextLine();

                            System.out.println("Crie uma senha:");
                            senha = entrada.nextLine();

                            sistema.cadastro(nome, userName, senha, caso);
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

                            Usuario user = sistema.login(userName, senha); // o metodo login retornará ou um aluno ou um professor. Assim vamos usar Usuario como variavel, pois nao sabemos qual deles será retornado.
                            System.out.println("Debug: Tipo real do usuário: " + user.getClass().getSimpleName());
                            user.mostrarMenuPrincipal(entrada); // Isso chama automaticamente a interface correta, se for aluno exibira seu respectivo menu (o mesmo acontecera para o professor)
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