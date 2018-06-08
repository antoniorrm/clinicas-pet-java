package JFrames;

import java.awt.Container;

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
import Excecoes.PetInvalidoException;
import Projeto.Agenda;
import Projeto.Cliente;
import Projeto.Pet;

public class JRemoverPet extends JFrame {

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
	public JRemoverPet() {
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
		lblCliente.setBounds(37, 90, 96, 27);
		contentPane.add(lblCliente);

		Container lblPet = new JLabel("Pet:");
		lblPet.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPet.setBounds(37, 136, 58, 27);
		contentPane.add(lblPet);

		final JComboBox<Object> cmbPet = new JComboBox<Object>();
		cmbPet.setMaximumRowCount(Agenda.clientes.size() + 1);
		cmbPet.setModel(new DefaultComboBoxModel<Object>(new String[] { "Selecione o Pet!" }));
		cmbPet.setBounds(116, 136, 285, 27);
		contentPane.add(cmbPet);

		cmbCliente = new JComboBox<Object>();
		cmbCliente.setModel(new DefaultComboBoxModel<Object>(new String[] { "Selecione o Cliente!" }));
		cmbCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (cmbCliente.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Selecione um cliente v�lido!");
				}
				if (Agenda.clientes.size() > 0) {
					if (Agenda.clientes.get(cmbCliente.getSelectedIndex() - 1).pets.size() > 0) {
						for (Pet p : Agenda.clientes.get(cmbCliente.getSelectedIndex() - 1).pets) {
							cmbPet.addItem(p.getNome());
						}
					} else {
						JOptionPane.showMessageDialog(rootPane, "Cliente n�o possui nenhum Pet!!");
						setVisible(false);
					}
				} else {
					JOptionPane.showMessageDialog(rootPane, "N�o h� clientes cadastrado no sistema!!");
					setVisible(false);
				}

			}
		});
		cmbCliente.setMaximumRowCount(Agenda.clientes.size() + 1);
		cmbCliente.setBounds(116, 90, 285, 27);
		contentPane.add(cmbCliente);

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

				if (Agenda.clientes.size() > 0) {
					try {
						int aux;
						aux = JOptionPane.showConfirmDialog(rootPane,
								"Deseja remover o pet: " + JLogin.agenda.getClienteI(cmbCliente.getSelectedIndex() - 1)
										.buscar_pet(cmbPet.getSelectedItem().toString()).getNome());
						if (aux == JOptionPane.YES_OPTION) {
							JLogin.agenda.getClienteI(cmbCliente.getSelectedIndex() - 1).remove_pet(
									JLogin.agenda.getClienteI(cmbCliente.getSelectedIndex() - 1)
											.buscar_pet(cmbPet.getSelectedItem().toString()).getTipo(),
									cmbPet.getSelectedItem().toString());
							;
							JOptionPane.showMessageDialog(rootPane, "Pet Removido com Sucesso");
							setVisible(false);
						}
					} catch (ConsultaException | PetInvalidoException e1) {
						JOptionPane.showMessageDialog(rootPane, e1.getMessage());

					}
				} else {

					JOptionPane.showMessageDialog(rootPane, "N�o h� Pet cadastrado!");
					setVisible(false);
				}
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRemover.setBounds(97, 195, 122, 35);
		contentPane.add(btnRemover);

		for (Cliente c : Agenda.clientes) {
			cmbCliente.addItem(c.getNome());
		}
	}
}
