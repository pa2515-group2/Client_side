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
public class Edit_doctors_info extends JFrame {

	public String[] profession = { "Surgeon", "Neurologist", "Physician",
			"Dermatologist", "Gynecologist", "Radiologist" };
	public String[] gender = { "Male", "Female" };
	public String[] doctor_IDs = {  };
	public String doctorID, firstname, lastname, qualification, experience, age;

//	private static JTextField textFirstname;
	private static JTextField textDoctorid;
	private static JTextField textLastname;
	private static JTextField textFirstname;
	private static JTextField textExperience;
	private JPanel contentPane;

	JDateChooser dateChooser = new JDateChooser();
	JComboBox comboBox_1 = new JComboBox(gender);
	JComboBox comboBox = new JComboBox(profession);
	JComboBox doctorIDs = new JComboBox(doctor_IDs);

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Doctors_info frame = new Doctors_info();
//					frame.setVisible(true);
//
//				} catch (Exception e) {
//					System.out.println("Exception caught:" + e);
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Edit_doctors_info() {
		final ServerCode sc = new ServerCode();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//		JButton btnGet = new JButton("Get");
//		btnGet.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					// Getting the values written in text fields
//					firstname = textDoctorid.getText();
//					lastname = textLastname.getText();
//					qualification = textFirstname.getText();
//					experience = textExperience.getText();
//
//					SimpleDateFormat dateformat = new SimpleDateFormat(
//							"dd/MM/yyyy");
//					Date d = dateChooser.getDate();
//
//					// If date is not given throw an exception to the user
//					if (firstname.equals("") || lastname.equals("")
//							|| qualification.equals("")
//							|| experience.equals("") || d == null)
//						throw new RuntimeException();
//
//					else {
//						age = dateformat.format(d);
//						//System.out.println(age);
//
//						// Encoding values into a JSON object
//						JSONObject obj = new JSONObject();
//
//						obj.put("first_name", firstname);
//						obj.put("last_name", lastname);
//						obj.put("qualification", qualification);
//						obj.put("experience", experience);
//						obj.put("age", age);
//						obj.put("gender", comboBox_1.getSelectedItem()
//								.toString());
//						obj.put("profession", comboBox.getSelectedItem()
//								.toString());
//
//						// Printing JSON object in string format for testing
//						System.out.println(obj);
//						sc.PostData(obj, "http://localhost:8080/Server/Test","Edit_doctors_info","");
//					}
//				}
//
//				catch (RuntimeException e5) {
//					// JOptionPane.showMessageDialog(null, e5, "Error",
//					// JOptionPane.ERROR_MESSAGE);
//					JOptionPane.showMessageDialog(getParent(),
//							"Enter the missing informations!");
//
//				} catch (Exception e1) {
//					// System.out.println("Exception caught:" + e1);
//					JOptionPane.showMessageDialog(getParent(),
//							"Exception caught: " + e1);
//				}
//			}
//		});
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Getting the values written in text fields
//					doctorID = textFirstname.getText();
					doctorID = textDoctorid.getText();
					lastname = textLastname.getText();
//					qualification = textField_2.getText();
					firstname = textFirstname.getText();
					experience = textExperience.getText();

					SimpleDateFormat dateformat = new SimpleDateFormat(
							"dd/MM/yyyy");
					Date d = dateChooser.getDate();

					// If date is not given throw an exception to the user
					if (firstname.equals("") || lastname.equals("")
							|| doctorID.equals("")
							|| experience.equals("") || d == null)
						throw new RuntimeException();

					else {
						age = dateformat.format(d);
						//System.out.println(age);

						// Encoding values into a JSON object
						JSONObject obj = new JSONObject();

						obj.put("doctorid", doctorID);
						obj.put("first_name", firstname);
						obj.put("last_name", lastname);
//						obj.put("qualification", qualification);
						obj.put("experience", experience);
						obj.put("age", age);
						obj.put("gender", comboBox_1.getSelectedItem()
								.toString());
						obj.put("profession", comboBox.getSelectedItem()
								.toString());

						// Printing JSON object in string format for testing
						System.out.println(obj);
						sc.PutData(obj, ServerCode.URL_PREFIX+"doctor/"+doctorID,"Edit_doctors_info","");
					}
				}

