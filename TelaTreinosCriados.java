import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class TelaTreinosCriados extends JPanel {

    public TelaTreinosCriados(JFrame frame, TelaProfessor telaProfessor, Professor professor){
        setLayout(new BorderLayout(10, 10)); // Layout para organizar os componentes
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adiciona uma margem

        JLabel tituloLabel = new JLabel("Meus Treinos Criados", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(tituloLabel, BorderLayout.NORTH);

        // Painel para exibir os treinos
        JPanel painelTreinos = new JPanel();
        painelTreinos.setLayout(new BoxLayout(painelTreinos, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(painelTreinos);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Treinos"));
        add(scrollPane, BorderLayout.CENTER);

        ArrayList<Treino> treinosCriados = professor.getTreinosCriados();

        if (treinosCriados.isEmpty()) {
            painelTreinos.add(new JLabel("Você não possui treinos criados."));
        } else {
            for (Treino treino : treinosCriados) {
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

                painelTreinos.add(treinoItemPanel);
            }
        }

        // Botão para voltar à tela do aluno
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            frame.setContentPane(telaProfessor);
            frame.revalidate();
        });
        add(backButton, BorderLayout.SOUTH);
    }
}
