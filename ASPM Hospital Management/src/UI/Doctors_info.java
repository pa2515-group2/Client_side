package UI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.toedter.calendar.JDateChooser;

import UI.ServerCode;

@SuppressWarnings("unused")
public class Doctors_info extends JFrame {

	public String[] profession = { "Surgeon", "Neurologist", "Physician", "Dermatologist", "Gynecologist",
			"Radiologist" };
	public String[] gender = { "Male", "Female" };
	public String firstname, lastname, qualification, experience, age;

	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private JPanel contentPane;

	JDateChooser dateChooser = new JDateChooser();
	JComboBox comboBox_1 = new JComboBox(gender);
	JComboBox comboBox = new JComboBox(profession);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctors_info frame = new Doctors_info();
					frame.setVisible(true);

				} catch (Exception e) {
					System.out.println("Exception caught:" + e);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Doctors_info() {
		final ServerCode sc=new ServerCode();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Getting the values written in text fields
					firstname = textField.getText();
					lastname = textField_1.getText();
					qualification = textField_2.getText();
					experience = textField_3.getText();

					SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
					Date d = dateChooser.getDate();

					// If date is not given throw an exception to the user
					if (firstname.equals("") || lastname.equals("") || qualification.equals("") || experience.equals("")
							|| d == null)
						throw new RuntimeException("Enter the missing informations!");

					else {
						age = dateformat.format(d);
						System.out.println(age);

						// Encoding values into a JSON object
						JSONObject obj = new JSONObject();

						obj.put("first_name", firstname);
						obj.put("last_name", lastname);
						obj.put("qualification", qualification);
						obj.put("experience", experience);
						obj.put("age", age);
						obj.put("gender", comboBox_1.getSelectedItem().toString());
						obj.put("profession", comboBox.getSelectedItem().toString());

						// Printing JSON object in string format for testing
						System.out.println(obj);
						sc.PostData(obj, "http://localhost:8080/Server/Test");
					}
				}

				catch (RuntimeException e5) {
					JOptionPane.showMessageDialog(null, e5, "Error", JOptionPane.ERROR_MESSAGE);

				} catch (Exception e1) {
					System.out.println("Exception caught:" + e1);
				}
			}
		});

		btnNewButton.setBounds(308, 210, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				dateChooser.setDate(null);
			}
		});

		btnNewButton_1.setBounds(209, 210, 89, 23);
		contentPane.add(btnNewButton_1);

		textField = new JTextField();
		textField.setBounds(114, 44, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setTransferHandler(null); // disable copy&paste actions

		// prevent numerical values
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < 'A') || (c > 'Z')) && ((c < 'a') || (c > 'z')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});

		JList list = new JList();
		list.setBounds(155, 123, 67, -14);
		contentPane.add(list);

		comboBox.setBounds(258, 63, 95, 27);
		contentPane.add(comboBox);

		textField_1 = new JTextField();
		textField_1.setBounds(114, 70, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setTransferHandler(null); // disable copy&paste actions

		// prevent numerical values
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < 'A') || (c > 'Z')) && ((c < 'a') || (c > 'z')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});

		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setBounds(31, 47, 46, 14);
		contentPane.add(lblFirstName);

		JLabel lblNewLabel = new JLabel("Last name");
		lblNewLabel.setBounds(31, 73, 46, 14);
		contentPane.add(lblNewLabel);

		comboBox_1.setBounds(284, 101, 69, 20);
		contentPane.add(comboBox_1);

		textField_2 = new JTextField();
		textField_2.setBounds(114, 101, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setTransferHandler(null); // disable copy&paste actions

		// prevent numerical values
		textField_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < 'A') || (c > 'Z')) && ((c < 'a') || (c > 'z')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});

		JLabel lblQualification = new JLabel("Qualification");
		lblQualification.setBounds(31, 98, 46, 14);
		contentPane.add(lblQualification);

		textField_3 = new JTextField();
		textField_3.setBounds(114, 132, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setTransferHandler(null); // disable copy&paste actions

		// prevent text values
		textField_3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});

		JLabel lblExperience = new JLabel("Experience");
		lblExperience.setBounds(31, 135, 46, 14);
		contentPane.add(lblExperience);

		JLabel lblYears = new JLabel("years");
		lblYears.setBounds(210, 135, 46, 14);
		contentPane.add(lblYears);

		dateChooser.setBounds(114, 163, 91, 20);
		contentPane.add(dateChooser);

		JLabel lblage = new JLabel("Age");
		lblage.setBounds(31, 169, 46, 14);
		contentPane.add(lblage);
	}
}
