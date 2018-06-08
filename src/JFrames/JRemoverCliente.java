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

import Excecoes.ConsultaException;
import Projeto.Agenda;
import Projeto.Cliente;

public class JRemoverCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Object> cmbCliente;
	private JButton button;
	private JButton btnRemover;

	/**
	 * Create the frame.
	 */
	public JRemoverCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRemoverCliente = new JLabel("Remover Cliente");
		lblRemoverCliente.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lblRemoverCliente.setBounds(91, 11, 251, 43);
		contentPane.add(lblRemoverCliente);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCliente.setBounds(32, 104, 96, 35);
		contentPane.add(lblCliente);

		cmbCliente = new JComboBox<Object>();
		cmbCliente.setModel(new DefaultComboBoxModel<Object>(new String[] { "Selecione o Cliente!" }));

		cmbCliente.setMaximumRowCount(Agenda.clientes.size() + 1);
		cmbCliente.setBounds(115, 110, 285, 27);
		contentPane.add(cmbCliente);
		for (Cliente c : Agenda.clientes) {
			cmbCliente.addItem(c.getNome());
		}

		button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(243, 195, 125, 35);
		contentPane.add(button);

		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cmbCliente.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Selecione um cliente v�lido!");
				}
				if (Agenda.clientes.size() > 0) {
					try {
						int aux;
						aux = JOptionPane.showConfirmDialog(rootPane, "Deseja remover o cliente: "
								+ JLogin.agenda.getClienteI(cmbCliente.getSelectedIndex() - 1).getNome());
						if (aux == JOptionPane.YES_OPTION) {
							JLogin.agenda.removeCliente(
									JLogin.agenda.getClienteI(cmbCliente.getSelectedIndex() - 1).getId());
							JOptionPane.showMessageDialog(rootPane, "Cliente Removido com Sucesso!");
							setVisible(false);
						}
					} catch (ConsultaException e1) {
						JOptionPane.showMessageDialog(rootPane, e1.getMessage());
					}
				} else {
					JOptionPane.showMessageDialog(rootPane, "N�o h� usu�rios cadastrado!");
					setVisible(false);
				}
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRemover.setBounds(97, 195, 122, 35);
		contentPane.add(btnRemover);

	}
}
