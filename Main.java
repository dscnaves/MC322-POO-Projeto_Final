import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

// oi main aaaaaaaaa
public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sistema");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 800);//teste

            // Instânciamento do sistema (usado para cadastro e login de usuários)
            Sistema sistema = new Sistema();

            TelaLogin telaLogin = new TelaLogin(frame, sistema);
            frame.setContentPane(telaLogin); // inicia com tela de login
            frame.setVisible(true);
        });
    }

}