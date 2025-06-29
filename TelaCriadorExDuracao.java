import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaCriadorExDuracao extends JPanel {
    
    public TelaCriadorExDuracao(JFrame frame, TelaProfessor telaProfessor, Treino treino, Professor professor){
    
        // O layout básico da tela de criação de exercício é um título, com campos de preenchimento e um botão
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(30, 40, 30, 40));

        // Configurações do centro da página
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        add(centro, BorderLayout.CENTER);

        // Texto fixo no topo
        JLabel titulo = new JLabel("Novo Exercicio");
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

        // Criação dos campos de preenchimento
        JTextField campoNome = criarCampo(camposSize);
        JTextField campoSeries = criarCampo(camposSize);
        JTextField campoDuracao = criarCampo(camposSize);
        JTextField campoIntervalo = criarCampo(camposSize);

        // Criação dos campos de escolha
        JComboBox<String> selecao1 = criarCaixaSelecao(camposSize);
        JComboBox<String> selecao2 = criarCaixaSelecao(camposSize);

        // Adiciona componentes ao painel
        painelCampos.add(new JLabel("Digite o nome do exercício: "));
        painelCampos.add(Box.createVerticalStrut(5));
        painelCampos.add(campoNome);
        painelCampos.add(Box.createVerticalStrut(10));
        painelCampos.add(new JLabel("Digite o tempo de atividade do exercício:"));
        painelCampos.add(Box.createVerticalStrut(5));
        painelCampos.add(campoDuracao);
        painelCampos.add(Box.createVerticalStrut(5));
        painelCampos.add(selecao1);
        painelCampos.add(Box.createVerticalStrut(10));
        painelCampos.add(new JLabel("Digite o número de séries: "));
        painelCampos.add(Box.createVerticalStrut(5));
        painelCampos.add(campoSeries);
        painelCampos.add(Box.createVerticalStrut(10));
        painelCampos.add(new JLabel("Digite o tempo de intervalo entre cada série:"));
        painelCampos.add(Box.createVerticalStrut(5));
        painelCampos.add(campoIntervalo);
        painelCampos.add(Box.createVerticalStrut(5));
        painelCampos.add(selecao2);

        // Criação do painel para o botão "adicionar exercício"
        JPanel painelAdicionar = new JPanel();
        painelAdicionar.setLayout(new BoxLayout(painelAdicionar, BoxLayout.Y_AXIS));
        painelAdicionar.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(painelAdicionar, BorderLayout.SOUTH);

        // Criação do botão "adicionar exercicio"
        JButton botaoAdicionar = new JButton("Adicionar exercício");
        botaoAdicionar.setMaximumSize(botaoSize);
        botaoAdicionar.setPreferredSize(botaoSize);
        botaoAdicionar.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelAdicionar.add(botaoAdicionar);

        // Adiciona a função de cada um dos botões

        // Cria um novo exercicio
        botaoAdicionar.addActionListener(e -> {
                ExercicioDuracao exercicio;

                // Coleta os dados de preenchimento
                String nome = campoNome.getText();
                int numDuracao = Integer.parseInt(campoDuracao.getText());
                int medDuracao = selecao1.getSelectedIndex();

                Tempo duracao;
                if (medDuracao == 0){
                    duracao = new Tempo(numDuracao, EnumTempo.segundos);
                } else {
                    duracao = new Tempo(numDuracao, EnumTempo.minutos);
                }

                int series = Integer.parseInt(campoSeries.getText());
                int numIntervalo = Integer.parseInt(campoIntervalo.getText());
                int medIntervalo = selecao2.getSelectedIndex();

                Tempo intervalo;
                if (medIntervalo == 0){
                    intervalo = new Tempo(numIntervalo, EnumTempo.segundos);
                } else {
                    intervalo = new Tempo(numIntervalo, EnumTempo.minutos);
                }
                
                // Cria um novo exercicio
                ExercicioDuracao ex = new ExercicioDuracao(nome, series, intervalo, duracao);
                treino.adicionarExercicio(ex);
                
                // Vai para a tela criadora de treinos
                frame.setContentPane(new TelaCriadorTreino(frame, telaProfessor, treino, professor));
                frame.revalidate();
        });
    }

    public JTextField criarCampo(Dimension dimensao){
        JTextField campo = new JTextField();
        campo.setMaximumSize(dimensao);
        campo.setPreferredSize(dimensao);
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        return campo;
    }

    public JComboBox<String> criarCaixaSelecao(Dimension dimensao){
        String[] opcoes = {"segundos", "minutos"};
        JComboBox<String> caixaSelecao = new JComboBox<>(opcoes);
        caixaSelecao.setMaximumSize(dimensao);
        caixaSelecao.setPreferredSize(dimensao);
        caixaSelecao.setAlignmentX(Component.LEFT_ALIGNMENT);
        return caixaSelecao;
    }
}
