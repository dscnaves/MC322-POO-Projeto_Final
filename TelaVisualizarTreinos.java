import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Classe para a tela de visualização de treinos recebidos pelo aluno
public class TelaVisualizarTreinos extends JPanel {
    public TelaVisualizarTreinos(JFrame frame, Aluno aluno) {

        // Layout para organizar os componentes
        setLayout(new BorderLayout(10, 10));
        // Adiciona uma margem em volta do painel
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Criar o 1° título da tela
        JLabel tituloLabel = new JLabel("Meus Treinos Recebidos", SwingConstants.CENTER);
        // Formatação do 1° título da página
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(tituloLabel, BorderLayout.NORTH);

        // Painel para exibir os treinos
        JPanel treinosPanel = new JPanel();
        // Usamos BoxLayout para empilhar os treinos verticalmente
        treinosPanel.setLayout(new BoxLayout(treinosPanel, BoxLayout.Y_AXIS));
        // Adiciona uma barra de rolagem para o painel de treinos
        JScrollPane scrollPane = new JScrollPane(treinosPanel);
        // Adiciona uma borda ao painel de rolagem
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Treinos"));
        add(scrollPane, BorderLayout.CENTER);

        // Supondo que a classe Aluno tenha um método getTreinosRecebidos()
        // que retorna uma lista de objetos Treino.
        ArrayList<Treino> treinos = aluno.getTreinosRecebidos();

        // Verifica se a lista de treinos está vazia
        if (treinos.isEmpty()) {
            treinosPanel.add(new JLabel("Você não possui treinos recebidos."));
        } else {
            for (Treino treino : treinos) {

                // Aqui criamos um painel para cada treino
                JPanel treinoItemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                //
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
            frame.setContentPane(new TelaAluno(frame, aluno));
            frame.revalidate();
            frame.repaint();
        });
        add(backButton, BorderLayout.SOUTH);
    }
}