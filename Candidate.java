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
 * [11] MS Office;
 * [12] Javascript;
 * [13] Sales;
 * [14] Management
 */

public class Candidate extends User {

	private int fieldOfStudy;			//1 = Business, 2 = Social, 3 = Technical 
	private int experience;
	private int availability;			//1 = Available, 2 = Unavailable (currently employed)
	private boolean dutch;
	private boolean english;
	private boolean german;
	private boolean msOffice;
	private boolean javaScript;
	private boolean sales;
	private boolean management;

	// Constructor for candidate
	public Candidate(int userID, String logInName, String password, String name, String emailAddress, int fieldOfStudy, int experience, 
			int availability, boolean Dutch, boolean English, boolean German, boolean msOffice, boolean Javascript, boolean Sales, boolean Management){
		setUserID(userID);
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

	// Log-in for candidate. Reads from candidates.txt file
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

	// Candidate registration. Writes to candidates.txt
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
		int availability;					//1 = Available, 2 = Unavailable (currently employed)
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
			if(logInName.equals("")){						// Prevents empty input
				System.out.println("Can't be empty!");
				continue;
			}
			Candidate tempCandidate = ReadFile.getCandidatebyLogInName(logInName);
			if (tempCandidate == null) break; 		// If username doesn't exist, break out of loop and continue registration
			System.out.println("Please choose another name, this login-name is already taken!");
		}
		while(true){								// Create a password for the account
			while(true){
				System.out.print("password: ");
				password = Main.userInput2.nextLine();
				if(!password.equals("")) break;		// Password can't be empty
			}
			System.out.print("Repeat password: ");	// repeat the password 
			String repeatpassword = Main.userInput2.nextLine();		
			if(repeatpassword.equals(password)) break;			// If passwords are the same --> break out of this loop
			System.out.println("Your passwords do not match!");
		}
		while(true){
			System.out.print("name: ");
			name = Main.userInput2.nextLine();					
			if(!name.equals("")) break;						// Name can't be empty
		}
		while(true){
			System.out.print("emailaddress: ");
			emailAddress = Main.userInput2.nextLine();
			if(!emailAddress.equals("")) break;				// Emailaddress can't be empty
		}
		while(true){
			System.out.println("What is you field of study? : ");
			System.out.println("1 = Business");
			System.out.println("2 = Social");
			System.out.println("3 = Technical: ");
			while (!Main.userInput3.hasNextInt()) {
		        System.out.println("That's not a number!");
		        Main.userInput3.next(); // Tells to go to next scanner
		    }
			fieldOfStudy = Main.userInput3.nextInt();
			if(fieldOfStudy == 1 || fieldOfStudy == 2 || fieldOfStudy == 3) break;
			System.out.println("Please enter 1 , 2 or 3");	 // Catches invalid int inputs
		}
		while(true){
			System.out.print("How many years of workexperience do you have? (please enter the amount of years) : ");
			while (!Main.userInput3.hasNextInt()) {
		        System.out.println("That's not a number!");
		        Main.userInput3.next(); // Tells to go to next scanner
		    }
			experience = (int) Main.userInput3.nextInt();
			if(experience>= 0) break;
			System.out.println("Please enter a positive number");	// Catches negatives integers
		} 
		while(true){
			System.out.print("Are you available to start rightaway? ( Y/N )"); 
			char temp = 'Z';										// Make a temp variable with a char value
			temp = Main.userInput1.next().charAt(0);				
			if( temp == 'Y') { 										
				availability = 1;										// Returns boolean value
				break;			
			} else if( temp == 'N') { 
				availability = 2;										// Returns boolean value
				break;
			} else {System.out.println("Please enter Y or N");}		// Catches invalid char input
		}

		while(true){
			System.out.print("Do you speak Dutch? ( Y/N )"); 
			char temp = 'Z';										// Make a temp variable with a char value
			temp = Main.userInput1.next().charAt(0);				
			if( temp == 'Y') { 										
				dutch = true;										// Returns boolean value
				break;			
			} else if( temp == 'N') { 
				dutch = false;										// Returns boolean value
				break;
			} else {System.out.println("Please enter Y or N");}		// Catches invalid char input
		}

