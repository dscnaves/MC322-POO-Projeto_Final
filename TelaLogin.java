import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// Usamos JPanel para mudar entre "telas" 
public class TelaLogin extends JPanel {

    private JTextField campoUserName;
    private JPasswordField campoSenha;

    public TelaLogin(JFrame frame, Sistema sistema) {
        setLayout(new GridLayout(0,1));
        setBorder(new EmptyBorder(30, 40, 30, 40));
        
        campoUserName = new JTextField();
        campoSenha = new JPasswordField();
        JButton botaoLogin = new JButton("Entrar");
        JButton botaoCadastro = new JButton("Cadastrar");

        add(new JLabel("Digite seu UserName:"));
        add(campoUserName);
        add(new JLabel("Digite sua Senha:"));
        add(campoSenha);
        add(new JLabel("Fazer Login"));
        add(botaoLogin);
        add(new JLabel("Não possui cadastro ainda? Clique aqui para se cadastrar"));
        add(botaoCadastro);

        // Fica escutando/esperando o click no botao para executar
        botaoLogin.addActionListener(e -> {
            String userName = campoUserName.getText(); // Pegamos o que a pessoa digitou e guardamos em uma variavel
            String senha = new String(campoSenha.getPassword());

            // Tratamento de erro usando exceptions
            try {
                //O login tambem é tratado com execption logo precisamos do try catch
                Usuario user = sistema.login(userName, senha); // Como o metodo login retorna um usuario vamos guarda-lo aqui. Se não houver nenhum erro executará as linhas abaixo
                JOptionPane.showMessageDialog(frame, "Login bem-sucedido! Bem-vindo, " + user.getNome());

                // Aqui verificamos o tipo do usuário retornado pelo metodo login:
                if (user instanceof Aluno) {
                    frame.setContentPane(new TelaAluno(sistema, frame, this, (Aluno) user)); // muda para a tela principal do aluno
                } else if (user instanceof Professor) {
                    frame.setContentPane(new TelaProfessor(sistema, frame, this, (Professor) user)); // muda para a tela principal do professor
                }
                limparCampos();
                frame.revalidate();
            } catch (CadastroInvalidoException ex) {
                limparCampos();
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        botaoCadastro.addActionListener(e -> {
            frame.setContentPane(new TelaCadastro(frame, sistema, this)); //substitui o conteúdo visível da janela para agora exibirmos a tela de cadastro
            frame.revalidate();
        });
    }

    public void limparCampos(){
        campoUserName.setText("");
        campoSenha.setText("");
    }
}
