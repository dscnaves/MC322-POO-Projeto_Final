import javax.swing.*;
import java.awt.*;

// Usamos JPanel para mudar entre "telas" 
public class TelaAluno extends JPanel {
    public TelaAluno(JFrame frame, Aluno aluno) { // Recebemos sempre por parametro a janela, aqui recebemos o aluno tambem
        
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
            frame.setContentPane(new TelaVisualizarTreinos(frame, aluno));
            frame.revalidate();
            frame.repaint();
        });

        registrarProgressoButton.addActionListener(e -> {
            frame.setContentPane(new TelaRegistrarProgresso(frame, aluno));
            frame.revalidate();
            frame.repaint();
        });

        visualizarHistoricoButton.addActionListener(e -> {
            frame.setContentPane(new TelaVisualizarHistorico(frame, aluno));
            frame.revalidate();
            frame.repaint();
        });

        // Ação do botão de sair ao ser clicado
        sairButton.addActionListener(e -> {
            // Recupera o Sistema armazenado como propriedade do frame
            Sistema sistema = (Sistema) frame.getRootPane().getClientProperty("sistema");
            // Substitui o conteúdo principal (JPanel) da janela (JFrame) pela tela de login novamente
            frame.setContentPane(new TelaLogin(frame, sistema));
            // Recalcular o layout de todos os componentes no novo painel
            frame.revalidate();
            // Atualiza a janela para refletir a mudança
            frame.repaint();
        });
    }
}