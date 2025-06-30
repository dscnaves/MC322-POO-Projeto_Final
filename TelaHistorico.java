import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaHistorico extends JPanel {

    public TelaHistorico(JFrame frame, TelaAluno telaAluno, Aluno aluno){

        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(30, 40, 30, 40));

        JLabel tituloLabel = new JLabel("Treinos concluidos", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(tituloLabel, BorderLayout.NORTH);
        add(Box.createVerticalStrut(20));

        // Painel para exibir os treinos
        JPanel treinosPanel = new JPanel();
        treinosPanel.setLayout(new BoxLayout(treinosPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(treinosPanel);
        scrollPane.setBorder(BorderFactory.createTitledBorder(""));
        add(scrollPane, BorderLayout.CENTER);

        // Supondo que a classe Aluno tenha um método getTreinosRecebidos()
        // que retorna uma lista de objetos Treino.
        ArrayList<TreinoExecutavel> treinos = aluno.getTreinosExecutaveis();
        ArrayList<TreinoExecutavel> treinosConcluidos = new ArrayList<>();
        for (int i = 0; i < treinos.size(); i++){
            if (treinos.get(i).getPercentual() == 100){
                treinosConcluidos.add(treinos.get(i));
            }
        }

        if (treinosConcluidos.isEmpty()) {
            treinosPanel.add(new JLabel("Você não concluiu nenhum treino."));
        } else {
            for (TreinoExecutavel treino : treinosConcluidos) {
                // Aqui criamos um painel para cada treino
                JPanel treinoItemPanel = new JPanel();
                treinoItemPanel.setLayout(new BoxLayout(treinoItemPanel, BoxLayout.Y_AXIS));
                treinoItemPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                treinoItemPanel.add(new JLabel("Nome do Treino: " + treino.getTreino().getNome()));
                treinoItemPanel.add(Box.createVerticalStrut(5));
                treinoItemPanel.add(new JLabel("Professor responsável: " + treino.getProfResponsavel()));
                treinoItemPanel.add(Box.createVerticalStrut(10));

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