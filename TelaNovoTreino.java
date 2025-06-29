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

        // Painel principal
        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new BoxLayout(painelCampos, BoxLayout.Y_AXIS));
        painelCampos.setAlignmentX(Component.CENTER_ALIGNMENT);
        centro.add(painelCampos);

        // Dimensões padronizadas
        Dimension camposSize = new Dimension(400, 35);
        Dimension botaoSize = new Dimension(400, 50);

        // Criação do campo para escolher o título do treino
        JTextField campoTitulo = new JTextField();
        campoTitulo.setMaximumSize(camposSize);
        campoTitulo.setPreferredSize(camposSize);
        campoTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Criação do campo para escolher a dificuldade do treino
        String[] opcoes = { "Fácil", "Médio", "Difícil"};
        JComboBox<String> caixaSelecao = new JComboBox<>(opcoes);
        caixaSelecao.setMaximumSize(camposSize);
        caixaSelecao.setPreferredSize(camposSize);
        caixaSelecao.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Criação do botão "Prosseguir"
        JButton botaoProsseguir = new JButton("Prosseguir");
        botaoProsseguir.setMaximumSize(botaoSize);
        botaoProsseguir.setPreferredSize(botaoSize);
        botaoProsseguir.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Adiciona componentes ao painel
        painelCampos.add(new JLabel("Digite o título do treino: "));
        painelCampos.add(Box.createVerticalStrut(5));
        painelCampos.add(campoTitulo);
        painelCampos.add(Box.createVerticalStrut(10));
        painelCampos.add(new JLabel("Selecione a dificuldade do treino: "));
        painelCampos.add(Box.createVerticalStrut(5));
        painelCampos.add(caixaSelecao);
        painelCampos.add(Box.createVerticalStrut(20));
        painelCampos.add(botaoProsseguir);

        // Criação do painel para o botão "sair sem salvar"
        JPanel painelSair = new JPanel();
        painelSair.setLayout(new BoxLayout(painelSair, BoxLayout.Y_AXIS));
        painelSair.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(painelSair, BorderLayout.SOUTH);

        // Criação do botão "sair sem salvar"
        JButton botaoSair = new JButton("Sair sem salvar");
        botaoSair.setMaximumSize(botaoSize);
        botaoSair.setPreferredSize(botaoSize);
        botaoSair.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelSair.add(botaoSair);

        // Adiciona a função de cada um dos botões

        botaoProsseguir.addActionListener(e -> {

                // Coleta os dados de preenchimento
                String nome = campoTitulo.getText();
                int dificuldade = caixaSelecao.getSelectedIndex(); // 0 = Fácil, 1 = Médio, 2 = Difícil
                
                // Cria um novo treino com a dificuldade adequada
                Treino novoTreino;
                
                novoTreino = switch (dificuldade) {
                    case 0 -> new Treino(nome, EnumDificuldade.FACIL, professor);
                    case 1 -> new Treino(nome, EnumDificuldade.MEDIO, professor);
                    case 2 -> new Treino(nome, EnumDificuldade.DIFICIL, professor);
                    default -> new Treino(nome, EnumDificuldade.DESCONHECIDO, professor);
                };
                
                // Vai para a tela criadora de treinos
                frame.setContentPane(new TelaCriadorTreino(frame, telaProfessor, novoTreino, professor));
                frame.revalidate();
        });

        botaoSair.addActionListener(e -> {
            frame.setContentPane(telaProfessor);
            frame.revalidate();
        });
    }
}
