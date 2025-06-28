import java.awt.*;
import javax.swing.*;

/** Painel com 3 botões. */
public class ThreeButtonsPanel extends JPanel {

    public ThreeButtonsPanel(Runnable backToStart) {
        setLayout(new FlowLayout());

        JButton b1 = new JButton("Botão 1");
        JButton b2 = new JButton("Botão 2");
        JButton b3 = new JButton("Voltar");

        b1.addActionListener(e -> System.out.println("Botão 1 clicado"));
        b2.addActionListener(e -> System.out.println("Botão 2 clicado"));
        b3.addActionListener(e -> backToStart.run());     // volta à tela inicial

        add(b1); add(b2); add(b3);
    }
}
