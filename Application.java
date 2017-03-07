package groupProject;

public class Application {
	private int applicationID;
	private Candidate candidate;
	private Vacancy vacancy;	
	private String motivation;
	
	public Application(int applicationID, Candidate candidate, Vacancy vacancy, String motivation) {
		setApplicationID(applicationID);
		this.candidate = candidate;
		this.vacancy = vacancy;
		setMotivation(motivation);
	}
	
	// Setters
	public void setApplicationID(int applicationID){
		this.applicationID = applicationID;
	}
	public void setMotivation(String motivation){
		this.motivation = motivation;
	}
	
	// Getters
	public int getApplicationID() {
		return applicationID;
	}
	public String getMotivation() {
		return motivation;
	}
}