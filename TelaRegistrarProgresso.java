import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class TelaRegistrarProgresso extends JPanel {
    public TelaRegistrarProgresso(Sistema sistema, JFrame frame, TelaAluno telaAluno, Aluno aluno) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel tituloLabel = new JLabel("Registrar Progresso de Treino", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(tituloLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        // Selecionar o treino
        mainPanel.add(new JLabel("Selecione o treino:"));
        ArrayList<TreinoExecutavel> treinos = aluno.getProgresso();
        JComboBox<TreinoExecutavel> treinoComboBox = new JComboBox<>(treinos.toArray(new TreinoExecutavel[0]));
        mainPanel.add(treinoComboBox);

        // Campo para inserir o progresso (ex: percentual)
        mainPanel.add(new JLabel("Percentual de Conclusão (%):"));
        JSlider progressoSlider = new JSlider(0, 100, 0);
        progressoSlider.setMajorTickSpacing(25);
        progressoSlider.setMinorTickSpacing(5);
        progressoSlider.setPaintTicks(true);
        progressoSlider.setPaintLabels(true);
        mainPanel.add(progressoSlider);

        // Atualiza o valor da barra ao trocar de treino no combo
        treinoComboBox.addActionListener(e -> {
            TreinoExecutavel selecionado = (TreinoExecutavel) treinoComboBox.getSelectedItem();
            if (selecionado != null) {
                progressoSlider.setValue((int) selecionado.getPercentual());
            }
        });

        // Inicializa com o valor do primeiro treino (se houver)
        if (!treinos.isEmpty()) {
            progressoSlider.setValue((int) treinos.get(0).getPercentual());
        }

        // Botão para registrar
        JButton registrarButton = new JButton("Registrar Progresso");
        registrarButton.addActionListener(e -> {
            TreinoExecutavel treinoSelecionado = (TreinoExecutavel) treinoComboBox.getSelectedItem();
            if (treinoSelecionado != null) {
                double percentual = progressoSlider.getValue();
                aluno.registrarProgresso(treinoSelecionado, percentual);

                JOptionPane.showMessageDialog(frame, "Progresso de " + percentual + "% registrado para o treino: " + treinoSelecionado.getTreino().getNome());
                sistema.salvarDados();
                // Você pode voltar para a tela anterior após o registro, se quiser
                frame.setContentPane(telaAluno);
                frame.revalidate();
                frame.repaint();
            } else {
                JOptionPane.showMessageDialog(frame, "Selecione um treino para registrar o progresso.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        mainPanel.add(registrarButton);
        
        add(mainPanel, BorderLayout.CENTER);

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