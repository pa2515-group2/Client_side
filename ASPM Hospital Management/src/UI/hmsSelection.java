package UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;

public class hmsSelection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public hmsSelection() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JComboBox comboBox = new JComboBox(
				new String[] { "Book an appointment", "add a patient", "add a doctor" });
		comboBox.setBounds(49, 107, 544, 39);
		contentPane.add(comboBox);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int selcVal = comboBox.getSelectedIndex();

				switch (selcVal) {
				case 0:
					// book an appointment
					break;
				case 1:
					UI.PatientInfo i = new UI.PatientInfo();
					i.setVisible(true);
					break;
				case 2:
					UI.Doctors_info frame = new UI.Doctors_info();
					frame.setVisible(true);
					break;
				default:
					System.out.println("error message");
				}
				dispose();
			}

		});
		btnSubmit.setBounds(422, 192, 171, 41);
		contentPane.add(btnSubmit);

		JLabel lblSelectAnOption = new JLabel("Select an option");
		lblSelectAnOption.setBounds(26, 28, 344, 33);
		contentPane.add(lblSelectAnOption);
	}
}
