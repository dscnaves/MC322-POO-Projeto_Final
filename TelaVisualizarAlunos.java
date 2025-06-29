import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class TelaVisualizarAlunos extends JPanel{
    public TelaVisualizarAlunos(JFrame frame, Professor professor, TelaProfessor telaProfessor){
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel tituloLabel = new JLabel("Lista dos seus alunos", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(tituloLabel, BorderLayout.NORTH);

        JPanel alunosPanel = new JPanel();
        alunosPanel.setLayout(new BoxLayout(alunosPanel, BoxLayout.Y_AXIS));
        ArrayList<Aluno> alunos = professor.getAlunos();

        if (alunos.isEmpty()) {
            alunosPanel.add(new JLabel("Não há nenhum aluno."));
        } else {
            Dimension botaoSize = new Dimension(400, 50);
            for (Aluno i : alunos) {
                JPanel alunoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                alunoPanel.setBorder(BorderFactory.createEtchedBorder());
                alunoPanel.add(new JLabel(i.getNome()));

                alunosPanel.add(alunoPanel);
            }
        }

        JScrollPane scrollPane = new JScrollPane(alunosPanel);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Seus Alunos"));
        add(scrollPane, BorderLayout.CENTER);

        // Botão para voltar
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            frame.setContentPane(telaProfessor);
            frame.revalidate();
            frame.repaint();
        });
        add(backButton, BorderLayout.SOUTH);
    }

}
