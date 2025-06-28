import javax.swing.*;
import java.awt.*;

// Usamos JPanel para mudar entre "telas" 
public class TelaProfessor extends JPanel {
    public TelaProfessor(JFrame frame, Professor professor) { // Recebemos sempre por parametro a janela, aqui recebemos o professor tambem
        setLayout(new GridLayout(0,1)); //
        add(new JLabel("professor"));

    }
}
