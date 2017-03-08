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
	

	public static void updateCandidate(Candidate candidate) {
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
			String[] lines = new String[100];

			BufferedReader br = new BufferedReader(new FileReader("Candidates.txt"));			
			String sCurrentLine;
			String[] uCurrentLine = new String[15];
			
			int counter = 0;
			while((sCurrentLine = br.readLine()) != null){					
				uCurrentLine = sCurrentLine.split("\t");			
				// every time if statement not met, increment counter to know what line is read.
				if(Integer.parseInt(uCurrentLine[0]) == candidate.getUserID()){				
					sCurrentLine = uCurrentLine[0] +"\t"+ User.getLoginName() +"\t"+ User.getPassword() +"\t"+ User.getName() +"\t"+ User.getEmailAddress() +"\t"+ candidate.getFieldOfStudy() +"\t"+ candidate.getExperience() +"\t"+ 
							candidate.getAvailability() +"\t"+ candidate.getDutch() +"\t"+ candidate.getEnglish() +"\t"+ candidate.getGerman() +"\t"+ candidate.getMSOffice() +"\t"+ candidate.getJavaScript() +"\t"+ candidate.getSales() +"\t"+ candidate.getManagement();				 
				}
				lines[counter] = sCurrentLine;		
				counter++;
			}
			br.close();
			
			// When the if statement is met, so the correct ID is found, update the line in the textfile.
			PrintWriter wr = new PrintWriter(new BufferedWriter (new FileWriter("Candidates.txt")));	
			
			for(int i = 0; i < counter; i++){
				wr.println(lines[i]);
			}
			
			wr.close();
		} catch (IOException error) {
			error.printStackTrace();
		}		
	}
	
	public static void updateRecruiter(Recruiter recruiter) {

		try {
			String[] lines = new String[100];

			BufferedReader br = new BufferedReader(new FileReader("Recruiters.txt"));			
			String sCurrentLine;
			String[] uCurrentLine = new String[6];

			int counter = 0;
			while((sCurrentLine = br.readLine()) != null){					
				uCurrentLine = sCurrentLine.split("\t");			
				// every time if statement not met, increment counter to know what line is read.
				if(Integer.parseInt(uCurrentLine[0]) == recruiter.getUserID()){				
					sCurrentLine = uCurrentLine[0] +"\t"+ User.getLoginName() +"\t"+ User.getPassword() +"\t"+ User.getName() +"\t"+ User.getEmailAddress() +"\t"+ recruiter.getCompany(); 				 
				}
				lines[counter] = sCurrentLine;		
				counter++;
			}
			br.close();

			// When the if statement is met, so the correct ID is found, update the line in the textfile.
			PrintWriter wr = new PrintWriter(new BufferedWriter (new FileWriter("Recruiters.txt")));	

			for(int i = 0; i < counter; i++){
				wr.println(lines[i]);
			}

			wr.close();
		} catch (IOException error) {
			error.printStackTrace();
		}		
	}
	public static void addApplication(int candidateID, int vacancyID, String motivation){
		/* 
		 * Fields in the TXT file:
		 * [0] applicationID;
		 * [1] candidateID;
		 * [2] vacancyUD;
		 * [3] motivation;
		 */
		try {
			int nextApplicationID = getNextId("Applications.txt");
			// Initialize applications.txt as file to read
			PrintWriter wr = new PrintWriter(new BufferedWriter (new FileWriter("Applications.txt", true)));	//True means it's going to add it to the existing file instead of creating a new one					
			String newLine = (nextApplicationID + "\t" + candidateID + "\t" + vacancyID + "\t" + motivation); 			 

			wr.println(newLine);
			wr.close();	
		} catch (IOException e) {
			e.printStackTrace();								// catches errors and shows where you can find the error
		}		
	}
}