package groupProject;

public class User {
	private static int userID;
	private static String logInName;
	private static String password;
	private static String name;
	private static String emailAddress;


	public static void logOut(){
		// Print a bye bye statement with a cool picture ASCII
		System.out.println("Bye bye!");
	}

	public static void viewVacancies(){

		// Ask what ID user wants to see more information, or go back to main menu

		System.out.println("\nIf yout want to see more information, please enter a vacancy number. Enter 0 to go back to main menu.");
		
		while(true){
			int choice = Main.userInput3.nextInt();

			if (choice < 0) {
				System.out.println("Please enter a valid input");
				continue;
			}
			else if (choice == 0) {
				break;
			}
			else {
				// Find vacancy by id and print details
				Main.vacancy = ReadFile.getVacancyByVacancyID(choice);
				Main.vacancy.printVacancy();
				if (Main.recruiterOrCandidate == 'B') Candidate.applyForVacancy();
				break;
			}

		}
	}
	

	//Setters
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
		User.name = name;
	}	
	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}	

	//Getters
	public int getUserID() {
		return userID;
	}
	public static String getLoginName() {
		return logInName;
	}
	public static String getPassword() {
		return password;
	}
	public static String getEmailAddress() {
		return emailAddress;
	}
	public static String getName() {
		return name;
	}

}