package groupProject;

import java.io.*;
import java.util.Scanner;

public class Main {
	public static Candidate candidate; //These are objects from the classes to store the values put in by the user (WS5)
	public static Recruiter recruiter;
	public static User user;
	public static Vacancy vacancy;
	public static Application application;
	public static Scanner userInput1 = new Scanner(System.in);	//Char
	public static Scanner userInput2 = new Scanner(System.in);	//String
	public static Scanner userInput3 = new Scanner(System.in);	//Int
	public static Scanner userInput4 = new Scanner(System.in); // boolean
	public static char recruiterOrCandidate = 'B';				//A = recruiter, B = candidate

	public static void main(String[] args) throws IOException{
		System.out.println("Welcome to the Recruiment System.");
		while(true){
			System.out.println("\nDo you already have an account? (Y/N)");
			char accountYN = userInput1.next().charAt(0); 
			accountYN = Character.toUpperCase(accountYN);
			if(accountYN != 'Y' && accountYN != 'N'){
				System.out.println("\nThis is not a valid input! Please choose again.");
				continue;
			}

			else if(accountYN == 'Y'){
				// Check if recruiter or candidate and open login method

				while(true){
					System.out.println("\nAre you a recruiter (A) or a candidate (B)?"); 
					recruiterOrCandidate = userInput1.next().charAt(0); 
					recruiterOrCandidate = Character.toUpperCase(recruiterOrCandidate);
					
					if(recruiterOrCandidate != 'A' && recruiterOrCandidate != 'B'){
						System.out.println("\nThis is not a valid input! Please choose again.");
						continue;
					}
					else if (recruiterOrCandidate == 'B'){
						Candidate.candidateLogIn();
						break;
					}
					else {
						Recruiter.recruiterLogIn();
						break;
					}
				}
			}
			

			else { 		// When answer is no --> start register process User.registerAccount(); 

				while(true){	
					System.out.println("\nDo you want to register as a recruiter (A) or a candidate (B)?"); // ask if you want to register as candidate/recruiter
					recruiterOrCandidate = userInput1.next().charAt(0); 
					recruiterOrCandidate = Character.toUpperCase(recruiterOrCandidate);

					if(recruiterOrCandidate != 'A' && recruiterOrCandidate != 'B'){
						System.out.println("\nThis is not a valid input! Please choose again.");
						continue;
					}
					else if (recruiterOrCandidate == 'B'){
						Candidate.candidateRegistration();													// Register a candidate 
						break;
					}
					else {
						//Recruiter.recruiterRegistration();	//												// Register a recruiter
						Recruiter.recruiterRegistration();
						break;
					}
					
				}
				
			}

			// Hier ga je verder als OF recruiter OF candidate
			if (recruiterOrCandidate == 'A') runRecruiter();
			else runCandidate();
			break;
		}


	}

	public static void runCandidate() {
		System.out.print("\nWelcome " + Main.candidate.getName() + "! ");
		while (true){
			System.out.println("What would you like to do?");
			System.out.println("A = Update profile information");
			System.out.println("B = View vacancies");
			System.out.println("C = Filter vacancies");
			System.out.println("D = See applications");
			System.out.println("E = Logout");
			char choice = userInput1.next().charAt(0); 
			choice = Character.toUpperCase(choice);

			if (choice == 'A'){
				candidate.setCandidateInfo();
				continue;
			}
			if (choice == 'B'){
				// view ALL vacancies
				// Print list of all vacancies with ID
				ReadFile.printAllVacancies();
				User.viewVacancies();
				continue;
			}
			if (choice == 'C'){
				Candidate.filterVacancies();
				continue;
			}
			if (choice == 'D'){
				Candidate.viewApplications();
				continue;
			}
			if (choice == 'E'){
				User.logOut();
				break;
			}
			else {
				System.out.println("\nThis is not a valid input! Please choose again.");
				continue;
			}
		}
	}

	public static void runRecruiter() {
		System.out.print("\nWelcome " + Main.recruiter.getName() + "! ");
		while (true){
			System.out.println("What would you like to do?");
			System.out.println("A = Create a vacancy");
			System.out.println("B = View your vacancies");
			System.out.println("C = Filter candidates");
			System.out.println("D = See applications");
			System.out.println("E = Update profile information");
			System.out.println("F = Logout");
			char choice = userInput1.next().charAt(0); 
			choice = Character.toUpperCase(choice);

			if (choice == 'A'){
				Recruiter.setVacancy();
				continue;
			}
			if (choice == 'B'){
				Recruiter.viewRecruiterVacancies();
				continue;
			}
			if (choice == 'C'){
				Recruiter.filterCandidates();
				continue;
			}
			if (choice == 'D'){
				Recruiter.viewApplications();
				continue;
			}
			if (choice == 'E'){
				recruiter.setRecruiterInfo();
				continue;
			}
			if (choice == 'F'){
				User.logOut();
				break;
			}
			else {
				System.out.println("\nThis is not a valid input! Please choose again.");
				continue;
			}
		}
	}

}