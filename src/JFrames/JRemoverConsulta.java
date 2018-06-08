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

import Excecoes.ConsultaException;

public class JRemoverConsulta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JRemoverConsulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRemoverConsulta = new JLabel("Remover Consulta");
		lblRemoverConsulta.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lblRemoverConsulta.setBounds(82, 11, 269, 43);
		contentPane.add(lblRemoverConsulta);

		JLabel lblNovaDataDa = new JLabel("Data da Consulta:");
		lblNovaDataDa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNovaDataDa.setBounds(62, 81, 167, 27);
		contentPane.add(lblNovaDataDa);

		final JDateChooser calendar = new JDateChooser();
		calendar.setBounds(242, 81, 109, 27);
		contentPane.add(calendar);

		String[] hrs = new String[] { "08:00", "09:00", "10:00", "11:00", "14:00", "15:00", "16:00", "17:00", "18:00",
				"19:00" };
		final int[] hrsi = new int[] { 8, 9, 10, 11, 14, 15, 16, 17, 18, 19 };
		final JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel<Object>(hrs));
		comboBox.setBounds(293, 115, 58, 27);
		contentPane.add(comboBox);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JLogin.agenda.removeConsulta(calendar.getCalendar().get(Calendar.DAY_OF_MONTH),
							calendar.getCalendar().get(Calendar.MONTH) + 1, calendar.getCalendar().get(Calendar.YEAR),
							hrsi[comboBox.getSelectedIndex()]);
					JOptionPane.showMessageDialog(rootPane, "Consulta Removida com sucesso!");
					int aux;
					aux = JOptionPane.showConfirmDialog(rootPane, "Deseja continuar a remover consulta?");
					if (aux == JOptionPane.NO_OPTION) {
						setVisible(false);
					}
				} catch (NullPointerException | ConsultaException e1) {
					if (e1.getMessage() == null) {
						JOptionPane.showMessageDialog(rootPane, "Data n�o selecionada!");
					} else {
						JOptionPane.showMessageDialog(rootPane, e1.getMessage());
					}
				}
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRemover.setBounds(76, 195, 122, 35);
		contentPane.add(btnRemover);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(222, 195, 125, 35);
		contentPane.add(btnCancelar);

		JLabel lblHorrioDaConsulta = new JLabel("Hor\u00E1rio da Consulta:");
		lblHorrioDaConsulta.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblHorrioDaConsulta.setBounds(62, 115, 177, 27);
		contentPane.add(lblHorrioDaConsulta);
	}
}
