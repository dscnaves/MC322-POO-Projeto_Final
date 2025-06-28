import java.awt.*;
import javax.swing.*;

public class TelaInicialProfessor extends JFrame {

    private static final String TELA_INICIAL_PROF = "telaInicialProfessor";
    private static final String TELA_TRES    = "three";
    private static final String TELA_DOIS    = "two";

    private final JPanel cards; // baralho de telas

    public TelaInicialProfessor(String nome){
        super("Menu inicial do professor");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Sistema criado com base no cards layout (uma janela abre outras cartas dentro delas mesmas)
        cards = new JPanel(new CardLayout());

        // Tela inicial do professor
        cards.add(criarTelaInicial(nome), TELA_INICIAL_PROF);

        // 2. Painel com 3 botões
        cards.add(new ThreeButtonsPanel(() -> mostrar(TELA_INICIAL_PROF)), TELA_TRES);

        // 3. Painel com 2 botões
        cards.add(new TwoButtonsPanel(() -> mostrar(TELA_INICIAL_PROF)), TELA_DOIS);

        getContentPane().add(cards);
        pack();
        setLocationRelativeTo(null);   // centraliza
    }

    // Tela inicial do professor
    private JPanel criarTelaInicial(String nome){
        JPanel painel1 = new JPanel(new FlowLayout());

        // texto fixo no topo
        JLabel titulo = new JLabel(("Seja bem vindo " + nome), JLabel.LEFT);
        add(titulo, BorderLayout.NORTH);

        // Criando botões da tela inicial
        JButton abreNovoTreino = new JButton("Criar novo treino");
        JButton abreVisualizarTreinos = new JButton("Visualizar treinos criados");
        JButton abreIndicarPara = new JButton("Indicar treino para um aluno");
        JButton abreVisualizarAlunos = new JButton("Visualizar alunos");
        JButton abreVisualizarRecados = new JButton("Visualizar recados");

        // Adiciona a função de cada um dos botões
        abreNovoTreino.addActionListener(e -> mostrar(TELA_TRES));
        abreVisualizarTreinos.addActionListener(e -> mostrar(TELA_DOIS));
        abreIndicarPara.addActionListener(e -> System.out.println("clicado indicar para"));
        abreVisualizarAlunos.addActionListener(e -> System.out.println("clicado visualizar alunos"));
        abreVisualizarRecados.addActionListener(e -> System.out.println("clicado visualizar recados"));

        // Adiciona os botões no painel
        painel1.add(abreNovoTreino);
        painel1.add(abreVisualizarTreinos);
        painel1.add(abreIndicarPara);
        painel1.add(abreVisualizarAlunos);
        painel1.add(abreVisualizarRecados);
        return painel1;
    }

    /** Mostra o cartão escolhido. */
    private void mostrar(String nome) {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, nome);
        pack();              // ajusta o tamanho se necessário
    }

    public static void main(String[] args) {
        Professor usuario = new Professor("teste_nome", "teste_username", "1234");
        String nome = usuario.getNome();

        SwingUtilities.invokeLater(() -> new TelaInicialProfessor(nome).setVisible(true));
    }
}