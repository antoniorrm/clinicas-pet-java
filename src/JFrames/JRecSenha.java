package JFrames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Excecoes.LoginException;
import Projeto.Usuario;

public class JRecSenha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfLogin;
	private JTextField tfEmail;
	private JTextField tfPergunta;
	private JLabel lblNovaSenha;
	private JTextField tfNovasenha;
	private JButton btnRecuperar;
	private JLabel lblRecuperarSenha;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JRecSenha() {
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_login = new JLabel("Login:");
		lbl_login.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbl_login.setBounds(35, 75, 58, 27);
		contentPane.add(lbl_login);

		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		tfLogin.setBounds(127, 77, 281, 27);
		contentPane.add(tfLogin);

		final JLabel lbl_mostrarPergunta = new JLabel("Digite o Login e o email para saber a pergunta!");
		lbl_mostrarPergunta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_mostrarPergunta.setBounds(35, 141, 403, 37);
		contentPane.add(lbl_mostrarPergunta);

		JLabel lblResposta = new JLabel("Resposta:");
		lblResposta.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblResposta.setBounds(35, 173, 119, 27);
		contentPane.add(lblResposta);

		JLabel lblPergunta = new JLabel("Email:");
		lblPergunta.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPergunta.setBounds(35, 117, 58, 27);
		contentPane.add(lblPergunta);

		tfEmail = new JTextField();
		tfEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (!(tfLogin.getText().equals("") && tfEmail.getText().equals(""))) {
					try {
						lbl_mostrarPergunta.setText(Usuario.getPergunta(tfLogin.getText(), tfEmail.getText()));
						lbl_mostrarPergunta.setForeground(Color.GREEN);
					} catch (LoginException e) {
						lbl_mostrarPergunta.setText(e.getMessage());
						lbl_mostrarPergunta.setForeground(Color.RED);
					}
				}
			}
		});
		tfEmail.setColumns(10);
		tfEmail.setBounds(127, 119, 281, 27);
		contentPane.add(tfEmail);

		tfPergunta = new JTextField();
		tfPergunta.setColumns(10);
		tfPergunta.setBounds(153, 175, 255, 27);
		contentPane.add(tfPergunta);

		lblNovaSenha = new JLabel("Nova Senha:");
		lblNovaSenha.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNovaSenha.setBounds(35, 211, 140, 27);
		contentPane.add(lblNovaSenha);

		tfNovasenha = new JTextField();
		tfNovasenha.setColumns(10);
		tfNovasenha.setBounds(153, 212, 255, 27);
		contentPane.add(tfNovasenha);

		btnRecuperar = new JButton("Recuperar");
		btnRecuperar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Usuario.recuperarSenha(tfLogin.getText(), tfPergunta.getText(), tfNovasenha.getText());
					JOptionPane.showMessageDialog(btnRecuperar, "Senha Recuperada com Sucesso!");
					setVisible(false);
				} catch (LoginException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnRecuperar.setBounds(35, 260, 178, 44);
		contentPane.add(btnRecuperar);

		lblRecuperarSenha = new JLabel("Recuperar Senha");
		lblRecuperarSenha.setFont(new Font("Century Gothic", Font.PLAIN, 23));
		lblRecuperarSenha.setBounds(116, 22, 202, 27);
		contentPane.add(lblRecuperarSenha);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(223, 260, 178, 44);
		contentPane.add(btnCancelar);
	}
}
