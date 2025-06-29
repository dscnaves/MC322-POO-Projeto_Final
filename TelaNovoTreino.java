import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaNovoTreino extends JPanel {

    public TelaNovoTreino(JFrame frame, TelaProfessor telaProfessor, Professor professor) {

        // O layout básico da tela de criação de treino é um título, com dois campos de preenchimento e dois botões
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(30, 40, 30, 40));

        // Configurações do centro da página
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        add(centro, BorderLayout.CENTER);

        // Texto fixo no topo
        JLabel titulo = new JLabel("Novo Treino");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setFont(new Font("Arial", Font.BOLD,  18));
        centro.add(titulo);
        centro.add(Box.createVerticalStrut(20));

        // Campos de preenchimento
        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new BoxLayout(painelCampos, BoxLayout.Y_AXIS));
        painelCampos.setAlignmentX(Component.CENTER_ALIGNMENT);
        centro.add(painelCampos);

        // Preencher título
        JTextField campoTitulo = new JTextField();
        add(new JLabel("Digite o título do treino: "));
        add(campoTitulo);

        // Selecionar dificuldade
        String[] opcoes = { "Fácil", "Médio", "Difícil"};
        JComboBox<String> caixaSelecao = new JComboBox<>(opcoes);

        add(new JLabel("Selecione a dificuldade do treino: "));
        add(caixaSelecao);

        // Configurações dos botões
        JPanel painelBotoes = new JPanel();
        Dimension botaoSize = new Dimension(400, 50);
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        centro.add(painelBotoes);

        // Criando botões 
        JButton botaoProsseguir = criarBotao("Prosseguir", botaoSize);
        JButton botaoSair = criarBotao("Sair sem salvar", botaoSize);

        // Adiciona os botões no painel
        painelBotoes.add(botaoProsseguir);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(botaoSair);

        // Adiciona a função de cada um dos botões

        botaoProsseguir.addActionListener(e -> {

            // Coleta os dados de preenchimento
            String nome = campoTitulo.getText(); 
            int dificuldade = caixaSelecao.getSelectedIndex(); // 0 = Fácil, 1 = Médio, 2 = Difícil

            // Cria um novo treino com a dificuldade adequada
            Treino novoTreino;

            if (dificuldade == 0){
                novoTreino = new Treino(nome, EnumDificuldade.FACIL, professor);
            } else if (dificuldade == 1){
                novoTreino = new Treino(nome, EnumDificuldade.MEDIO, professor);
            } else { // dificuldade == 2
                novoTreino = new Treino(nome, EnumDificuldade.DIFICIL, professor);
            }

            // Vai para a tela criadora de treinos
            frame.setContentPane(new TelaCriadorTreino(frame, telaProfessor, novoTreino, professor));
            frame.revalidate();
        });

        botaoSair.addActionListener(e -> {
            frame.setContentPane(telaProfessor);
            frame.revalidate();
        });
    }

    // Cria um botão na formatação desejada
    private static JButton criarBotao(String texto, Dimension size){
        JButton botao = new JButton(texto);
        botao.setMaximumSize(size);
        botao.setPreferredSize(size);
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
        return botao;
    }
}
