package JFrames;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Excecoes.LoginException;
import Projeto.Usuario;

public class JRemoveU extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JRemoveU() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);

		JLabel lblRemoverUsurio = new JLabel("Remover Usu\u00E1rio");
		lblRemoverUsurio.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lblRemoverUsurio.setBounds(91, 11, 251, 43);
		panel.add(lblRemoverUsurio);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsurio.setBounds(32, 104, 96, 35);
		panel.add(lblUsurio);

		final JComboBox<Object> cmbUsuario = new JComboBox<Object>();
		cmbUsuario.setModel(new DefaultComboBoxModel<Object>(new String[] { "Selecione o Usu\u00E1rio!" }));
		cmbUsuario.setMaximumRowCount(Usuario.users.size() + 1);
		cmbUsuario.setBounds(103, 111, 285, 27);
		panel.add(cmbUsuario);
		for (Usuario u : Usuario.users) {
			if (u.getLogin().equals("admin")) {
				continue;
			}
			cmbUsuario.addItem(u.getLogin());
		}

		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(243, 195, 125, 35);
		panel.add(button);

		JButton button_1 = new JButton("Remover");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cmbUsuario.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Selecione um cliente v�lido!");
				} else {
					if (Usuario.users.size() > 1) {
						try {
							int aux;
							String senha = null;
							aux = JOptionPane.showConfirmDialog(rootPane, "Deseja remover o Usu�rio: "
									+ Usuario.users.get(cmbUsuario.getSelectedIndex() - 1).getNome());
							if (aux == JOptionPane.YES_OPTION) {
								senha = JOptionPane.showInputDialog("Digite a senha do Usu�rio!");
								if (senha != null) {
									if (Usuario.autentica(
											Usuario.users.get(cmbUsuario.getSelectedIndex() - 1).getLogin(), senha)) {
										Usuario.removeUsuario(
												Usuario.users.get(cmbUsuario.getSelectedIndex() - 1).getLogin(), senha);
										JOptionPane.showMessageDialog(rootPane, "Usu�rio Removido com Sucesso");
										setVisible(false);
									} else {
										JOptionPane.showMessageDialog(rootPane, "Senha n�o confere!");
									}
								}

							}
						} catch (LoginException e1) {
							JOptionPane.showMessageDialog(rootPane, e1.getMessage());

						}

					} else {

						JOptionPane.showMessageDialog(rootPane, "N�o h� usu�rios cadastrado!");
						setVisible(false);
					}
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_1.setBounds(97, 195, 122, 35);
		panel.add(button_1);

	}

}
