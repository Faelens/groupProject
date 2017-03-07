package groupProject;

import java.io.*;

public class WriteFile {



	public static void addCandidate(String logInName, String password, String name, String emailAddress, int fieldOfStudy, int experience, 
			int availability, boolean Dutch, boolean English, boolean German, boolean msOffice, boolean Javascript, boolean Sales, boolean Management) {

		/* 
		 * Fields in the TXT file:
		 * [0] userID;
		 * [1] logInName;
		 * [2] password;
		 * [3] name;
		 * [4] emailAdress;
		 * [5] fieldOfStudy;
		 * [6] experience;
		 * [7] availability;
		 * [8] Dutch;
		 * [9] English;
		 * [10] German;
		 * [11] MS Office;
		 * [12] Javascript;
		 * [13] Sales;
		 * [14] Management
		 */

		try {

			int nextUserID = getNextId("Candidates.txt");
			// Initialize users.txt as file to read
			PrintWriter wr = new PrintWriter(new BufferedWriter (new FileWriter("Candidates.txt", true)));						
			String newLine = nextUserID +"\t"+ logInName +"\t"+ password +"\t"+ name +"\t"+ emailAddress +"\t"+ fieldOfStudy +"\t"+ experience +"\t"+ 
					availability +"\t"+ Dutch +"\t"+ English +"\t"+ German +"\t"+ msOffice +"\t"+ Javascript +"\t"+ Sales +"\t"+ Management; 			 

			wr.println(newLine);
			wr.close();	
		} catch (IOException e) {
			e.printStackTrace();								// catches errors and shows where you can find the error
		}		
	}

	public static void addRecruiter(String logInName, String password, String name, String emailAddress, String company){

		/* 
		 * Fields in the TXT file:
		 * [0] userID;
		 * [1] logInName;
		 * [2] password;
		 * [3] name;
		 * [4] emailAddress;
		 * [5] company
		 */
		
		
		try {

			int nextUserID = getNextId("Recruiters.txt");
			// Initialize users.txt as file to read
			PrintWriter wr = new PrintWriter(new BufferedWriter (new FileWriter("Recruiters.txt", true)));						
			String newLine = (nextUserID + "\t" + logInName + "\t" + password + "\t" + name + "\t" + emailAddress + "\t" + company); 			 

			wr.println(newLine);
			wr.close();	
		} catch (IOException e) {
			e.printStackTrace();								// catches errors and shows where you can find the error
		}		
	}


	public static int getNextId(String txtfile) throws IOException{
		int nextUserID = 0;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(txtfile));		
			String sCurrentLine;

			String lastLine = null;
			String[] uLastLine = new String[15];

			while((sCurrentLine = br.readLine()) != null){	
				lastLine = sCurrentLine;
			}

			br.close();

			uLastLine = lastLine.split("\t");			
			int previousUserID = Integer.parseInt(uLastLine[0]);			
			nextUserID = previousUserID + 1;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	

		return nextUserID;
	}
}