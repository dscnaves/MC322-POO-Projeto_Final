import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaEscolherTipo extends JPanel {

    public TelaEscolherTipo(Sistema sistema, JFrame frame, TelaProfessor telaProfessor, Treino treino, Professor professor){
        // O layout básico da tela de escolha é um título e dois botões com opções
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(30, 40, 30, 40));

        // Configurações do centro da página
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));

        // Centralizando verticalmente
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(Box.createVerticalGlue());
        container.add(centro);           
        container.add(Box.createVerticalGlue()); 
        add(container, BorderLayout.CENTER);

        // Criando e adicionando o título
        JLabel titulo = new JLabel("O exercício a adicionar será baseado em:");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        centro.add(titulo);
        centro.add(Box.createVerticalStrut(20));

        // Criando e adicionando botões
        Dimension botaoSize = new Dimension(400, 50);
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        centro.add(painelBotoes);

        // Criando os botões
        JButton botaoRepeticoes = criarBotao("Número de repetições", botaoSize);
        JButton botaoDuracao = criarBotao("Duração", botaoSize);

        painelBotoes.add(botaoRepeticoes);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(botaoDuracao);

        // Adiciona a função de cada um dos botões

        botaoRepeticoes.addActionListener(e -> {
            frame.setContentPane(new TelaCriadorExRepeticoes(sistema, frame, telaProfessor, treino, professor));
            frame.revalidate();
        });

        botaoDuracao.addActionListener(e -> {
            frame.setContentPane(new TelaCriadorExDuracao(sistema, frame, telaProfessor, treino, professor));
            frame.revalidate();
        });
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
