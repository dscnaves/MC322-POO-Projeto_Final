import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaCriadorTreino extends JPanel {
    
    public TelaCriadorTreino(Sistema sistema, JFrame frame, TelaProfessor telaProfessor, Treino treino, Professor professor){

        // O layout básico da tela de criação de treino é um título, com uma lista de exercícios e dois botões
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(30, 40, 30, 40));

        // Configurações do centro da página
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        add(centro, BorderLayout.CENTER);

        // Texto fixo no topo
        JLabel titulo = new JLabel("Treino: " + treino.getNome());
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setFont(new Font("Arial", Font.BOLD,  18));
        centro.add(titulo);
        centro.add(Box.createVerticalStrut(20));

        // Dimensões padronizadas
        Dimension botaoSize = new Dimension(400, 50);

        // Painel principal
        JPanel lista = new JPanel();
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));

        JScrollPane scroll = new JScrollPane(lista);
        scroll.setAlignmentX(Component.CENTER_ALIGNMENT);
        centro.add(scroll);

        // Imprime todos os exercícios já adicionados na lista
        ArrayList<Exercicio> exercicios = treino.getArrayExercicios();
        if (exercicios.isEmpty()){
            lista.add(new JLabel("Ainda não foram adicionados exercícios ao treino"));
        }
        for (Exercicio ex : treino.getArrayExercicios()) {
            String desc = ex.descreverExercicio()
                            .replace("\n", "<br>");          // quebra de linha
            JLabel texto = new JLabel("<html>" + desc + "</html>");
            texto.setAlignmentX(Component.LEFT_ALIGNMENT);
            lista.add(texto);
            lista.add(Box.createVerticalStrut(10));
        }

        // Criação do painel para os botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(painelBotoes, BorderLayout.SOUTH);

        // Criação dos botões
        JButton botaoNovoExercicio = criarBotao(botaoSize, "Adicionar exercício");
        JButton botaoFinalizar = criarBotao(botaoSize, "Finalizar treino");

        // Adicionando botões no painel
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(botaoNovoExercicio);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(botaoFinalizar);

        // Adiciona a função de cada um dos botões

        // Abre uma tela que permite criar um novo exercício
        botaoNovoExercicio.addActionListener(e -> {
            frame.setContentPane(new TelaEscolherTipo(sistema, frame, telaProfessor, treino, professor));
            frame.revalidate();
        });

        // Encerra e salva o treino
        botaoFinalizar.addActionListener(e -> {
            // Salva o treino no ArrayList do professor
            professor.adicionarTreino(treino);

            // Vamos salvar no arquivo .dat o que o usuario acabou de tentar registrar (sem isso só salvamos no array e ao encerrar o programa desaparecera))
            sistema.salvarDados();

            // Volta para a tela inicial do professor
            frame.setContentPane(telaProfessor);
            frame.revalidate();
        });
    
    }

    // Cria um botão com as dimensões desejadas
    public static JButton criarBotao(Dimension botaoSize, String texto){
        JButton botao = new JButton(texto);
        botao.setMaximumSize(botaoSize);
        botao.setPreferredSize(botaoSize);
        botao.setAlignmentX(Component.LEFT_ALIGNMENT);
        return botao;
    }
}
