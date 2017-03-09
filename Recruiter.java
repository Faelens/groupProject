package groupProject;

/* 
 * Fields in the TXT file:
 * [0] userID;
 * [1] logInName;
 * [2] password;
 * [3] name;
 * [4] emailAddress;
 * [5] company
 */

public class Recruiter extends User {

	private String company;

	public Recruiter(int userID, String logInName, String password, String name, String emailAddress, String company ){
		setUserID(userID);
		setLogInName(logInName);
		setPassword(password);
		setName(name);
		setEmailAddress(emailAddress);
		this.company = company;

	}

	public static void recruiterLogIn(){
		System.out.println("#####");
		System.out.println("LOGIN as Recruiter");
		System.out.println("#####");

		Recruiter tempRecruiter = null;

		while(true){
			System.out.println("Log-in name: ");
			String logInName = Main.userInput2.nextLine();

			System.out.println("Password: ");
			String password = Main.userInput2.nextLine();

			tempRecruiter = ReadFile.getRecruiterbyLogInName(logInName);

			if(tempRecruiter == null){
				System.out.println("\nThis user does not exist!");
				continue;
			}

			if(!tempRecruiter.getPassword().equals(password)){
				System.out.println("\nThis password is not correct!");
				continue;
			}

			Main.recruiter = tempRecruiter;

			break;
		}
	}

	public static void recruiterRegistration(){
		System.out.println("#####");
		System.out.println("Register new Recruiter");
		System.out.println("#####");

		String logInName;
		String password;
		String name;
		String emailAddress;
		String company;


		while(true){
			System.out.print("Login-name: ");
			logInName = Main.userInput2.nextLine();

			if(logInName.equals("")){
				System.out.println("Can't be empty!");
				continue;
			}

			Recruiter tempRecruiter = ReadFile.getRecruiterbyLogInName(logInName);

			if (tempRecruiter == null) break;

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
			System.out.print("Company: ");
			company = Main.userInput2.nextLine();

			if(!company.equals("")) break;

		}

		WriteFile.addRecruiter(logInName, password, name, emailAddress, company);		
		System.out.println("\nCongratulations! You are successfully registered as a recruiter and you can now login!");

		Recruiter.recruiterLogIn();
	}

	public void setRecruiterInfo(){
		int choice = 0;
		while(true){
			System.out.println("\n#####################");
			System.out.println("What do you want to do?");
			System.out.println("1 = Change password");
			System.out.println("2 = Change name");
			System.out.println("3 = Change e-mailaddress");
			System.out.println("4 = Change company");
			System.out.println("5 = Back to main menu");

			choice = Main.userInput3.nextInt();

			if(choice == 1){	//password
				while(true){
					String newpassword = null;
					while(true){
						System.out.println("Your current password is: " + getPassword());
						System.out.println("--------------------------");
						System.out.print("Fill in your new password here: ");
						newpassword = Main.userInput2.nextLine();

						if(!newpassword.equals("")) break;

					}
					System.out.print("Repeat your new password: ");
					String repeatnewpassword = Main.userInput2.nextLine();		

					if(!repeatnewpassword.equals(newpassword)) {			
						System.out.println("Your passwords do not match!");
					}

					Main.recruiter.setPassword(newpassword);

					WriteFile.updateRecruiter(this);
					System.out.println("Your password has been updated correctly."); 
					System.out.println("Use it to log in next time");
					break;
				}

			}
			if(choice == 2){ // Name			
				while(true){		
					System.out.println("\nYour current name is: " + User.getName());
					System.out.print("Please enter your new name: ");
					String newname = Main.userInput2.nextLine();	

					if(newname.equals("")){
						System.out.println("Can't be empty!");
						continue;
					}
					Main.recruiter.setName(newname);

					WriteFile.updateRecruiter(this);
					System.out.println("Your name has been updated correctly to " 
							+ User.getName() + ".\n");
					break;
				}
			}

			if(choice == 3){ // Email address			
				while(true){		
					System.out.println("\nYour current e-mailaddress is: " + User.getEmailAddress());
					System.out.print("Please enter your new e-mailaddress:");
					String newemail = Main.userInput2.nextLine();	

					if(newemail.equals("")){
						System.out.println("Can't be empty!");
						continue;
					}
					Main.recruiter.setEmailAddress(newemail);

					WriteFile.updateRecruiter(this);
					System.out.println("Your e-mailaddress has been updated correctly to " 
							+ User.getEmailAddress() + ".\n");
					break;

				}
			}

			if(choice == 4){ // Company	
				while(true){		
					System.out.println("\nYour current company is: " + company);
					System.out.print("Please enter your new company name: ");
					String newcompany = Main.userInput2.nextLine();	

					if(newcompany.equals("")){
						System.out.println("Can't be empty!");
						continue;
					}
					Main.recruiter.setCompany(newcompany);

					WriteFile.updateRecruiter(this);
					System.out.println("Your company has been updated correctly to " 
							+ company + ".\n");
					break;

				}
			}
			
			if(choice == 5){ // Go Back			
				Main.runRecruiter();
			}
		}
	}
	
	public static void runRecruiterVacancy(){
		
	}
	public static void searchCandidates(){

	}

	public static void viewRecruiterVacancies(){

		System.out.println("\nYou have the following vacancies outstanding:");
		ReadFile.getVacancies(Main.recruiter.getUserID());
		viewVacancies();
		System.out.println("");
	}

