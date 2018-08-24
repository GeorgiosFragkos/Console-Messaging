/**
 * 
 */
package consoleProject;

import java.util.Scanner;

/**
 * @author georg
 *
 */
public class SuAdminMenu {

	private static String menuInput;
	private static Scanner input=new Scanner(System.in);
	private static SuAdminMenu instance;
	/**
	 * 
	 */
	private SuAdminMenu() {
		// TODO Auto-generated constructor stub
	}
	
	public static SuAdminMenu getInstance( ) {
		if(instance == null) {
	         instance = new SuAdminMenu();
		}
		return instance;
	}
	
	public static String mainScreen() {
		System.out.println("Hello "+ConnectionManager.getLOGGED_IN_USER());
		System.out.println("Choose an action:");
		System.out.println("To process users,type: users");
		System.out.println("To process messages,type: messages");
		System.out.println("To logout,type: logout");
		menuInput=input.nextLine();
		return menuInput;
	}
	
	public static void mainChoice(String menuInput) {
		switch(menuInput) {
		case "users": 
			processUsersChoice(processUsersScreen());
			break;
		case "messages":
			processMessagesChoice(processMessagesScreen());
			break;
		case "logout":
			ConnectionManager.Disconnect();
			LoginMenu.getInstance().loginScreen();
			break;
		default:	  
			System.out.println("Invalid typing.");
			mainChoice(mainScreen());
		}
	}
	
	public static String processUsersScreen() {
		System.out.println("Hello "+ConnectionManager.getLOGGED_IN_USER());
		System.out.println("Choose an action:");
		System.out.println("To create users,type: create");
		System.out.println("To update users,type: update");
		System.out.println("To delete users,type: delete");
		menuInput=input.nextLine();
		return menuInput;
	}
	
	public static void processUsersChoice(String menuinput) {
		System.out.println("Hello");
		switch(menuInput) {
			case "create": 
				SuAdmin.createUser();
				break;
			case "update":  
				break;
			case "delete":
				SuAdmin.deleteUser();
				break;
			default:	  
				System.out.println("Invalid typing.");
				processUsersChoice(menuInput);
		}
	}
	
	
	public static String processMessagesScreen() {
		System.out.println("Hello "+ConnectionManager.getLOGGED_IN_USER());
		System.out.println("Choose an action:");
		System.out.println("To compose a message,type: compose");
		System.out.println("To view messages,type: view");
		System.out.println("To delete messages,type: delete");
		menuInput=input.nextLine();
		return menuInput;
	}
	
	public static void processMessagesChoice(String menuinput) {
		System.out.println("Hello");
		switch(menuInput) {
			case "compose": 
				UserMenu.recipientScreen();
				UserMenu.messageScreen();
				User.createMsg();
				break;
			case "view":  
				break;
			case "delete":
				break;
			default:	  
				System.out.println("Invalid typing.");
				processMessagesChoice(menuInput);
		}
	}
	
}
