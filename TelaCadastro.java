import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

// Usamos JPanel para mudar entre "telas" 
public class TelaCadastro extends JPanel {
    private JTextField campoNome;
    private JTextField campoUserName;
    private JPasswordField campoSenha;

    public TelaCadastro(JFrame frame, Sistema sistema, TelaLogin telaLogin) {
        setLayout(new GridLayout(0,1));
        setBorder(new EmptyBorder(30, 40, 30, 40));
        
        campoNome = new JTextField();
        campoUserName = new JTextField();
        campoSenha = new JPasswordField();
        JButton botaoConfirmar = new JButton("Cadastrar");
        JButton botaoVoltarLogin = new JButton("Voltar");

        String[] opcoes = { "Aluno", "Professor" }; // As opcoes da caixa de selecao
        JComboBox<String> caixaSelecao = new JComboBox<>(opcoes); // caixa de selecao (dropdown)

        add(new JLabel("Selecione na caixa abaixo alguma das opcoes"));
        add(caixaSelecao);
        add(new JLabel("Qual seu nome:"));
        add(campoNome);
        add(new JLabel("Crie um Username:"));
        add(campoUserName);
        add(new JLabel("Crie uma Senha:"));
        add(campoSenha);
        add(new JLabel("Realizar cadastro"));
        add(botaoConfirmar);
        add(new JLabel("Voltar para Login"));
        add(botaoVoltarLogin);

        // Fica escutando/esperando o click no botao para executar
        botaoConfirmar.addActionListener(e -> {

            String nome = campoNome.getText(); // Pegamos o que a pessoa digitou e guardamos em uma variavel
            String userName = campoUserName.getText(); // Pegamos o que a pessoa digitou e guardamos em uma variavel
            String senha = new String(campoSenha.getPassword()); // // Pegamos o que a pessoa digitou e guardamos em uma variavel (acho q aqui é diferente pois o campo é JPasswordField)
            int tipo = caixaSelecao.getSelectedIndex(); // 0 = Aluno, 1 = Professor usaremos abaixo

            // Estamos usando try pois eu tinha tratado o cadastro invalido com uma excecao
            try {
                // tipo é a variavel que controla se é aluno ou professor. Estamos usando um array (com dois indices (0 e 1) para o usuario selecionar na caixa)
                sistema.cadastro(nome, userName, senha, tipo); // esse metodo ja salva o user no arq .dat. Só executará a prox linha se for um cadastro valido
                JOptionPane.showMessageDialog(frame, "Usuário cadastrado com sucesso!"); // exibimos mensagem de sucesso
                frame.setContentPane(new TelaLogin(frame, sistema)); // Mudamos para a tela de Login
                limparCampos();
                frame.revalidate();
            } catch (CadastroInvalidoException erro) {
                limparCampos();
                JOptionPane.showMessageDialog(frame, erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE); // exibimos uma mensagem de erro
            }
        });

        botaoVoltarLogin.addActionListener(e -> {
            telaLogin.limparCampos();
            frame.setContentPane(telaLogin);
            frame.revalidate();
        });

    }

    public void limparCampos(){
        campoNome.setText("");
        campoUserName.setText("");
        campoSenha.setText("");
    }
}