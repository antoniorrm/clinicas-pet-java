package JFrames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Excecoes.LoginException;
import Projeto.Usuario;

public class JUpdateU extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfResposta;
	private JTextField tfPergunta;
	private JPasswordField tfpSenha;
	private JTextField tfEmail;
	private JTextField tfNome;
	private JTextField tfLogin;
	private JPasswordField tfpSenhaantiga;

	/**
	 * Create the frame.
	 */
	public JUpdateU() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRemoverUsurio = new JLabel("Atualizar Usu\u00E1rio");
		lblRemoverUsurio.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lblRemoverUsurio.setBounds(96, 11, 241, 43);
		contentPane.add(lblRemoverUsurio);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsurio.setBounds(41, 61, 96, 27);
		contentPane.add(lblUsurio);

		final JComboBox<Object> cmbUsuario = new JComboBox<Object>();
		cmbUsuario.setModel(
				new DefaultComboBoxModel<Object>(new String[] { "Selecione o usu\u00E1rio para atualizar!" }));
		cmbUsuario.setMaximumRowCount(Usuario.users.size() + 1);
		cmbUsuario.setBounds(112, 61, 285, 27);
		contentPane.add(cmbUsuario);

		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(30, 154, 58, 27);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Email:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_1.setBounds(30, 192, 58, 27);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Login:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_2.setBounds(30, 233, 58, 27);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Senha:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_3.setBounds(30, 271, 68, 27);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Pergunta:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_4.setBounds(30, 309, 86, 27);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("Resposta:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_5.setBounds(30, 347, 86, 27);
		contentPane.add(label_5);

		tfResposta = new JTextField();
		tfResposta.setColumns(10);
		tfResposta.setBounds(129, 347, 281, 27);
		contentPane.add(tfResposta);

		tfPergunta = new JTextField();
		tfPergunta.setColumns(10);
		tfPergunta.setBounds(129, 309, 281, 27);
		contentPane.add(tfPergunta);

		tfpSenha = new JPasswordField();
		tfpSenha.setColumns(10);
		tfpSenha.setBounds(96, 271, 314, 27);
		contentPane.add(tfpSenha);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(96, 192, 314, 27);
		contentPane.add(tfEmail);

		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(96, 154, 314, 27);
		contentPane.add(tfNome);

		tfLogin = new JTextField();
		tfLogin.setColumns(10);
		tfLogin.setBounds(96, 233, 314, 27);
		contentPane.add(tfLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setBounds(41, 96, 68, 20);
		contentPane.add(lblSenha);

		final JLabel lblModifiqueOsCampos = new JLabel("Digite a senha do usu�rio para se autenticar!");
		lblModifiqueOsCampos.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifiqueOsCampos.setVerticalAlignment(SwingConstants.TOP);
		lblModifiqueOsCampos.setFont(new Font("Century Gothic", Font.PLAIN, 19));
		lblModifiqueOsCampos.setBounds(10, 116, 414, 27);
		contentPane.add(lblModifiqueOsCampos);

		for (Usuario u : Usuario.users) {
			if (u.getLogin().equals("admin")) {
				continue;
			}
			cmbUsuario.addItem(u.getLogin());
		}

		tfpSenhaantiga = new JPasswordField();
		tfpSenhaantiga.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent arg0) {
				if (!(tfpSenhaantiga.getText().equals(""))) {
					try {
						Usuario aux = Usuario.getUsuario(cmbUsuario.getSelectedIndex(),
								tfpSenhaantiga.getText().toString());
						if (aux != null) {
							lblModifiqueOsCampos.setText("Modifique os campos que desejar!");
							lblModifiqueOsCampos.setForeground(Color.GREEN);
							tfNome.setText(aux.getNome());
							tfEmail.setText(aux.getEmail());
							tfLogin.setText(aux.getLogin());
							tfPergunta.setText(
									Usuario.getPergunta(cmbUsuario.getSelectedItem().toString(), aux.getEmail()));

						} else {
							tfNome.setText("");
							tfEmail.setText("");
							tfLogin.setText("");
							tfPergunta.setText("");
							lblModifiqueOsCampos.setText("Erro Usu�rio n�o encontrado!");
							lblModifiqueOsCampos.setForeground(Color.RED);
						}

					} catch (LoginException e) {
						lblModifiqueOsCampos.setText(e.getMessage());
						lblModifiqueOsCampos.setForeground(Color.RED);
					}

				}
			}
		});
		tfpSenhaantiga.setBounds(110, 96, 287, 20);
		contentPane.add(tfpSenhaantiga);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario aux = Usuario.getUsuario(cmbUsuario.getSelectedIndex(),
							tfpSenhaantiga.getText().toString());
					Usuario.updateUsuario(aux.getLogin(), tfpSenhaantiga.getText(), tfNome.getText(), tfEmail.getText(),
							tfLogin.getText(), tfpSenha.getText(), tfPergunta.getText(), tfResposta.getText());
					JOptionPane.showMessageDialog(rootPane, "Usu�rio Atualizado com Sucesso!");
					setVisible(false);
				} catch (LoginException e1) {
					JOptionPane.showMessageDialog(rootPane, e1.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(30, 385, 152, 43);
		contentPane.add(btnNewButton);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.setBounds(244, 385, 152, 43);
		contentPane.add(btnCancelar);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 141, 414, 2);
		contentPane.add(separator);

	}
}
