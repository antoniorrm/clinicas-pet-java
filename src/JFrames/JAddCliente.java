package JFrames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Excecoes.AgendaException;

public class JAddCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfEmail;

	/**
	 * Create the frame.
	 */
	public JAddCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 434, 310);
		contentPane.add(panel);

		JLabel lblCadastrarClientes = new JLabel("Cadastrar Clientes/Pet");
		lblCadastrarClientes.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lblCadastrarClientes.setBounds(44, 11, 346, 43);
		panel.add(lblCadastrarClientes);

		JLabel label_1 = new JLabel("Nome:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_1.setBounds(33, 82, 58, 27);
		panel.add(label_1);

		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(99, 82, 314, 27);
		panel.add(tfNome);

		JLabel label_2 = new JLabel("Email:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_2.setBounds(33, 120, 58, 27);
		panel.add(label_2);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(99, 120, 314, 27);
		panel.add(tfEmail);

		final JFormattedTextField ftfCpf = new JFormattedTextField();
		try {
			ftfCpf.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
		} catch (java.text.ParseException ex) {
			JOptionPane.showMessageDialog(rootPane, ex.getMessage());
		}
		ftfCpf.setColumns(4);
		ftfCpf.setBounds(99, 161, 314, 27);
		panel.add(ftfCpf);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDataDeNascimento.setBounds(33, 199, 187, 27);
		panel.add(lblDataDeNascimento);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCpf.setBounds(33, 161, 58, 27);
		panel.add(lblCpf);

		final JDateChooser dnCliente = new JDateChooser();
		dnCliente.setBounds(220, 199, 170, 27);
		panel.add(dnCliente);

		JButton btncadastrar = new JButton("Cadastrar");
		btncadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					JLogin.agenda.addCliente(tfNome.getText(), tfEmail.getText(), ftfCpf.getText(),
							dnCliente.getCalendar().get(Calendar.DAY_OF_MONTH),
							dnCliente.getCalendar().get(Calendar.MONTH) + 1,
							dnCliente.getCalendar().get(Calendar.YEAR));
					JOptionPane.showMessageDialog(rootPane, "Cliente cadastrado com sucesso!");
					int aux;
					aux = JOptionPane.showConfirmDialog(rootPane, "Deseja continuar a adicionar Cliente?");
					if (aux == JOptionPane.NO_OPTION) {
						setVisible(false);
					} else {
						tfNome.setText("");
						tfEmail.setText("");
						ftfCpf.setText("");
					}
				} catch (NullPointerException | AgendaException e1) {
					if (e1.getMessage() == null) {
						JOptionPane.showMessageDialog(rootPane, "Data não selecionada!");
					} else {
						JOptionPane.showMessageDialog(rootPane, e1.getMessage());
						tfNome.setText("");
						tfEmail.setText("");
						ftfCpf.setText("");
					}

				}
			}
		});
		btncadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btncadastrar.setBounds(33, 244, 156, 43);
		panel.add(btncadastrar);

		JButton btncancelar = new JButton("Cancelar");
		btncancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btncancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btncancelar.setBounds(257, 244, 156, 43);
		panel.add(btncancelar);

	}
}
