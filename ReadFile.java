package groupProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static Candidate getCandidatebyLogInName(String logInName){
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

		Candidate candidate = null;

		try{
			BufferedReader br = new BufferedReader(new FileReader("Candidates.txt"));
			String sCurrentLine;
			String[] uCurrentLine = new String[16];

			while((sCurrentLine = br.readLine()) != null){
				uCurrentLine = sCurrentLine.split("\t");

				if(uCurrentLine[1].toLowerCase().equals(logInName.toLowerCase())){

					candidate = new Candidate(
							Integer.parseInt(uCurrentLine[0]),
							uCurrentLine[1],
							uCurrentLine[2],
							uCurrentLine[3],
							uCurrentLine[4],
							Integer.parseInt(uCurrentLine[5]),
							Integer.parseInt(uCurrentLine[6]),
							Integer.parseInt(uCurrentLine[7]),							
							Boolean.parseBoolean(uCurrentLine[8]),
							Boolean.parseBoolean(uCurrentLine[9]),
							Boolean.parseBoolean(uCurrentLine[10]),
							Boolean.parseBoolean(uCurrentLine[11]),
							Boolean.parseBoolean(uCurrentLine[12]),
							Boolean.parseBoolean(uCurrentLine[13]),
							Boolean.parseBoolean(uCurrentLine[14])
							);

					break;
				}				
			}
			br.close();
		}
		catch(IOException e){
			System.out.println("The file does not exist!");
		}

		return candidate;
	}


	public static Recruiter getRecruiterbyLogInName(String logInName){

		/* 
		 * Fields in the TXT file:
		 * [0] userID;
		 * [1] logInName;
		 * [2] password;
		 * [3] name;
		 * [4] emailAddress;
		 * [5] company
		 */

		Recruiter recruiter = null;

		try{
			BufferedReader br = new BufferedReader(new FileReader("Recruiters.txt"));
			String sCurrentLine;
			String[] uCurrentLine = new String[6];

			while((sCurrentLine = br.readLine()) != null){
				uCurrentLine = sCurrentLine.split("\t");

				if(uCurrentLine[1].toLowerCase().equals(logInName.toLowerCase())){

					recruiter = new Recruiter(
							Integer.parseInt(uCurrentLine[0]),
							uCurrentLine[1],
							uCurrentLine[2],
							uCurrentLine[3],
							uCurrentLine[4],
							uCurrentLine[5]
							);

					break;
				}				
			}

			br.close();
		}
		catch(IOException e){
			System.out.println("The file does not exist!");
		}

		return recruiter;
	}


	public static void printAllVacancies() {

		try{
			BufferedReader br= new BufferedReader(new FileReader("Vacancy.txt"));
			String sCurrentLine;
			String[] uCurrentLine = new String[13];

			while((sCurrentLine = br.readLine()) != null){
				uCurrentLine = sCurrentLine.split("\t");

				System.out.println(uCurrentLine[0] + " - " + uCurrentLine[1]);
			}
			br.close();
		}
		catch(IOException error){
			System.out.println("The file does not exist!");
		}	

	}


	public static Vacancy getVacancyByVacancyID(int vacancyID) {

		Vacancy vacancy = null;

		try{
			BufferedReader br = new BufferedReader(new FileReader("Vacancy.txt"));
			String sCurrentLine;
			String[] uCurrentLine = new String[13];

			while((sCurrentLine = br.readLine()) != null){
				uCurrentLine = sCurrentLine.split("\t");

				if(Integer.parseInt(uCurrentLine[0]) == vacancyID){

					vacancy = new Vacancy(

							Integer.parseInt(uCurrentLine[0]),
							uCurrentLine[1],
							Integer.parseInt(uCurrentLine[2]),
							Integer.parseInt(uCurrentLine[3]),					
							Boolean.parseBoolean(uCurrentLine[4]),
							Boolean.parseBoolean(uCurrentLine[5]),			
							Boolean.parseBoolean(uCurrentLine[6]),
							Boolean.parseBoolean(uCurrentLine[7]),			
							Boolean.parseBoolean(uCurrentLine[8]),
							Boolean.parseBoolean(uCurrentLine[9]),			
							Boolean.parseBoolean(uCurrentLine[10]),
							Boolean.parseBoolean(uCurrentLine[11]),
							Integer.parseInt(uCurrentLine[12])
							);

					break;
				}				
			}

			br.close();
		}
		catch(IOException e){
			System.out.println("The file does not exist!");
		}

		return vacancy;

	}

	public static void getVacanciesByFieldOfStudy(int studyfilter){
		try{
			BufferedReader br = new BufferedReader(new FileReader("Vacancy.txt"));
			String sCurrentLine;
			String[] uCurrentLine = new String[13];

			while((sCurrentLine = br.readLine()) != null){
				uCurrentLine = sCurrentLine.split("\t");

				if(Integer.parseInt(uCurrentLine[2]) == studyfilter){

					System.out.println(uCurrentLine[0] + " - " + uCurrentLine[1]);
				}
			}				

			br.close();
		}
		catch(IOException e){
			System.out.println("The file does not exist!");
		}

	}


	public static void getVacanciesByExperience(int experience) {
		try{
			BufferedReader br = new BufferedReader(new FileReader("Vacancy.txt"));
			String sCurrentLine;
			String[] uCurrentLine = new String[13];

			while((sCurrentLine = br.readLine()) != null){
				uCurrentLine = sCurrentLine.split("\t");

				if(Integer.parseInt(uCurrentLine[3]) <= experience){

					System.out.println(uCurrentLine[0] + " - " + uCurrentLine[1]);
				}
			}				

			br.close();
		}
		catch(IOException e){
			System.out.println("The file does not exist!");
		}

	}

	public static void getVacanciesBySkill(int rowNumber) {
		try{
			BufferedReader br = new BufferedReader(new FileReader("Vacancy.txt"));
			String sCurrentLine;
			String[] uCurrentLine = new String[13];

			while((sCurrentLine = br.readLine()) != null){
				uCurrentLine = sCurrentLine.split("\t");

				if(Boolean.parseBoolean(uCurrentLine[rowNumber]) == true){

					System.out.println(uCurrentLine[0] + " - " + uCurrentLine[1]);
				}
			}				

			br.close();
		}
		catch(IOException e){
			System.out.println("The file does not exist!");
		}
	}
	public static void getApplications(int userID) {
		try{
			BufferedReader br = new BufferedReader(new FileReader("Applications.txt"));
			String sCurrentLine;
			String[] uCurrentLine = new String[4];

			while((sCurrentLine = br.readLine()) != null){
				uCurrentLine = sCurrentLine.split("\t");

				if(Integer.parseInt(uCurrentLine[1]) == userID){

					System.out.println(uCurrentLine[0] + " - " + getJobTitleByVacancyID(Integer.parseInt(uCurrentLine[2])));
				}
			}				

			br.close();
		}
		catch(IOException e){
			System.out.println("The file does not exist!");
		}
	}

	public static void getVacancies(int userID) {
		try{
			BufferedReader br = new BufferedReader(new FileReader("Vacancy.txt"));
			String sCurrentLine;
			String[] uCurrentLine = new String[13];

			while((sCurrentLine = br.readLine()) != null){
				uCurrentLine = sCurrentLine.split("\t");

				if(Integer.parseInt(uCurrentLine[12]) == userID){

					System.out.println(uCurrentLine[0] + " - " + uCurrentLine[1]);
				}
			}				

			br.close();
		}
		catch(IOException e){
			System.out.println("The file does not exist!");
		}
	}


	private static String getJobTitleByVacancyID(int vacancyID) {
		String jobTitle = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader("Vacancy.txt"));
			String sCurrentLine;
			String[] uCurrentLine = new String[13];

			while((sCurrentLine = br.readLine()) != null){
				uCurrentLine = sCurrentLine.split("\t");

				if(Integer.parseInt(uCurrentLine[0]) == vacancyID){

					jobTitle = uCurrentLine[1];

					break;
				}				
			}

			br.close();
		}
		catch(IOException e){
			System.out.println("The file does not exist!");
		}
		return jobTitle;
	}
	
	public static void printMotivationByApplicationID(int applicationID) {
		try{
			BufferedReader br = new BufferedReader(new FileReader("Applications.txt"));
			String sCurrentLine;
			String[] uCurrentLine = new String[12];

			while((sCurrentLine = br.readLine()) != null){
				uCurrentLine = sCurrentLine.split("\t");

				if(Integer.parseInt(uCurrentLine[0]) == applicationID){

					System.out.println("Your motivation: " + uCurrentLine[3]);

					break;
				}				
			}

			br.close();
		}
		catch(IOException e){
			System.out.println("The file does not exist!");
		}
	}
}