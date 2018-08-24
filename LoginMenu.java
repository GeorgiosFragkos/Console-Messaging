/**
 * 
 */
package consoleProject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//import java.util.Scanner;

/**
 * @author georg
 *
 */
public class LoginMenu {

	private String menuInput;
	private Scanner input=new Scanner(System.in);
	private static LoginMenu instance;
	private PreparedStatement stmt = null;
	private String sql = null;
	private ResultSet rs = null;
	private String role;

	/**
	 * 
	 */
	private LoginMenu() {
		// TODO Auto-generated constructor stub
	}
	
	public static LoginMenu getInstance( ) {
		if(instance == null) {
	         instance = new LoginMenu();
		}
		return instance;
	}
	
	public void loginScreen() {
		System.out.println("-----------------------------------------");
		System.out.println("--------<Messenger Application>----------");
		System.out.println("-----------------------------------------");
		menuChoice(getMenuInput());
		serveMenu(fetchURole());
		//validity check should take place here
	}
	
	private String getMenuInput() {
		System.out.println("----------Please select action:----------");
		System.out.println("--To login,type: login-------------------");
		System.out.println("--To terminate the application,type: exit");
		System.out.println("-----------------------------------------");
		menuInput=input.nextLine();
		return menuInput;
	}
	
	private void menuChoice(String menuInput) {
		switch(menuInput) {
		case "login": ConnectionManager.Connect();
					  fetchURole();
					  break;
		case "exit":  System.out.println("Goodbye!");
				 	  System.exit(1);
		default:	  System.out.println("Invalid typing.");
					  menuChoice(getMenuInput());
		}
		//input.close();
	}
	
	public String fetchURole() {
		try {
			sql = "SELECT role FROM users WHERE username = ?";
			stmt = ConnectionManager.getCon().prepareStatement(sql);
			stmt.setString(1,ConnectionManager.getLOGGED_IN_USER());
			rs = stmt.executeQuery();
			while(rs.next()){
			     //Retrieve by column name
			     role  = rs.getString("role");
			     //System.out.println("Role is: " + role);
			     //System.out.println(Roles.valueOf(role));
			     //role=Roles.SUADMIN.toString();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}
	
	public void serveMenu(String role) {
		switch(Roles.valueOf(role)) {
			case SUADMIN: 
				//SuAdmin.getInstance().setUsername(ConnectionManager.getLOGGED_IN_USER());
				SuAdminMenu.mainChoice(SuAdminMenu.mainScreen());
				break;
			case MANAGER: 
				Manager sessionManager = new Manager(Roles.valueOf(role).toString(), ConnectionManager.getLOGGED_IN_USER());
				break;
			case SUPERVISOR: 
				Supervisor sessionSupervisor = new Supervisor(Roles.valueOf(role).toString(), ConnectionManager.getLOGGED_IN_USER());
				break;
			case USER: 
				//User.getInstance().setUsername(ConnectionManager.getLOGGED_IN_USER());
				UserMenu.processUserMenuChoice(UserMenu.mainScreen());
				break;
		}
	}
	
}
