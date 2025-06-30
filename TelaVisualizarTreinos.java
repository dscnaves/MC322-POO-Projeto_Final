import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaVisualizarTreinos extends JPanel {
    public TelaVisualizarTreinos(JFrame frame, TelaAluno telaAluno, Aluno aluno) {

        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10)); // Adiciona margens ao painel principal

        JLabel tituloLabel = new JLabel("Meus Treinos Recebidos", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(tituloLabel, BorderLayout.NORTH);

        // Painel para exibir os treinos
        JPanel treinosPanel = new JPanel();
        treinosPanel.setLayout(new BoxLayout(treinosPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(treinosPanel);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Treinos"));
        add(scrollPane, BorderLayout.CENTER);

        // Supondo que a classe Aluno tenha um método getTreinosRecebidos()
        ArrayList<Treino> treinos = aluno.getTreinosRecebidos(); // Obtém os treinos recebidos pelo aluno

        if (treinos.isEmpty()) {
            treinosPanel.add(new JLabel("Você não possui treinos recebidos."));
        } else {
            for (Treino treino : treinos) {
                // Aqui criamos um painel para cada treino com um layout vertical
                JPanel treinoItemPanel = new JPanel();
                treinoItemPanel.setLayout(new BoxLayout(treinoItemPanel, BoxLayout.Y_AXIS));
                treinoItemPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEtchedBorder(),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10) // Adiciona espaçamento interno
                ));
                
            // Nome do treino
            JLabel nomeLabel = new JLabel("<html><b>Nome do Treino:</b> " + treino.getNome() + "</html>");
            nomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // centraliza horizontalmente
            treinoItemPanel.add(nomeLabel);

            // Dificuldade do treino
            JLabel dificuldadeLabel = new JLabel("<html><b>Dificuldade:</b> " + treino.getDificuldade() + "</html>");
            dificuldadeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // centraliza horizontalmente
            treinoItemPanel.add(dificuldadeLabel);

                // Adiciona os detalhes dos exercícios
                ArrayList<Exercicio> exercicios = treino.getArrayExercicios(); // Obtém a lista de exercícios do treino
                if (exercicios.isEmpty()) {
                    treinoItemPanel.add(new JLabel("  - Este treino não possui exercícios."));
                } else {
                    treinoItemPanel.add(Box.createVerticalStrut(10)); // Espaçamento
                    treinoItemPanel.add(new JLabel("<html><b>Exercícios:</b></html>"));
                    for (Exercicio exercicio : exercicios) {
                        // Usa um JTextArea para exibir o texto com quebras de linha
                        JTextArea exercicioDetails = new JTextArea(exercicio.descreverExercicio());
                        exercicioDetails.setEditable(false);
                        exercicioDetails.setOpaque(false); // Torna o JTextArea transparente
                        exercicioDetails.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Usa uma fonte monoespaçada para alinhamento
                        treinoItemPanel.add(exercicioDetails);
                        treinoItemPanel.add(Box.createVerticalStrut(5)); // Espaço entre os exercícios
                    }
                }

                treinosPanel.add(treinoItemPanel);
                treinosPanel.add(Box.createVerticalStrut(15)); // Espaço entre os treinos
            }
        }

        // Botão para voltar à tela do aluno
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            frame.setContentPane(telaAluno); // Volta para a tela do aluno
            frame.revalidate();
            frame.repaint();
        });
        add(backButton, BorderLayout.SOUTH);
    }
}