// TelaProfessor.java
import java.awt.*;
import javax.swing.*;

public class TelaProfessor extends JPanel {

    public TelaProfessor(JFrame frame, Professor professor) {
        /* 1) Layout em coluna, 8 px de espaçamento vertical */
        setLayout(new GridLayout(0, 1, 0, 8));

        /* 2) Texto fixo */
        JLabel titulo = new JLabel("Seja bem‑vindo, " + professor.getNome(),
                                   SwingConstants.CENTER);
        add(titulo);

        /* 3) Botões da “página” */
        JButton botaoNovoTreino        = new JButton("Criar novo treino");
        JButton botaoVerTreinos        = new JButton("Visualizar treinos criados");
        JButton botaoIndicarAluno      = new JButton("Indicar treino para um aluno");
        JButton botaoVerAlunos         = new JButton("Visualizar alunos");
        JButton botaoVerRecados        = new JButton("Visualizar recados");

        add(botaoNovoTreino);
        add(botaoVerTreinos);
        add(botaoIndicarAluno);
        add(botaoVerAlunos);
        add(botaoVerRecados);

        /* 4) Ações – trocam apenas o painel dentro do mesmo JFrame */
        botaoNovoTreino.addActionListener(e -> {
            frame.setContentPane(new TelaNovoTreino(frame, professor));
            frame.revalidate();
        });

        /* 
        botaoVerTreinos.addActionListener(e -> {
            frame.setContentPane(new TelaTreinosCriados(frame, professor));
            frame.revalidate();
        });

        botaoIndicarAluno.addActionListener(e -> {
            frame.setContentPane(new TelaIndicarParaAluno(frame, professor));
            frame.revalidate();
        });

        botaoVerAlunos.addActionListener(e -> {
            frame.setContentPane(new TelaVisualizarAlunos(frame, professor));
            frame.revalidate();
        });

        botaoVerRecados.addActionListener(e -> {
            frame.setContentPane(new TelaRecados(frame, professor));
            frame.revalidate();
        }); */
    }
}