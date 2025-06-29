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

        // Configurações e adição dos botões
        JButton visualizarTreinosButton = criarBotao("Visualizar Treinos Recebidos", botaoSize);
        JButton registrarProgressoButton = criarBotao("Registrar Progresso", botaoSize);
        JButton visualizarHistoricoButton = criarBotao("Visualizar Histórico", botaoSize);
        JButton adicionarProfButton = criarBotao("Adicionar Professor", botaoSize);
        JButton enviarRecadoButton = criarBotao("Enviar/Ver Recados", botaoSize);
        JButton sairButton = criarBotao("Sair", botaoSize);

        centro.add(visualizarTreinosButton);
        centro.add(Box.createVerticalStrut(10));
        centro.add(registrarProgressoButton);
        centro.add(Box.createVerticalStrut(10));
        centro.add(visualizarHistoricoButton);
        centro.add(Box.createVerticalStrut(10));
        centro.add(adicionarProfButton);
        centro.add(Box.createVerticalStrut(10));
        centro.add(enviarRecadoButton);
        centro.add(Box.createVerticalStrut(10));
        centro.add(sairButton);
        centro.add(Box.createVerticalStrut(10));

        // Ações dos botões
        visualizarTreinosButton.addActionListener(e -> {
            // A ser implementado em outra tela
            JOptionPane.showMessageDialog(frame, "Funcionalidade a ser implementada.");
        });

        registrarProgressoButton.addActionListener(e -> {
            // A ser implementado em outra tela
            JOptionPane.showMessageDialog(frame, "Funcionalidade a ser implementada.");
        });

        visualizarHistoricoButton.addActionListener(e -> {
            // A ser implementado em outra tela
            JOptionPane.showMessageDialog(frame, "Funcionalidade a ser implementada.");
        });

        adicionarProfButton.addActionListener(e -> {
            // A ser implementado em outra tela
            JOptionPane.showMessageDialog(frame, "Funcionalidade a ser implementada.");
        });
        
        enviarRecadoButton.addActionListener(e -> {
            // Seleciona um professor para enviar o recado
            Professor[] professores = aluno.getProfessores().toArray(new Professor[0]);
            if (professores.length == 0) {
                JOptionPane.showMessageDialog(frame, "Você não adicionou nenhum professor ainda.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Professor professorSelecionado = (Professor) JOptionPane.showInputDialog(
                frame,
                "Selecione o professor para enviar o recado:",
                "Enviar Recado",
                JOptionPane.QUESTION_MESSAGE,
                null,
                professores,
                professores[0]
            );

            if (professorSelecionado != null) {
                frame.setContentPane(new TelaRecados(sistema, frame, this, aluno, professorSelecionado));
                frame.revalidate();
                frame.repaint();
            }
        });

        // Ação do botão de sair ao ser clicado
        sairButton.addActionListener(e -> {
            telaLogin.limparCampos();
            frame.setContentPane(telaLogin);
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