import java.awt.*;
import javax.swing.*;

// Usamos JPanel para mudar entre "telas" 
public class TelaLogin extends JPanel {

    private JTextField campoUserName;
    private JPasswordField campoSenha;

    public TelaLogin(JFrame frame, Sistema sistema) {
        setLayout(new GridLayout(0,1));

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

            try {
                //O login tambem é tratado com execption logo precisamos do try catch
                Usuario user = sistema.login(userName, senha); // Como o metodo login retorna um usuario vamos guarda-lo aqui. Se não houver nenhum erro executará as linhas abaixo
                JOptionPane.showMessageDialog(frame, "Login bem-sucedido! Bem-vindo, " + user.getNome());

                // Aqui verificamos o tipo do usuário retornado pelo metodo login:
                if (user instanceof Aluno) {
                    frame.setContentPane(new TelaAluno(frame, this, (Aluno) user)); // muda para a tela principal do aluno
                } else if (user instanceof Professor) {
                    frame.setContentPane(new TelaProfessor(frame, this, (Professor) user)); // muda para a tela principal do professor
                }

                frame.revalidate();
            } catch (CadastroInvalidoException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        botaoCadastro.addActionListener(e -> {
            frame.setContentPane(new TelaCadastro(frame, sistema)); //substitui o conteúdo visível da janela para agora exibirmos a tela de cadastro
            frame.revalidate();
        });
    }

    public void limparCampos(){
        campoUserName.setText("");
        campoSenha.setText("");
    }
}
