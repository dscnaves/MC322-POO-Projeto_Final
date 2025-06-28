import javax.swing.*;
import java.awt.*;

// Usamos JPanel para mudar entre "telas" 
public class TelaAluno extends JPanel {
    public TelaAluno(JFrame frame, Aluno aluno) { // Recebemos sempre por parametro a janela, aqui recebemos o aluno tambem
        setLayout(new GridLayout(0,1)); //
        add(new JLabel("Aluno"));

    }
}
