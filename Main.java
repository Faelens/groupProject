package groupProject;

import java.io.*;
import java.util.Scanner;

// Cool ideas for bonus:
// - Bold, italic, colored texts

public class Main {

	public static Scanner userInput1 = new Scanner(System.in);	//Char
	public static Scanner userInput2 = new Scanner(System.in);	//String
	public static char recruiterOrCandidate = 'B';

	public static void main(String[] args) throws IOException{

		System.out.println("Welcome to the Recruiment System.");

		while(true){
			System.out.println("Do you already have an account? (Y/N)");
			char accountYN = userInput1.next().charAt(0); 

			if(accountYN != 'Y' && accountYN != 'N'){

				System.out.println("\nThis is not a valid input! Please choose again.");
				continue;
			}

			else if(accountYN == 'Y'){
				// Check if recruiter or candidate and open login method

				while(true){
					System.out.println("\nAre you a recruiter (A) or a candidate (B)?"); 
					recruiterOrCandidate = userInput1.next().charAt(0); 

					if(recruiterOrCandidate != 'A' && recruiterOrCandidate != 'B'){
						System.out.println("\nThis is not a valid input! Please choose again.");
						continue;
					}
					else if (recruiterOrCandidate == 'A'){
						User.logIn();
						break;
					}
					else {
						User.logIn();
						break;
					}
				}

				break;
			}

			else { 
				// User.registerAccount();

				break;
			}
		}

		// Hier ga je verder als OF recruiter OF candidate
		if (recruiterOrCandidate == 'A') runRecruiter();
		else runCandidate();

	}

	public static void runCandidate() {
		System.out.print("\nWelcome " + User.name + "! ");
		while (true){
			System.out.println("What would you like to do?");
			System.out.println("A = Update profile information");
			System.out.println("B = View vacancies");
			System.out.println("C = Search vacancies");
			System.out.println("D = See applications");
			System.out.println("E = Logout");
			char choice = userInput1.next().charAt(0); 

			if (choice == 'A'){
				Candidate.setCandidateInfo();
				continue;
			}
			if (choice == 'B'){
				User.viewVacancies();
				continue;
			}
			if (choice == 'C'){
				User.searchVacancies();
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
		System.out.print("\nWelcome " + User.name + "! ");
		while (true){
			System.out.println("What would you like to do?");
			System.out.println("A = Create a vacancy");
			System.out.println("B = View your vacancies");
			System.out.println("C = Search candidates");
			System.out.println("D = See applications");
			System.out.println("E = Update profile information");
			System.out.println("F = Logout");
			char choice = userInput1.next().charAt(0); 

			if (choice == 'A'){
				Recruiter.setVacancy();
				continue;
			}
			if (choice == 'B'){
				Recruiter.viewVacancies();
				continue;
			}
			if (choice == 'C'){
				Recruiter.searchCandidates();
				continue;
			}
			if (choice == 'D'){
				Recruiter.viewApplications();
				continue;
			}
			if (choice == 'E'){
				Recruiter.setRecruiterInfo();
				break;
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
