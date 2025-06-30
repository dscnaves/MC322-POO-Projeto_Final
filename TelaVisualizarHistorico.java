import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class TelaVisualizarHistorico extends JPanel {
    public TelaVisualizarHistorico(JFrame frame, TelaAluno telaAluno, Aluno aluno) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel tituloLabel = new JLabel("Histórico de Treinos", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(tituloLabel, BorderLayout.NORTH);

        JPanel historicoPanel = new JPanel();
        historicoPanel.setLayout(new BoxLayout(historicoPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(historicoPanel);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Treinos Concluídos/Registrados"));
        add(scrollPane, BorderLayout.CENTER);

        // Pegamos o progresso do aluno
        ArrayList<TreinoExecutavel> progressoHistorico = aluno.getProgresso();

        if (progressoHistorico.isEmpty()) {
            historicoPanel.add(new JLabel("Você ainda não possui histórico de treinos."));
        } else {
            for (TreinoExecutavel progresso : progressoHistorico) {
                JPanel historicoItemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                historicoItemPanel.setBorder(BorderFactory.createEtchedBorder());
                historicoItemPanel.add(new JLabel("Treino: " + progresso.getTreino().getNome()));
                historicoItemPanel.add(new JLabel(" | Progresso: " + progresso.getPercentual() + "%"));
                historicoItemPanel.add(new JLabel(" | Concluído: " + (progresso.getPercentual() >= 100 ? "Sim" : "Não")));

                historicoPanel.add(historicoItemPanel);
            }
        }

        // Botão para voltar
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            frame.setContentPane(telaAluno);
            frame.revalidate();
            frame.repaint();
        });
        add(backButton, BorderLayout.SOUTH);
    }
}