package consoleProject;

public class User {
	
	private static String role;
	private static String username;
	private String password;
	private static User instance;
	
	private User() {
		
	}
	
	protected User(String role, String username) {
		super();
		this.role = role;
		this.username = username;
	}

	public static User getInstance( ) {
		if(instance == null) {
	         instance = new User();
		}
		return instance;
	}


	public static String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public static void createMsg() {
		CreateMessage createMessage = new CreateMessage();
		createMessage.CreateMessageExec();
	}
	
	public static void viewMsg() {
		
	}
	
}
