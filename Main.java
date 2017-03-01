package groupProject;

import java.io.*;
import java.util.Scanner;

//TOM, LAU EN LUC ZIJN BAZENnn
//tom kan helemaal niks
public class Main {

	public static Scanner userInput1 = new Scanner(System.in);	//Char
	public static Scanner userInput2 = new Scanner(System.in);	//String

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
				//logIn();

				while(true){
					System.out.println("Are you a recruiter (A) or a user (B)?"); 
					char recruiterOrUser = userInput1.next().charAt(0); 

					if(recruiterOrUser != 'A' && recruiterOrUser != 'B'){
						System.out.println("\nThis is not a valid input! Please choose again.");
						continue;
					}
					else if (recruiterOrUser == 'A'){
						
						break;
					}
				}

				break;
			}

			else { 
				//registerAccount();

				break;
			}
		} TEST NIGGA
	}
}
