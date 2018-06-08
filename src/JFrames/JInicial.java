package JFrames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

public class JInicial extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JInicial() {
		setTitle("Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);

		JMenuItem mntmMarcar = new JMenuItem("Marcar");
		mntmMarcar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame marcar = new JMarcar();
				marcar.setVisible(true);
				marcar.setLocationRelativeTo(null);
			}
		});
		mnConsultas.add(mntmMarcar);

		JMenuItem mntmRemarcar = new JMenuItem("Remarcar");
		mntmRemarcar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame remarcar = new JRemarcar();
				remarcar.setVisible(true);
				remarcar.setLocationRelativeTo(null);
			}
		});
		mnConsultas.add(mntmRemarcar);

		JMenuItem mntmRemover = new JMenuItem("Remover");
		mntmRemover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame remover = new JRemoverConsulta();
				remover.setVisible(true);
				remover.setLocationRelativeTo(null);

			}
		});
		mnConsultas.add(mntmRemover);

		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);

		JMenu mnAdicionar = new JMenu("Adicionar");
		mnClientes.add(mnAdicionar);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame addc = new JAddCliente();
				addc.setVisible(true);
				addc.setLocationRelativeTo(null);
			}
		});
		mnAdicionar.add(mntmCliente);

		JMenuItem mntmPet = new JMenuItem("Pet");
		mntmPet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame addc = new JAddPet();
				addc.setVisible(true);
				addc.setLocationRelativeTo(null);
			}
		});
		mnAdicionar.add(mntmPet);

		JMenu mnRemover = new JMenu("Remover");
		mnClientes.add(mnRemover);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame remover = new JRemoverCliente();
				remover.setVisible(true);
				remover.setLocationRelativeTo(null);
			}
		});
		mnRemover.add(mntmNewMenuItem);

		JMenuItem mntmPet_1 = new JMenuItem("Pet");
		mntmPet_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame remover = new JRemoverPet();
				remover.setVisible(true);
				remover.setLocationRelativeTo(null);
			}
		});
		mnRemover.add(mntmPet_1);

		JMenuItem mntmVisualizar = new JMenuItem("Visualizar");
		mntmVisualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame addu = new JVizualizarClientes();
				addu.setVisible(true);
				addu.setLocationRelativeTo(null);
			}
		});
		mnClientes.add(mntmVisualizar);

		JMenu mnUsurios = new JMenu("Usu\u00E1rios");
		menuBar.add(mnUsurios);

		JMenuItem mntmAdicionar_1 = new JMenuItem("Adicionar");
		mntmAdicionar_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame addu = new JAddU();
				addu.setVisible(true);
				addu.setLocationRelativeTo(null);
			}
		});
		mnUsurios.add(mntmAdicionar_1);

		JMenuItem mntmAtualizar = new JMenuItem("Atualizar");
		mntmAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame addu = new JUpdateU();
				addu.setVisible(true);
				addu.setLocationRelativeTo(null);
			}
		});
		mnUsurios.add(mntmAtualizar);

		JMenuItem mntmRemover_2 = new JMenuItem("Remover");
		mntmRemover_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame remover = new JRemoveU();
				remover.setVisible(true);
				remover.setLocationRelativeTo(null);
			}
		});
		mnUsurios.add(mntmRemover_2);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JFrame login = new JLogin();
				login.setVisible(true);
				login.setLocationRelativeTo(null);
			}
		});
		menuBar.add(mntmLogout);
		menuBar.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JCalendar calendar = new JCalendar();
		calendar.setBounds(285, 40, 191, 153);
		contentPane.add(calendar);

		final DefaultListModel<String> modelo = new DefaultListModel<String>();
		final JList<String> list = new JList<String>();
		list.setModel(modelo);
		int cont = 0;
		for (int k = 1; k < 24; k++) {
			if (JLogin.agenda.getAgendaDia(calendar.getCalendar().get(Calendar.DAY_OF_MONTH),
					calendar.getCalendar().get(Calendar.MONTH) + 1, calendar.getCalendar().get(Calendar.YEAR),
					k) != null) {
				modelo.addElement(JLogin.agenda.getAgendaDia(calendar.getCalendar().get(Calendar.DAY_OF_MONTH),
						calendar.getCalendar().get(Calendar.MONTH) + 1, calendar.getCalendar().get(Calendar.YEAR), k));
				cont++;
			}
		}
		if (cont == 0) {
			modelo.addElement("Não há consultas marcada para este dia!");
		}
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(10, 40, 265, 186);

		contentPane.add(list);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 40, 265, 186);
		contentPane.add(scrollPane);

		final JLabel lblNewLabel = new JLabel("Veja as Consultas agendadas para "
				+ calendar.getCalendar().get(Calendar.DAY_OF_MONTH) + "/"
				+ (calendar.getCalendar().get(Calendar.MONTH) + 1) + "/" + calendar.getCalendar().get(Calendar.YEAR));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(46, 0, 391, 29);
		contentPane.add(lblNewLabel);

		list.setForeground(Color.RED);
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel
						.setText("Veja as Consultas agendadas para " + calendar.getCalendar().get(Calendar.DAY_OF_MONTH)
								+ "/" + (calendar.getCalendar().get(Calendar.MONTH) + 1) + "/"
								+ calendar.getCalendar().get(Calendar.YEAR));
				modelo.clear();
				int cont = 0;
				for (int k = 1; k < 24; k++) {
					if (JLogin.agenda.getAgendaDia(calendar.getCalendar().get(Calendar.DAY_OF_MONTH),
							calendar.getCalendar().get(Calendar.MONTH) + 1, calendar.getCalendar().get(Calendar.YEAR),
							k) != null) {
						modelo.addElement(JLogin.agenda.getAgendaDia(calendar.getCalendar().get(Calendar.DAY_OF_MONTH),
								calendar.getCalendar().get(Calendar.MONTH) + 1,
								calendar.getCalendar().get(Calendar.YEAR), k));
						list.setForeground(Color.GREEN);
						cont++;
					}
				}
				if (cont == 0) {
					modelo.addElement("Não há consultas marcada para este dia!");
					list.setForeground(Color.RED);
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(285, 204, 195, 23);
		contentPane.add(btnNewButton);

	}
}
