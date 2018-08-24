package consoleProject;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author georg
 *
 */
public class CreateUser {
	
	private PreparedStatement stmt = null;
	private Scanner scan = new Scanner(System.in);
	private String uName;
	private String uPass;
	private String uRole;

	/**
	 * 
	 */
	public CreateUser() {
		// TODO Auto-generated constructor stub
	}
	
	public void CreateUserExec() {
		
		   try{
		      //STEP 4: Execute a query
			  
		      String sql = "CREATE USER ? @'localhost' IDENTIFIED BY ?;";
		      stmt = ConnectionManager.getCon().prepareStatement(sql);
		    	//"DROP USER 'newuser'@'localhost';";
		    	//"REVOKE SELECT ON semester.student FROM 'newuser'@'localhost';";
		    	//"GRANT SELECT ON semester.student TO 'newuser'@'localhost';";
		      	//String sql = "INSERT studentbackup SELECT * FROM student;";
		      getParamsIn();
		      int i=stmt.executeUpdate();
		      switch(uRole) {
		      	case "USER": sql = "GRANT SELECT,INSERT ON messaging.* TO ? @'localhost';";
		      		stmt = ConnectionManager.getCon().prepareStatement(sql);
		      		stmt.setString(1,uName);
		      		i=stmt.executeUpdate();
		      		break;
		      	case "SUPERVISOR": sql = "GRANT SELECT,UPDATE,INSERT ON messaging.* TO ? @'localhost';";
		      		stmt = ConnectionManager.getCon().prepareStatement(sql);
		      		stmt.setString(1,uName);
		      		i=stmt.executeUpdate();
		      		break;
		      	case "MANAGER": sql = "GRANT SELECT,UPDATE,DELETE,INSERT ON messaging.* TO ? @'localhost';";
		      		stmt = ConnectionManager.getCon().prepareStatement(sql);
		      		stmt.setString(1,uName);
		      		i=stmt.executeUpdate();
		      		break;
		      	default: break;
		      }
		      sql = "INSERT INTO messaging.users (username,password,role) VALUES (?,?,?);";
		      stmt = ConnectionManager.getCon().prepareStatement(sql);
		      stmt.setString(1, uName);
		      stmt.setString(2, uPass);
		      stmt.setString(3, uRole);
		      i=stmt.executeUpdate();
		      System.out.println("Creating user...");
		      System.out.println(i+" records inserted");  
		      //stmt.executeUpdate(sql);
		      stmt.close();
		   }catch(SQLException ex){
			   //Handle errors for JDBC
			 //Logger.getLogger(ConnectionManager.class.getName()).log(Level.INFO, "Access denied", ex);
	            System.out.println("\n error code: "+ex.getErrorCode());
	            System.out.println(ex.getMessage());
	            if(ex.getErrorCode()==1396) {
	            	System.out.println("User already exists.");
	            	CreateUserExec();
	            }
			   //se.printStackTrace();
		   }catch(Exception e){
			   //Handle errors for Class.forName
			   e.printStackTrace();
		   }finally{
			//scan.close();
			//ConnectionManager.Disconnect();
		   }//end try
		   LoginMenu.getInstance().serveMenu(LoginMenu.getInstance().fetchURole());
	   //System.out.println("Goodbye!");
		
	}
	
	public void getParamsIn() {
		try {
			System.out.println("user to create?");
			uName = scan.nextLine();
			stmt.setString(1,uName); 
			System.out.println("password for "+uName+"?");
			uPass = scan.nextLine();
			stmt.setString(2,uPass); 
			System.out.println("role for "+uName+"? (in CAPITALS)");
			uRole = scan.nextLine();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
