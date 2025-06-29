import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// Tela mostrada quando um usuário que é um professor faz login
public class TelaProfessor extends JPanel {

    public TelaProfessor(Sistema sistema, JFrame frame, TelaLogin telaLogin, Professor professor) {
        // O layout básico da tela do professor é feito em uma coluna com vários botões e uma margem 
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(30, 40, 30, 40));

        // Configurações do centro da página
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        add(centro, BorderLayout.CENTER);

        // Texto fixo no topo
        JLabel textoBoasVindas = new JLabel("Seja bem-vindo(a), " + professor.getNome() + "!");
        JLabel textoRecados = new JLabel("Você tem " + professor.getNovosRecados() + " recados novos");

        // Alinhamento do texto
        textoBoasVindas.setAlignmentX(Component.CENTER_ALIGNMENT);
        textoRecados.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionando o texto
        centro.add(textoBoasVindas);
        centro.add(textoRecados);
        centro.add(Box.createVerticalStrut(20));
        Dimension botaoSize = new Dimension(400, 50);

        // Configurações dos botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        centro.add(painelBotoes);

        // Criando botões da tela inicial do professor
        JButton botaoNovoTreino = criarBotao("Criar novo treino", botaoSize);
        JButton botaoVerTreinos = criarBotao("Visualizar treinos criados", botaoSize);
        JButton botaoIndicarAluno = criarBotao("Indicar treino para um aluno", botaoSize);
        JButton botaoVerAlunos = criarBotao("Visualizar alunos", botaoSize);
        JButton botaoVerRecados = criarBotao("Visualizar recados", botaoSize);
        JButton botaoSair = criarBotao("Sair", botaoSize);

        // Adiciona os botões no painel
        painelBotoes.add(botaoNovoTreino);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(botaoVerTreinos);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(botaoIndicarAluno);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(botaoVerAlunos);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(botaoVerRecados);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(botaoSair);

        // Adiciona a função de cada um dos botões

        botaoNovoTreino.addActionListener(e -> {
            frame.setContentPane(new TelaNovoTreino(sistema, frame, this, professor));
            frame.revalidate();
        });

        botaoVerTreinos.addActionListener(e -> {
            frame.setContentPane(new TelaTreinosCriados(frame, this, professor));
            frame.revalidate();
        });
        /* 

        botaoIndicarAluno.addActionListener(e -> {
            frame.setContentPane(new TelaIndicarParaAluno(frame, professor));
            frame.revalidate();
        });
        */

        botaoVerAlunos.addActionListener(e -> {
            frame.setContentPane(new TelaVisualizarAlunos(frame, professor, this));
            frame.revalidate();
        });

        /* 
        botaoVerRecados.addActionListener(e -> {
            frame.setContentPane(new TelaRecados(frame, professor));
            frame.revalidate();
        });*/

        botaoSair.addActionListener(e -> {
            telaLogin.limparCampos();
            frame.setContentPane(telaLogin);
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