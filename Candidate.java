package groupProject;

/* 
 * Fields in the TXT file:
 * [0] userID;
 * [1] logInName;
 * [2] password;
 * [3] name;
 * [4] emailAdress;
 * [5] dateOfBirth;
 * [6] address;
 * [7] phoneNumber;
 * [8] fieldOfStudy;
 * [9] experience;
 * [10] availability;
 * [11] Dutch;
 * [12] English;
 * [13] German;
 * [14] French;
 * [15] MS Office;
 * [16] Javascript;
 * [17] Sales;
 * [18] Management
*/

public class Candidate extends User {
	String dateOfBirth;
	String address;
	int phoneNumber;
	char fieldOfStudy;
	int experience;
	boolean availability;
	
	String[] languages = {"Dutch", "English", "German", "French"};
	boolean[] candidateLanguages = new boolean[4]; 
	
	String[] skills = {"MS Office", "JavaScript", "Sales", "Management"};
	boolean[] candidateSkills = new boolean[4];
	
	public static void setCandidateInfo(){
	}
	
	public static void viewCandidateInfo(){
		
	}
	
	public static void viewApplications(){
		
	}
	
	public static void applyToApplication(){
		
	}


}
