import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// Usamos JPanel para mudar entre "telas" 
public class TelaAluno extends JPanel {
    public TelaAluno(Sistema sistema, JFrame frame, TelaLogin telaLogin, Aluno aluno) { // Recebemos sempre por parametro a janela, aqui recebemos o aluno tambem
        // gente mudei o layout para ficar padronizado com o do professor
        // O layout básico da tela do aluno é feito em uma coluna com vários botões e uma margem 
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(30, 40, 30, 40));

        // Configurações do centro da página
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        add(centro, BorderLayout.CENTER);

        // Texto fixo no topo
        JLabel textoBoasVindas = new JLabel("Seja bem-vindo(a), " + aluno.getNome() + "!");
        JLabel textoRecados = new JLabel("Você tem " + aluno.getNovosRecados() + " recados novos");

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
        JButton visualizarTreinosButton = criarBotao("Visualizar treinos", botaoSize);
        JButton registrarProgressoButton = criarBotao("Registrar progresso", botaoSize);
        JButton visualizarHistoricoButton = criarBotao("Visualizar histórico", botaoSize);
        JButton adicionarProfButton =  criarBotao("Adicionar Professor", botaoSize);
        JButton sairButton = criarBotao("Sair", botaoSize);
   
        // Adiciona os botões no painel
        painelBotoes.add(visualizarTreinosButton);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(registrarProgressoButton);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(visualizarHistoricoButton);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(adicionarProfButton);
        painelBotoes.add(Box.createVerticalStrut(10));
        painelBotoes.add(sairButton);
        painelBotoes.add(Box.createVerticalStrut(10));

        // Ações dos botões
        visualizarTreinosButton.addActionListener(e -> {
            frame.setContentPane(new TelaVisualizarTreinos(frame, this, aluno));
            frame.revalidate();
            frame.repaint();
        });

        registrarProgressoButton.addActionListener(e -> {
            frame.setContentPane(new TelaRegistrarProgresso(frame, this, aluno));
            frame.revalidate();
            frame.repaint();
        });

        visualizarHistoricoButton.addActionListener(e -> {
            frame.setContentPane(new TelaVisualizarHistorico(frame, this, aluno));
            frame.revalidate();
            frame.repaint();
        });

        adicionarProfButton.addActionListener(e -> {
            frame.setContentPane(new TelaAdicionarProf(sistema, frame, this, aluno));
            frame.revalidate();
            frame.repaint();
        });

        // Ação do botão de sair ao ser clicado
        sairButton.addActionListener(e -> {
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