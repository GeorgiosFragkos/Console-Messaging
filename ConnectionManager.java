/**
 * 
 */
package consoleProject;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.util.Scanner;
/**
 * @author georg
 *
 */
public class ConnectionManager {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String USERNAME = null;
    private static String PASS = null;
    private static final String MYSQLURL = "jdbc:mysql://localhost/messaging?useSSL=false";
    private static Connection con = null;
    private static Scanner scanForInput = new Scanner(System.in);
    private static byte tries=0;
    private static final byte maxTries=3;
    private static String LOGGED_IN_USER = null;
    private static ConnectionManager instance = null;
	/**
	 * 
	 */
	private ConnectionManager() {
		// TODO Auto-generated constructor stub
	}
	
	public static ConnectionManager getInstance( ) {
		if(instance == null) {
	         instance = new ConnectionManager();
		}
		return instance;
	}

	protected static Connection Connect() {
		/*Properties props = new Properties();
		try {
			FileInputStream in = new FileInputStream("db.properties");
			props.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		try {
			try {
				//JDBC_DRIVER = props.getProperty("db.driver");
				Class.forName(JDBC_DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			//MYSQLURL = props.getProperty("db.url");
            con = DriverManager.getConnection(MYSQLURL, getUSERNAME(), getPASS());
            LOGGED_IN_USER = USERNAME;
            System.out.println("Connecting...");
            System.out.println("Welcome user '"+LOGGED_IN_USER+"'!\n");
        } catch (SQLException ex) {
            //Logger.getLogger(ConnectionManager.class.getName()).log(Level.INFO, "Access denied", ex);
            System.out.println("\n error code: "+ex.getErrorCode());
            System.out.println(ex.getMessage());
            if(ex.getErrorCode()==1045) {
            	tries+=1;
            	if(tries<maxTries) {
            		System.out.println("Please try again.\n");
            		Connect();
            	}
            	else if (tries==maxTries) {
            		System.out.println("You have reached maximum permitted attempts.\nThe application will terminate now. Bye!");
            		System.exit(1);
            	}
            }
            
        }//end of catch  
		//scanForInput.close();
		return con;
	}//end of Connect() method
	
	protected static void Disconnect() {
		if (con != null) {
            try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
	}//end of method Disconnect

	private static String getUSERNAME() {
		System.out.println("Remaining attempts:"+(maxTries-tries));
		System.out.println("Give a username: ");
		USERNAME= scanForInput.nextLine();
		return USERNAME;
	}

	private static String getPASS() {
		System.out.println("Give a password: ");
		PASS = scanForInput.nextLine();
		return PASS;
	}

	protected static String getLOGGED_IN_USER() {
		return LOGGED_IN_USER;
	}

	protected static Connection getCon() {
		return con;
	}
	
}//end of class ConnectionManager
