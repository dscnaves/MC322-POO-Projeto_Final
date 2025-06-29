import java.awt.*;
import javax.swing.*;

// Usamos JPanel para mudar entre "telas" 
public class TelaAluno extends JPanel {
    public TelaAluno(JFrame frame, TelaLogin telaLogin, Aluno aluno) { // Recebemos sempre por parametro a janela, aqui recebemos o aluno tambem
        
        // Configurações do layout
        setLayout(new BorderLayout());

        // Título de boas-vindas
        JLabel welcomeLabel = new JLabel("Bem-vindo, " + aluno.getNome() + "!", SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.NORTH);

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        // 4 linhas, 1 coluna, hgap	Espaço horizontal entre os componentes (10 pixels), vgap	Espaço vertical entre os componentes (10 pixels)
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10)); 

        // Botões de funcionalidade do aluno
        JButton visualizarTreinosButton = new JButton("Visualizar Treinos Recebidos");
        JButton registrarProgressoButton = new JButton("Registrar Progresso");
        JButton visualizarHistoricoButton = new JButton("Visualizar Histórico");
        JButton sairButton = new JButton("Sair");

        // Adiciona os botões ao painel de botões
        buttonPanel.add(visualizarTreinosButton);
        buttonPanel.add(registrarProgressoButton);
        buttonPanel.add(visualizarHistoricoButton);
        buttonPanel.add(sairButton);

        // Adiciona o painel de botões ao centro do layout principal
        add(buttonPanel, BorderLayout.CENTER);

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

        // Ação do botão de sair ao ser clicado
        sairButton.addActionListener(e -> {
            telaLogin.limparCampos();
            frame.setContentPane(telaLogin);
            frame.revalidate();
        });
    }
}