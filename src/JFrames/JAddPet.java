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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Excecoes.ConsultaException;
import Excecoes.PetInvalidoException;
import Projeto.Agenda;
import Projeto.Cliente;

public class JAddPet extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfpNome;
	private JTextField tfpCor;
	private JComboBox<String> cmbCliente;

	/**
	 * Create the frame.
	 */
	public JAddPet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPet = new JLabel("Cadastrar Pet");
		lblPet.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lblPet.setBounds(110, 11, 214, 43);
		contentPane.add(lblPet);

		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(46, 65, 58, 27);
		contentPane.add(lblNewLabel);

		cmbCliente = new JComboBox<String>();
		cmbCliente.setModel(new DefaultComboBoxModel<String>(new String[] { "Selecione o Cliente!" }));
		cmbCliente.setMaximumRowCount(Agenda.clientes.size() + 1);
		cmbCliente.setBounds(116, 65, 285, 27);
		contentPane.add(cmbCliente);
		for (Cliente c : Agenda.clientes) {
			cmbCliente.addItem(c.getNome());
		}

		JLabel label_5 = new JLabel("Tipo:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_5.setBounds(46, 99, 58, 27);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("Nome:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_6.setBounds(46, 137, 58, 27);
		contentPane.add(label_6);

		tfpNome = new JTextField();
		tfpNome.setColumns(10);
		tfpNome.setBounds(112, 137, 287, 27);
		contentPane.add(tfpNome);

		tfpCor = new JTextField();
		tfpCor.setColumns(10);
		tfpCor.setBounds(112, 171, 287, 27);
		contentPane.add(tfpCor);

		JLabel label_7 = new JLabel("Cor:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_7.setBounds(46, 171, 58, 27);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("Data de Nascimento:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_8.setBounds(46, 204, 179, 27);
		contentPane.add(label_8);

		final JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setMaximumRowCount(3);
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] { "", "Gato", "Chachorro" }));
		comboBox.setBounds(114, 99, 285, 27);
		contentPane.add(comboBox);

		final JDateChooser dnPet = new JDateChooser();
		dnPet.setBounds(229, 204, 170, 27);
		contentPane.add(dnPet);

		JButton btncadastrar = new JButton("Cadastrar");
		btncadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					if (cmbCliente.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(rootPane, "Selecione um cliente v�lido!");
					}
					JLogin.agenda.getClienteI(cmbCliente.getSelectedIndex() - 1).add_pet(
							comboBox.getSelectedItem().toString(), tfpNome.getText(), tfpCor.getText(),
							dnPet.getCalendar().get(Calendar.DAY_OF_MONTH), dnPet.getCalendar().get(Calendar.MONTH) + 1,
							dnPet.getCalendar().get(Calendar.YEAR));
					JOptionPane.showMessageDialog(rootPane, "Pet cadastrado com sucesso!");
					int aux;
					aux = JOptionPane.showConfirmDialog(rootPane, "Deseja continuar a adicionar Pet?");
					if (aux == JOptionPane.NO_OPTION) {
						setVisible(false);
					} else {
						tfpNome.setText("");
						tfpCor.setText("");
					}

				} catch (NullPointerException | PetInvalidoException | ConsultaException e1) {
					if (e1.getMessage() == null) {
						JOptionPane.showMessageDialog(rootPane, "Data n�o selecionada!");
					} else {
						JOptionPane.showMessageDialog(rootPane, e1.getMessage());
						tfpNome.setText("");
						tfpCor.setText("");
					}

				}
			}
		});
		btncadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btncadastrar.setBounds(33, 247, 156, 43);
		contentPane.add(btncadastrar);

		JButton btncancelar = new JButton("Cancelar");
		btncancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btncancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btncancelar.setBounds(257, 247, 156, 43);
		contentPane.add(btncancelar);

	}
}
