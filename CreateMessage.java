package consoleProject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author georg
 *
 */
public class CreateMessage {
	
	private PreparedStatement stmt = null;
	private String sql = null;
	private ResultSet rs = null;
	private Scanner scan = new Scanner(System.in);
	private static Message message = new Message();
	private Statement statement = null;
	private int senderID;
	private int receiverID;

	/**
	 * 
	 */
	public CreateMessage() {
		// TODO Auto-generated constructor stub
	}
	
	public void CreateMessageExec() {
			
		   try{
		      sql = "INSERT INTO messages (senderID,receiverID,subm_date,msg_body) VALUES (?,?,?,?);";
		      stmt = ConnectionManager.getCon().prepareStatement(sql);
		      stmt.setInt(1,getSenderID());
		      stmt.setInt(2,getReceiverID());
		      String subm_date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		      stmt.setString(3, subm_date);
		      setMessageBody();
		      stmt.setString(4, message.getText());
		      int i=stmt.executeUpdate();
		      System.out.println("Creating messageee...");
		      System.out.println(i+" records inserted");
		      stmt.close();
		   }catch(SQLException ex){
			 //Logger.getLogger(ConnectionManager.class.getName()).log(Level.INFO, "Access denied", ex);
	            System.out.println("\n error code: "+ex.getErrorCode());
	            System.out.println(ex.getMessage());
	            /*if(ex.getErrorCode()==1396) {
	            	System.out.println("User already exists.");
	            	CreateMessageExec();
	            }*/
			   //se.printStackTrace();
		   }catch(Exception e){
			   //Handle errors for Class.forName
			   e.printStackTrace();
		   }finally{
			scan.close();
			ConnectionManager.Disconnect();
		   }//end try
	   System.out.println("Goodbye!");
		
	}
	
	public int getSenderID() {
		try{
			  //System.out.println("Creating statement...");
		      statement = ConnectionManager.getCon().createStatement();
		      message.setSender(ConnectionManager.getLOGGED_IN_USER());
		      String sql = "SELECT id FROM users WHERE username='" + message.getSender() + "';";
		      rs = statement.executeQuery(sql);
		      while(rs.next()){	
			         //Retrieve by column name
			         senderID  = rs.getInt("id");
			         //Display values
			         //System.out.print("sender ID: " + senderID);
		      }
		      rs.close();
		      //statement.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //ConnectionManager.Disconnect();
		   }//end try
		return senderID;
	}
	
	public int getReceiverID() {
		try{
			  //System.out.println("Creating statement...");
		      statement = ConnectionManager.getCon().createStatement();
		      message.setReceiver(UserMenu.recipientScreen());
		      String sql = "SELECT id FROM users WHERE username='"+message.getReceiver()+"';";
		      rs = statement.executeQuery(sql);
		      while(rs.next()){	
			         //Retrieve by column name
			         receiverID  = rs.getInt("id");
			         //Display values
			         //System.out.print("recipient ID: " + receiverID);
		      }
		      rs.close();
		      //statement.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //ConnectionManager.Disconnect();
		   }//end try
		return receiverID;
	}
	
	public void setMessageBody() {
				message.setText(UserMenu.messageScreen());
	}

}
