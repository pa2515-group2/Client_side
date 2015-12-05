import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.json.simple.JSONObject;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import org.json.simple.JSONObject;

import com.toedter.calendar.JDateChooser;

public class PatientInfo extends JFrame {

	private JPanel contentPane;
	private JTextField txtFN;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JTextField txtLN;
	private JLabel lblBirthDate;
	private JLabel lblEmailId;
	private JTextField txtEid;
	private JLabel lblAddress;
	private JTextArea txtaAdd1;
	private JTextField txtH;
	private JTextField txtW;
	private JTextField txtO;
	private JLabel lblRefered;
	private JTextField txtRef;
	public String age;
	JDateChooser dateChooser = new JDateChooser();
	private email_validator eval;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { PatientInfo frame = new
	 * PatientInfo(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public PatientInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1170, 977);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtFN = new JTextField();
		txtFN.setText(" ");
		txtFN.setBounds(167, 58, 236, 39);
		contentPane.add(txtFN);
		txtFN.setColumns(10);

		// prevent numerical values
		txtFN.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < 'A') || (c > 'Z')) && ((c < 'a') || (c > 'z'))
						&& (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});

		JButton btnSend = new JButton("Send");
		btnSend.setBounds(893, 791, 171, 41);
		contentPane.add(btnSend);

		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(26, 61, 186, 33);
		contentPane.add(lblFirstName);

		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(449, 61, 186, 33);
		contentPane.add(lblLastName);

		txtLN = new JTextField();
		txtLN.setText(" ");
		txtLN.setColumns(10);
		txtLN.setBounds(624, 58, 236, 39);
		contentPane.add(txtLN);
		txtLN.setTransferHandler(null); // disable copy&paste actions

		// prevent numerical values
		txtLN.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < 'A') || (c > 'Z')) && ((c < 'a') || (c > 'z'))
						&& (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});

		lblBirthDate = new JLabel("Birth Date");
		lblBirthDate.setBounds(26, 149, 154, 33);
		contentPane.add(lblBirthDate);

		lblEmailId = new JLabel("E-mail id");
		lblEmailId.setBounds(26, 389, 115, 33);
		contentPane.add(lblEmailId);

		txtEid = new JTextField();
		txtEid.setText(" ");
		txtEid.setColumns(10);
		txtEid.setBounds(157, 386, 523, 39);
		contentPane.add(txtEid);
		txtEid.setTransferHandler(null); // disable copy&paste actions

		lblAddress = new JLabel("Address");
		lblAddress.setBounds(26, 457, 547, 33);
		contentPane.add(lblAddress);

		txtaAdd1 = new JTextArea();
		txtaAdd1.setBounds(141, 468, 390, 250);
		contentPane.add(txtaAdd1);

		ButtonGroup bg = new ButtonGroup();
		final JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setActionCommand("Male");
		rdbtnMale.setBounds(505, 149, 121, 41);
		contentPane.add(rdbtnMale);
		rdbtnMale.doClick();

		final JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setActionCommand("Female");
		rdbtnFemale.setBounds(624, 149, 136, 41);
		contentPane.add(rdbtnFemale);
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(393, 153, 115, 33);
		contentPane.add(lblGender);

		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(36, 232, 115, 33);
		contentPane.add(lblHeight);

		txtH = new JTextField();
		txtH.setBounds(141, 229, 50, 40);
		contentPane.add(txtH);
		txtH.setColumns(10);
		txtH.setTransferHandler(null); // disable copy&paste actions

		// prevent text values
		txtH.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});

		txtW = new JTextField();
		txtW.setColumns(10);
		txtW.setBounds(449, 226, 50, 40);
		contentPane.add(txtW);
		txtW.setTransferHandler(null); // disable copy&paste actions

		// prevent text values
		txtW.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});

		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(308, 229, 115, 33);
		contentPane.add(lblWeight);

		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setBounds(595, 235, 180, 33);
		contentPane.add(lblBloodGroup);

		JLabel lblCms = new JLabel("cms");
		lblCms.setBounds(195, 232, 64, 33);
		contentPane.add(lblCms);

		JLabel lblKgs = new JLabel("Kgs");
		lblKgs.setBounds(505, 232, 50, 33);
		contentPane.add(lblKgs);

		final JComboBox comboBldGrp = new JComboBox(
				new String[] { "O +ve", "O -ve", "A +ve", "A -ve", "B +ve",
						"B -ve", "AB +ve", "AB -ve" });
		comboBldGrp.setBounds(778, 232, 111, 39);
		contentPane.add(comboBldGrp);

		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setBounds(706, 389, 145, 33);
		contentPane.add(lblOccupation);

		txtO = new JTextField();
		txtO.setText(" ");
		txtO.setColumns(10);
		txtO.setBounds(851, 386, 236, 39);
		contentPane.add(txtO);
		txtO.setTransferHandler(null); // disable copy&paste actions

		// prevent numerical values
		txtO.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < 'A') || (c > 'Z')) && ((c < 'a') || (c > 'z'))
						&& (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});

		JLabel lblMaritalStatus = new JLabel("Marital Status");
		lblMaritalStatus.setBounds(470, 319, 186, 33);
		contentPane.add(lblMaritalStatus);

		final JComboBox comboMarSts = new JComboBox(
				new String[] { "yes", "no" });
		comboMarSts.setBounds(647, 316, 111, 39);
		comboMarSts.setEnabled(true);
		contentPane.add(comboMarSts);

		lblRefered = new JLabel("Refered");
		lblRefered.setBounds(26, 322, 186, 33);
		contentPane.add(lblRefered);

		txtRef = new JTextField();
		txtRef.setText(" ");
		txtRef.setColumns(10);
		txtRef.setBounds(167, 319, 236, 39);
		contentPane.add(txtRef);
		txtRef.setTransferHandler(null); // disable copy&paste actions

		// prevent numerical values
		txtRef.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < 'A') || (c > 'Z')) && ((c < 'a') || (c > 'z'))
						&& (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					getToolkit().beep();
				}
			}
		});

		final JTextArea txtaAdd2 = new JTextArea();
		txtaAdd2.setBounds(672, 468, 390, 250);
		contentPane.add(txtaAdd2);

		JLabel label = new JLabel("Address");
		label.setBounds(557, 457, 547, 33);
		contentPane.add(label);

		dateChooser.setBounds(177, 149, 181, 39);
		contentPane.add(dateChooser);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtFN.setText("");
				txtLN.setText("");
				txtH.setText("");
				txtW.setText("");
				txtRef.setText("");
				txtEid.setText("");
				txtO.setText("");
				txtaAdd1.setText("");
				txtaAdd2.setText("");
				rdbtnMale.doClick();
				dateChooser.setDate(null);
				comboBldGrp.setSelectedIndex(1);
			}
		});
		btnReset.setBounds(689, 791, 171, 41);
		contentPane.add(btnReset);

		btnSend.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					eval = new email_validator();

					SimpleDateFormat dateformat = new SimpleDateFormat(
							"dd/MM/yyyy");
					Date d = dateChooser.getDate();

					// If date is not given throw an exception to the user
					if (d == null || txtFN.getText().equals("")
							|| txtLN.getText().equals("")
							|| txtH.getText().equals("")
							|| txtW.getText().equals("")
							|| txtO.getText().equals("")
							|| txtaAdd1.getText().equals("")
							|| txtRef.getText().equals("")
							|| txtEid.getText().equals(""))
						throw new RuntimeException(
								"Enter the missing informations!");

					else {

						boolean valid = eval.validate(txtEid.getText());

						if (valid) {

							age = dateformat.format(d);
							System.out.println(age);

							JSONObject obj = new JSONObject();
							obj.put("firstname", txtFN.getText());
							obj.put("lastname", txtLN.getText());
							obj.put("Bdate", age);
							if (rdbtnMale.isSelected())
								obj.put("gender", rdbtnMale.getActionCommand());
							else if (rdbtnFemale.isSelected())
								obj.put("gender", rdbtnMale.getActionCommand());
							obj.put("height", txtH.getText());
							obj.put("weight", txtW.getText());
							obj.put("blgGrp", comboBldGrp.getSelectedItem()
									.toString());
							obj.put("refBy", txtRef.getText());
							obj.put("mStatus", comboMarSts.getSelectedItem()
									.toString());
							obj.put("eid", txtEid.getText());
							obj.put("occupation", txtO.getText());
							obj.put("Address", txtaAdd1.getText());

							System.out.println(obj);
						} else {
							throw new RuntimeException(
									"E-mail address is not right!");
						}
					}
				}

				catch (RuntimeException e5) {
					JOptionPane.showMessageDialog(null, e5, "Error",
							JOptionPane.ERROR_MESSAGE);

				} catch (Exception e1) {
					System.out.println("Exception caught:" + e1);
				}

			}

		});
	}

}
