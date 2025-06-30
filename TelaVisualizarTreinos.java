import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class TelaVisualizarTreinos extends JPanel {
    public TelaVisualizarTreinos(JFrame frame, TelaAluno telaAluno, Aluno aluno) {

        setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Meus Treinos Recebidos", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(tituloLabel, BorderLayout.NORTH);

        // Painel para exibir os treinos
        JPanel treinosPanel = new JPanel();
        treinosPanel.setLayout(new BoxLayout(treinosPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(treinosPanel);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Treinos"));
        add(scrollPane, BorderLayout.CENTER);

        ArrayList<Treino> treinos = aluno.getTreinosRecebidos();

        if (treinos.isEmpty()) {
            treinosPanel.add(new JLabel("Você não possui treinos recebidos."));
        } else {
            for (Treino treino : treinos) {
                // Aqui criamos um painel para cada treino
                JPanel treinoItemPanel = new JPanel();
                treinoItemPanel.setLayout(new BoxLayout(treinoItemPanel, BoxLayout.Y_AXIS));
                treinoItemPanel.setBorder(BorderFactory.createEtchedBorder());
                
                treinoItemPanel.add(new JLabel("Nome do Treino: " + treino.getNome()));
                treinoItemPanel.add(new JLabel("Dificuldade: " + treino.getDificuldade()));
                
                // Adiciona os detalhes dos exercícios
                ArrayList<Exercicio> exercicios = treino.getArrayExercicios();
                if (exercicios.isEmpty()) {
                    treinoItemPanel.add(new JLabel("  - Este treino não possui exercícios."));
                } else {
                    treinoItemPanel.add(new JLabel("  - Exercícios:"));
                    for (Exercicio exercicio : exercicios) {
                        // Usa o método descreverExercicio() para obter os detalhes completos do exercício
                        treinoItemPanel.add(new JLabel("    - " + exercicio.descreverExercicio()));
                    }
                }

                treinosPanel.add(treinoItemPanel);
                treinosPanel.add(Box.createVerticalStrut(10)); // Espaço entre os treinos
            }
        }

        // Botão para voltar à tela do aluno
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            frame.setContentPane(telaAluno);
            frame.revalidate();
            frame.repaint();
        });
        add(backButton, BorderLayout.SOUTH);
    }
}