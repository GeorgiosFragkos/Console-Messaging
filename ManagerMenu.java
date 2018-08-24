/**
 * 
 */
package consoleProject;

/**
 * @author georg
 *
 */
public class ManagerMenu {

	private static ManagerMenu instance;
	/**
	 * 
	 */
	private ManagerMenu() {
		// TODO Auto-generated constructor stub
	}

	public static ManagerMenu getInstance( ) {
		if(instance == null) {
	         instance = new ManagerMenu();
		}
		return instance;
	}
	
	protected static void mainScreen() {
		System.out.println("Hello "+ConnectionManager.getLOGGED_IN_USER());
		System.out.println("Choose an action:");
		System.out.println("To create a new message,type: new");
		System.out.println("To view existing messages,type: view");
		System.out.println("To edit existing messages,type: edit");
		System.out.println("To delete existing messages,type: delete");
	}
	
}
