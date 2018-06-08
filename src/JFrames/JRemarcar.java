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
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Excecoes.ConsultaException;

public class JRemarcar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JRemarcar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRemarcarConsulta = new JLabel("Remarcar Consulta");
		lblRemarcarConsulta.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lblRemarcarConsulta.setBounds(67, 11, 300, 43);
		contentPane.add(lblRemarcarConsulta);

		JLabel lblNovaDataDa = new JLabel("Nova Data da Consulta:");
		lblNovaDataDa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNovaDataDa.setBounds(56, 137, 205, 27);
		contentPane.add(lblNovaDataDa);

		final JDateChooser calendar = new JDateChooser();
		calendar.setBounds(258, 137, 109, 27);
		contentPane.add(calendar);

		String[] hrs = new String[] { "08:00", "09:00", "10:00", "11:00", "14:00", "15:00", "16:00", "17:00", "18:00",
				"19:00" };
		final int[] hrsi = new int[] { 8, 9, 10, 11, 14, 15, 16, 17, 18, 19 };
		final JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(hrs));
		comboBox.setBounds(309, 175, 58, 27);
		contentPane.add(comboBox);

		final JDateChooser atual = new JDateChooser();
		atual.setBounds(258, 65, 109, 27);
		contentPane.add(atual);

		final JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(hrs));
		comboBox_1.setBounds(309, 103, 58, 27);
		contentPane.add(comboBox_1);

		JButton btnMarcar = new JButton("Marcar");
		btnMarcar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					JLogin.agenda.remarcarConsulta(atual.getCalendar().get(Calendar.DAY_OF_MONTH),
							atual.getCalendar().get(Calendar.MONTH) + 1, atual.getCalendar().get(Calendar.YEAR),
							hrsi[comboBox_1.getSelectedIndex()], calendar.getCalendar().get(Calendar.DAY_OF_MONTH),
							calendar.getCalendar().get(Calendar.MONTH) + 1, calendar.getCalendar().get(Calendar.YEAR),
							hrsi[comboBox.getSelectedIndex()]);
					JOptionPane.showMessageDialog(rootPane, "Consulta Remarcada com Sucesso!");
					int aux;
					aux = JOptionPane.showConfirmDialog(rootPane, "Deseja continuar a remarcar consulta?");
					if (aux == JOptionPane.NO_OPTION) {
						setVisible(false);
					}
				} catch (NullPointerException | ConsultaException e) {
					if (e.getMessage() == null) {
						JOptionPane.showMessageDialog(rootPane, "Data n�o selecionada!");
					} else {
						JOptionPane.showMessageDialog(rootPane, e.getMessage());
					}
				}

			}
		});

		btnMarcar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMarcar.setBounds(96, 215, 122, 35);
		contentPane.add(btnMarcar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(242, 215, 125, 35);
		contentPane.add(btnCancelar);

		JLabel lblDataAtualDa = new JLabel("Data Atual da Consulta:");
		lblDataAtualDa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDataAtualDa.setBounds(56, 65, 205, 27);
		contentPane.add(lblDataAtualDa);

		JLabel lblHorrioAtualDa = new JLabel("Hor\u00E1rio Atual da Consulta:");
		lblHorrioAtualDa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblHorrioAtualDa.setBounds(54, 103, 220, 27);
		contentPane.add(lblHorrioAtualDa);

		JLabel lblNovoHorrioDa = new JLabel("Novo Hor\u00E1rio da Consulta:");
		lblNovoHorrioDa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNovoHorrioDa.setBounds(56, 175, 220, 27);
		contentPane.add(lblNovoHorrioDa);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 133, 404, 2);
		contentPane.add(separator);

	}
}
