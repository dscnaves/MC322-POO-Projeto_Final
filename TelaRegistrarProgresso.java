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

        // Combobox com os treinos do aluno
        mainPanel.add(new JLabel("Selecione o treino:"));
        ArrayList<TreinoExecutavel> treinos = aluno.getProgresso();
        JComboBox<TreinoExecutavel> treinoComboBox = new JComboBox<>(treinos.toArray(new TreinoExecutavel[0]));
        mainPanel.add(treinoComboBox);

        // Slider de progresso
        mainPanel.add(new JLabel("Percentual de Conclusão (%):"));
        JSlider progressoSlider = new JSlider(0, 100, 0);
        progressoSlider.setMajorTickSpacing(25);
        progressoSlider.setMinorTickSpacing(5);
        progressoSlider.setPaintTicks(true);
        progressoSlider.setPaintLabels(true);
        mainPanel.add(progressoSlider);

        // Atualiza o slider quando um novo treino é selecionado
        treinoComboBox.addActionListener(e -> {
            TreinoExecutavel selecionado = (TreinoExecutavel) treinoComboBox.getSelectedItem();
            if (selecionado != null) {
                progressoSlider.setValue((int) selecionado.getPercentual());
            }
        });

        // Impede mover para trás
        progressoSlider.addChangeListener(e -> {
            TreinoExecutavel selecionado = (TreinoExecutavel) treinoComboBox.getSelectedItem();
            if (selecionado != null) {
                int atual = progressoSlider.getValue();
                int anterior = (int) selecionado.getPercentual();
                if (atual < anterior) {
                    progressoSlider.setValue(anterior); // trava
                }
            }
        });

        // Botão para registrar progresso
        JButton registrarButton = new JButton("Registrar Progresso");
        registrarButton.addActionListener(e -> {
            TreinoExecutavel selecionado = (TreinoExecutavel) treinoComboBox.getSelectedItem();
            if (selecionado != null) {
                int valorAtual = (int) selecionado.getPercentual();
                int novoValor = progressoSlider.getValue();

                if (novoValor > valorAtual) {
                    double incremento = novoValor - valorAtual;
                    selecionado.setPercentual(incremento); // Aumenta progresso do treino atual
                    sistema.salvarDados();
                    JOptionPane.showMessageDialog(frame, "Progresso de " + novoValor + "% registrado para o treino: " + selecionado.getTreino().getNome());
                } else {
                    JOptionPane.showMessageDialog(frame, "Você só pode aumentar o progresso.");
                }

                // Atualiza tela
                frame.setContentPane(telaAluno);
                frame.revalidate();
                frame.repaint();
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