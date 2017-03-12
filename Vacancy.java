package groupProject;

/* List in TXT file:
 * [0] vacancyID;
 * [1] jobTitle;
 * [2] fieldOfStudy;
 * [3] requiredExperience;
 * [4] preferedAvailability;
 * [5] Dutch;
 * [6] English;
 * [7] German;
 * [8] MS Office;
 * [9] Javascript;
 * [10] Sales;
 * [11] Management
 * [12] RecruiterID
 */

public class Vacancy {
	private int vacancyID;
	private String jobTitle;
	private int fieldOfStudy;
	private int requiredExperience;
	private boolean preferredAvailability;
	private boolean vacancyDutch;
	private boolean vacancyEnglish;
	private boolean vacancyGerman;
	private boolean vacancyMSOffice;
	private boolean vacancyJavaScript;
	private boolean vacancySales;
	private boolean vacancyManagement;
	private int recruiterID;

	public Vacancy(int vacancyID, String jobTitle, int fieldOfStudy, int requiredExperience, boolean preferredAvailability,
			boolean vacancyDutch, boolean vacancyEnglish, boolean vacancyGerman, boolean vacancyMSOffice,
			boolean vacancyJavaScript, boolean vacancySales, boolean vacancyManagement, int recruiterID) {
		setVacancyID(vacancyID);
		setJobTitle(jobTitle);
		setFieldOfStudy(fieldOfStudy);
		setRequiredExperience(requiredExperience);
		setPreferredAvailability(preferredAvailability);
		setVacancyDutch(vacancyDutch);
		setVacancyEnglish(vacancyEnglish);
		setVacancyGerman(vacancyGerman);
		setVacancyMSOffice(vacancyMSOffice);
		setVacancyJavaScript(vacancyJavaScript);
		setVacancySales(vacancySales);
		setVacancyManagement(vacancyManagement);
		this.recruiterID = recruiterID;
		
	}
	/*boolean[] vacancyLanguages = new boolean[4]; 
	boolean[] vacancySkills = new boolean[4];
	*/

	public void printVacancy() {
		
		
		System.out.println("Job title: " + getJobTitle());
		System.out.println("Field of study: " + getFieldOfStudyByFieldOfStudy(getFieldOfStudy()));
		System.out.println("Required experience: " + getRequiredExperience() + " years");
		System.out.println("Preferred availability: " + getPreferredAvailabilityInText(getPreferredAvailability()));
		System.out.println("Dutch: " + getSkill(getVacancyDutch()));
		System.out.println("English: " + getSkill(getVacancyEnglish()));
		System.out.println("German: " + getSkill(getVacancyGerman()));
		System.out.println("MSOffice: " + getSkill(getVacancyMSOffice()));
		System.out.println("JavaScript: " + getSkill(getVacancyJavaScript()));
		System.out.println("Sales: " + getSkill(getVacancySales()));
		System.out.println("Management: " + getSkill(getVacancyManagement()));
		
		
	}
	
	public static  String getFieldOfStudyByFieldOfStudy(int fieldOfStudy) {
		String text = null;
		if (fieldOfStudy == 1 ) text = "Business";
		if (fieldOfStudy == 2 ) text = "Social";
		if (fieldOfStudy == 3 ) text = "Technical";
		return text;
	}

	public String getPreferredAvailabilityInText(boolean preferredAvailability) {
		String text = null;
		if (preferredAvailability == true ) text = "Available immediately";
		if (preferredAvailability == false ) text = "Not available immediately";
		return text;
	}
	public static String getSkill(boolean skill) {
		String text = null;
		if (skill == true ) text = "Yes";
		if (skill == false ) text = "No";
		return text;
	}
	
	// Setters
	public void setVacancyID(int vacancyID){
		this.vacancyID = vacancyID;
	}
	public void setJobTitle(String jobTitle){
		this.jobTitle = jobTitle;
	}
	public void setFieldOfStudy(int fieldOfStudy){
		this.fieldOfStudy = fieldOfStudy;
	}
	public void setRequiredExperience(int requiredExperience){
		this.requiredExperience = requiredExperience;
	}
	public void setPreferredAvailability(boolean preferredAvailability){
		this.preferredAvailability = preferredAvailability;
	}
	public void setVacancyDutch(boolean vacancyDutch){
		this.vacancyDutch = vacancyDutch;
	}
	public void setVacancyEnglish(boolean vacancyEnglish){
		this.vacancyEnglish = vacancyEnglish;
	}
	public void setVacancyGerman(boolean vacancyGerman){
		this.vacancyGerman = vacancyGerman;
	}
	public void setVacancyMSOffice(boolean vacancyMSOffice){
		this.vacancyMSOffice = vacancyMSOffice;
	}
	public void setVacancyJavaScript(boolean vacancyJavaScript){
		this.vacancyJavaScript = vacancyJavaScript;
	}
	public void setVacancySales(boolean vacancySales){
		this.vacancySales = vacancySales;
	}
	public void setVacancyManagement(boolean vacancyManagement){
		this.vacancyManagement = vacancyManagement;
	}

	//Getters
	public int getVacancyID() {
		return vacancyID;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public int getFieldOfStudy() {
		return fieldOfStudy;
	}
	public int getRequiredExperience() {
		return requiredExperience;
	}
	public boolean getPreferredAvailability() {
		return preferredAvailability;
	}
	public boolean getVacancyDutch() {
		return vacancyDutch;
	}
	public boolean getVacancyEnglish() {
		return vacancyEnglish;
	}
	public boolean getVacancyGerman() {
		return vacancyGerman;
	}
	public boolean getVacancyMSOffice() {
		return vacancyMSOffice;
	}
	public boolean getVacancyJavaScript() {
		return vacancyJavaScript;
	}
	public boolean getVacancySales() {
		return vacancySales;
	}
	public boolean getVacancyManagement() {
		return vacancyManagement;
	}

}