				catch (RuntimeException e5) {
					// JOptionPane.showMessageDialog(null, e5, "Error",
					// JOptionPane.ERROR_MESSAGE);
					JOptionPane.showMessageDialog(getParent(),
							"Enter the missing informations!");

				} catch (Exception e1) {
					// System.out.println("Exception caught:" + e1);
					JOptionPane.showMessageDialog(getParent(),
							"Exception caught: " + e1);
				}
			}
		});

		btnNewButton.setBounds(264, 234, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnReturn = new JButton("Return");
//		btnReturn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//				textFirstname.setText("");
//				textDoctorid.setText("");
//				textLastname.setText("");
//				textFirstname.setText("");
//				textExperience.setText("");
//				dateChooser.setDate(null);
//			}
//		});
		

		btnReturn.setBounds(10, 234, 89, 23);
		contentPane.add(btnReturn);

		btnReturn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {


				// response=sc.PostData(obj
				// ,"/v1/auth/"+jComboBox1.getSelectedItem);//reponse
				// System.out.println("obj"+obj+"\n
				// path"+"/v1/auth/"+jComboBox1.getSelectedItem());
//				response = sc.PostData(obj, "http://localhost:8080/Server/Test", "Login",
//						jComboBox1.getSelectedItem().toString());// reponse
				String role = Client.role;
				if (role == "Manager")
					role = "admin";
				else
					role = role.toLowerCase();

				System.out.println("role: "+role);
				if (role == "admin") {

					dispose();
					hmsSelection frame = new hmsSelection("Manager");
					frame.setVisible(true);
				}

				else if (role == "doctor") {

					dispose();
					hmsSelection frame = new hmsSelection("Doctor");
					frame.setVisible(true);
				}
				else if (role == "patient") {

					dispose();
					hmsSelection frame = new hmsSelection("Patient");
					frame.setVisible(true);
				}
			}
		});
		
		
//		textFirstname = new JTextField();
//		textFirstname.setBounds(67, 5, 120, 31);
//		contentPane.add(textFirstname);
//		textFirstname.setColumns(10);
//		textFirstname.setTransferHandler(null); // disable copy&paste actions
		
		textDoctorid = new JTextField();
		textDoctorid.setBounds(87, 11, 120, 31);
		contentPane.add(textDoctorid);
		textDoctorid.setColumns(10);
		textDoctorid.setTransferHandler(null); // disable copy&paste actions

		// prevent numerical values
//		textDoctorid.addKeyListener(new KeyAdapter() {
//			public void keyTyped(KeyEvent e) {
//				char c = e.getKeyChar();
//				if (((c < 'A') || (c > 'Z')) && ((c < 'a') || (c > 'z'))
//						&& (c != KeyEvent.VK_BACK_SPACE)) {
//					e.consume();
//					getToolkit().beep();
//				}
//			}
//		});

		JList list = new JList();
		list.setBounds(155, 123, 67, -14);
		contentPane.add(list);

		comboBox.setBounds(226, 11, 127, 20);
		contentPane.add(comboBox);

		textLastname = new JTextField();
		textLastname.setBounds(87, 53, 120, 30);
		contentPane.add(textLastname);
		
		textLastname.setColumns(10);
		textLastname.setTransferHandler(null); // disable copy&paste actions

		// prevent numerical values
		textLastname.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < 'A') || (c > 'Z')) && ((c < 'a') || (c > 'z'))
						&& (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});

		JLabel lblFirstName = new JLabel("First name:");
//		lblFirstName.setBounds(10, 19, 67, 14);
		lblFirstName.setBounds(10, 102, 89, 14);
	
		contentPane.add(lblFirstName);

		JLabel lblNewLabel = new JLabel("Last name");
		lblNewLabel.setBounds(10, 61, 67, 14);
		contentPane.add(lblNewLabel);

//		comboBox_1.setBounds(226, 42, 127, 20);
//		contentPane.add(comboBox_1);

		textFirstname = new JTextField();
		textFirstname.setBounds(87, 94, 120, 31);
		contentPane.add(textFirstname);
		textFirstname.setColumns(10);
		textFirstname.setTransferHandler(null); // disable copy&paste actions

		// prevent numerical values
		textFirstname.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < 'A') || (c > 'Z')) && ((c < 'a') || (c > 'z'))
						&& (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});

		JLabel lblQualification = new JLabel("Doctor ID");
//		lblQualification.setBounds(10, 102, 89, 14);
		lblQualification.setBounds(10, 19, 67, 14);
		contentPane.add(lblQualification);

		textExperience = new JTextField();
		textExperience.setBounds(87, 133, 120, 31);
		contentPane.add(textExperience);
		textExperience.setColumns(10);
		textExperience.setTransferHandler(null); // disable copy&paste actions

		// prevent text values
		textExperience.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});

		JLabel lblExperience = new JLabel("Experience");
		lblExperience.setBounds(10, 141, 67, 14);
		contentPane.add(lblExperience);

		dateChooser.setBounds(87, 177, 120, 31);
		contentPane.add(dateChooser);

		JLabel lblage = new JLabel("Birth Date");
		lblage.setBounds(10, 177, 67, 14);
		contentPane.add(lblage);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(141, 234, 89, 23);
		contentPane.add(btnDelete);
		
		JComboBox doctorIDs = new JComboBox();
		doctorIDs.setBounds(238, 150, 115, 20);
		contentPane.add(doctorIDs);
		
		JButton btnShowDoctor = new JButton("Show doctor");
		btnShowDoctor.setBounds(238, 185, 115, 23);
		contentPane.add(btnShowDoctor);
	}
}
