import java.awt.*;
import javax.swing.*;

public class TelaNovoTreino extends JPanel {

    public TelaNovoTreino(JFrame frame, Professor professor) { // Recebemos sempre por parametro a janela, aqui recebemos o aluno tambem
        setLayout(new GridLayout(0,1)); //
        add(new JLabel("Criar novo treino"));

    }
}
