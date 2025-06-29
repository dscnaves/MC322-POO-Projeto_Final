import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class TelaAdicionarProf extends JPanel{
    public TelaAdicionarProf(Sistema sistema, JFrame frame, TelaAluno telaAluno, Aluno aluno){
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel tituloLabel = new JLabel("Adicionar professor", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(tituloLabel, BorderLayout.NORTH);

        JPanel professoresPanel = new JPanel();
        professoresPanel.setLayout(new BoxLayout(professoresPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(professoresPanel);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Selecione um professor"));
        add(scrollPane, BorderLayout.CENTER);

        // Supondo que a classe Aluno tenha um método getProgresso()
        ArrayList<Professor> professores = sistema.getArrayProfessores();

        if (professores.isEmpty()) {
            professoresPanel.add(new JLabel("Não há nenhum professor."));
        } else {
            Dimension botaoSize = new Dimension(400, 50);
            for (Professor i : professores) {
                Professor prof = i;

                // Verifica se o professor já foi adicionado pelo aluno
                if (!aluno.getProfessores().contains(prof)) {
                    JButton professoresCadastrados = criarBotao(prof.getNome(), botaoSize);

                    professoresCadastrados.addActionListener(e -> {
                        aluno.addProf(prof);
                        prof.addAluno(aluno);
                        sistema.salvarDados(); // Estamos guardando no arquivo .dat as alteracoes, ou seja, guardamos o prof que o aluno adicionou no array de profs e salvamos esse aluno que esta no array de alunos do prof
                        JOptionPane.showMessageDialog(frame, "Professor " + prof.getNome() + " adicionado com sucesso!");

                        // Atualiza a tela para esconder o botão depois da adição
                        frame.setContentPane(new TelaAdicionarProf(sistema, frame, telaAluno, aluno));
                        frame.revalidate();
                        frame.repaint();
                    });

                    professoresPanel.add(professoresCadastrados);
                }
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

     //Cria um botão na formatação desejada
    private static JButton criarBotao(String texto, Dimension size){
        JButton botao = new JButton(texto);
        botao.setMaximumSize(size);
        botao.setPreferredSize(size);
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
        return botao;
    }
}
