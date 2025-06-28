import java.awt.*;
import javax.swing.*;

public class TwoButtonsPanel extends JPanel {

    public TwoButtonsPanel(Runnable backToStart) {
        setLayout(new BorderLayout());

        // texto fixo no topo
        JLabel titulo = new JLabel("Painel com dois botões", JLabel.CENTER);
        add(titulo, BorderLayout.NORTH);

        // botões em um subpainel FlowLayout
        JPanel botoes = new JPanel(new FlowLayout());
        JButton b1 = new JButton("Botão A");
        JButton b2 = new JButton("Voltar");

        b1.addActionListener(e -> System.out.println("Botão A clicado"));
        b2.addActionListener(e -> backToStart.run());

        botoes.add(b1);
        botoes.add(b2);

        add(botoes, BorderLayout.CENTER);
    }
}