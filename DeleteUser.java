package consoleProject;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author georg
 *
 */
public class DeleteUser {
	
	PreparedStatement stmt = null;
	Scanner scan = new Scanner(System.in);
	String uName;
	String uPass;
	String uRole;

	/**
	 * 
	 */
	public DeleteUser() {
		// TODO Auto-generated constructor stub
	}
	
	public void DeleteUserExec() {
		
		   try{
		      //STEP 4: Execute a query
			  
		      String sql = "DROP USER ? @'localhost';";
		      stmt = ConnectionManager.getCon().prepareStatement(sql);
		    	//"DROP USER 'newuser'@'localhost';";
		    	//"REVOKE SELECT ON semester.student FROM 'newuser'@'localhost';";
		    	//"GRANT SELECT ON semester.student TO 'newuser'@'localhost';";
		      	//String sql = "INSERT studentbackup SELECT * FROM student;";
		      getParamsIn();
		      int i=stmt.executeUpdate();
		      sql = "DELETE FROM messaging.users WHERE username = ?;";
		      stmt = ConnectionManager.getCon().prepareStatement(sql);
		      stmt.setString(1, uName);
		      i=stmt.executeUpdate();
		      System.out.println("Deleting user...");
		      System.out.println(i+" records deleted");
		      stmt.close();
		   }catch(SQLException ex){
			   //Handle errors for JDBC
			 //Logger.getLogger(ConnectionManager.class.getName()).log(Level.INFO, "Access denied", ex);
	            System.out.println("\n error code: "+ex.getErrorCode());
	            System.out.println(ex.getMessage());
	            if(ex.getErrorCode()==1396) {
	            	System.out.println("Such a user does not exist.");
	            	DeleteUserExec();
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
			System.out.println("User to drop?");
			uName = scan.nextLine();
			stmt.setString(1,uName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
