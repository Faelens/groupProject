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
	}

	public static void viewVacancies(){
		// view ALL vacancies
		// Print list of all vacancies with ID
		ReadFile.printAllVacancies();
		
		// Ask what ID user wants to see more information, or go back to main menu
		while(true){
		System.out.println("\nWould you like to see more information about a vacancy (A) or go back to main menu (B)?");
		char choice = Main.userInput1.next().charAt(0);
		
		if (choice != 'A' && choice != 'B') {
			System.out.println("Please choose A or B");
		}
		else if (choice == 'A') {
			// Ask for vacancy
			System.out.println("Please enter the vacancy number");
			int vacancyID = Main.userInput3.nextInt();
			
			
			Main.vacancy = ReadFile.getVacancyByVacancyID(vacancyID);
			Main.vacancy.printVacancy();
		}
		else {
			break;
		}
		
		}
		
		
	}

	public static void searchVacancies(){
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