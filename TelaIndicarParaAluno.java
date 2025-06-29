import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaIndicarParaAluno extends JPanel {

    private JFrame frame;

    public TelaIndicarParaAluno(JFrame frame, TelaProfessor telaProfessor, Professor professor){
        frame = this.frame;
        // O layout básico da tela de criação de indicação de treinos é uma caixa de seleção de alunos e uma caixa de selção de treinos
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(30, 40, 30, 40));

        // Configurações do centro da página
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        add(centro, BorderLayout.CENTER);

        // Texto fixo no topo
        JLabel titulo = new JLabel("Indicar treino");
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

        // Criação do campo de escolha dos treinos
        ArrayList<Treino> treinos = professor.getTreinosCriados();
        JComboBox<Treino> selecaoTreino = new JComboBox<>();
        for (Treino t : treinos){
            selecaoTreino.addItem(t);
        }
        selecaoTreino.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Treino t) {
                setText(t.getNome()); // exibe apenas o nome
            }
            return this; 
                }
        });

        // Criação do campo escolha de alunos
        ArrayList<Aluno> alunos = professor.getAlunos();
        JComboBox<Aluno> selecaoAluno = new JComboBox<>();
        for (Aluno a : alunos){
            selecaoAluno.addItem(a);
        }
        selecaoAluno.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Aluno a) {
                setText(a.getNome()); // exibe apenas o nome
            }
            return this; 
                }
        });

        // Adiciona componentes ao painel
        painelCampos.add(new JLabel("Escolha o treino a ser indicado: "));
        painelCampos.add(Box.createVerticalStrut(5));
        painelCampos.add(selecaoTreino);
        painelCampos.add(Box.createVerticalStrut(10));
        painelCampos.add(new JLabel("Escolha o aluno para o qual irá indicar esse treino: "));
        painelCampos.add(Box.createVerticalStrut(5));
        painelCampos.add(selecaoAluno);

        // Criação do painel para os botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(painelBotoes, BorderLayout.SOUTH);

        // Criação do botão "confirmar"
        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.setMaximumSize(botaoSize);
        botaoConfirmar.setPreferredSize(botaoSize);
        botaoConfirmar.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelBotoes.add(botaoConfirmar);
        painelBotoes.add(Box.createVerticalStrut(10));

        // Criação do botão "sair sem salvar"
        JButton botaoSair = new JButton("Sair sem salvar");
        botaoSair.setMaximumSize(botaoSize);
        botaoSair.setPreferredSize(botaoSize);
        botaoSair.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelBotoes.add(botaoSair);

        // Adiciona a função de cada um dos botões

        // Indica o treino escolhido para o aluno escolhido
        botaoConfirmar.addActionListener(e -> {

            Aluno alunoEscolhido = (Aluno) selecaoAluno.getSelectedItem();
            Treino treinoEscolhido = (Treino) selecaoTreino.getSelectedItem();

            TreinoExecutavel treinoIndicado = new TreinoExecutavel(treinoEscolhido, professor);

            alunoEscolhido.
                
            // Vai para a tela inicial do professor
            // Dani: Não sei pq mas só consegui resolver o problema desse arquivo colocando this. na frente do frame
            frame.setContentPane(telaProfessor);
            frame.revalidate();
            frame.repaint();
        });
    }
}
