/**
 * 
 */
package consoleProject;

import java.util.Scanner;

/**
 * @author georg
 *
 */
public class UserMenu {
	
	private static String menuInput;
	private static Scanner input=new Scanner(System.in);
	private static UserMenu instance;
	private static String recipient;
	private static String messageBody;
	/**
	 * 
	 */
	private UserMenu() {
		// TODO Auto-generated constructor stub
	}
	
	public static UserMenu getInstance( ) {
		if(instance == null) {
	         instance = new UserMenu();
		}
		return instance;
	}
	
	protected static String mainScreen() {
		System.out.println("Hello "+ConnectionManager.getLOGGED_IN_USER());
		System.out.println("Choose an action:");
		System.out.println("To create a new message,type: new");
		System.out.println("To view existing messages,type: view");
		menuInput=input.nextLine();
		return menuInput;
	}

	public static void processUserMenuChoice(String menuinput) {
		System.out.println("Creating New Message...");
		switch(menuInput) {
			case "new": 
				recipientScreen();
				messageScreen();
				User.createMsg();
				break;
			case "view":  
				
				break;
			default:	  
				System.out.println("Invalid typing.");
				processUserMenuChoice(menuInput);
		}
	}
	
	public static String recipientScreen() {
		System.out.println("Type the recipient:");
		menuInput=input.nextLine();
		recipient=menuInput;
		return recipient;
	}
	
	public static String messageScreen() {
		System.out.println("Type the message (max.250 chars) :");
		menuInput=input.nextLine();
		messageBody=menuInput;
		return messageBody;
	}
	
	public static String viewMessages() {
		
		return "";
	}
	
}
