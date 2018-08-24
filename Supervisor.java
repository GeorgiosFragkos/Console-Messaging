package consoleProject;

public class Supervisor extends User {
	
	private static Supervisor instance;

	public Supervisor(String role, String username) {
		super(role, username);
	}
	
	public static Supervisor getInstance( ) {
		if(instance == null) {
	         instance = new Supervisor(getRole(), getUsername());
		}
		return instance;
	}

	public void editMsg() {
		
	}
	
}
