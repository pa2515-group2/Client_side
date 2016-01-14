package UI;

public class Client {

	public static String authToken="2636548610c64ec8a0fafcc4ac426b61";
	public static String role="admin";
	public static void main(String[] args) {
//		Edit_appointment e=new Edit_appointment();
//		e.setVisible(true);
		
//		UI.Login login = new UI.Login();
//		login.setVisible(true);
		
		
		/*
		 * 
							 * Login l=new Login(); l.setVisible(true);
							 */

		/*
		 * //Doctors_info frame = new Doctors_info(); //frame.setVisible(true);
		 */ System.out.println("Client main() :) :) :) :) :)");
		 
		 switch (7) {
			case 0:
				
				UI.Book_app frame = new UI.Book_app();
				frame.setVisible(true);
				break;
			case 1:
				UI.PatientInfo frame2 = new UI.PatientInfo();
				frame2.setVisible(true);
				break;
			case 2:
				UI.Doctors_info frame3 = new UI.Doctors_info();
				frame3.setVisible(true);
				break;
			case 3:
				UI.discharge frame4 = new UI.discharge();
				frame4.setVisible(true);
				break;
				
			case 4:
				UI.Edit_doctors_info frame5 = new UI.Edit_doctors_info();
				frame5.setVisible(true);
				break;
				
			case 5:
				UI.Edit_patientInfo frame6 = new UI.Edit_patientInfo();
				frame6.setVisible(true);
				break;
				
			case 6:
				UI.Edit_appointment frame7 = new UI.Edit_appointment();
				frame7.setVisible(true);
				break;
			case 7:
				UI.Login l = new UI.Login();
				l.setVisible(true);
				break;
				
			default:
				System.out.println("Error message");
			}
		 
	}
     public String getToken(){
    	return authToken;
    }
}