		while(true){
			System.out.print("Do you speak English? ( Y/N )"); 
			char temp = 'Z';
			temp = Main.userInput1.next().charAt(0);				
			if( temp == 'Y') { 
				english = true;
				break;
			} else if( temp == 'N') { 
				english = false;
				break;
			} else {System.out.println("Please enter Y or N");}
		}

		while(true){
			System.out.print("Do you speak German? ( Y/N )"); 
			char temp = 'Z';
			temp = Main.userInput1.next().charAt(0);							
			if( temp == 'Y') { 
				german = true;
				break;
			} else if( temp == 'N') { 
				german = false;
				break;
			} else {System.out.println("Please enter Y or N");}
		}

		while(true){
			System.out.print("Do you have MS Office skills? ( Y/N )"); 
			char temp = 'Z';
			temp = Main.userInput1.next().charAt(0);							

			if( temp == 'Y') { 
				msOffice = true;
				break;
			} else if( temp == 'N') { 
				msOffice = false;
				break;
			} else {System.out.println("Please enter Y or N");}
		}
		while(true){
			System.out.print("Do you have Javascript skills? ( Y/N )"); 
			char temp = 'Z';
			temp = Main.userInput1.next().charAt(0);							
			if( temp == 'Y') { 
				javaScript = true;
				break;
			} else if( temp == 'N') { 
				javaScript = false;
				break;
			} else {System.out.println("Please enter Y or N");}
		}

		while(true){
			System.out.print("Do you have sales skills? ( Y/N )"); 
			char temp = 'Z';
			temp = Main.userInput1.next().charAt(0);							
			if( temp == 'Y') { 
				sales = true;
				break;
			} else if( temp == 'N') { 
				sales = false;
				break;
			} else {System.out.println("Please enter Y or N");}
		}
		while(true){
			System.out.print("Do you have management skills? ( Y/N )"); 
			char temp = 'Z';
			temp = Main.userInput1.next().charAt(0);
			if( temp == 'Y') { 
				management = true;
				break;
			} else if( temp == 'N') { 
				management = false;
				break;
			} else {System.out.println("Please enter Y or N");}
		}

