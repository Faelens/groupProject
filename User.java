package groupProject;

public class User {
	private int userID;
	private String logInName;
	private String password;
	private String name;
	private String emailAddress;

	public static void logOut(){
		System.out.println("Bye bye!");			// Goodbye statement
	}
	
	public static void viewVacancies(){
		// Ask what ID user wants to see more information, or go back to main menu
		System.out.println("\nIf you want to see more information, please enter a vacancy number. Enter 0 to go back to main menu.");
		while(true){
			while (!Main.userInput3.hasNextInt()) {
		        System.out.println("That's not a number!");
		        Main.userInput3.next(); // Tells to go to next scanner
		    }
			int choice = Main.userInput3.nextInt();
			if (choice < 0) {
				System.out.println("Please enter a valid input");
				continue;
			} else if (choice == 0) {
				break;
			} else {
				// Find vacancy by id and print details
				Main.vacancy = ReadFile.getVacancyByVacancyID(choice);
				Main.vacancy.printVacancy();
				if (Main.recruiterOrCandidate == 'B') Candidate.applyForVacancy();
				break;
			}
		}
	}
	//SETTERS
	
	public void setUserID(int userID){
		this.userID = userID;
	}
	
	public void setLogInName(String logInName){
		this.logInName = logInName;
	}

	public void setPassword(String password){
		this.password = password;
	}
	public void setName(String name){
		this.name = name;
	}	
	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}	
	//GETTERS
	
	public int getUserID() {
		return userID;
	}
	public String getLoginName() {
		return logInName;
	}
	public String getPassword() {
		return password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getName() {
		return name;
	}

}