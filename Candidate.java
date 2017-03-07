package groupProject;

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
 * [12] MS Office;
 * [13] Javascript;
 * [14] Sales;
 * [15] Management
 */

public class Candidate extends User {

	private int fieldOfStudy;			//1 = Business, 2 = Social, 3 = Technical 
	private int experience;
	private int availability;		//1 = Available, 2 = Unavailable (currently employed)
	private boolean dutch;
	private boolean english;
	private boolean german;
	private boolean msOffice;
	private boolean javaScript;
	private boolean sales;
	private boolean management;

	public Candidate(int userID, String logInName, String password, String name, String emailAddress, int fieldOfStudy, int experience, 
			int availability, boolean Dutch, boolean English, boolean German, boolean msOffice, boolean Javascript, boolean Sales, boolean Management){
		setLogInName(logInName);
		setPassword(password);
		setName(name);
		setEmailAddress(emailAddress);
		this.fieldOfStudy = fieldOfStudy;			
		this.experience = experience;
		this.availability = availability;
		this.dutch = Dutch;
		this.english = English;
		this.german = German;
		this.msOffice = msOffice;
		this.javaScript = Javascript;
		this.sales = Sales;
		this.management = Management;
	}

	public static void candidateLogIn(){
		System.out.println("\n#####");
		System.out.println("LOGIN as Candidate");
		System.out.println("#####");

		Candidate tempCandidate = null;

		while(true){
			System.out.println("Log-in name: ");
			String logInName = Main.userInput2.nextLine();

			System.out.println("Password: ");
			String password = Main.userInput2.nextLine();

			tempCandidate = ReadFile.getCandidatebyLogInName(logInName);

			if(tempCandidate == null){
				System.out.println("\nThis user does not exist!");
				continue;
			}

			if(!tempCandidate.getPassword().equals(password)){
				System.out.println("\nThis password is not correct!");
				continue;
			}

			Main.candidate = tempCandidate;

			break;
		}
	}

