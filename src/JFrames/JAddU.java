package JFrames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Excecoes.LoginException;
import Projeto.Usuario;

public class JAddU extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JPasswordField tfpSenha;
	private JTextField tfLogin;
	private JTextField tfPergunta;
	private JTextField tfResposta;

	/**
	 * Create the frame.
	 */
	public JAddU() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastrarUsurio = new JLabel("Cadastrar Usu�rio");
		lblCadastrarUsurio.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lblCadastrarUsurio.setBounds(78, 11, 277, 43);
		contentPane.add(lblCadastrarUsurio);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNome.setBounds(32, 89, 58, 27);
		contentPane.add(lblNome);

		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(98, 89, 314, 27);
		contentPane.add(tfNome);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail.setBounds(32, 127, 58, 27);
		contentPane.add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(98, 127, 314, 27);
		contentPane.add(tfEmail);

		tfpSenha = new JPasswordField();
		tfpSenha.setColumns(10);
		tfpSenha.setBounds(98, 206, 314, 27);
		contentPane.add(tfpSenha);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSenha.setBounds(32, 206, 68, 27);
		contentPane.add(lblSenha);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLogin.setBounds(32, 168, 58, 27);
		contentPane.add(lblLogin);

		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		tfLogin.setBounds(98, 168, 314, 27);
		contentPane.add(tfLogin);

		JLabel lblPergunta = new JLabel("Pergunta:");
		lblPergunta.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPergunta.setBounds(32, 244, 86, 27);
		contentPane.add(lblPergunta);

		JLabel lblResposta = new JLabel("Resposta:");
		lblResposta.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblResposta.setBounds(32, 282, 86, 27);
		contentPane.add(lblResposta);

		tfPergunta = new JTextField();
		tfPergunta.setColumns(10);
		tfPergunta.setBounds(131, 244, 281, 27);
		contentPane.add(tfPergunta);

		tfResposta = new JTextField();
		tfResposta.setColumns(10);
		tfResposta.setBounds(131, 282, 281, 27);
		contentPane.add(tfResposta);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					new Usuario(tfNome.getText(), tfEmail.getText(), tfLogin.getText(), tfpSenha.getText(),
							tfPergunta.getText(), tfResposta.getText());
					JOptionPane.showMessageDialog(rootPane, "Usu�rio Cadastrado com Sucesso!");
					int aux;
					aux = JOptionPane.showConfirmDialog(rootPane, "Deseja continuar a adicionar usu�rios?");
					if (aux == JOptionPane.NO_OPTION) {
						setVisible(false);
					} else {
						tfNome.setText("");
						tfEmail.setText("");
						tfLogin.setText("");
						tfpSenha.setText("");
						tfPergunta.setText("");
						tfResposta.setText("");
					}

				} catch (LoginException e1) {
					JOptionPane.showMessageDialog(rootPane, e1.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(32, 356, 156, 43);
		contentPane.add(btnNewButton);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.setBounds(246, 356, 156, 43);
		contentPane.add(btnCancelar);
	}
}
