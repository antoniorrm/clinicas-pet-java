package JFrames;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import Excecoes.ConsultaException;
import Excecoes.PetInvalidoException;
import Projeto.Agenda;
import Projeto.Cliente;
import Projeto.Pet;

public class JVizualizarClientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JVizualizarClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblVizualizarInformaesDo = new JLabel("Vizualizar informa\u00E7\u00F5es do");
		lblVizualizarInformaesDo.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		lblVizualizarInformaesDo.setBounds(54, 11, 326, 43);
		contentPane.add(lblVizualizarInformaesDo);

		JLabel lblVizualizarInformaesDo_1 = new JLabel(" Cliente e de seu(s) Pet(s)");
		lblVizualizarInformaesDo_1.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		lblVizualizarInformaesDo_1.setBounds(56, 49, 321, 43);
		contentPane.add(lblVizualizarInformaesDo_1);

		JLabel label_1 = new JLabel("Cliente:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(36, 103, 59, 27);
		contentPane.add(label_1);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltar.setBounds(154, 383, 125, 35);
		contentPane.add(btnVoltar);

		JLabel label = new JLabel("Data de Nascimento:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(202, 223, 147, 19);
		contentPane.add(label);

		JLabel label_2 = new JLabel("CPF:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(36, 223, 58, 19);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Email:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(36, 199, 58, 19);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Nome:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(36, 179, 50, 19);
		contentPane.add(label_4);

		final JLabel lblNome = new JLabel("");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(90, 179, 334, 19);
		contentPane.add(lblNome);

		final JLabel lblEMail = new JLabel("");
		lblEMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEMail.setBounds(90, 199, 334, 19);
		contentPane.add(lblEMail);

		final JLabel lblCpf = new JLabel("");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCpf.setBounds(68, 223, 126, 19);
		contentPane.add(lblCpf);

		final JLabel lbldata = new JLabel("");
		lbldata.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbldata.setBounds(340, 223, 84, 19);
		contentPane.add(lbldata);
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 254, 414, 2);
		contentPane.add(separator);

		final DefaultListModel<Object> modelo = new DefaultListModel<Object>();
		final JList<Object> list = new JList<Object>();
		list.setModel(modelo);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(21, 300, 391, 72);
		contentPane.add(list);

		JLabel lblInformaesDoCliente = new JLabel("Informa\u00E7\u00F5es do Cliente");
		lblInformaesDoCliente.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblInformaesDoCliente.setBounds(98, 135, 238, 35);
		contentPane.add(lblInformaesDoCliente);

		JLabel lblInformaesDosPets = new JLabel("Informa\u00E7\u00F5es do(s) Pet(s)");
		lblInformaesDosPets.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblInformaesDosPets.setBounds(98, 254, 238, 35);
		contentPane.add(lblInformaesDosPets);

		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(20, 300, 392, 72);
		contentPane.add(scrollPane);

		final JComboBox<Object> cmbCliente = new JComboBox<Object>();
		cmbCliente.setModel(new DefaultComboBoxModel<Object>(new String[] { "Selecione o Cliente!" }));
		cmbCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				modelo.clear();
				if (cmbCliente.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Selecione um cliente v�lido!");
				} else {
					if (Agenda.clientes.size() > 0) {

						try {
							lblNome.setText(JLogin.agenda.getClienteI(cmbCliente.getSelectedIndex() - 1).getNome());
						} catch (ConsultaException e1) {
							lblNome.setText(e1.getMessage());
						}
						try {
							lblEMail.setText(JLogin.agenda.getClienteI(cmbCliente.getSelectedIndex() - 1).getEmail());
						} catch (ConsultaException e1) {
							lblEMail.setText(e1.getMessage());
						}
						try {
							lblCpf.setText(JLogin.agenda.getClienteI(cmbCliente.getSelectedIndex() - 1).getCpf());
						} catch (ConsultaException e1) {
							lblCpf.setText(e1.getMessage());
						}
						try {
							lbldata.setText(JLogin.agenda.getClienteI(cmbCliente.getSelectedIndex() - 1)
									.getDia_nascimento() + "/"
									+ JLogin.agenda.getClienteI(cmbCliente.getSelectedIndex() - 1).getMes_nascimento()
									+ "/"
									+ JLogin.agenda.getClienteI(cmbCliente.getSelectedIndex() - 1).getAno_nascimento());
						} catch (ConsultaException e1) {
							lbldata.setText(e1.getMessage());
						}
						if (Agenda.clientes.get(cmbCliente.getSelectedIndex() - 1).pets.size() > 0) {
							for (Pet p : Agenda.clientes.get(cmbCliente.getSelectedIndex() - 1).pets) {
								try {
									modelo.addElement(JLogin.agenda.getClienteI(cmbCliente.getSelectedIndex() - 1)
											.buscar_pet(p.getNome()).toString());
								} catch (PetInvalidoException | ConsultaException e) {
									JOptionPane.showMessageDialog(rootPane, e.getMessage());
								}
							}
						} else {
							modelo.addElement("Cliente n�o possui nenhum Pet!!");
						}
					} else {
						JOptionPane.showMessageDialog(rootPane, "N�o h� clientes cadastrado no sistema!!");
						setVisible(false);
					}

				}
			}
		});
		cmbCliente.setMaximumRowCount(Agenda.clientes.size() + 1);
		cmbCliente.setBounds(115, 103, 285, 27);
		contentPane.add(cmbCliente);

		for (Cliente c : Agenda.clientes) {
			cmbCliente.addItem(c.getNome());
		}

	}
}