	public static void candidateRegistration(){
		System.out.println("#####");
		System.out.println("Register new Candidate");
		System.out.println("#####");

		String logInName;
		String password;
		String name;
		String emailAddress;
		int fieldOfStudy;					//1 = Business, 2 = Social, 3 = Technical  
		int experience;
		int availability;		
		boolean dutch;
		boolean english;
		boolean german;
		boolean msOffice;
		boolean javaScript;
		boolean sales;
		boolean management;


		while(true){
			System.out.print("Login-name: ");
			logInName = Main.userInput2.nextLine();

			if(logInName.equals("")){
				System.out.println("Can't be empty!");
				continue;
			}

			Candidate tempCandidate = ReadFile.getCandidatebyLogInName(logInName);

			if (tempCandidate == null) break;

			System.out.println("Please choose another name, this login-name is already taken!");
		}

		while(true){
			while(true){
				System.out.print("password: ");
				password = Main.userInput2.nextLine();

				if(!password.equals("")) break;

			}
			System.out.print("Repeat password: ");
			String repeatpassword = Main.userInput2.nextLine();		
			if(repeatpassword.equals(password)) break;			
			System.out.println("Your passwords do not match!");
		}

		while(true){
			System.out.print("name: ");
			name = Main.userInput2.nextLine();

			if(!name.equals("")) break;

		}

		while(true){
			System.out.print("emailaddress: ");
			emailAddress = Main.userInput2.nextLine();

			if(!emailAddress.equals("")) break;

		}

		while(true){
			System.out.print("What is you field of study? : ");
			System.out.print("1 = Business");
			System.out.print("2 = Social");
			System.out.print("3 = Technical: ");
			fieldOfStudy = Main.userInput3.nextInt();

			if(fieldOfStudy == 1 || fieldOfStudy == 2 || fieldOfStudy == 3) break;

			System.out.println("Please enter 1 , 2 or 3");

		}

		while(true){
			System.out.print("How many years of workexperience do you have? (please enter the amount of years) : ");
			experience = (int) Main.userInput3.nextInt();

			if(experience>= 0) break;

			System.out.println("Please enter a positive number");

		} 

		while(true){
			System.out.print("Are you available to start rightaway? (1 = yes ; 2 = no )"); // maybe we need to change this to a boolean
			availability = (int) Main.userInput3.nextInt();

			if(availability == 1 || availability == 2) break;

			System.out.println("Please enter 1 (yes) or a 2 (no)");

		}

		while(true){
			System.out.print("Do you speak Dutch? ( true or false )"); 
			dutch = Main.userInput4.nextBoolean();							// maybe need to change to int scanner

			if( dutch == true || dutch == false ) break;

			System.out.println("Please enter true or false");
		}




		while(true){
			System.out.print("Do you speak English? (true or false) "); 
			english = Main.userInput4.nextBoolean();							// maybe need to change to int scanner

			if( english == true || english == false ) break;

			System.out.println("Please enter true or false");
		}




		while(true){
			System.out.print("Do you speak German? (true or false) "); 
			german = Main.userInput4.nextBoolean();							// maybe need to change to int scanner

			if( german == true || german == false ) break;

			System.out.println("Please enter true or false");
		}



		while(true){
			System.out.print("Do you have MS Office skills? (true or false) "); 
			msOffice = Main.userInput4.nextBoolean();							// maybe need to change to int scanner

			if( msOffice == true || msOffice == false ) break;

			System.out.println("Please enter true or false");

		}



		while(true){
			System.out.print("Do you have Javascript skills? (true or false) "); 
			javaScript = Main.userInput4.nextBoolean();							// maybe need to change to int scanner

			if( javaScript == true || javaScript == false ) break;

			System.out.println("Please enter true or false");
		}



		while(true){
			System.out.print("Do you have sales skills? (true or false) "); 
			sales = Main.userInput4.nextBoolean();							// maybe need to change to int scanner

			if( sales == true || sales == false ) break;

			System.out.println("Please enter true or false");
		}



		while(true){
			System.out.print("Do you have management skills? (true or false) "); 
			management = Main.userInput4.nextBoolean();						// maybe need to change to int scanner

			if( management == true || management == false ) break;

			System.out.println("Please enter true or false");	

		}

		WriteFile.addCandidate(logInName, password, name, emailAddress, fieldOfStudy, experience, availability,
				dutch, english, german, msOffice, javaScript, sales, management);		
		System.out.println("\nCongratulations! You now have a candidate account and you can now login!");

		Candidate.candidateLogIn();
	}





	public static void setCandidateInfo(){
		System.out.println("\n####################");
		System.out.println("1 = Login-name");
		System.out.println("2 = Password");
		System.out.println("3 etc");
		System.out.println("Which information do you want to update?");
		System.out.println("Which information do you want to update?");
		System.out.println("Which information do you want to update?");
		System.out.println("Which information do you want to update?");
		System.out.println("Which information do you want to update?");
		System.out.println("Which information do you want to update?");
		System.out.println("Which information do you want to update?");
		System.out.println("Which information do you want to update?");
		System.out.println("go back?");


		if(choice == '1'){ //do stuff			
			while(true){		
				System.out.println("\nHow much do you want to add?");
				try{		
					String newlogin = userInput2.nextLine();				
					User.setLogInName(newlogin);
					
					System.out.println("Your login-name has been updated");
					break;
				
				}catch(Exception e){
					System.out.println("This is not a valid number");
				}			


			
		}
		public static void getCandidateInfo(){	
		}
		public static void viewApplications(){
		}
		public static void applyToApplication(){	
		}

		//SETTERS
		
		//Getters
		public int getfieldOfStudy() {
			return fieldOfStudy;
		}
		public int getExperience() {
			return experience;
		}
		public int getAvailability() {
			return availability;
		}
		public boolean getDutch() {
			return dutch;
		}
		public boolean getEnglish() {
			return english;
		}
		public boolean getGerman() {
			return german;
		}
		public boolean getMSOffice() {
			return msOffice;
		}
		public boolean getJavaScript() {
			return javaScript;
		}
		public boolean getSales() {
			return sales;
		}
		public boolean getManagement() {
			return management;
		}

	}
