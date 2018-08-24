package consoleProject;

public class SuAdmin extends Manager {
	
	private static SuAdmin instance;

	private SuAdmin(String role, String username) {
		super(role, username);
		// TODO Auto-generated constructor stub
	}
	
	public static SuAdmin getInstance( ) {
		if(instance == null) {
	         instance = new SuAdmin(getRole(), getUsername());
		}
		return instance;
	}

	public static void createUser() {
		CreateUser createUser=new CreateUser();
		createUser.CreateUserExec();
	}
	
	public static void deleteUser() {
		DeleteUser deleteUser=new DeleteUser();
		deleteUser.DeleteUserExec();
	}
	
	public void updateUser() {
		
	}
	
}
