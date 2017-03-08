package groupProject;

public class User {
	private static int userID;
	private static String logInName;
	private static String password;
	private static String name;
	private static String emailAddress;

	public static void registerAccount(){

	}

	public static void logOut(){
		// Print a bye bye statement with a cool picture ASCII
		System.out.println("Bye bye!");
	}

	public static void viewVacancies(){

		// Ask what ID user wants to see more information, or go back to main menu

		System.out.println("\nWould you like to see more information about a vacancy (A) or go back to main menu (B)?");
		
		while(true){
			char choice = Main.userInput1.next().charAt(0);

			if (choice != 'A' && choice != 'B') {
				System.out.println("Please choose A or B");
				continue;
			}
			else if (choice == 'A') {
				// Ask for vacancy
				System.out.println("Please enter the vacancy number");
				int vacancyID = Main.userInput3.nextInt();

				// Find vacancy by id and print details
				Main.vacancy = ReadFile.getVacancyByVacancyID(vacancyID);
				Main.vacancy.printVacancy();
				if (Main.recruiterOrCandidate == 'A') Recruiter.runRecruiterVacancy();
				if (Main.recruiterOrCandidate == 'B') Candidate.applyForVacancy();
				break;
			}
			else {
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