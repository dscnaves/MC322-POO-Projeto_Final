import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class TelaRecados extends JPanel {

    public TelaRecados(Sistema sistema, JFrame frame, JPanel telaAnterior, Usuario usuarioAtual, Usuario destinatario) {
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(20, 20, 20, 20));

        // Título da tela
        JLabel tituloLabel = new JLabel("Recados para " + destinatario.getNome(), SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(tituloLabel, BorderLayout.NORTH);

        // Painel para exibir as mensagens
        JPanel mensagensPanel = new JPanel();
        mensagensPanel.setLayout(new BoxLayout(mensagensPanel, BoxLayout.Y_AXIS));
        
        // Use um JScrollPane para a área de mensagens
        JScrollPane scrollPane = new JScrollPane(mensagensPanel);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Conversa"));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Garante a barra de rolagem
        add(scrollPane, BorderLayout.CENTER);
        
        // Exibe todas as mensagens do usuário atual
        ArrayList<Comentario> mensagens = usuarioAtual.getMensagens();
        if (mensagens.isEmpty()) {
            mensagensPanel.add(new JLabel("Nenhuma mensagem enviada ou recebida."));
        } else {
            for (Comentario comentario : mensagens) {
                // Formatação melhor para cada comentário
                JPanel comentarioPanel = new JPanel(new BorderLayout());
                JLabel autorLabel = new JLabel("De: " + comentario.getAutor().getNome() + " em " + comentario.getData());
                JTextArea textoArea = new JTextArea(comentario.getTexto());
                textoArea.setEditable(false);
                textoArea.setLineWrap(true);
                textoArea.setWrapStyleWord(true);
                textoArea.setBackground(getBackground()); // Cor de fundo transparente
                
                comentarioPanel.setBorder(BorderFactory.createEtchedBorder());
                comentarioPanel.add(autorLabel, BorderLayout.NORTH);
                comentarioPanel.add(textoArea, BorderLayout.CENTER);
                
                mensagensPanel.add(comentarioPanel);
                mensagensPanel.add(Box.createVerticalStrut(10)); // Espaçamento entre mensagens
            }
        }
        
        // Zera a contagem de novos recados ao abrir a tela
        usuarioAtual.zerarNovosRecados();
        // Salva os dados para que a mudança seja persistida
        sistema.salvarDados();

        // Painel para escrever nova mensagem
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        JTextArea campoMensagem = new JTextArea(3, 20);
        campoMensagem.setBorder(BorderFactory.createTitledBorder("Escrever nova mensagem"));
        JScrollPane mensagemScrollPane = new JScrollPane(campoMensagem);

        JButton enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(e -> {
            String texto = campoMensagem.getText().trim();
            if (!texto.isEmpty()) {
                // 1. Cria um novo comentário com o usuário atual como autor
                Comentario novoRecado = new Comentario(usuarioAtual, texto);

                // 2. Adiciona o comentário ao arraylist de mensagens do destinatário
                destinatario.adicionarMensagem(novoRecado);
                
                // 3. Adiciona o comentário ao arraylist de mensagens do remetente para ter histórico da conversa
                usuarioAtual.adicionarMensagem(novoRecado);

                // 4. Aumenta a variável de contagem de recados novos do destinatário
                destinatario.incrementarNovosRecados();

                // 5. Salva os dados para que as mensagens não sejam perdidas
                sistema.salvarDados();
                
                // 6. Atualiza a interface gráfica para mostrar a nova mensagem
                JOptionPane.showMessageDialog(frame, "Mensagem enviada com sucesso!");
                
                // Recarrega a tela para mostrar a nova mensagem
                // Usamos a tela atual como tela anterior para voltar
                frame.setContentPane(new TelaRecados(sistema, frame, telaAnterior, usuarioAtual, destinatario));
                frame.revalidate();
                frame.repaint();
            } else {
                JOptionPane.showMessageDialog(frame, "A mensagem não pode ser vazia.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Adiciona os componentes de entrada no painel de entrada
        inputPanel.add(mensagemScrollPane, BorderLayout.CENTER);
        inputPanel.add(enviarButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        // Botão de voltar
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> {
            frame.setContentPane(telaAnterior);
            frame.revalidate();
            frame.repaint();
        });
        
        // Crie um painel para o botão de voltar para que ele não sobreponha a área de entrada
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(inputPanel, BorderLayout.CENTER);
        southPanel.add(backButton, BorderLayout.SOUTH);
        add(southPanel, BorderLayout.SOUTH);

    }
}