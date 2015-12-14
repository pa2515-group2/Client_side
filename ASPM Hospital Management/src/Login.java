import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsrname;
	private JTextField txtPasswrd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		final int value=1;//0=doc >0=hms
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("USER NAME:");
		lblUserName.setBounds(36, 62, 162, 33);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(36, 123, 149, 33);
		contentPane.add(lblPassword);
		
		txtUsrname = new JTextField();
		txtUsrname.setForeground(Color.BLACK);
		txtUsrname.setBounds(204, 59, 236, 39);
		contentPane.add(txtUsrname);
		txtUsrname.setColumns(10);
		
		txtPasswrd = new JTextField();
		txtPasswrd.setBounds(204, 120, 236, 39);
		contentPane.add(txtPasswrd);
		txtPasswrd.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener(){
             
			@Override
			public void actionPerformed(ActionEvent e) {
			    dispose();	
				//Server code
				if(txtUsrname.getText().equals("test") && txtPasswrd.getText().equals("test"))
				{
					if(value==0)//response=="doctor")
					{
						//view appointment code
					}
					else
					{
						hmsSelection frame=new hmsSelection();
						frame.setVisible(true);
					}
				}
				else
				{
					txtUsrname.setText("");
					txtPasswrd.setText("");
					JOptionPane.showMessageDialog(getParent(), "invalid user name or password");
				}
					
			}
			
		});
		btnSubmit.setBounds(309, 203, 171, 41);
		contentPane.add(btnSubmit);
	}
}
