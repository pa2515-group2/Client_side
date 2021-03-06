package UI;

import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import org.json.simple.JSONObject;

import java.awt.Component;
import javax.swing.JPasswordField;

public class Login extends javax.swing.JFrame {

	public static String personType;
	private ServerCode sc;

	/**
	 * Creates new form WelcomeLogin
	 */
	public Login() {
		sc = new ServerCode();
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		initComponents();

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		jTextField2 = new javax.swing.JTextField();
		jComboBox1 = new javax.swing.JComboBox<>();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jComboBox1.setFont(new java.awt.Font("å®‹ä½“", 0, 14)); // NOI18N
		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doctor", "Patient", "Manager" }));

		jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton4.setText("Register");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton5.setText("Login");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				int response = -1;
				JSONObject obj = new JSONObject();
				obj.put("username", jTextField2.getText());
				obj.put("password", passwordField.getText());
				// response=sc.PostData(obj
				// ,"/v1/auth/"+jComboBox1.getSelectedItem);//reponse
				// System.out.println("obj"+obj+"\n
				// path"+"/v1/auth/"+jComboBox1.getSelectedItem());
				response = sc.PostData(obj, "http://localhost:8080/Server/Test", "Login",
						jComboBox1.getSelectedItem().toString());// reponse
				System.out.println("response : "+ response+" token "+ Client.authToken);
				if (jComboBox1.getSelectedItem() == "Manager" && response == 1) {

					dispose();
					personType = "Manager";
					hmsSelection frame = new hmsSelection(personType);
					frame.setVisible(true);
				}

				else if (jComboBox1.getSelectedItem() == "Doctor" && response==1) {

					dispose();
					personType = "Doctor";
					hmsSelection frame = new hmsSelection(personType);
					frame.setVisible(true);
				}

				else if (jComboBox1.getSelectedItem() == "Patient" && response==1) {

					dispose();
					personType = "Patient";
					hmsSelection frame = new hmsSelection(personType);
					frame.setVisible(true);
				}

				else {
					passwordField.setText("");
					jTextField2.setText("");
					JOptionPane.showMessageDialog(getParent(), "Invalid user name or password!");
				}

			}

		});

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel1.setText("User Name :");

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel2.setText("Role           :");

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel3.setText("Password   :");

		jLabel4.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
		jLabel4.setText("Welcome");

		passwordField = new JPasswordField();

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap(103, Short.MAX_VALUE)
						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE).addGap(95))
				.addGroup(layout.createSequentialGroup().addGap(61)
						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(layout.createSequentialGroup().addComponent(jButton4).addPreferredGap(
										ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton5))
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(jLabel3).addComponent(jLabel2))
								.addGap(38)
								.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(passwordField)
										.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(jTextField2, GroupLayout.DEFAULT_SIZE, 138,
														Short.MAX_VALUE)
												.addComponent(jComboBox1, 0, 138, Short.MAX_VALUE)))))
						.addContainerGap(73, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE).addGap(28)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addGap(7)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addGap(35)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jButton4).addComponent(jButton5))
				.addGap(38)));
		layout.linkSize(SwingConstants.VERTICAL, new Component[] { jLabel1, jLabel2, jLabel3 });
		layout.linkSize(SwingConstants.VERTICAL, new Component[] { jTextField2, jComboBox1, jButton4, jButton5 });
		layout.linkSize(SwingConstants.HORIZONTAL, new Component[] { jButton4, jButton5 });
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton4ActionPerformed

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton5ActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JTextField jTextField2;
	private JPasswordField passwordField;
}
