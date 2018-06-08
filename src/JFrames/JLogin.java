package JFrames;

import java.awt.EventQueue;
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
import Projeto.Agenda;
import Projeto.Usuario;

public class JLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField login;
	private JPasswordField senha;
	private JLabel lblNewLabel;
	static Agenda agenda = new Agenda();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			@SuppressWarnings("unused")
			public void run() {
				try {
					Usuario padrao = new Usuario("administrador", "admin@admin.com", "admin", "admin123",
							"Ano de nascimento", "1996");
					Usuario admin = new Usuario("aaaaaaa", "aaaa@admin.com", "aaaa", "admin", "Ano de nascimento",
							"1996");
					// Usuario.updateUsuario("aaaa", "admin123",
					// "abababa","admin@admi.com", "aaa123", "admin123", "Ano",
					// "1222");
					agenda.addCliente("Antonio", "antonio_R@gmail.com", "05810120239", 1, 2, 1980);
					// agenda.getCliente(0).add_pet("gato", "Miau", "preto",
					// 12,1,1999);
					// agenda.addConsulta(0,agenda.getCliente(0).buscar_pet("Miau"),
					// 31,01,2016,9);
					// agenda.addConsulta(0,agenda.getCliente(0).buscar_pet("Miau"),
					// 31,01,2016,10);
					JLogin frame = new JLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JLogin() {
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLogin.setBounds(73, 105, 64, 27);
		
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setBounds(73, 143, 64, 21);
		contentPane.add(lblSenha);

		lblNewLabel = new JLabel("Acessar Sistema");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lblNewLabel.setBounds(102, 42, 248, 43);
		contentPane.add(lblNewLabel);

		login = new JTextField();
		login.setToolTipText("Digite seu Login");
		login.setBounds(135, 105, 229, 27);
		contentPane.add(login);
		login.setColumns(10);

		senha = new JPasswordField();
		senha.setBounds(135, 137, 229, 27);
		contentPane.add(senha);

		JButton btnEsqueciMinhaSenha = new JButton("Esqueci minha senha");
		btnEsqueciMinhaSenha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame recsenha = new JRecSenha();
				recsenha.setLocationRelativeTo(null);
				recsenha.setVisible(true);
				;

			}
		});
		btnEsqueciMinhaSenha.setBounds(132, 227, 169, 23);
		contentPane.add(btnEsqueciMinhaSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Usuario.autentica(login.getText(), senha.getText()) != false) {
						setVisible(false);
						JFrame inicial = new JInicial();
						inicial.setLocationRelativeTo(null);
						inicial.setVisible(true);
						;

					} else {
						JOptionPane.showMessageDialog(null, "Login ou Senha Inv�lido!");
					}
				} catch (LoginException msg) {
					JOptionPane.showMessageDialog(null, msg.getMessage());
				}
			}
		});
		btnEntrar.setBounds(73, 189, 136, 27);
		contentPane.add(btnEntrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(240, 189, 124, 27);
		contentPane.add(btnCancelar);
	}

	public static void EXIT_ON_CLOSE() {
		// TODO Auto-generated method stub

	}

}
