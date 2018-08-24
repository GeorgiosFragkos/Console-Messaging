/**
 * 
 */
package consoleProject;

/**
 * import java.awt.Desktop;
 *import java.io.File;
 *import java.io.IOException;
 *
 */
public class RunDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoginMenu.getInstance().loginScreen();
		
		//SelectTest SelQ=new SelectTest();
		//SelQ.SelectExec();
	
		//DeleteUser deleteQTest=new DeleteUser();
		//deleteQTest.DeleteUserExec();
		
		//CreateUser createQTest=new CreateUser();
		//createQTest.CreateUserExec();
		
		//A way to open the text files containing the messages for editing with the default application
		/*File f = new File("C:\\Users\\georg\\Documents\\Javascript\\Second.js");
		try {
			Desktop.getDesktop().edit(f);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

}