	public static void viewApplications(){

	}

	public static void setVacancy(){
		System.out.println("#####");
		System.out.println("Create a vacancy");
		System.out.println("#####");

		String jobTitle;
		int fieldOfStudy;
		int requiredExperience;
		int preferredAvailability;
		boolean vacancyDutch;
		boolean vacancyEnglish;
		boolean vacancyGerman;
		boolean vacancyMSOffice;
		boolean vacancyJavaScript;
		boolean vacancySales;
		boolean vacancyManagement;


		while(true){
			System.out.print("Job title: ");
			jobTitle = Main.userInput2.nextLine();

			if(jobTitle.equals("")){
				System.out.println("Can't be empty!");
				continue;
			}
			break;
		}
		while(true){
			System.out.println("What is the required field of study? : ");
			System.out.println("1 = Business");
			System.out.println("2 = Social");
			System.out.println("3 = Technical");
			fieldOfStudy = Main.userInput3.nextInt();

			if(fieldOfStudy == 1 || fieldOfStudy == 2 || fieldOfStudy == 3) break;

			System.out.println("Please enter 1 , 2 or 3");

		}

		while(true){
			System.out.print("What is the required workexperience in years? ");
			requiredExperience = (int) Main.userInput3.nextInt();

			if(requiredExperience>= 0) break;

			System.out.println("Please enter a positive number");

		} 
		
		while(true){
			System.out.print("Do you need a candidate rightaway? ( Y/N ) "); 
			char temp = 'Z';
			temp = Main.userInput1.next().charAt(0);							

			if( temp == 'Y') { 
				preferredAvailability = 1;
				break;
			}
			else if( temp == 'N') { 
				preferredAvailability = 2;
				break;
			}

			else {System.out.println("Please enter Y or N");}
		}

		while(true){
			System.out.print("Do you need to speak Dutch? ( Y/N ) "); 
			char temp = 'Z';
			temp = Main.userInput1.next().charAt(0);							

			if( temp == 'Y') { 
				vacancyDutch = true;
				break;
			}
			else if( temp == 'N') { 
				vacancyDutch = false;
				break;
			}

			else {System.out.println("Please enter Y or N");}
		}




		while(true){
			System.out.print("Do you need to speak English? ( Y/N ) "); 
			char temp = 'Z';
			temp = Main.userInput1.next().charAt(0);							// maybe need to change to int scanner

			if( temp == 'Y') { 
				vacancyEnglish = true;
				break;
			}
			else if( temp == 'N') { 
				vacancyEnglish = false;
				break;
			}

			else {System.out.println("Please enter Y or N");}
		}




		while(true){
			System.out.print("Do you need to speak German? ( Y/N ) "); 
			char temp = 'Z';
			temp = Main.userInput1.next().charAt(0);							// maybe need to change to int scanner

			if( temp == 'Y') { 
				vacancyGerman = true;
				break;
			}
			else if( temp == 'N') { 
				vacancyGerman = false;
				break;
			}

			else {System.out.println("Please enter Y or N");}
		}



		while(true){
			System.out.print("Do you need to have MS Office skills? ( Y/N ) "); 
			char temp = 'Z';
			temp = Main.userInput1.next().charAt(0);							// maybe need to change to int scanner

			if( temp == 'Y') { 
				vacancyMSOffice = true;
				break;
			}
			else if( temp == 'N') { 
				vacancyMSOffice = false;
				break;
			}

			else {System.out.println("Please enter Y or N");}

		}



		while(true){
			System.out.print("Do you need to have Javascript skills? ( Y/N ) "); 
			char temp = 'Z';
			temp = Main.userInput1.next().charAt(0);							// maybe need to change to int scanner

			if( temp == 'Y') { 
				vacancyJavaScript = true;
				break;
			}
			else if( temp == 'N') { 
				vacancyJavaScript = false;
				break;
			}

			else {System.out.println("Please enter Y or N");}
		}



		while(true){
			System.out.print("Do you need to have sales skills? ( Y/N ) "); 
			char temp = 'Z';
			temp = Main.userInput1.next().charAt(0);							// maybe need to change to int scanner

			if( temp == 'Y') { 
				vacancySales = true;
				break;
			}
			else if( temp == 'N') { 
				vacancySales = false;
				break;
			}

			else {System.out.println("Please enter Y or N");}
		}



		while(true){
			System.out.print("Do you need to have management skills? ( Y/N ) "); 
			char temp = 'Z';
			temp = Main.userInput1.next().charAt(0);							// maybe need to change to int scanner

			if( temp == 'Y') { 
				vacancyManagement = true;
				break;
			}
			else if( temp == 'N') { 
				vacancyManagement = false;
				break;
			}

			else {System.out.println("Please enter Y or N");}

		}

		WriteFile.addVacancy(jobTitle, fieldOfStudy, requiredExperience, preferredAvailability, vacancyDutch, vacancyEnglish, vacancyGerman, vacancyMSOffice, vacancyJavaScript, vacancySales, vacancyManagement);		
		System.out.println("\nCongratulations! You created a new vacancy.\n");


	}
	
	public void setCompany(String company){
		this.company = company;
	}

	public static void viewRecruiterInfo(){

	}
	public String getCompany() {
		return company;
	}

}