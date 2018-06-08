package JFrames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Excecoes.AgendaException;
import Excecoes.ConsultaException;
import Excecoes.PetInvalidoException;
import Projeto.Agenda;
import Projeto.Cliente;
import Projeto.Pet;

public class JMarcar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPet;
	private JComboBox<Object> cmbPet;
	private JLabel lblConsultaNoDia;
	private JButton btnMarcar;
	private JButton btnCancelar;
	private JComboBox<Object> cmbCliente;

	/**
	 * Create the frame.
	 */
	public JMarcar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMarcarConsulta = new JLabel("Marcar Consulta");
		lblMarcarConsulta.setBounds(91, 11, 251, 43);
		lblMarcarConsulta.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		contentPane.add(lblMarcarConsulta);

		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(26, 117, 96, 35);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);

		lblPet = new JLabel("Pet:");
		lblPet.setBounds(26, 163, 58, 27);
		lblPet.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(lblPet);

		cmbPet = new JComboBox<Object>();
		cmbPet.setBounds(115, 166, 285, 27);
		cmbPet.setMaximumRowCount(Agenda.clientes.size() + 1);
		cmbPet.setModel(new DefaultComboBoxModel<Object>(new String[] { "Selecione o Pet!" }));
		contentPane.add(cmbPet);

		lblConsultaNoDia = new JLabel("Data da Consulta:");
		lblConsultaNoDia.setBounds(26, 65, 152, 27);
		lblConsultaNoDia.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(lblConsultaNoDia);
		String[] hrs = new String[] { "08:00", "09:00", "10:00", "11:00", "14:00", "15:00", "16:00", "17:00", "18:00",
				"19:00" };
		final int[] hrsi = new int[] { 8, 9, 10, 11, 14, 15, 16, 17, 18, 19 };
		final JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBounds(323, 72, 58, 20);
		comboBox.setModel(new DefaultComboBoxModel<Object>(hrs));
		contentPane.add(comboBox);

		final JDateChooser calendar = new JDateChooser();
		calendar.setBounds(189, 72, 109, 20);
		contentPane.add(calendar);

		btnMarcar = new JButton("Marcar");
		btnMarcar.setBounds(91, 215, 122, 35);
		btnMarcar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (cmbPet.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(rootPane, "Selecione um pet v�lido!");
					}
					JLogin.agenda.addConsulta(cmbCliente.getSelectedIndex() - 1,
							JLogin.agenda.getClienteI(cmbCliente.getSelectedIndex() - 1)
									.buscar_pet(cmbPet.getSelectedItem().toString()),
							calendar.getCalendar().get(Calendar.DAY_OF_MONTH),
							calendar.getCalendar().get(Calendar.MONTH) + 1, calendar.getCalendar().get(Calendar.YEAR),
							hrsi[comboBox.getSelectedIndex()]);
					JOptionPane.showMessageDialog(rootPane,
							"Consulta marcada com sucesso!\n para o pet: "
									+ JLogin.agenda.getClienteI(cmbCliente.getSelectedIndex() - 1)
											.buscar_pet(cmbPet.getSelectedItem().toString()).getNome()
									+ "do cliente: "
									+ JLogin.agenda.getCliente(cmbCliente.getSelectedIndex() - 1).getNome() + " �s "
									+ hrsi[comboBox.getSelectedIndex()] + " horas!");
					setVisible(false);
				} catch (NullPointerException | AgendaException | PetInvalidoException | ConsultaException e1) {
					if (e1.getMessage() == null) {
						JOptionPane.showMessageDialog(rootPane, "Data n�o selecionada!");
					} else {
						JOptionPane.showMessageDialog(rootPane, e1.getMessage());
					}
				}
			}
		});
		btnMarcar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(btnMarcar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(237, 215, 125, 35);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(btnCancelar);

		cmbCliente = new JComboBox<Object>();
		cmbCliente.setBounds(115, 123, 285, 27);
		cmbCliente.setModel(new DefaultComboBoxModel<Object>(new String[] { "Selecione o Cliente!" }));
		cmbCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cmbCliente.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Selecione um cliente v�lido!");
				} else {
					if (Agenda.clientes.size() > 0) {
						if (Agenda.clientes.get(cmbCliente.getSelectedIndex() - 1).pets.size() > 0) {
							for (Pet p : Agenda.clientes.get(cmbCliente.getSelectedIndex() - 1).pets) {
								cmbPet.addItem(p.getNome());
							}
						} else {
							JOptionPane.showMessageDialog(rootPane, "Cliente n�o possui nenhum Pet!!");
						}
					} else {
						JOptionPane.showMessageDialog(rootPane, "N�o h� clientes cadastrado no sistema!!");
						setVisible(false);
					}
				}
			}
		});
		cmbCliente.setMaximumRowCount(Agenda.clientes.size() + 1);
		contentPane.add(cmbCliente);
		for (Cliente c : Agenda.clientes) {
			cmbCliente.addItem(c.getNome());
		}

	}
}
