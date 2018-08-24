package consoleProject;

/*
*import java.io.File;
*import java.io.FileWriter;
*import java.io.IOException;
*import java.util.Scanner;
*/

public class Message {

	private String sender;
	private String receiver;
	private static final int capacity=250;
	private String dateOfSubmission;
	private String Text;
	
	public Message() {
		
	}
	
	public Message(String sender, String receiver, String dateOfSubmission, String Text) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.dateOfSubmission = dateOfSubmission;
		this.Text=Text;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getDateOfSubmission() {
		return dateOfSubmission;
	}

	public void setDateOfSubmission(String dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	/*public void createMsg() {
		Scanner filenameScanner= new Scanner(System.in);
		System.out.println("Who do you want to message: ");
		receiver=filenameScanner.nextLine();
		Message newMsg=new Message(sender, receiver, "dateOfSubmission", Text);
		File file = new File(sender+"_"+receiver+".txt") ;
		File fileR = new File(receiver+"_"+sender+".txt") ;
		//("Repository.class.getResource(file).getPath()");
		//Create the file
		filenameScanner.close();
		try {
			if (!file.exists() && !fileR.exists()) {
				file.createNewFile();
				System.out.println("File is created!");
			}else{
				System.out.println("File already exists.");
			}
			
			Scanner textScanner= new Scanner(System.in);
			System.out.println("Your message(to send it when done,press enter): ");
			Text=textScanner.nextLine();
			
			FileWriter out;
			if (file.exists()) {
				out=new FileWriter(file);
				out.append(Text);
				out.close();
			}
			else if (fileR.exists()) {
				out=new FileWriter(fileR);
				out.append(Text);
				out.close();
			}
			textScanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}*/
	
	public void saveMsg() {
		//save the text message to the existing file

	}
	
	public void viewSavedMsg() {
		//load the message according to username input
	}

}
