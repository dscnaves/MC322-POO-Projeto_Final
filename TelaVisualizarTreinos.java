import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class TelaVisualizarTreinos extends JPanel {
    public TelaVisualizarTreinos(JFrame frame, TelaAluno telaAluno, Aluno aluno) {

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
        // que retorna uma lista de objetos Treino.
        ArrayList<Treino> treinos = aluno.getTreinosRecebidos();

        if (treinos.isEmpty()) {
            treinosPanel.add(new JLabel("Você não possui treinos recebidos."));
        } else {
            for (Treino treino : treinos) {
                // Aqui criamos um painel para cada treino
                JPanel treinoItemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                treinoItemPanel.setBorder(BorderFactory.createEtchedBorder());
                treinoItemPanel.add(new JLabel("Nome do Treino: " + treino.getNome()));
                treinoItemPanel.add(new JLabel("Dificuldade: " + treino.getDificuldade()));

                // Exemplo: Botão para ver detalhes de um treino específico (opcional)
                JButton detalhesButton = new JButton("Ver Detalhes");
                detalhesButton.addActionListener(e -> {
                    // Implementação para mostrar os detalhes do treino
                    JOptionPane.showMessageDialog(frame, "Detalhes do Treino: " + treino.toString());
                });
                treinoItemPanel.add(detalhesButton);

                treinosPanel.add(treinoItemPanel);
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