		// Write all the entered information to the Candidate.txt file
		WriteFile.addCandidate(logInName, password, name, emailAddress, fieldOfStudy, experience, availability,
				dutch, english, german, msOffice, javaScript, sales, management);		
		System.out.println("\nCongratulations! You now have a candidate account and you can now login!");
		Candidate.candidateLogIn();
	}
	// SetCandidateInfo method, give the user the possibility to change his/her account information
	public void setCandidateInfo(){
		int choice = 0;
		while(true){
			System.out.println("\n#####################");
			System.out.println("What do you want to do?");
			System.out.println("1 = Change password");
			System.out.println("2 = Change name");
			System.out.println("3 = Change e-mailaddress");
			System.out.println("4 = Change field of study");
			System.out.println("5 = Change experience");
			System.out.println("6 = Change availability");
			System.out.println("7 = Change languages");
			System.out.println("8 = Change skills");
			System.out.println("9 = Back to main menu");

			while (!Main.userInput3.hasNextInt()) {
		        System.out.println("That's not a number!");
		        Main.userInput3.next(); // Tells to go to next scanner
		    }
			choice = Main.userInput3.nextInt();

			if(choice == 1){												// Change password
				while(true){
					String newpassword = null;								// Temp variable for creating a new password
					while(true){
						System.out.println("Your current password is: " + getPassword());	// Show current password
						System.out.println("--------------------------");
						System.out.print("Fill in your new password here: ");
						newpassword = Main.userInput2.nextLine();
						if(!newpassword.equals("")) break;					// Catches empty input
					}

					System.out.print("Repeat your new password: ");			
					String repeatnewpassword = Main.userInput2.nextLine();		
					if(!repeatnewpassword.equals(newpassword)) {			// Repeat password 
						System.out.println("Your passwords do not match!"); // Catches if password do not match
					}
					Main.candidate.setPassword(newpassword);
					WriteFile.updateCandidate(this);						// Method for updating password
					System.out.println("Your password has been updated correctly."); 
					System.out.println("Use it to log in next time");
					break;
				}
			}

			if(choice == 2){ 											// Name			
				while(true){		
					System.out.println("\nYour current name is: " + Main.candidate.getName());		// Shows current name
					System.out.print("Please enter your new name:");
					String newname = Main.userInput2.nextLine();	
					if(newname.equals("")){								// Catches empty input
						System.out.println("Can't be empty!");
						continue;
					}
					Main.candidate.setName(newname);					// Method for updating name
					WriteFile.updateCandidate(this);					
					System.out.println("Your name has been updated correctly to " 
							+ Main.candidate.getName() + "\n.");
					break;
				}
			}

			if(choice == 3){ 											// Email address			
				while(true){		
					System.out.println("\nYour current e-mailaddress is: " + Main.candidate.getEmailAddress());	// Shows Email-address
					System.out.print("Please enter your new e-mailaddress:");
					String newemail = Main.userInput2.nextLine();	
					if(newemail.equals("")){
						System.out.println("Can't be empty!");			// Catches empty input
						continue;
					}
					Main.candidate.setEmailAddress(newemail);			// Method for updating Email-address
					WriteFile.updateCandidate(this);
					System.out.println("Your e-mailaddress has been updated correctly to " 
							+ Main.candidate.getEmailAddress() + ".\n");
					break;
				}
			}

			if(choice == 4){ 											// Field of study			
				while(true){		
					System.out.println("The possible fields of study are:");
					System.out.println("1 = Business");
					System.out.println("2 = Social");
					System.out.println("3 = Technical");
					System.out.println("Your current field of study is: " + getFieldOfStudy());
					System.out.print("Please enter your new field of study:");
					while (!Main.userInput3.hasNextInt()) {
				        System.out.println("That's not a number!");
				        Main.userInput3.next(); // Tells to go to next scanner
				    }
					int newFieldOfStudy = (int)Main.userInput3.nextInt();	
					if(newFieldOfStudy != 1 && newFieldOfStudy != 2 && newFieldOfStudy != 3){	// Catches invalid integers 
						System.out.println("Please enter 1, 2 or 3");	
						continue;
					}
					setFieldOfStudy(newFieldOfStudy);
					WriteFile.updateCandidate(this);
					System.out.println("Your field of study has been updated corrrectly to " 
							+ fieldOfStudy + ".\n");
					break;
				}
			}

			if(choice == 5){ 													// Experience		
				while(true){		
					System.out.println("Currently, your profile says you have " 
							+ experience + " years of experience.");
					System.out.print("Enter your new experience level here: ");
					while (!Main.userInput3.hasNextInt()) {
				        System.out.println("That's not a number!");
				        Main.userInput3.next(); // Tells to go to next scanner
				    }
					int newExperience = (int)Main.userInput3.nextInt();	

					if(newExperience < 0){										// Catches negative integers
						System.out.println("A positive number is required!");
						continue;
					}
					setExperience(newExperience);								// method for updating experience
					WriteFile.updateCandidate(this);
					System.out.println("Your experience has been updated correctly to " 
							+ experience + " years.\n");
					break;
				}
			}

			if(choice == 6){ 													// Availability		
				while(true){		
					System.out.println("1 = Available immediately");
					System.out.println("2 = Not available immediately");
					System.out.println("Your current availability is set to: " + availability + ".");
					System.out.print("Enter your new availability status here: ");
					while (!Main.userInput3.hasNextInt()) {
				        System.out.println("That's not a number!");
				        Main.userInput3.next(); // Tells to go to next scanner
				    }
					int newAvailability = (int)Main.userInput3.nextInt();	
					if(newAvailability != 1 && newAvailability != 2){			// Catches invalid integers
						System.out.println("Please enter 1 or 2");
						continue;
					}
					setAvailability(newAvailability);							// Method for updating availability
					WriteFile.updateCandidate(this);
					System.out.println("Your availability has been updated correctly to " 
							+ availability + ".");
					break;
				}
			}

			if(choice == 7){ 													// Languages	
				while(true){		
					System.out.println("Currently, your language settings are as follows: ");
					System.out.println("Dutch: " + dutch);
					System.out.println("English: " + english);
					System.out.println("German: " + german);
					//To ask for Dutch
					System.out.println("----------------------------");
					System.out.println("Do you speak Dutch? (Y/N)"); 
					char newDutch = 'Z';										// Creates temp char
					boolean tempDutch = true;									// Creates a temp boolean
					newDutch = Main.userInput1.next().charAt(0);	
					newDutch = Character.toUpperCase(newDutch);				
					if(newDutch == 'Y') { 
						tempDutch = true;										// Set boolean to true
					}	else if(newDutch == 'N') { 
						tempDutch = false;
					}	else {													// Catches invalid Char
						System.out.println("####################");
						System.out.println("Please enter Y or N!");
						System.out.println("####################");
						continue;
					}

					setDutch(tempDutch);										// Set the new value of the language

					//To ask for English
					System.out.println("Do you speak English? (Y/N)"); 
					char newEnglish = 'Z';
					boolean tempEnglish = true;
					newEnglish = Main.userInput1.next().charAt(0);			
					newEnglish = Character.toUpperCase(newEnglish);	
					if(newEnglish == 'Y') { 
						tempEnglish = true;
					}	else if(newEnglish == 'N') { 
						tempEnglish = false;
					}	else {
						System.out.println("####################");
						System.out.println("Please enter Y or N!");
						System.out.println("####################");
						continue;
					}

					setEnglish(tempEnglish);

					//To ask for German
					System.out.println("Do you speak German? (Y/N)"); 
					char newGerman = 'Z';
					boolean tempGerman = true;
					newGerman = Main.userInput1.next().charAt(0);			
					newGerman = Character.toUpperCase(newGerman);	
					if(newGerman == 'Y') { 
						tempGerman = true;
					}	else if(newGerman == 'N') { 
						tempGerman = false;
					}	else {
						System.out.println("####################");
						System.out.println("Please enter Y or N!");
						System.out.println("####################");
						continue;
					}
					setGerman(tempGerman);

					WriteFile.updateCandidate(this);
					System.out.println("Your languages have been correctly updated to: ");
					System.out.println("Dutch: " + dutch);
					System.out.println("English: " + english);
					System.out.println("German: " + german);
					break;
				}
			}
			if(choice == 8){ 																	// Skills		
				System.out.println("Your current skills are set as follows:");
				System.out.println("MS Office: " + msOffice);
				System.out.println("JavaScript: " + javaScript);
				System.out.println("Sales: " + sales);
				System.out.println("Management: " + management);

				while(true){		
					//To ask for MS Office
					System.out.println("------------------------------------------");
					System.out.println("Are you able to work with MS Office? (Y/N)"); 
					char newmsOffice = 'Z';
					boolean tempmsOffice = true;
					newmsOffice = Main.userInput1.next().charAt(0);					
					newmsOffice = Character.toUpperCase(newmsOffice);
					if(newmsOffice == 'Y') { 
						tempmsOffice = true;
					}	else if(newmsOffice == 'N') { 
						tempmsOffice = false;
					}	else {System.out.println("Please enter Y or N");
					continue;
					}

					setmsOffice(tempmsOffice);

					//To ask for JavaScript
					System.out.println("Are you able to program in JavaScript? (Y/N)"); 
					char newjavaScript = 'Z';
					boolean tempJavaScript = true;
					newjavaScript = Main.userInput1.next().charAt(0);					
					newjavaScript = Character.toUpperCase(newjavaScript);	
					if(newjavaScript == 'Y') { 
						tempJavaScript = true;
					}	else if(newjavaScript == 'N') { 
						tempJavaScript = false;
					}	else {System.out.println("Please enter Y or N");
					continue;
					}

					setjavaScript(tempJavaScript);

					//To ask for Sales 
					System.out.println("Do you have experience in Sales? ( Y/N )"); 
					char newsales = 'Z';
					boolean tempsales = true;
					newsales = Main.userInput1.next().charAt(0);				
					newsales = Character.toUpperCase(newsales);	
					if(newsales == 'Y') { 
						tempsales = true;
					}	else if(newsales == 'N') { 
						tempsales = false;
					}	else {System.out.println("Please enter Y or N");
					continue;
					}

					setsales(tempsales);

					//To ask for Management 
					System.out.println("Do you have experience in Management? ( Y/N )"); 
					char newmanagement = 'Z';
					boolean tempmanagement = true;
					newmanagement = Main.userInput1.next().charAt(0);				
					newmanagement = Character.toUpperCase(newmanagement);	
					if(newmanagement == 'Y') { 
						tempmanagement = true;
					}	else if(newmanagement == 'N') { 
						tempmanagement = false;
					}	else {System.out.println("Please enter Y or N");
					continue;
					}

					setmanagement(tempmanagement);

					WriteFile.updateCandidate(this);											// Write updates to canidate.txt file
					System.out.println("Your skills have been updated correctly to:");
					System.out.println("MS Office: " + msOffice);
					System.out.println("JavaScript: " + javaScript);
					System.out.println("Sales: " + sales);
					System.out.println("Management: " + management);
					break;
				}
			}

			if(choice == 9){ 																	// Go Back to main menu		
				System.out.println("");
				break;
			}
		}
	}

	public static void applyForVacancy(){
		System.out.println("\nWould you like to apply for the position? (Y/N)");
		while(true){
			char apply = Main.userInput1.next().charAt(0);			
			apply = Character.toUpperCase(apply);
			if  (!(apply == 'Y') && !(apply == 'N') ) {
				System.out.println("Please enter Y or N");
				continue;
			}	else if(apply == 'N') { 				// No: Back to main menu
				break;
			}	else if  (apply == 'Y') { 				// Yes: apply for a vacancy
				String motivation = null;				// Temp motivation variable (= empty at first)
				System.out.println("Please fill out your motivation here:"); 
				motivation = (Main.userInput2.nextLine());
				WriteFile.addApplication(Main.candidate.getUserID(), Main.vacancy.getVacancyID(), motivation);	// Write to vacancy.txt file
				System.out.println("\nYou have succesfully applied to the position of " + Main.vacancy.getJobTitle() + ".\n");
				break;
			}
		}
	}

	public static void filterVacancies(){
		outerloop:														// Filter menu is on the outer loop
			while(true){
				System.out.println("What do you want to filter on?");
				System.out.println("A = Field of study");
				System.out.println("B = Years of experience");
				System.out.println("C = Skills required");
				System.out.println("D = Go back to main menu");

				while(true){											// Innerloop
					char filter = Main.userInput1.next().charAt(0);		
					filter = Character.toUpperCase(filter);
					if  (!(filter == 'A') && !(filter == 'B') && !(filter == 'C') && !(filter == 'D')) {
						System.out.println("Please enter A, B, C or D");
						continue;
					} else if (filter == 'A') {
						System.out.println("What field of study would you like to filter on?");
						System.out.println("A = Business");
						System.out.println("B = Social");
						System.out.println("C = Technical");
					
						while(true){
							char studyfilter = Main.userInput1.next().charAt(0);		
							studyfilter = Character.toUpperCase(studyfilter);
							if  (!(studyfilter == 'A') && !(studyfilter == 'B') && !(studyfilter == 'C')) {
								System.out.println("Please enter A, B, or C");
								continue;
							} else if (studyfilter == 'A') {
								System.out.println("The following vacancies require a business background:");
								ReadFile.getVacanciesByFieldOfStudy(1);
								viewVacancies();								// Gives the possibility to apply directly 
								break outerloop;
							} else if (studyfilter == 'B') {
								System.out.println("The following vacancies require a social background:");
								ReadFile.getVacanciesByFieldOfStudy(2);
								viewVacancies();
								break outerloop;
							} else {
								System.out.println("The following vacancies require a technical background:");
								ReadFile.getVacanciesByFieldOfStudy(3);
								viewVacancies();
								break outerloop;
							}
						}
					} else if (filter == 'B') {
						System.out.println("\nWith your " + Main.candidate.getExperience() + " years of experience you fit the following vacancies:");
						ReadFile.getVacanciesByExperience(Main.candidate.getExperience());
						viewVacancies();
						break outerloop;
					} else if (filter == 'C') {
						System.out.println("What skills would you like to filter on?");
						System.out.println("A = MS Office");
						System.out.println("B = JavaScript");
						System.out.println("C = Sales");
						System.out.println("D = Management");

						while(true){
							char skillfilter = Main.userInput1.next().charAt(0);
							skillfilter = Character.toUpperCase(skillfilter);
							if  (!(skillfilter == 'A') && !(skillfilter == 'B') && !(skillfilter == 'C') && !(skillfilter == 'D')) {
								System.out.println("Please enter A, B, C or D");
								continue;
							} else if (skillfilter == 'A') {
								System.out.println("The following vacancies require MS Office skills:");
								ReadFile.getVacanciesBySkill(8);
								viewVacancies();
								break outerloop;
							} else if (skillfilter == 'B') {
								System.out.println("The following vacancies require JavaScript skills:");
								ReadFile.getVacanciesBySkill(9);
								viewVacancies();
								break outerloop;
							} else if (skillfilter == 'C') {
								System.out.println("The following vacancies require sales skills:");
								ReadFile.getVacanciesBySkill(10);
								viewVacancies();
								break outerloop;
							} else {
								System.out.println("The following vacancies require management skills:");
								ReadFile.getVacanciesBySkill(11);
								viewVacancies();
								break outerloop;
							}
						}
					}
				}
			}
	}

	public static void viewApplications(){
		System.out.println("\nYou have applied on the following vacancies:");
		ReadFile.getApplications(Main.candidate.getUserID());
		viewMotivation();
		System.out.println("");
	}

	public static void viewMotivation(){
		// Ask what ID user wants to see more information, or go back to main menu
		System.out.println("\nEnter the number of the vacancy to see your motivation or fill in 0 to return to the main menu");
		while(true){
			while (!Main.userInput3.hasNextInt()) {
		        System.out.println("That's not a number!");
		        Main.userInput3.next(); // Tells to go to next scanner
		    }
			int applicationID = Main.userInput3.nextInt();
			if (applicationID < 0) {
				System.out.println("Please enter a valid input");
				continue;
			} else if (applicationID == 0) {
				break;
			} else {
				ReadFile.printMotivationByApplicationID(applicationID);	// Find motivation by applicationID and print details
				break;
			}
		}
	}

	public String getAvailabilityInText(int Availability) {				// Method that changes int to string to make it more clear for the recruiter
		String text = null;
		if (Availability == 1 ) text = "Available immediately";		
		if (Availability == 2 ) text = "Not available immediately";
		return text;
	}

	public void printCandidate() { 								// Method for printing Candidate info for recruiter

		System.out.println("Name: " + getName());
		System.out.println("E-mailaddress: " + getEmailAddress());
		System.out.println("Field of study: " + Vacancy.getFieldOfStudyByFieldOfStudy(getFieldOfStudy()));
		System.out.println("Experience: " + getExperience() + " years");
		System.out.println("Availability: " + getAvailabilityInText(getAvailability()));
		System.out.println("Dutch: " + Vacancy.getSkill(getDutch()));
		System.out.println("English: " + Vacancy.getSkill(getEnglish()));
		System.out.println("German: " + Vacancy.getSkill(getGerman()));
		System.out.println("MSOffice: " + Vacancy.getSkill(getMSOffice()));
		System.out.println("JavaScript: " + Vacancy.getSkill(getJavaScript()));
		System.out.println("Sales: " + Vacancy.getSkill(getSales()));
		System.out.println("Management: " + Vacancy.getSkill(getManagement()) + "\n");
	}
	//SETTERS

	public void setFieldOfStudy(int fieldOfStudy){
		this.fieldOfStudy = fieldOfStudy;
	}
	public void setExperience(int experience){
		this.experience = experience;
	}
	public void setAvailability(int availability){
		this.availability = availability;
	}
	public void setDutch(boolean dutch){
		this.dutch = dutch;
	}
	public void setEnglish(boolean english){
		this.english = english;
	}
	public void setGerman(boolean german){
		this.german = german;
	}
	public void setmsOffice(boolean msOffice){
		this.msOffice = msOffice;
	}
	public void setjavaScript(boolean javaScript){
		this.javaScript = javaScript;
	}
	public void setsales(boolean sales){
		this.sales = sales;
	}
	public void setmanagement(boolean management){
		this.management = management;
	}
	//GETTERS

	public int getFieldOfStudy() {
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