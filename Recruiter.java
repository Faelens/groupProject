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

	public static void viewVacancies(){
		// view recruiter vacancies
	}

	public static void viewApplications(){

	}

	public static void setVacancy(){

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