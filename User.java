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
	}

	public static void searchVacancies(){
	}
	
	//Setters
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
	public static int getUserID() {
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